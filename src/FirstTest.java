import lib.CoreTestCase;
import lib.ui.*;
import org.junit.Test;
import org.openqa.selenium.*;

import java.util.Iterator;
import java.util.List;

public class FirstTest extends CoreTestCase
{
//Ex5
    @Test
    public void testSaveTwoArticlesAndDeleteOneOfThem()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElement();

        String article_title = ArticlePageObject.getArticleTitle();
        String name_of_folder = "Learning programming";

        ArticlePageObject.addArticleToMyList(name_of_folder);
        ArticlePageObject.closeArticle();

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("JavaScript");
        SearchPageObject.clickByArticleWithSubstring("Programming language");

        ArticlePageObject.waitForTitleElement();

        String second_article_title = ArticlePageObject.getArticleTitle();

        ArticlePageObject.addMoreArticleToMyList(name_of_folder);
        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.clickMyLists();

        MyListsPageObject MyListsPageObject = new MyListsPageObject(driver);
        MyListsPageObject.openFolderByName(name_of_folder);
        MyListsPageObject.swipeByArticleToDelete(article_title);
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//android.widget.ImageView[@content-desc='More options']"),
//                "Cannot find button to open article options",
//                5
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[@resource-id='org.wikipedia:id/title'][@text='Add to reading list']"),
//                "Cannot find option to add article to reading list",
//                5
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[@resource-id='org.wikipedia:id/item_container']//*[@text='" + name_of_folder + "']"),
//                "Cannot find folder '" + name_of_folder + "' in list",
//                5
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
//                "Cannot close article, cannot find X link",
//                5
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"),
//                "Cannot find navigation button to 'My lists'",
//                10
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[@text='" + name_of_folder + "']"),
//                "Cannot find created folder",
//                10
//        );
//
//        MainPageObject.waitForElementPresent(
//                By.xpath("//*[@text='" + first_search_line + "']"),
//                "Cannot find '" + first_search_line + "' topic in '" + name_of_folder + "' folder" ,
//                5
//        );
//
//        MainPageObject.waitForElementPresent(
//                By.xpath("//*[@text='" + second_search_line + "']"),
//                "Cannot find '" + second_search_line + "' topic in '" + name_of_folder + "' folder" ,
//                5
//        );
//
//        MainPageObject.swipeElementToLeft(
//                By.xpath("//*[@text='" + second_search_line + "']"),
//                "Cannot find saved article"
//        );
//
//        MainPageObject.waitForElementNotPresent(
//                By.xpath("//*[@text='" + second_search_line + "']"),
//                "Cannot delete save article",
//                5
//        );
//
//        MainPageObject.waitForElementPresent(
//                By.xpath("//*[@text='" + first_search_line + "']"),
//                "Cannot find '" + first_search_line + "' topic in '" + name_of_folder + "' folder" ,
//                5
//        );
//
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[@text='" + first_search_line + "']"),
//                "Cannot find '" + first_search_line + "' topic in '" + name_of_folder + "' folder" ,
//                5
//        );
//
//        WebElement title_element = MainPageObject.waitForElementPresent(
//                By.id("org.wikipedia:id/view_page_title_text"),
//                "Cannot find article title",
//                15
//        );
//
//        String article_title = title_element.getAttribute("text");
//
//        assertEquals(
//                "We see unexpected title!",
//                first_search_line,
//                article_title
//        );
    }

//Ex6
    @Test
    public void testAssertElementPresent()
    {
        MainPageObject MainPageObject = new MainPageObject(driver);

        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/search_container"),
                "Cannot find 'Search Wikipedia' input",
                5
        );

        String search_line = "Java (programming language)";

        MainPageObject.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search…')]"),
                search_line,
                "Cannot find search input",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='" + search_line + "']"),
                "Cannot find topic searching by '" + search_line + "'",
                5
        );

        int titile_count = MainPageObject.getAmountOfElements(By.xpath("//*[@resource-id='org.wikipedia:id/view_page_title_text']"));

        assertTrue(
                "Cannot find title '" + search_line + "'",
                titile_count > 0
        );
    }
}