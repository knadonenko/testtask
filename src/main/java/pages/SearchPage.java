package pages;

import driverutils.WaitActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SearchPage {

    WaitActions waitActions;

    @FindBy(xpath = "//input[@title='Поиск']")
    WebElement searchInput;
    @FindBy(xpath = "//li[@class='sbct']")
    List<WebElement> suggestionList;

    public SearchPage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
        waitActions = new WaitActions(webDriver);
    }

    public void searchText(String textToSearch) {
        searchInput.sendKeys(textToSearch);
    }

    public void verifyFirstSuggestion(String correctText) {
        waitForSuggestionsToAppear();
        assertEquals(correctText, suggestionList.get(0).getText());
    }

    private void waitForSuggestionsToAppear() {
        waitActions.waitUntilCondition((ExpectedCondition<Boolean>)
                ex -> suggestionList.size() != 1);
    }

}
