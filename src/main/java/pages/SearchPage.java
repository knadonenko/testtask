package pages;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driverutils.DriverManager;
import driverutils.WaitActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class SearchPage {

    WaitActions waitActions;

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchInput;
    @FindBy(xpath = "//li[@class='sbct']")
    private List<WebElement> suggestionList;

    public SearchPage(){}

    public SearchPage(WebDriver webDriver1){
        PageFactory.initElements(webDriver1, this);
        waitActions = new WaitActions(webDriver1);
    }

    @Given("^I open browser$")
    public void iOpenBrowser() {
//        webDriver = new DriverManager().setupDriver();
//        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        initElements();
    }

    private void initElements() {
//        PageFactory.initElements(webDriver, this);
//        waitActions = new WaitActions(webDriver);
    }

    @Then("^I open Google Page$")
    public void openGooglePage() {
//        webDriver.get("https://www.google.com/");
    }

    @When("^I search for (.+)$")
    public void searchText(String textToSearch) {
        searchInput.sendKeys(textToSearch);
    }

    @Then("^I see valid suggestion with text (.+)")
    public void verifyFirstSuggestion(String correctText) {
        waitForSuggestionsToAppear();
        assertEquals(correctText, suggestionList.get(0).getText());
    }

    @Then("^Results are valid")
    public void newMethod() {

    }

    private void waitForSuggestionsToAppear() {
        waitActions.waitUntilCondition(ex -> suggestionList.size() != 1);
    }

}
