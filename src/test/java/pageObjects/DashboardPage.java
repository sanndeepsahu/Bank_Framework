package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import utilities.WaitUtils;

public class DashboardPage {

    WebDriver driver;
    WaitUtils wait;
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    By newTransaction = By.id("new-transaction-link");
    By addAccount = By.cssSelector("#add-account-link");

    public void clickNewTransaction() {
        wait.waitForElementVisible(newTransaction).click();
    }
    public void addAccount()
    {
        wait.waitForElementVisible(addAccount).click();
    }
}