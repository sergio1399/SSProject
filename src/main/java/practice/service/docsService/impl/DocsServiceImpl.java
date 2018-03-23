package practice.service.docsService.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import practice.dao.docsDAO.DocsDAO;
import practice.model.docsModel.Doc_types;
import practice.service.docsService.DocsService;
import practice.utils.DocsConverter;
import practice.view.docsView.DocsView;

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
        return DocsConverter.toViewList(docsDAO.getDocs());
    }
}
