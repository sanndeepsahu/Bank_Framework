package testcases;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import pageObjects.DashboardPage;
import pageObjects.WithdrawalPage;

public class WithdrawalTest extends BaseTest {

    private static final Logger log = LogManager.getLogger(WithdrawalTest.class);

    @Test(groups = {"regression"})
    public void Withdrawal()
    {
        log.info("Starting Withdrawal test");
        loginToApplication();
        DashboardPage dashboard = new DashboardPage(getDriver());
        dashboard.clickNewTransaction();

        WithdrawalPage withdrawal = new WithdrawalPage(getDriver());
        withdrawal.selectTransactionType("Withdrawal");
        log.info("Selected transaction type");
        withdrawal.selectAccount("Primary Savings");
        log.info("Selected Primary Account");
        withdrawal.enterAmount("1000.00");
        log.info("Entered amount");
        withdrawal.submitTransaction();
        log.info("Withdrawal done");
    }
}
