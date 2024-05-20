package pages;

import Base.BasePage;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class paymentPage extends BasePage {
    @FindBy(xpath = "//*[@class='MuiTypography-root MuiTypography-h3']")
    private WebElement totalPayment;

    @FindBy(xpath = "//input[@value='STRIPE.CARD']")
    private WebElement creditCardSelector;

    @FindBy(xpath = "//input[@value='STRIPE.DIRECT_DEBIT']")
    private WebElement directDebitSelector;


    @FindBy(xpath = "//button[@type='button']")
    private WebElement nextPayment;

    @FindBy(name = "cardnumber")
    private WebElement cardSelector;

    @FindBy(name = "exp-date")
    private WebElement mmddSelector;

    @FindBy(name = "cvc")
    private WebElement cvcSelector;

    @FindBy(xpath = "//*[@id='root']/div/div[1]/div[2]/div[2]/div/div[2]/button[1]")
    private WebElement continuePayment;

    @FindBy(xpath = "//h2[@class='MuiTypography-root MuiTypography-h5 css-zq6grw']")
    private WebElement homepageSelector;

    @FindBy(xpath = "(//button[@type='button'])[4]")
    private WebElement listSelector;

    @FindBy(xpath="//input[@name='accountHolder']")
    private WebElement accountHolder;

    @FindBy(xpath="//input[@name='email']")
    private WebElement emailSelector;

    @FindBy(xpath="//input[@name='iban']")
    private WebElement ibanSelector;

    @FindBy(xpath="//input[@type='checkbox']")
    private WebElement termsCondition;

    @FindBy(xpath="(//button[@type='button'])[1]")
    private WebElement nextDebit;



    public paymentPage(WebDriver driver) {
        super(driver);
    }

    public void cartValue()  {
        waitTillElementLoaded(totalPayment);
        String totalValue = totalPayment.getText();
        Assert.notNull(totalValue,"Not at Payment screen");

    }

    public void creditPayment(){
        creditCardSelector.click();
        nextPayment.click();
    }

    public void enterCreditDetails(String creditNumber, String cardExpiry,String cvcValue) throws InterruptedException {
        waitTillElementLoaded(continuePayment);
        enterFrame();
        cardSelector.sendKeys(creditNumber);
        mmddSelector.sendKeys(cardExpiry);
        cvcSelector.sendKeys(cvcValue);
        exitFrame();
        continuePayment.click();
    }

    public void validateInsuranceCreated(){
        homepageSelector.isDisplayed();
    }

    public void clickList(){
        listSelector.click();
    }

    public void directDebit(){
        directDebitSelector.click();
        continuePayment.click();
        accountHolder.sendKeys("Jacob");
        emailSelector.sendKeys("xyz@gmail.com");
        enterFrame();
        ibanSelector.sendKeys("DE89370400440532013000");
        exitFrame();
        termsCondition.click();
        nextDebit.click();


    }

}
