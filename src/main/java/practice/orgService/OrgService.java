package practice.orgService;

import practice.orgView.OrgInView;
import practice.orgView.OrgView;

import java.util.List;

/**
 * Created by sergi on 13.03.2018.
 */
public interface OrgService {

    List<OrgView> getOrganizations(OrgInView orgInView);

    OrgView getOrg(long id);

    boolean update(OrgView orgView);

    boolean save(OrgView orgView);

    boolean delete(long id);

}
