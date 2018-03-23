package practice.dao.orgDAO;

import practice.model.orgModel.Organization;

import java.util.List;

/**
 * Created by sergi on 13.03.2018.
 */
public interface OrgDAO {

    List<Organization> getOrganizations(Organization fltOrg);

    Organization getOrg(long id);

    boolean update(Organization org);

    boolean save(Organization org);

    boolean delete(long id);
}
