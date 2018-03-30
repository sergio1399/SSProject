package practice.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import practice.model.countriesModel.Country;
import practice.model.docsModel.Doc_types;
import practice.model.docsModel.Document;
import practice.model.employeeModel.Employee;
import practice.model.orgModel.Organization;
import practice.view.employeeView.EmployeeView;
import practice.view.orgView.OrgInView;
import practice.view.orgView.OrgView;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by sergi on 23.03.2018.
 */
public class OrgConverter {
    private static final Logger log = LoggerFactory.getLogger(OrgConverter.class);
    public static List<OrgView> toViewList(List<Organization> orgList)
    {
        Function<Organization, OrgView> mapOrg = o -> {
            OrgView view = new OrgView();
            view.id = o.getId();
            view.name = o.getName();
            view.isActive = o.isActive();
            log.debug(view.toString());
            return view;
        };

        return orgList.stream()
                .map(mapOrg)
                .collect(Collectors.toList());
    }

    public static OrgView toView(Organization org){
        OrgView view = new OrgView();
        view.id = org.getId();
        view.name = org.getName();
        view.fullName = org.getFullName();
        view.inn = org.getInn();
        view.kpp = org.getKpp();
        view.address = org.getAddress();
        view.phone = org.getPhone();
        view.isActive = org.isActive();
        log.debug(view.toString());
        return view;
    }

    public static Organization toModel(OrgInView orgInView){
        return new Organization(orgInView.name, orgInView.inn, orgInView.isActive);
    }

    public static Organization toModel(OrgView orgView){
        Organization organization = null;
        if( orgView.id != null ){
            organization = new Organization(orgView.id, orgView.name, orgView.fullName, orgView.inn, orgView.kpp,
                    orgView.address, orgView.phone, orgView.isActive);
        }
        else {
            organization = new Organization(orgView.name, orgView.fullName, orgView.inn, orgView.kpp,
                    orgView.address, orgView.phone, orgView.isActive);
        }
        return organization;
    }
}
