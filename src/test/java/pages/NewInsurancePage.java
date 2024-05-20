package pages;
import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewInsurancePage extends BasePage {
    WebDriver driver;

    @FindBy(xpath = "(//button[@type='button'])[5]")
    private WebElement listSelector;

    @FindBy(id = "country-select")
    private WebElement countryOption;

    @FindBy(xpath = "(//li[@data-value='AT'])")
    private WebElement selectCountry;

    @FindBy(id = "product-name-select")
    private WebElement productOption;

    @FindBy(xpath = "(//li[@data-value='Nokia_v1Allianz_global'])")
    private WebElement allianzProduct;

    @FindBy(id = "tariff-name-select")
    private WebElement tariffOption;

    @FindBy(xpath = "(//li[@data-value='1-34-Nokia_v1Allianz_global-D-EUR-v1-Accidental_damage'])")
    private WebElement damageTariff;

    @FindBy(id = "category-name-select")
    private WebElement categoryOption;

    @FindBy(xpath = "(//li[@data-value='CATEGORY_SMARTPHONE'])")
    private WebElement smartphoneSelect;

    @FindBy(id = "duration-select")
    private WebElement durationOption;

    @FindBy(xpath = "(//li[@data-value='12 month(s)'])")
    private WebElement monthSelect;

    @FindBy(id = "frequency-select")
    private WebElement frequenceOption;

    @FindBy(xpath = "(//li[@data-value='12 month(s)'])")
    private WebElement monthSelector;

    @FindBy(id = "class-name-select")
    private WebElement classOption;

    @FindBy(xpath = "(//li[@data-value='PDCODE677395'])")
    private WebElement codeSelect;

    @FindBy(id = "input-createCertificate_serialNumber")
    private WebElement serialSelector;

    @FindBy(id = "input-createCertificate_deviceName")
    private WebElement deviceSelector;

    @FindBy(id = "input-createCertificate_invoiceNumber")
    private WebElement invoiceSelector;

    @FindBy(id = "input-createCertificate_orderNumber")
    private WebElement orderSelector;

    @FindBy(xpath = "(//button[@type='button'])[9]")
    private WebElement nextSelector;

    @FindBy(xpath = "(//input[@value='male'])")
    private WebElement maleCheckbox;

    @FindBy(name = "firstName")
     private WebElement firstnameTextbox;

    @FindBy(name = "lastName")
    private WebElement lastnameTextbox;

    @FindBy(id= "input-createCertificate_email")
    private WebElement emailTextbox;

    @FindBy(name = "streetName")
    private WebElement streetNameTextbox;

    @FindBy(name = "streetNumber")
    private WebElement streetNumberTextbox;

    @FindBy(name = "zip")
    private WebElement zipTextbox;

    @FindBy(name = "city")
    private WebElement cityTextbox;

    @FindBy(name = "country")
    private WebElement countryTextbox;

    @FindBy(xpath = "(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[1]")
    private WebElement allCheckbox;

    @FindBy(xpath = "(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[2]")
    private WebElement consentCheckbox;

    @FindBy(xpath = "(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[3]")
    private WebElement termsCheckbox;

    @FindBy(xpath = "(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[4]")
    private WebElement insuredCheckbox;

    public NewInsurancePage(WebDriver driver) {
        super(driver);
    }

    public boolean isUserLoggedIn() {
        return listSelector.isDisplayed();
    }

    public void product(){
        listSelector.click();
        countryOption.click();
        selectCountry.click();
        productOption.click();
        allianzProduct.click();
        tariffOption.click();
        damageTariff.click();
        categoryOption.click();
        smartphoneSelect.click();
        durationOption.click();
        monthSelect.click();
        frequenceOption.click();
        monthSelector.click();
        classOption.click();
        codeSelect.click();
        serialSelector.sendKeys("54321");
        deviceSelector.sendKeys("Samsung");
        invoiceSelector.sendKeys("54321");
        orderSelector.sendKeys("54321");
    }

    public void nextClick(){
        nextSelector.click();
    }

    public void custromerInfo(){
        maleCheckbox.click();
        firstnameTextbox.sendKeys("John");
        lastnameTextbox.sendKeys("Jacob");
        emailTextbox.sendKeys("xyz@gmail.com");
        streetNameTextbox.sendKeys("Austria");
        streetNumberTextbox.sendKeys("55");
        zipTextbox.sendKeys("b43338");
        cityTextbox.sendKeys("Nig");
        countryTextbox.sendKeys("AT");
    }

    public void clickCheckbox(){
        allCheckbox.click();
        consentCheckbox.click();
        termsCheckbox.click();
        insuredCheckbox.click();
    }


}

