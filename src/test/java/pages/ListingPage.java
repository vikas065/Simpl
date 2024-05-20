package pages;
import Base.BasePage;
import Base.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ListingPage extends BasePage {

    @FindBy(id = ":r8:")
    private WebElement searchFilter;

    @FindBy(xpath = "//*[@data-value='policy_number']")
    private WebElement policyNumberSelect;

    @FindBy(id = ":rd:")
    private WebElement enterFilter;

    @FindBy(id = ":rp:")
    private WebElement enterPress;

    @FindBy(xpath = "//*[@data-testid='policy-list']")
    private WebElement tableSelector;

    @FindBy(xpath = "//*[@data-testid='CancelIcon']")
    private WebElement clearFilter;

    @FindBy(xpath = "//*[@data-testid='ExpandMoreIcon']")
    private WebElement applySorting;

    @FindBy(xpath = "//table[@data-testid='policy-list']/tbody/tr/th[1]")
    private List<WebElement> beforeSortValue;


    public ListingPage(WebDriver driver) {
        super(driver);
    }

    public void policyFilter() {
        waitTillElementLoaded(searchFilter);
        searchFilter.click();
        policyNumberSelect.click();
        waitTillElementLoaded(enterFilter);
        enterFilter.sendKeys(ConfigReader.get("policyNumber"));
        enterPress.sendKeys(Keys.ENTER);
    }

    public void filterValue() {
        List<WebElement> rows = tableSelector.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            List<WebElement> columns = row.findElements(By.tagName("th"));
            String cellText = columns.get(0).getText().toString();
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(cellText);
            if (matcher.find()) {
                String expectedValue = matcher.group();
                expectedValue.compareTo(ConfigReader.get("policyNumber"));
            }
        }

    }

    public void clearFilter() {
        clearFilter.click();
        waitTillElementLoaded(tableSelector);
    }

    public void applySorting() {
        String sort;
        String[] beforesort = new String[beforeSortValue.size()];
        for (int i = 0; i < beforeSortValue.size(); i++) {
            beforesort[i] = beforeSortValue.get(i).getText().trim();
            System.out.println(beforesort[i]);
        }
        for (int i = 0; i < beforeSortValue.size(); i++) {
            Arrays.sort(beforesort);
            sort = beforesort[i];
            System.out.println(sort);
        }
        applySorting.click();
        waitTillElementLoaded(tableSelector);
        String[] aftersort = new String[beforeSortValue.size()];
        for (int i = 0; i < beforeSortValue.size(); i++) {
            aftersort[i] = beforeSortValue.get(i).getText().trim();
            System.out.println(aftersort[i]);
        }
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(beforesort,aftersort,"Sort Failed");
    }
}


