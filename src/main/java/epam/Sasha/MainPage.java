package epam.Sasha;


import epam.Sasha.constants.TimeConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {

    private By title= new By.ByXPath("//h1[@class='cws-headline--headline-2']");
    private By searchBox= new By.ByXPath("//input[@name='q']");

    public MainPage(WebDriver driver){
        super(driver);
    }

    public void open(){
        driver.get("https://cloud.google.com/");
    }

    @Override
    public boolean isOpened() {
        return driver.findElement(title).isDisplayed();
    }

    public SearchedPage searchCalculator(String input) {
        WebElement inputBox= driver.findElement(searchBox);
        WaitUntil(TimeConstants.PAGE_LOAD_TIMEOUT, ExpectedConditions.elementToBeClickable(inputBox));
        inputBox.click();
        inputBox.sendKeys(input+ Keys.ENTER);
        return new SearchedPage(driver);
    }
}

