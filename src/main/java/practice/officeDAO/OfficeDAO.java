package practice.officeDAO;

import practice.officeModel.Office;
import practice.officeView.OfficeInView;
import practice.officeView.OfficeView;
import practice.orgModel.Organization;
import practice.orgView.OrgInView;
import practice.orgView.OrgView;

import java.util.List;

/**
 * Created by sergi on 15.03.2018.
 */
public interface OfficeDAO {
    List<Office> getOffices(long orgId,  Office fltOffice);

    Office getOffice(long id);

    boolean update(Office office);

    boolean save(Office office);

    boolean delete(long id);
}
