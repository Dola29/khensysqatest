package BaseClasses;

import org.openqa.selenium.WebDriver;

public abstract class BasePageCommon {
    protected Actions actions = WebDriverActionsManager.getWebDriverActions();
    protected WebDriver driver;
    public BasePageCommon() {
        this.driver = this.actions.getDriver();
    }
}
