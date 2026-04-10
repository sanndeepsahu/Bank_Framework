package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    By username = By.id("username");
    By password = By.id("password");
    By loginBtn = By.id("login-btn");

    public void clickLogin(String user, String pwd)
    {
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(loginBtn).click();
    }

}
