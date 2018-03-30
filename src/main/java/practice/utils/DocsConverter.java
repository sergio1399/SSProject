package practice.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import practice.model.countriesModel.Country;
import practice.model.docsModel.Doc_types;
import practice.view.countriesView.CountriesView;
import practice.view.docsView.DocsView;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by sergi on 23.03.2018.
 */
public class DocsConverter {
    private static final Logger log = LoggerFactory.getLogger(DocsConverter.class);
    public static List<DocsView> toViewList(List<Doc_types> docTypes)
    {
        Function<Doc_types, DocsView> mapDocs = d -> {
            DocsView view = new DocsView();
            view.name = d.getName();
            view.code = d.getCode();
            log.debug(view.toString());
            return view;
        };

        return docTypes.stream()
                .map(mapDocs)
                .collect(Collectors.toList());
    }
}
