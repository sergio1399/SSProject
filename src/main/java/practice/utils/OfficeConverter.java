package practice.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import practice.model.employeeModel.Employee;
import practice.model.officeModel.Office;
import practice.model.orgModel.Organization;
import practice.view.employeeView.EmployeeView;
import practice.view.officeView.OfficeInView;
import practice.view.officeView.OfficeView;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by sergi on 23.03.2018.
 */
public class OfficeConverter {
    private static final Logger log = LoggerFactory.getLogger(OfficeConverter.class);
    public static List<OfficeView> toViewList(List<Office> offices)
    {
        Function<Office, OfficeView> mapOffice = o -> {
            OfficeView view = new OfficeView();
            view.id = o.getId();
            view.name = o.getName();
            view.address = o.getAddress();
            view.phone = o.getPhone();
            view.isActive = o.isActive();
            log.debug(view.toString());
            return view;
        };

        return offices.stream()
                .map(mapOffice)
                .collect(Collectors.toList());
    }

    public static OfficeView toView(Office office) {
        OfficeView view = new OfficeView();
        view.id = office.getId();
        view.name = office.getName();
        view.address = office.getAddress();
        view.phone = office.getPhone();
        view.isActive = office.isActive();
        log.debug(view.toString());
        return view;
    }

    public static Office toModel(OfficeInView officeInView)
    {
        return new Office(officeInView.name, officeInView.phone, officeInView.isActive);
    }

    public static Office toModel(OfficeView officeView)
    {
        Office office = null;
        if(officeView.id != null)
            office = new Office(officeView.id, officeView.name, officeView.address, officeView.phone,
                              officeView.isActive);
        else
            office = new Office(officeView.name, officeView.address, officeView.phone,
                    officeView.isActive);
        if(officeView.orgId != null)
        {
            Organization org = new Organization(officeView.orgId);
            office.setOrganization(org);
        }
        return office;
    }


}
