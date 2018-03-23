package practice.dao.docsDAO;

import practice.model.docsModel.Doc_types;

import java.util.List;

/**
 * Created by sergi on 15.03.2018.
 */
public interface DocsDAO {

    List<Doc_types> getDocs();
}
