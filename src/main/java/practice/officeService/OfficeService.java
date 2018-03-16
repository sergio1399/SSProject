package practice.officeService;

import practice.officeView.OfficeView;
import practice.orgView.OrgInView;
import practice.orgView.OrgView;

import java.util.List;

/**
 * Created by sergi on 15.03.2018.
 */
public interface OfficeService {
    List<OfficeView> getOffices(OfficeView officeView);

    OfficeView getOffice(int id);

    boolean update(OfficeView officeView);

    boolean save(OfficeView officeView);

    boolean delete(int id);
}
