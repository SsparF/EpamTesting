package epam.Sasha.yopMail;

import epam.Sasha.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RandomYopMailPage extends BasePage {

    private By title=new By.ByXPath("//h2[@class='pagetitle']");
    private By randomMail =new By.ByXPath("//div[@id='egen']");
    private By checkMailButton=new By.ByXPath("(//button[@class='md but text f24 egenbut'])[3]");

    public RandomYopMailPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return driver.findElement(title).isDisplayed();
    }

    public String takeMail() {
        return driver.findElement(randomMail).getText();
    }

    public CheckLettersPage checkMail() {
        driver.findElement(checkMailButton).click();
        return new CheckLettersPage(driver);
    }
}
