package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.WaitUtils;

public class TransactionPage {

    WebDriver driver;
    WaitUtils wait;
    public TransactionPage(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    By transactionType = By.id("transaction-type");
    By fromAccount = By.id("from-account");
    By amount = By.id("transaction-amount");
    By submitBtn = By.id("submit-transaction-btn");

    public void selectTransactionType(String type)
    {
        wait.waitForElementClickable(transactionType).click();
        By typeOption = By.xpath("//div[normalize-space()='" + type + "']");
        wait.waitForElementVisible(typeOption).click();

    }
    public void selectAccount(String account)
    {
        driver.findElement(fromAccount).click();
        By accountOption = By.xpath("//div[starts-with(normalize-space(),'" + account + "')]");
        wait.waitForElementVisible(accountOption).click();
    }

    private static final Logger log = LogManager.getLogger(TransactionPage.class);
    public void enterAmount(String amt)
    {
        log.info("Entering amount: " + amt);
        driver.findElement(amount).sendKeys(amt);
    }

    public void submitTransaction() {
        driver.findElement(submitBtn).click();
    }

    public String getAlertText()
    {
        wait.waitForAlert();
        return driver.switchTo().alert().getText();
    }

    public void acceptAlert()
    {
        driver.switchTo().alert().accept();
    }

}
