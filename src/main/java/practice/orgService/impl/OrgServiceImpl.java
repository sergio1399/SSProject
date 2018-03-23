package practice.orgService.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.orgDAO.OrgDAO;
import practice.orgModel.Organization;
import practice.orgService.OrgService;
import practice.orgView.OrgInView;
import practice.orgView.OrgView;

import java.util.ArrayList;
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
        List<Organization> orgList = orgDAO.getOrganizations(fltOrg);

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
