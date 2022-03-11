package Pages;

import BaseClasses.BasePageCommon;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static org.openqa.selenium.By.*;

public class Request extends BasePageCommon {
    //Locators
    private static final String NEW_REQUEST_LINK = "//a[@id='lnkNewCase']";
    private static final String CONFIRMATION_TEXT = "//span[contains(.,'Prueba')]";
    private static final String BTN_ACCEPT_TERMS_CONDITIONS = "//button[@id='btagreements']";
    private static final String LBL_CONTINUE = "//span[contains(@id,'lblContinue')]";

    //Step 2
    private static final String INPUT_MENTOR_NAME = "//input[@id='mentorFullName']";
    private static final String INPUT_MENTOR_POSITION = "//input[contains(@name,'mentorJobPosition')]";
    private static final String INPUT_MENTOR_WORKPLACE = "//input[contains(@name,'mentorWorkplace')]";
    private static final String INPUT_MENTOR_PHONE = "//input[contains(@name,'mentorPhoneNumber')]";
    private static final String INPUT_MENTOR_CELLPHONE = "//input[contains(@id,'mentorCellphone')]";
    private static final String INPUT_MENTOR_EMAIL = "//input[contains(@id,'mentorEmail')]";

    //step3
    private static final String RADIO_TYPE_INVESTIGATION="//label[@id='lbrequestTypeInvestigation']";
    private static final String TEXTAREA_DETAILS="//textarea[contains(@id,'schoolDependencies')]";
    private static final String RADIO_WORK_INSTITUTION= "//input[contains(@id,'organizationName1')]";
    private static final String TEXTAREA_WORK_INSTITUTION = "//textarea[contains(@id,'OrganizationNameSpecification')]";

    //step4
    private static final String TEXTAREA_RESEARCH_TYPE="//textarea[contains(@id,'researchType')]";
    private static final String TEXTAREA_OBJECTIVE="//textarea[contains(@id,'s2objective')]";
    private static final String TEXTAREA_METHODOLOGY="//textarea[contains(@id,'s2Methodology')]";
    private static final String TEXTAREA_SAMPLE="//textarea[contains(@id,'s2Sample')]";

    //step5
    private static final String LBL_APPROVED_TEACHERS="//span[contains(@id,'lblWizarStep5ApprovedTeachers')]";
    private static final String TEXTAREA_IMPORTANCE="//textarea[contains(@id,'investigationImportanceDescription')]";
    private static final String CHK_TERMS_CONDITIONS="//span[contains(@id,'lblWizarStep5TOSConfirmation')]";
    private static final String BTN_TERMS_CONDITIONS="//button[@id='btUserAgreement']";
    private static final String BTN_SEND="//input[contains(@id,'btnEnviar')]";




    //Methods
    @Then("The user can view the Homepage and the user select new request")
    public void homePageValidationAndClickOnNewRequest() throws InterruptedException {
        String userName = "Prueba";
        String confirmation = actions.getText(CONFIRMATION_TEXT);
        Assert.assertEquals(confirmation, userName);
        actions.click(NEW_REQUEST_LINK);
    }

    @Then("Accept the terms and conditions")
    public void acceptTermsAndConditions() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement div = actions.getDriver().findElement(xpath("//*[@id='user-agreement-newcase']"));
        WebElement btn = actions.getDriver().findElement(xpath(BTN_ACCEPT_TERMS_CONDITIONS));

        js.executeScript("arguments[0].scrollTo(0, arguments[0].scrollHeight)", div);
        js.executeScript("arguments[0].click()", btn);
    }

    @And("Complete form Step 1")
    public void completeFormStep1() throws InterruptedException {
        actions.sleep(3000);
        actions.click(LBL_CONTINUE);
    }

    @And("Complete form Step 2")
    public void completeFormStep2() throws InterruptedException {
        actions.setText(INPUT_MENTOR_NAME, "Juan Soto");
        actions.setText(INPUT_MENTOR_POSITION, "Sastre");
        actions.setText(INPUT_MENTOR_WORKPLACE, "Zona Franca");
        WebElement phone =  actions.getDriver().findElement(By.xpath(INPUT_MENTOR_PHONE));
        phone.click();
        phone.sendKeys(Keys.HOME + "1596351214");
        WebElement cellphone =  actions.getDriver().findElement(By.xpath(INPUT_MENTOR_CELLPHONE));
        cellphone.click();
        cellphone.sendKeys(Keys.HOME + "7493659635");
        actions.setText(INPUT_MENTOR_EMAIL, "juan@soto.me");
        actions.sleep(10000);
        actions.click(LBL_CONTINUE);
    }

    @And("Complete form Step 3")
    public void completeFormStep3() throws InterruptedException {
        actions.click(RADIO_TYPE_INVESTIGATION);
        actions.sleep(5000);
        WebElement details =  actions.getDriver().findElement(By.xpath(TEXTAREA_DETAILS));
        actions.sendKeys(details, "Details of this investigation");

        actions.sleep(5000);
        actions.click(RADIO_WORK_INSTITUTION);

        actions.sleep(5000);

        WebElement workIntitution =  actions.getDriver().findElement(By.xpath(TEXTAREA_WORK_INSTITUTION));
        actions.sendKeys(workIntitution, "Work insti");

        actions.sleep(10000);
        actions.click(LBL_CONTINUE);
    }

    @And("Complete form Step 4")
    public void completeFormStep4() throws InterruptedException {
        actions.setText(TEXTAREA_RESEARCH_TYPE, "Research type");
        actions.setText(TEXTAREA_OBJECTIVE, "Objective");
        actions.setText(TEXTAREA_METHODOLOGY, "Methodology");
        actions.setText(TEXTAREA_SAMPLE, "Sample");
        actions.sleep(10000);
        actions.click(LBL_CONTINUE);
    }

    @And("Complete form Step 5")
    public void completeFormStep6() throws InterruptedException {
        actions.sleep(3000);
        actions.click(LBL_APPROVED_TEACHERS);
        actions.setText(TEXTAREA_IMPORTANCE, "Importance");
        actions.click(CHK_TERMS_CONDITIONS);
        actions.sleep(3000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement div = actions.getDriver().findElement(xpath("//*[@id='user-agreement']"));
        WebElement btn = actions.getDriver().findElement(xpath(BTN_TERMS_CONDITIONS));

        js.executeScript("arguments[0].scrollTo(0, arguments[0].scrollHeight)", div);
        js.executeScript("arguments[0].click()", btn);

        actions.sleep(3000);
        actions.click(BTN_SEND);
    }

    @Then("A new request is created")
    public void waitForNextPage() throws InterruptedException {
        actions.sleep(10000);
    }
}
