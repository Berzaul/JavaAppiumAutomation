package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;

abstract public class MyListsPageObject extends MainPageObject {

    protected static String
            FOLDER_BY_NAME_TPL,
            ARTICLE_BY_TITLE_TPL,
            CLOSE_SYNC_ALERT;

    private static String getFolderXpathByName(String name_of_folder)
    {
        return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}", name_of_folder);
    }

    private static String getSavedArticleXpathByTitle(String article_title)
    {
        return ARTICLE_BY_TITLE_TPL.replace("{ARTICLE}", article_title);
    }


    public MyListsPageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public void openFolderByName(String name_of_folder)
    {
        String folder_name_xpath = getFolderXpathByName(name_of_folder);
        this.waitForElementAndClick(
                folder_name_xpath,
                "Cannot find folder by name '" + name_of_folder + "'",
                5
        );
    }

    public void waitForArticleToAppearByTitle(String article_title)
    {
        String article_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementPresent(
                article_xpath,
                "Cannot find saved article by title '" + article_title + "'",
                15
        );
    }

    public void waitForArticleToDisappearByTitle(String article_title)
    {
        String article_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementNotPresent(
                article_xpath,
                "Saved article still present with title '" + article_title + "'",
                15
        );
    }

    public void swipeByArticleToDelete(String article_title)
    {
        this.waitForArticleToAppearByTitle(article_title);
        String article_xpath = getSavedArticleXpathByTitle (article_title);
        this.swipeElementToLeft(
                article_xpath,
                "Cannot find saved article"
        );

        if(Platform.getInstance().isIOS()) {
            this.clickElementToTheRightUpperCorner(article_xpath, "Cannot find saved article");
        }

        this.waitForArticleToDisappearByTitle(article_title);
    }

    public void openArticleInFolder(String article_title)
    {
        String article_xpath = getSavedArticleXpathByTitle (article_title);
        this.waitForElementAndClick(
                article_xpath,
                "Cannot find article in folder",
                5
        );
    }

    public void closeSyncAlert(){
        //Знаю что в waitForElementAndClick используется waitForElementPresent но если тут убираю его то перестает закрывать алерт, хз почему
        this.waitForElementPresent(
                CLOSE_SYNC_ALERT,
                "Cannot find sync alert",
                10
        );
        this.waitForElementAndClick(
                CLOSE_SYNC_ALERT,
                "Cannot find close button on sync alert",
                20
        );
        this.waitForElementNotPresent(
                CLOSE_SYNC_ALERT,
                "Sync alert is still here",
                10
        );
    }
}
