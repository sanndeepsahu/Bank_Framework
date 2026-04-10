package testcases;

import base.BaseTest;
import org.testng.annotations.Test;
import pageObjects.DashboardPage;
import pageObjects.TransactionPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TransactionTest extends BaseTest {

    private static final Logger log = LogManager.getLogger(TransactionTest.class);

    @Test(groups = {"regression"})
    public void depositTest()
    {
        log.info("Starting deposit test");
        loginToApplication();
        DashboardPage dashboard = new DashboardPage(getDriver());
        dashboard.clickNewTransaction();
        log.info("Clicked on new transaction");

        TransactionPage transaction = new TransactionPage(getDriver());
        transaction.selectTransactionType("Deposit");
        log.info("Selected transaction type");
        transaction.selectAccount("Primary Savings");
        transaction.enterAmount("500.00");
        log.info("Entered amount");
        transaction.submitTransaction();
        log.info("Submitted transaction");
        System.out.println(transaction.getAlertText());
        transaction.acceptAlert();
    }
}
