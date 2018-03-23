package practice.utils;

import practice.model.employeeModel.Employee;
import practice.model.officeModel.Office;
import practice.view.employeeView.EmployeeView;
import practice.view.officeView.OfficeView;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by sergi on 23.03.2018.
 */
public class OfficeConverter {
    public static List<OfficeView> toViewList(List<Office> offices)
    {
        Function<Office, OfficeView> mapOffice = o -> {
            OfficeView view = new OfficeView();
            view.id = o.getId();
            view.name = o.getName();
            view.address = o.getAddress();
            view.phone = o.getPhone();
            view.isActive = o.isActive();

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
        return view;
    }


}
