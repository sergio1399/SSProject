package practice.service.officeService;

import practice.view.officeView.OfficeInView;
import practice.view.officeView.OfficeView;

import java.util.List;

/**
 * Created by sergi on 15.03.2018.
 */
public interface OfficeService {
    List<OfficeView> getOffices(OfficeInView officeInView);

    OfficeView getOffice(long id);

    boolean update(OfficeView officeView);

    boolean save(OfficeView officeView);

    boolean delete(long id);
}
