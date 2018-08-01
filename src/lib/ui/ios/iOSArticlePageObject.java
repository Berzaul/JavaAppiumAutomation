package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

public class iOSArticlePageObject extends ArticlePageObject {

    static {
        TITLE = "id:Java (programming language)";
        FOOTER_ELEMENT  = "id:View article in browser";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "id:Save for later";
//        CLOSE_ARTICLE_BUTTON = "id:Wikipedia, return to Explore";
        CLOSE_ARTICLE_BUTTON = "id:Search";
        CANCEL_SEARCH_BUTTON = "id:Cancel";
        MY_LIST_FOLDER_ITEM_TPL = "xpath://*[@resource-id='org.wikipedia:id/item_container']//*[@text='{FOLDER_NAME}']";
    }

    public iOSArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
