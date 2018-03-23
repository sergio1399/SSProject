package practice.officeService.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.officeDAO.OfficeDAO;
import practice.officeModel.Office;
import practice.officeService.OfficeService;
import practice.officeView.OfficeInView;
import practice.officeView.OfficeView;
import practice.orgDAO.OrgDAO;
import practice.orgModel.Organization;
import practice.orgView.OrgView;

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
        List<Office> officeList = officeDAO.getOffices(officeInView.orgId, fltOffice);

        Function<Office, OfficeView> mapOffice = o -> {
            OfficeView view = new OfficeView();
            view.id = o.getId();
            view.name = o.getName();
            view.address = o.getAddress();
            view.phone = o.getPhone();
            view.isActive = o.isActive();

            return view;
        };

        return officeList.stream()
                .map(mapOffice)
                .collect(Collectors.toList());
    }

    @Override
    public OfficeView getOffice(long id) {
        Office office = officeDAO.getOffice(id);
        OfficeView view = new OfficeView();
        view.id = office.getId();
        view.name = office.getName();
        view.address = office.getAddress();
        view.phone = office.getPhone();
        view.isActive = office.isActive();
        return view;
    }

    @Override
    @Transactional
    public boolean update(OfficeView officeView) {
        //проверяем на null id
        //if( officeView.id == null)
            //throw new NullInValue();
        Office officeToUpdate = new Office(officeView.id, officeView.name, officeView.address, officeView.phone,
                                            officeView.isActive);
        return officeDAO.update(officeToUpdate);
    }

    @Override
    @Transactional
    public boolean save(OfficeView officeView) {
        //if( officeView.orgId == null)
        //throw new NullInValue();
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
