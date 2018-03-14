package practice.orgService.impl;

import org.springframework.beans.factory.annotation.Autowired;
import practice.orgDAO.OrgDAO;
import practice.orgService.OrgService;
import practice.orgView.OrgInView;
import practice.orgView.OrgView;

import java.util.List;

/**
 * Created by sergi on 13.03.2018.
 */
public class OrgServiceImpl implements OrgService {

    private final OrgDAO orgDAO;

    @Autowired
    public OrgServiceImpl(OrgDAO orgDAO) {
        this.orgDAO = orgDAO;
    }

    @Override
    public List<OrgView> getOrganizations(OrgInView orgInView) {
        return null;
    }

    @Override
    public OrgView getOrg(int id) {
        return null;
    }

    @Override
    public boolean update(OrgView orgView) {
        return false;
    }

    @Override
    public boolean save(OrgView orgView) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
