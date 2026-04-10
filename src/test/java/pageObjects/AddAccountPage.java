package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.WaitUtils;

public class AddAccountPage {

    WebDriver driver;
    WaitUtils wait;
    public AddAccountPage(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    By accountName = By.id("account-name");
    By accountType = By.id("account-type");
    By initialBalance = By.id("initial-balance");
    By save = By.id("save-account-btn");

    public void enterAccountName(String name)
    {
        wait.waitForElementVisible(accountName).sendKeys(name);
//        driver.findElement(accountName).sendKeys(name);
    }
    public void selectAccountType()
    {
        wait.waitForElementClickable(accountType).click();
        By selectAccount = By.xpath("//div[normalize-space()='Savings Account']");
        wait.waitForElementVisible(selectAccount).click();
    }

    public void initialBalance(String balance)
    {
        driver.findElement(initialBalance).sendKeys(balance);
    }

    public void clickSaveBtn()
    {
        driver.findElement(save).click();
    }
}
