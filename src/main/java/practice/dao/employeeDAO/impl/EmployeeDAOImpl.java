package practice.dao.employeeDAO.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import practice.model.countriesModel.Country;
import practice.model.docsModel.Doc_types;
import practice.model.docsModel.Document;
import practice.dao.employeeDAO.EmployeeDAO;
import practice.model.employeeModel.Employee;
import practice.utils.ErrorCode;
import practice.utils.MyAppException;
import practice.view.employeeView.EmployeeInView;
import practice.view.employeeView.EmployeeView;
import practice.model.officeModel.Office;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergi on 14.03.2018.
 */
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private final EntityManager em;

    @Autowired
    public EmployeeDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Employee> getEmployees(EmployeeInView employeeInView) {
        List<Employee> result = new ArrayList<>();

        CriteriaBuilder qb = em.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = qb.createQuery(Employee.class);
        Root<Employee> employeeRoot = cq.from(Employee.class);

        //Constructing list of parameters
        List<Predicate> predicates = new ArrayList<>();

        predicates.add(
                qb.equal(employeeRoot.get("office").get("id"), employeeInView.officeId));
        //Adding predicates in case of parameter not being null
        if (employeeInView.firstName != null) {
            predicates.add(
                    qb.equal(employeeRoot.get("firstName"), employeeInView.firstName));
        }
        if (employeeInView.lastName != null) {
            predicates.add(
                    qb.equal(employeeRoot.get("lastName"), employeeInView.lastName));
        }
        if (employeeInView.middleName != null) {
            predicates.add(
                    qb.equal(employeeRoot.get("middleName"), employeeInView.middleName));
        }
        if (employeeInView.position != null) {
            predicates.add(
                    qb.equal(employeeRoot.get("position"), employeeInView.position));
        }
        if (employeeInView.citizenshipCode != null) {
            predicates.add(
                    qb.equal(employeeRoot.get("country").get("code"), employeeInView.citizenshipCode));
        }
        if (employeeInView.docCode != null) {
            predicates.add(
                    qb.equal(employeeRoot.get("document").get("docType").get("code"), employeeInView.position));
        }
        //query itself
        cq.select(employeeRoot)
                .where(predicates.toArray(new Predicate[]{}));
        //execute query and do something with result
        result = em.createQuery(cq).getResultList();

        return result;
    }

    @Override
    public Employee getEmp(long id) throws MyAppException {
        Employee employee = em.find(Employee.class, id);
        if(employee == null){
            throw new MyAppException(String.format("Работник с id %d не найден в базе", id), ErrorCode.WRONG_ID);
        }
        return employee;
    }

    @Override
    public boolean update(EmployeeView employeeView) throws MyAppException {
            Employee empToUpdate = em.find(Employee.class, employeeView.id);
            empToUpdate.setFirstName(employeeView.firstName);
            empToUpdate.setMiddleName(employeeView.middleName);
            empToUpdate.setLastName(employeeView.lastName);
            empToUpdate.setPosition(employeeView.position);
            empToUpdate.setPhone(employeeView.phone);
            //апдейт связанных сущностей
            //апдейт документа
            Document document = empToUpdate.getDocument();
            if(employeeView.docName != null) {
                Doc_types doc_types = findDocType(employeeView.docName);
                document.setDocType(doc_types);
            }
            else {
                if (employeeView.docDate != null || employeeView.docNumber != null || employeeView.isIdentified != null)
                {
                    throw new MyAppException("Несогласованные параметры для обновления документа работника",
                                             ErrorCode.WRONG_DOC_PARAMS);
                }
            }
            document.setDocDate(employeeView.docDate);
            document.setDocNumber(employeeView.docNumber);
            document.setIdentified(employeeView.isIdentified);
            Country country = findCountry(employeeView.citizenshipCode, employeeView.citizenshipName);
            if( country == null)
            {
                throw new MyAppException("Несогласованные параметры для обновления страны работника",
                        ErrorCode.WRONG_COUNTRY_PARAMS);
            }
            empToUpdate.setCountry(country);
            em.merge(empToUpdate);
            return true;
    }

    private Country findCountry(String code, String name)
    {
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Country> criteria = builder.createQuery(Country.class);

            Root<Country> countryRoot = criteria.from(Country.class);
            criteria.select(countryRoot).where(builder.and(builder.equal(countryRoot.get("code"), code),
                    builder.equal(countryRoot.get("name"), name)));
            TypedQuery<Country> query = em.createQuery(criteria);
            Country country = query.getSingleResult();
            if (country != null)
                return country;

            return null;
    }

    private Doc_types findDocType(String name)
    {
        Doc_types doc_types = new Doc_types();

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Doc_types> criteria = builder.createQuery(Doc_types.class);

        Root<Doc_types> docRoot = criteria.from(Doc_types.class);
        criteria.select(docRoot).where(builder.equal(docRoot.get("name"), name));
        TypedQuery<Doc_types> query = em.createQuery(criteria);
        doc_types = query.getSingleResult();

        return doc_types;
    }

    @Override
    public boolean save(EmployeeView employeeView) throws MyAppException {
        Employee employee = new Employee(employeeView.firstName, employeeView.lastName, employeeView.middleName,
                                        employeeView.position, employeeView.phone);
        //сохранение связанных сущностей
        Country country = findCountry(employeeView.citizenshipCode, employeeView.citizenshipName);
        if(country == null)
        {
            throw new MyAppException("Несогласованные параметры для сохранения страны работника",
                    ErrorCode.WRONG_COUNTRY_PARAMS);
        }
        employee.setCountry(country);
        Doc_types doc_types = findDocType(employeeView.docName);
        if(doc_types == null || doc_types.getCode() != employeeView.docCode)
        {
            throw new MyAppException("Несогласованные параметры для сохранения документа работника",
                    ErrorCode.WRONG_DOC_PARAMS);
        }
        Document document = new Document();
        document.setDocType(doc_types);
        document.setDocNumber(employeeView.docNumber);
        document.setDocDate(employeeView.docDate);
        document.setIdentified(employeeView.isIdentified);
        Office office = em.find(Office.class, employeeView.officeId);
        employee.setOffice(office);
        office.addEmployee(employee);
        em.persist(employee);

        return true;
    }

    @Override
    public boolean delete(long id) {
        Employee employee = em.find(Employee.class, id);
        employee.setOffice(null);
        em.remove(employee);

        return true;
    }
}
