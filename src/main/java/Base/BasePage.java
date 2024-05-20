package Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
        protected WebDriver driver;
        private WebDriverWait wait;

        public BasePage(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(10000));
            PageFactory.initElements(driver, this);
        }

        protected WebElement waitTillElementLoaded(WebElement element) {
            return wait.until(ExpectedConditions.visibilityOf(element));
        }

        protected void enterFrame(){
            driver.switchTo().frame(0);
        }
        protected void exitFrame() {
        driver.switchTo().parentFrame();
    }

        protected WebElement waitForElementToBeClickable(WebElement element) {
            return wait.until(ExpectedConditions.elementToBeClickable(element));
        }

        protected void waitForUrlToContain(String fraction) {
            wait.until(ExpectedConditions.urlContains(fraction));
        }
    }


