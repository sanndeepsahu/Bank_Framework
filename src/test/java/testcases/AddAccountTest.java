package testcases;
// There will be many log function like log.info, log.debug, log.warning, log.error-->
import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import pageObjects.AddAccountPage;
import pageObjects.DashboardPage;

public class AddAccountTest extends BaseTest {

    private static final Logger log = LogManager.getLogger(AddAccountTest.class);

    @Test(groups = {"smoke", "regression"})
    public void addAccountTest()
    {
        log.info("Starting AddAccount test");
        loginToApplication();
        DashboardPage dashboard = new DashboardPage(getDriver());
        dashboard.addAccount();
        log.info("Clicked on new ADD Account");

        AddAccountPage addAccount = new AddAccountPage(getDriver());
        addAccount.enterAccountName("Sandeep");
        addAccount.selectAccountType();
        addAccount.initialBalance("1000.00");
        log.info("Entered amount");
        addAccount.clickSaveBtn();
        System.out.println("Account added successfully!");

    }
}
