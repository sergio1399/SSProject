package practice.dao.officeDAO;

import practice.model.officeModel.Office;
import practice.utils.MyAppException;

import java.util.List;

/**
 * Created by sergi on 15.03.2018.
 */
public interface OfficeDAO {
    List<Office> getOffices(long orgId,  Office fltOffice);

    Office getOffice(long id) throws MyAppException;

    boolean update(Office office);

    boolean save(Office office);

    boolean delete(long id);
}
