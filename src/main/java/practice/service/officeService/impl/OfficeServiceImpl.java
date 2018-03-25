package practice.service.officeService.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.dao.officeDAO.OfficeDAO;
import practice.model.officeModel.Office;
import practice.service.officeService.OfficeService;
import practice.utils.ErrorCode;
import practice.utils.MyAppException;
import practice.utils.OfficeConverter;
import practice.view.officeView.OfficeInView;
import practice.view.officeView.OfficeView;
import practice.model.orgModel.Organization;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by sergi on 15.03.2018.
 */
@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class OfficeServiceImpl implements OfficeService {
    private final OfficeDAO officeDAO;

    @Autowired
    public OfficeServiceImpl(OfficeDAO officeDAO) {
        this.officeDAO = officeDAO;
    }

    @Override
    public List<OfficeView> getOffices(OfficeInView officeInView) {

        Office fltOffice = new Office(officeInView.name, officeInView.phone, officeInView.isActive);
        return OfficeConverter.toViewList(officeDAO.getOffices(officeInView.orgId, fltOffice));
    }

    @Override
    public OfficeView getOffice(long id) throws MyAppException {

        return OfficeConverter.toView(officeDAO.getOffice(id));
    }

    @Override
    @Transactional
    public boolean update(OfficeView officeView) throws MyAppException {
        //проверяем на null id
        if( officeView.id == null)
            throw new MyAppException("Не установлен обязательный параметр id", ErrorCode.NULL_REQUIRED_PARAM);
        Office officeToUpdate = new Office(officeView.id, officeView.name, officeView.address, officeView.phone,
                                            officeView.isActive);
        return officeDAO.update(officeToUpdate);
    }

    @Override
    @Transactional
    public boolean save(OfficeView officeView) throws MyAppException {
        if( officeView.orgId == null)
            throw new MyAppException("Не установлен обязательный параметр id организации", ErrorCode.NULL_REQUIRED_PARAM);
        Office officeToSave = new Office(officeView.name, officeView.address, officeView.phone,
                officeView.isActive);
        Organization org = new Organization(officeView.orgId);
        officeToSave.setOrganization(org);
        return officeDAO.save(officeToSave);
    }

    @Override
    @Transactional
    public boolean delete(long id) {

        return officeDAO.delete(id);
    }
}
