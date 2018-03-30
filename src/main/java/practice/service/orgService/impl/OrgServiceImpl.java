package practice.service.orgService.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.dao.orgDAO.OrgDAO;
import practice.model.orgModel.Organization;
import practice.service.employeeService.impl.EmployeeServiceImpl;
import practice.service.orgService.OrgService;
import practice.utils.ErrorCode;
import practice.utils.MyAppException;
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
    private final Logger log = LoggerFactory.getLogger(OrgServiceImpl.class);

    private final OrgDAO orgDAO;

    @Autowired
    public OrgServiceImpl(OrgDAO orgDAO) {
        this.orgDAO = orgDAO;
    }

    @Override
    public List<OrgView> getOrganizations(OrgInView orgInView) throws MyAppException {
        log.debug(orgInView.toString());
        //проверяем на null обязательное поле
        if( orgInView.name == null)
            throw new MyAppException("Не установлен обязательный параметр название организации", ErrorCode.NULL_REQUIRED_PARAM);
        Organization fltOrg = OrgConverter.toModel(orgInView);
        return OrgConverter.toViewList(orgDAO.getOrganizations(fltOrg));
    }

    @Override
    public OrgView getOrg(long id) throws MyAppException {
        Organization org = orgDAO.getOrg(id);
        OrgView view = OrgConverter.toView(org);
        return view;
    }

    @Override
    @Transactional
    public boolean update(OrgView orgView) throws MyAppException {
        log.debug(orgView.toString());
        //проверяем на null обязательное поле
        if( orgView.name == null)
            throw new MyAppException("Не установлен обязательный параметр название организации", ErrorCode.NULL_REQUIRED_PARAM);
        Organization org = OrgConverter.toModel(orgView);
        return orgDAO.update(org);
    }

    @Override
    @Transactional
    public boolean save(OrgView orgView) {
        log.debug(orgView.toString());
        Organization org = OrgConverter.toModel(orgView);
        return orgDAO.save(org);
    }

    @Override
    @Transactional
    public boolean delete(long id) {
        return orgDAO.delete(id);
    }
}
