package practice.officeService.impl;

import org.springframework.beans.factory.annotation.Autowired;
import practice.officeDAO.OfficeDAO;
import practice.officeModel.Office;
import practice.officeService.OfficeService;
import practice.officeView.OfficeView;
import practice.orgDAO.OrgDAO;

import java.util.List;

/**
 * Created by sergi on 15.03.2018.
 */
public class OfficeServiceImpl implements OfficeService {
    private final OfficeDAO officeDAO;

    @Autowired
    public OfficeServiceImpl(OfficeDAO officeDAO) {
        this.officeDAO = officeDAO;
    }

    @Override
    public List<OfficeView> getOffices(OfficeView officeView) {
        return null;
    }

    @Override
    public OfficeView getOffice(int id) {
        return null;
    }

    @Override
    public boolean update(OfficeView officeView) {
        return false;
    }

    @Override
    public boolean save(OfficeView officeView) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
