package practice.utils;

import practice.model.countriesModel.Country;
import practice.model.docsModel.Doc_types;
import practice.model.docsModel.Document;
import practice.model.employeeModel.Employee;
import practice.model.orgModel.Organization;
import practice.view.employeeView.EmployeeView;
import practice.view.orgView.OrgView;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by sergi on 23.03.2018.
 */
public class OrgConverter {
    public static List<OrgView> toViewList(List<Organization> orgList)
    {
        Function<Organization, OrgView> mapOrg = o -> {
            OrgView view = new OrgView();
            view.id = o.getId();
            view.name = o.getName();
            view.isActive = o.isActive();

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
        return view;
    }
}
