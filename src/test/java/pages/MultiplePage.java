package pages;

import Base.BasePage;
import Base.ConfigReader;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class MultiplePage extends BasePage {

    @FindBy(xpath = "(//button[@type='button'])[6]")
    private WebElement importSelector;

    @FindBy(xpath = "(//*[@data-testid='CloudUploadIcon'])")
    private WebElement uploadSelector;

    @FindBy(xpath = "(//button[@type='button'])[7]")
    private WebElement createBulk;

    @FindBy(xpath = "//*[@id='client-snackbar']/ul")
    private WebElement errorMsg;

    @FindBy(xpath = "(//button[@type='button'])[9]")
    private WebElement closeErrorMsg;

    public MultiplePage(WebDriver driver) {
        super(driver);
    }

    public void importInsurance() {
        waitTillElementLoaded(importSelector);
        importSelector.click();
        waitForElementToBeClickable(uploadSelector);
    }

    public void uploadFile() throws AWTException {
        uploadSelector.click();
        Robot robot = new Robot();
        robot.setAutoDelay(2000);
        StringSelection stringSelection = new StringSelection("C:\\Users\\DELL\\eclipse-workspace\\Insurance_Bassline\\src\\main\\resources\\testdata.csv");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        waitTillElementLoaded(createBulk);
    }
    public void addMultiple(){
        createBulk.click();
        waitTillElementLoaded(errorMsg);
        String errorMessage= errorMsg.getText();
        Assert.assertTrue(errorMsg.isDisplayed(),"Error with CSV file : "+errorMessage);
        closeErrorMsg.click();

        }



}
