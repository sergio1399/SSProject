package practice.service.employeeService.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.model.countriesModel.Country;
import practice.model.docsModel.Doc_types;
import practice.model.docsModel.Document;
import practice.dao.employeeDAO.EmployeeDAO;
import practice.model.employeeModel.Address;
import practice.model.employeeModel.Employee;
import practice.service.employeeService.EmployeeService;
import practice.utils.EmployeeConverter;
import practice.utils.ErrorCode;
import practice.utils.MyAppException;
import practice.view.employeeView.EmployeeInView;
import practice.view.employeeView.EmployeeView;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by sergi on 15.03.2018.
 */
@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class EmployeeServiceImpl implements EmployeeService {
    private final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }


    @Override
    public List<EmployeeView> getEmployees(EmployeeInView employeeInView) throws MyAppException {
        log.debug(employeeInView.toString());
        if(employeeInView.officeId == null)
            throw new MyAppException("Не установлен обязательный параметр id офиса", ErrorCode.NULL_REQUIRED_PARAM);
        return EmployeeConverter.toViewList(employeeDAO.getEmployees(employeeInView));
    }

    @Override
    public EmployeeView getEmp(long id) throws MyAppException {
        Employee employee = employeeDAO.getEmp(id);
        return EmployeeConverter.toView(employee);
    }

    @Override
    @Transactional
    public boolean update(EmployeeView employeeView) throws MyAppException {
        log.debug("employeeInView", employeeView);
        if(employeeView.id == null)
            throw new MyAppException("Не установлен обязательный параметр id", ErrorCode.NULL_REQUIRED_PARAM);
        return employeeDAO.update(employeeView);
    }

    @Override
    @Transactional
    public boolean save(EmployeeView employeeView) throws MyAppException {
        log.debug("employeeInView", employeeView);
        if(employeeView.officeId == null)
            throw new MyAppException("Не установлен обязательный параметр id офиса", ErrorCode.NULL_REQUIRED_PARAM);
        return employeeDAO.save(employeeView);
    }

    @Override
    @Transactional
    public boolean delete(long id) throws MyAppException {

        return employeeDAO.delete(id);
    }
}
