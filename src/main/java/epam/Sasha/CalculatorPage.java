package epam.Sasha;

import epam.Sasha.constants.TimeConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.security.Key;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorPage extends BasePage{

    private By title=new By.ByXPath("//h2[contains (text(),'Google Cloud Pricing Calculator')]");
    private String iframe="myFrame";
    private By section=new By.ByXPath("(//div[@title='Compute Engine'])[1]");
    //first block
    private FirstBlockPage firstBlockPage=new FirstBlockPage();
    //second block
    private SecondBlockPage secondBlockPage=new SecondBlockPage();
    private By total=new By.ByXPath("//b[@class='ng-binding' and contains (text(),'Total')]");
    private By mailEstimateButton=new By.ByXPath("//button[@id='email_quote']");
    private By inputMail=new By.ByXPath("//input[@id='input_473']");
    private By sendMailButton=new By.ByXPath("(//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple'])[7]");

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    public void switchFrame() {
        driver.switchTo().frame(0);
        driver.switchTo().frame(iframe);
    }

    @Override
    public boolean isOpened() {
        return driver.findElement(title).isDisplayed();
    }

    public void selectSection() {
        driver.findElement(section);
    }

    public void fillNumOfInstances() {
        WebElement instances=driver.findElement(firstBlockPage.numberInstances);
        instances.click();
        instances.sendKeys("4");
    }

    public void fillMachineType() {
        driver.findElement(firstBlockPage.machineType).click();
        driver.findElement(firstBlockPage.selectedMachineType).click();
    }

    public void clickEddToEstimate1() {
        driver.findElement(firstBlockPage.addEstimate1).click();
    }

    public void fillNumOfNodes() {
        WebElement nodes=driver.findElement(secondBlockPage.numberNodes);
        nodes.click();
        nodes.sendKeys("2");
    }

    public void clickAddGpu() {
        driver.findElement(secondBlockPage.addGPU).click();
    }

    public void fillGpuType() {
        driver.findElement(secondBlockPage.gPUType).click();
        driver.findElement(secondBlockPage.selectGPUType).click();
    }

    public void fillNumOfGpu() {
        driver.findElement(secondBlockPage.numberGPU).click();
        driver.findElement(secondBlockPage.selectNumberGPU).click();
    }

    public void clickCpuOverCommit() {
        driver.findElement(secondBlockPage.cPUOverCommit).click();
    }

    public void fillDataCenterLocation() {
        driver.findElement(secondBlockPage.dataCenterLocation).click();
        WaitUntil(TimeConstants.PAGE_LOAD_TIMEOUT, ExpectedConditions.elementToBeClickable(secondBlockPage.selectDataCenterLocation));
        driver.findElement(secondBlockPage.selectDataCenterLocation).click();
    }

    public void fillCommittedUsage() {
        driver.findElement(secondBlockPage.committedUsage).click();
        driver.findElement(secondBlockPage.selectCommittedUsage).click();
    }

    public void clickEddToEstimate2() {
        driver.findElement(secondBlockPage.addEstimate2).click();
    }

    public String totalCost() {
        String s = driver.findElement(total).getText();
        Pattern p=Pattern.compile("\\d+,\\d+.\\d{2}");
        Matcher m=p.matcher(s);
        m.find();
        return m.group();
    }

    public void sendMail(String input) {
        WaitUntil(TimeConstants.PAGE_LOAD_TIMEOUT, ExpectedConditions.elementToBeClickable(mailEstimateButton));
        driver.findElement(mailEstimateButton).click();
        WebElement mailInput = driver.findElement(inputMail);
        mailInput.click();
        mailInput.sendKeys(input);
        driver.findElement(sendMailButton).click();
    }

}
