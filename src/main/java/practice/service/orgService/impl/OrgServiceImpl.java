package practice.service.orgService.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.dao.orgDAO.OrgDAO;
import practice.model.orgModel.Organization;
import practice.service.orgService.OrgService;
import practice.utils.OrgConverter;
import practice.view.orgView.OrgInView;
import practice.view.orgView.OrgView;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by sergi on 13.03.2018.
 */
@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class OrgServiceImpl implements OrgService {

    private final OrgDAO orgDAO;

    @Autowired
    public OrgServiceImpl(OrgDAO orgDAO) {
        this.orgDAO = orgDAO;
    }

    @Override
    public List<OrgView> getOrganizations(OrgInView orgInView) {
        Organization fltOrg = new Organization(orgInView.name, orgInView.inn, orgInView.isActive);
        return OrgConverter.toViewList(orgDAO.getOrganizations(fltOrg));
    }

    @Override
    public OrgView getOrg(long id) {

        Organization org = orgDAO.getOrg(id);
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

    @Override
    @Transactional
    public boolean update(OrgView orgView) {
        //проверяем на null id
        //if( orgView.name == null)
        //throw new NullRequiredValue();
        Organization org = new Organization(orgView.id, orgView.name, orgView.fullName, orgView.inn, orgView.kpp,
                                            orgView.address, orgView.phone, orgView.isActive);

        return orgDAO.update(org);
    }

    @Override
    @Transactional
    public boolean save(OrgView orgView) {
        Organization org = new Organization(orgView.name, orgView.fullName, orgView.inn, orgView.kpp,
                orgView.address, orgView.phone, orgView.isActive);
        return orgDAO.save(org);
    }

    @Override
    @Transactional
    public boolean delete(long id) {

        return orgDAO.delete(id);
    }
}