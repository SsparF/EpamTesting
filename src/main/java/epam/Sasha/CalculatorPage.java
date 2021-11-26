package epam.Sasha;

import epam.Sasha.constants.TimeConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorPage extends BasePage{

    private By title=new By.ByXPath("//h2[contains (text(),'Google Cloud Pricing Calculator')]");
    private String iframe="myFrame";
    private By section=new By.ByXPath("(//div[@title='Compute Engine'])[1]");
    //first block
    private By numberInstances=new By.ByXPath("//input[@id='input_75']");
    private By machineType=new By.ByXPath("//md-select-value[@id='select_value_label_71']");
    private By selectedMachineType=new By.ByXPath("//md-option[@id='select_option_272']");
    private By addEstimate1=new By.ByXPath("(//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple'])[1]");
    //second block
    private By numberNodes=new By.ByXPath("//input[@id='input_121']");
    private By addGPU=new By.ByXPath("(//div[@class='md-container md-ink-ripple'])[3]");
    private By gPUType=new By.ByXPath("//md-select[@id='select_442']");
    private By selectGPUType=new By.ByXPath("//md-option[@id='select_option_449']");
    private By numberGPU=new By.ByXPath("//md-select[@id='select_444']");
    private By selectNumberGPU=new By.ByXPath("//md-option[@id='select_option_454']");
    private By cPUOverCommit=new By.ByXPath("(//div[@class='md-container md-ink-ripple'])[4]");
    private By dataCenterLocation=new By.ByXPath("//md-select-value[@id='select_value_label_119']");
    private By selectDataCenterLocation=new By.ByXPath("//md-option[@id='select_option_288']");
    private By committedUsage=new By.ByXPath("//md-select-value[@id='select_value_label_120']");
    private By selectCommittedUsage=new By.ByXPath("//md-option[@id='select_option_140']");
    private By addEstimate2=new By.ByXPath("(//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple'])[2]");

    private By total=new By.ByXPath("//b[@class='ng-binding' and contains (text(),'Total')]");

    public CalculatorPage(WebDriver driver) {
        super(driver);
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

    public void fillFirstModule() {
        WebElement instances=driver.findElement(numberInstances);
        instances.click();
        instances.sendKeys("4");
        driver.findElement(machineType).click();
        driver.findElement(selectedMachineType).click();
        driver.findElement(addEstimate1).click();
    }

    public void fillSecondModule() {
        WebElement nodes=driver.findElement(numberNodes);
        nodes.click();
        nodes.sendKeys("2");
        driver.findElement(addGPU).click();
        driver.findElement(gPUType).click();
        driver.findElement(selectGPUType).click();
        driver.findElement(numberGPU).click();
        driver.findElement(selectNumberGPU).click();
        driver.findElement(cPUOverCommit).click();
        driver.findElement(dataCenterLocation).click();
        WaitUntil(TimeConstants.PAGE_LOAD_TIMEOUT, ExpectedConditions.elementToBeClickable(selectDataCenterLocation));
        driver.findElement(selectDataCenterLocation).click();
        driver.findElement(committedUsage).click();
        driver.findElement(selectCommittedUsage).click();
        driver.findElement(addEstimate2).click();
    }

    public String totalCost() {
        String s = driver.findElement(total).getText();
        Pattern p=Pattern.compile("\\d+,\\d+.\\d{2}");
        Matcher m=p.matcher(s);
        m.find();
        return m.group();
    }
}
