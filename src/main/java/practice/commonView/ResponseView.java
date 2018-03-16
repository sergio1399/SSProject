package practice.commonView;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Common response view
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseView {
    public Boolean result;

    public String error;

    public Object data;

    public ResponseView(Boolean result, String error, Object data) {
        this.result = result;
        this.error = error;
        this.data = data;
    }

    //для jackson
    public ResponseView() {

    }
}
