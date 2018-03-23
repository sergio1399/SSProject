package practice.docsService.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import practice.docsDAO.DocsDAO;
import practice.docsModel.Doc_types;
import practice.docsService.DocsService;
import practice.docsView.DocsView;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by sergi on 15.03.2018.
 */
@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class DocsServiceImpl implements DocsService {
    private final DocsDAO docsDAO;

    @Autowired
    public DocsServiceImpl(DocsDAO docsDAO) {
        this.docsDAO = docsDAO;
    }
    @Override
    public List<DocsView> getDocs() {
        List<Doc_types> doc_types = docsDAO.getDocs();

        Function<Doc_types, DocsView> mapDocs = d -> {
            DocsView view = new DocsView();
            view.name = d.getName();
            view.code = d.getCode();

            return view;
        };

        return doc_types.stream()
                .map(mapDocs)
                .collect(Collectors.toList());

    }
}
