package Pages;
import BaseClasses.BasePageCommon;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class Login extends BasePageCommon {

    //Locators

    private static final String INPUT_USER = "//*[@id='txtUsername']";
    private static final String INPUT_PASSWORD = "//*[@id='txtPassword']";
    private static final String BTN_ENTER = "//*[@id='btnEnter']";
    private static final String CONFIRMATION_TEXT = "//span[contains(.,'Prueba')]";

    //Methods
    @When("^The user enters to CIIE with (.*) and password (.*)$")
    public void setUserAndPassword(String user, String password) throws InterruptedException{
        actions.setText(INPUT_USER, user);
        actions.setText(INPUT_PASSWORD, password);
        actions.click(BTN_ENTER);
    }

    @Then("The user can view the Homepage")
    public void homePageValidation() throws InterruptedException {
        String userName = "Prueba";
        String confirmation = actions.getText(CONFIRMATION_TEXT);
        Assert.assertEquals(confirmation, userName);
    }
}
