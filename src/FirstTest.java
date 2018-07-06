import lib.CoreTestCase;
import lib.ui.*;
import org.junit.Test;
import org.openqa.selenium.*;

import java.util.Iterator;
import java.util.List;

public class FirstTest extends CoreTestCase
{
//Ex2
//    @Test
//    public void testCompareSearchText()
//    {
//        MainPageObject.waitForElementAndClick(
//                By.id("org.wikipedia:id/search_container"),
//                "Cannot find 'Search Wikipedia' input",
//                5
//        );
//
//        WebElement text_element = MainPageObject.waitForElementPresent(
//                By.id("org.wikipedia:id/search_src_text"),
//                "Cannot find search area",
//                5
//        );
//
//        String search_text = text_element.getAttribute("text");
//
//        assertEquals(
//                "The text in the search bar does not match the expected",
//                "Search…",
//                search_text
//        );
//    }
//Ex3
    @Test
    public void testCountResults()
    {
        String search_word = "Java";

        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/search_container"),
                "Cannot find 'Search Wikipedia' input",
                5
        );

        MainPageObject.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search…')]"),
                search_word,
                "Cannot find search input",
                10
        );

        String search_result_locator = "//*[@resource-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/page_list_item_container']";

        MainPageObject.waitForElementPresent(
                By.xpath(search_result_locator),
                "Search for a given word '" + search_word + "' found nothing",
                10
        );

        int elements_count = MainPageObject.getAmountOfElements(
                By.xpath(search_result_locator)
        );

        assertTrue(
                "We found too few results!",
                elements_count > 1
        );

        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/search_close_btn"),
                "Cannot find X to cancel search",
                5
        );

        MainPageObject.waitForElementNotPresent(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
                "X is still present on page",
                5
        );
    }

//Ex4
//    @Test
//    public void testCompareSearchResults()
//    {
//        String search_word = "Java";
//
//        MainPageObject.waitForElementAndClick(
//                By.id("org.wikipedia:id/search_container"),
//                "Cannot find 'Search Wikipedia' input",
//                5
//        );
//
//        MainPageObject.waitForElementAndSendKeys(
//                By.xpath("//*[contains(@text, 'Search…')]"),
//                search_word,
//                "Cannot find search input",
//                10
//        );
//
//        MainPageObject.waitForElementPresent(
//                By.id("org.wikipedia:id/page_list_item_container"),
//                "Search for a given word '" + search_word + "' found nothing",
//                10
//        );
//
//        List<WebElement> list_containers = driver.findElements(By.id("org.wikipedia:id/page_list_item_container"));
//
//        Iterator<WebElement> iter_containers = list_containers.iterator();
//        while(iter_containers.hasNext())
//        {
//            List<WebElement> list_title = iter_containers.next().findElements(By.id("org.wikipedia:id/page_list_item_title"));
//
//            Iterator<WebElement> iter_title = list_title.iterator();
//            while(iter_title.hasNext())
//            {
//                String title_text = iter_title.next().getAttribute("text");
//
//                assertTrue(
//                        "One of the titles '" + title_text + "' does not contain the search word '" + search_word + "'",
//                        title_text.toLowerCase().contains(search_word.toLowerCase())
//                );
//            }
//        }
//    }

//Ex5
    @Test
    public void testSaveTwoArticlesAndDeleteOneOfThem()
    {
        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/search_container"),
                "Cannot find 'Search Wikipedia' input",
                5
        );

        String first_search_line = "Java (programming language)";

        MainPageObject.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search…')]"),
                first_search_line,
                "Cannot find search input",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='" + first_search_line + "']"),
                "Cannot find topic searching by '" + first_search_line + "'",
                5
        );

        MainPageObject.waitForElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Cannot find article title",
                15
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='More options']"),
                "Cannot find button to open article options",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/title'][@text='Add to reading list']"),
                "Cannot find option to add article to reading list",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/onboarding_button"),
                "Cannot find 'Got it' tip overlay",
                5
        );

        MainPageObject.waitForElementAndClear(
                By.id("org.wikipedia:id/text_input"),
                "Cannot find input to set name of articles folder",
                5
        );

        String name_of_folder = "Learning programming";

        MainPageObject.waitForElementAndSendKeys(
                By.id("org.wikipedia:id/text_input"),
                name_of_folder,
                "Cannot put text into articles folder input",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@text='OK']"),
                "Cannot press OK button",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot close article, cannot find X link",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/search_container"),
                "Cannot find 'Search Wikipedia' input",
                5
        );

        String second_search_line = "JavaScript";

        MainPageObject.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search…')]"),
                second_search_line,
                "Cannot find search input",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='" + second_search_line + "']"),
                "Cannot find topic searching by '" + second_search_line + "'",
                5
        );

        MainPageObject.waitForElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Cannot find article title",
                15
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='More options']"),
                "Cannot find button to open article options",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/title'][@text='Add to reading list']"),
                "Cannot find option to add article to reading list",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/item_container']//*[@text='" + name_of_folder + "']"),
                "Cannot find folder '" + name_of_folder + "' in list",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot close article, cannot find X link",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"),
                "Cannot find navigation button to 'My lists'",
                10
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@text='" + name_of_folder + "']"),
                "Cannot find created folder",
                10
        );

        MainPageObject.waitForElementPresent(
                By.xpath("//*[@text='" + first_search_line + "']"),
                "Cannot find '" + first_search_line + "' topic in '" + name_of_folder + "' folder" ,
                5
        );

        MainPageObject.waitForElementPresent(
                By.xpath("//*[@text='" + second_search_line + "']"),
                "Cannot find '" + second_search_line + "' topic in '" + name_of_folder + "' folder" ,
                5
        );

        MainPageObject.swipeElementToLeft(
                By.xpath("//*[@text='" + second_search_line + "']"),
                "Cannot find saved article"
        );

        MainPageObject.waitForElementNotPresent(
                By.xpath("//*[@text='" + second_search_line + "']"),
                "Cannot delete save article",
                5
        );

        MainPageObject.waitForElementPresent(
                By.xpath("//*[@text='" + first_search_line + "']"),
                "Cannot find '" + first_search_line + "' topic in '" + name_of_folder + "' folder" ,
                5
        );


        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@text='" + first_search_line + "']"),
                "Cannot find '" + first_search_line + "' topic in '" + name_of_folder + "' folder" ,
                5
        );

        WebElement title_element = MainPageObject.waitForElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Cannot find article title",
                15
        );

        String article_title = title_element.getAttribute("text");

        assertEquals(
                "We see unexpected title!",
                first_search_line,
                article_title
        );
    }

//Ex6
    @Test
    public void testAssertElementPresent()
    {
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

        assertTrue(
                "Cannot find title '" + search_line + "'",
                MainPageObject.isElementPresent(By.xpath("//*[@resource-id='org.wikipedia:id/view_page_title_text']"))
        );
    }
}