package practice.view.docsView;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Document types data view
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DocsView {
    public String code;

    public String name;

    //для jackson
    public DocsView() {

    }

    @Override
    public String toString() {
        return "DocsView{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
