package BaseClasses;


import io.cucumber.java.AfterAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected Actions actions;
    protected WebDriver webDriver;

    protected static String CHROME_DRIVER_PATH;

    /**
     * @BeforeMethod is used to state that the method under it will be executed before each test case.
     * Required.
     */

    @Given("Since the user enters to CIIE")
    public void setUp() {
        String baseUrl = "https://app-caseplus-dev.azurewebsites.net/";
        CHROME_DRIVER_PATH = "src/main/resources/chromedriver.exe";
        webDriver = WebDriverFactory.initWebDriver(WebDriverFactory.WebDriverType.CHROME, CHROME_DRIVER_PATH);
        WebDriverActionsManager.setWebDriverActions(webDriver);
        webDriver.get(baseUrl);
        actions = WebDriverActionsManager.getWebDriverActions();
    }

    /**
     * @AfterMethod annotation is used to state that the method under it will be executed after each test case.
     * Required.
     */
    @And("Close the browser")
    public void tearDown() throws InterruptedException{
        actions.sleep(5000);
        WebDriverActionsManager.closeDriver();
    }
}

