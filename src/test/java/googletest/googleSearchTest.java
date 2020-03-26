package googletest;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.SearchPage;

public class googleSearchTest extends BaseTest {

    @Test
    @DisplayName("Google search test")
    public void testGoogleSearch() {

        webDriver.get("https://www.google.com/");

        SearchPage searchPage = new SearchPage(webDriver);
        searchPage.searchText("yandex.ru");
        searchPage.verifyFirstSuggestion("yandex.ru");

    }

}
