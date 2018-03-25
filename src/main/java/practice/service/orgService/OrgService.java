package practice.service.orgService;

import practice.utils.MyAppException;
import practice.view.orgView.OrgInView;
import practice.view.orgView.OrgView;

import java.util.List;

/**
 * Created by sergi on 13.03.2018.
 */
public interface OrgService {

    List<OrgView> getOrganizations(OrgInView orgInView) throws MyAppException;

    OrgView getOrg(long id) throws MyAppException;

    boolean update(OrgView orgView) throws MyAppException;

    boolean save(OrgView orgView);

    boolean delete(long id);

}
