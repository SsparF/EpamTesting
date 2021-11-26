package epam.Sasha;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchedPage extends BasePage{

    private By title=new By.ByXPath("//h1[@class='devsite-search-title']");
    private By firstReference=new By.ByXPath("//a[@class='gs-title'][1]");

    public SearchedPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return driver.findElement(title).isDisplayed();
    }

    public CalculatorPage goToCalculator() {
        driver.findElement(firstReference).click();
        return new CalculatorPage(driver);
    }
}
