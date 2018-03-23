package practice.controller.docsController;

import practice.view.commonView.ResponseView;

/**
 * Created by sergi on 15.03.2018.
 */
public interface DocsController {
    /**
     * Get all doc types
     * @return JSON doc types values
     */
    ResponseView getDocs();
}
