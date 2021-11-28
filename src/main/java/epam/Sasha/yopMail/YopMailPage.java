package epam.Sasha.yopMail;

import epam.Sasha.BasePage;
import epam.Sasha.yopMail.RandomYopMailPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YopMailPage extends BasePage {
    //https://yopmail.com/

    private By mailButton =new By.ByXPath("(//div[@class='txtlien'])[1]");
    public YopMailPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return driver.findElement(mailButton).isDisplayed();
    }

    public RandomYopMailPage makeMail() {
        driver.findElement(mailButton).click();
        return new RandomYopMailPage(driver);
    }
}
