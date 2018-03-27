package practice.service.officeService;

import practice.utils.MyAppException;
import practice.view.officeView.OfficeInView;
import practice.view.officeView.OfficeView;

import java.util.List;

/**
 * Created by sergi on 15.03.2018.
 */
public interface OfficeService {
    List<OfficeView> getOffices(OfficeInView officeInView) throws MyAppException;

    OfficeView getOffice(long id) throws MyAppException;

    boolean update(OfficeView officeView) throws MyAppException;

    boolean save(OfficeView officeView) throws MyAppException;

    boolean delete(long id);
}
