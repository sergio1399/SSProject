package practice.officeService;

import practice.officeView.OfficeInView;
import practice.officeView.OfficeView;
import practice.orgView.OrgInView;
import practice.orgView.OrgView;

import java.util.List;

/**
 * Created by sergi on 15.03.2018.
 */
public interface OfficeService {
    List<OfficeView> getOffices(OfficeInView officeInView);

    OfficeView getOffice(long id);

    boolean update(OfficeView officeView);

    boolean save(OfficeView officeView);

    boolean delete(long id);
}
