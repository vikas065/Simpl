package pages;
import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//*[@data-testid='LanguageIcon']")
    private WebElement languageSelector;

    @FindBy(xpath = "(//li[@class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters MuiMenuItem-root MuiMenuItem-gutters css-91vqyr'])[2]")
    private WebElement selectEnglish;

    @FindBy(id = "login_username")
    private WebElement usernameSelector;

    @FindBy(id = "login_password")
    private WebElement passSelector;

    @FindBy(xpath = "(//button[@type='submit'])")
    private WebElement signBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setLanguage() {
        waitTillElementLoaded(languageSelector);
        languageSelector.click();
        selectEnglish.click();
    }

    public void login(String username, String password) {
        usernameSelector.sendKeys(username);
        passSelector.sendKeys(password);
        signBtn.click();
    }
}
