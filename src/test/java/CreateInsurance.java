import Base.ConfigReader;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

import java.awt.*;


public class CreateInsurance extends BaseTest {
    private LoginPage login;
    private NewInsurancePage newInsurance;
    private paymentPage payment;
    private ListingPage listing;
    private MultiplePage bulk;

    @BeforeTest
    public void pageSetup() {
        login = new LoginPage(driver);
        newInsurance = new NewInsurancePage(driver);
        payment = new paymentPage(driver);
        listing = new ListingPage(driver);
        bulk = new MultiplePage(driver);
        Reporter.log("------Test Started--------");
    }

    @Test(priority = 0)
    public void loginToInsurance() {
        login.setLanguage();
        login.login(ConfigReader.get("username"), ConfigReader.get("password"));
        Reporter.log("Login Successful", true);
        Assert.assertTrue(newInsurance.isUserLoggedIn(), "Login Failed");
    }

    @Test(priority = 1)
    public void CreateInsuranceCredit() throws InterruptedException {
        Reporter.log("Creating New Insurance", true);
        Reporter.log("Adding Product Details", true);
        newInsurance.product();
        newInsurance.nextClick();
        Reporter.log("Adding Customer Details", true);
        newInsurance.custromerInfo();
        newInsurance.nextClick();
        Reporter.log("Confirming All details", true);
        newInsurance.clickCheckbox();
        newInsurance.nextClick();
        Reporter.log("Adding payment details ", true);
        payment.cartValue();
        payment.creditPayment();
        payment.enterCreditDetails(ConfigReader.get("cardno"), ConfigReader.get("expdate"), ConfigReader.get("cvcard"));
        payment.validateInsuranceCreated();
        Reporter.log("Insurance created Successfully with credit card payment", true);
        payment.clickList();
    }

    @Test(priority = 2)
    public void CreateInsuranceDebit() throws InterruptedException {
        Reporter.log("Creating New Insurance", true);
        Reporter.log("Adding Product Details", true);
        newInsurance.product();
        newInsurance.nextClick();
        Reporter.log("Adding Customer Details", true);
        newInsurance.custromerInfo();
        newInsurance.nextClick();
        Reporter.log("Confirming Customer Details", true);
        newInsurance.clickCheckbox();
        newInsurance.nextClick();
        Reporter.log("Adding Debit Detail", true);
        payment.cartValue();
        payment.directDebit();
        payment.validateInsuranceCreated();
        payment.clickList();
        Reporter.log("Insurance created Successfully with credit card payment", true);
    }

    @Test(priority = 3)
    public void applyFiltered() {
        listing.policyFilter();
        listing.filterValue();
        Reporter.log("Filter applied successfully", true);
        listing.clearFilter();
        listing.applySorting();
        Reporter.log("Sort applied successfully", true);

    }

    @Test(priority = 4)
    public void bulkUpload() throws AWTException {
        bulk.importInsurance();
        Reporter.log("Upload CSV initiated", true);
        bulk.uploadFile();
        Reporter.log("CSV uploaded successfully", true);
        bulk.addMultiple();
        Reporter.log("File with error", true);
    }


}

