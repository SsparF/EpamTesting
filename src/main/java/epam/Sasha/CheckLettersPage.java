package epam.Sasha;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckLettersPage extends BasePage {

    private By title=new By.ByXPath("//div[@class='bname']");
    private By refreshButton=new By.ByXPath("//button[@id='refresh']");
    private By costInLetter=new By.ByXPath("//h2");

    public CheckLettersPage(WebDriver driver) {
        super(driver);
    }


    public void switchToRightFrame() {
        driver.switchTo().frame("ifmail");
    }

    @Override
    public boolean isOpened() {
        return driver.findElement(title).isDisplayed();
    }


    public void refreshLetters() {
        driver.findElement(refreshButton).click();
    }

    public String sentCost() {
        switchToRightFrame();
        String s = driver.findElement(costInLetter).getText();
        Pattern p=Pattern.compile("\\d+,\\d+.\\d{2}");
        Matcher m=p.matcher(s);
        m.find();
        return m.group();
    }
}
