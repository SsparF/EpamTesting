package epam.Sasha;

import epam.Sasha.constants.TimeConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.security.Key;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CalculatorPage extends BasePage{

    private By title=new By.ByXPath("//h2[contains (text(),'Google Cloud Pricing Calculator')]");
    private String iframe="myFrame";
    private By sectionСhoose = new By.ByXPath("//md-tabs-canvas//md-pagination-wrapper//md-tab-item//div[@class='name ng-binding']");
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

    public void selectSection(String sec) {
        List<WebElement> sections = driver.findElements(sectionСhoose);
        List<String> sectionName = sections.stream().map(el -> el.getText()).collect(Collectors.toList());
        for (int i=0; i<sections.size(); i++) {
            if (sectionName.get(i).contains(sec)) {
                sections.get(i).click();
                break;
            }
        }
    }

    public void fillNumOfInstances(String num) {
        WebElement instances=driver.findElement(firstBlockPage.numberInstances);
        instances.click();
        instances.sendKeys(num);
    }

    public void chooseSoftware(String sft) throws InterruptedException {
        WaitUntil(TimeConstants.PAGE_LOAD_TIMEOUT, ExpectedConditions.presenceOfElementLocated(firstBlockPage.software));
        driver.findElement(firstBlockPage.software).click();
        Thread.sleep(3000);
        WaitUntil(TimeConstants.PAGE_LOAD_TIMEOUT, ExpectedConditions.presenceOfElementLocated(firstBlockPage.chooseSoftware));
        List<WebElement> allSoftware = driver.findElements(firstBlockPage.chooseSoftware);
        List<String> sectionName = allSoftware.stream().map(el -> el.getText()).collect(Collectors.toList());
        for (int i=0; i<allSoftware.size(); i++) {
            if (sectionName.get(i).contains(sft)) {
                allSoftware.get(i).click();
                break;
            }
        }
    }

    public void fillMachineClass(String oneClass) throws InterruptedException {
        WaitUntil(TimeConstants.PAGE_LOAD_TIMEOUT, ExpectedConditions.presenceOfElementLocated(firstBlockPage.machineClass));
        driver.findElement(firstBlockPage.machineClass).click();
        Thread.sleep(3000);
        WaitUntil(TimeConstants.PAGE_LOAD_TIMEOUT, ExpectedConditions.presenceOfElementLocated(firstBlockPage.chooseMachineClass));
        List<WebElement> allClasses = driver.findElements(firstBlockPage.chooseMachineClass);
        List<String> className = allClasses.stream().map(el -> el.getText()).collect(Collectors.toList());
        for (int i=0; i<allClasses.size(); i++) {
            if (className.get(i).contains(oneClass)) {
                allClasses.get(i).click();
                break;
            }
        }
    }

    public void fillMachineType(String type) {
        WaitUntil(TimeConstants.PAGE_LOAD_TIMEOUT, ExpectedConditions.elementToBeClickable(firstBlockPage.machineType));
        driver.findElement(firstBlockPage.machineType).click();
        List<WebElement> allTypes = driver.findElements(firstBlockPage.selectedMachineType);
        List<String> sectionName = allTypes.stream().map(el -> el.getText()).collect(Collectors.toList());
        for (int i=0; i<allTypes.size(); i++) {
            if (sectionName.get(i).contains(type)) {
                allTypes.get(i).click();
                break;
            }
        }
    }

    public void clickEddToEstimate1() {
        driver.findElement(firstBlockPage.addEstimate1).click();
    }

    public void fillNumOfNodes(String num) {
        WebElement nodes=driver.findElement(secondBlockPage.numberNodes);
        nodes.click();
        nodes.sendKeys(num);
    }

    public void clickAddGpu() {
        driver.findElement(secondBlockPage.addGPU).click();
    }

    public void fillGpuType(String type) throws InterruptedException {
        WaitUntil(TimeConstants.PAGE_LOAD_TIMEOUT, ExpectedConditions.presenceOfElementLocated(secondBlockPage.gPUType));
        driver.findElement(secondBlockPage.gPUType).click();
        Thread.sleep(3000);
        WaitUntil(TimeConstants.PAGE_LOAD_TIMEOUT, ExpectedConditions.presenceOfElementLocated(secondBlockPage.selectGPUType));
        List<WebElement> allTypes = driver.findElements(secondBlockPage.selectGPUType);
        List<String> typesName = allTypes.stream().map(el -> el.getText()).collect(Collectors.toList());
        for (int i=0; i<allTypes.size(); i++) {
            if (typesName.get(i).contains(type)) {
                allTypes.get(i).click();
                break;
            }
        }
    }

    public void fillNumOfGpu(String num) throws InterruptedException {
        WaitUntil(TimeConstants.PAGE_LOAD_TIMEOUT, ExpectedConditions.presenceOfElementLocated(secondBlockPage.numberGPU));
        driver.findElement(secondBlockPage.numberGPU).click();
        Thread.sleep(3000);
        WaitUntil(TimeConstants.PAGE_LOAD_TIMEOUT, ExpectedConditions.presenceOfElementLocated(secondBlockPage.selectNumberGPU));
        List<WebElement> allNums = driver.findElements(secondBlockPage.selectNumberGPU);
        List<String> numsName = allNums.stream().map(el -> el.getText()).collect(Collectors.toList());
        for (int i=0; i<allNums.size(); i++) {
            if (numsName.get(i).contains(num)) {
                allNums.get(i).click();
                break;
            }
        }
    }

    public void clickCpuOverCommit() {
        driver.findElement(secondBlockPage.cPUOverCommit).click();
    }

    public void fillLocalSSD(String ssd) throws InterruptedException {
        WaitUntil(TimeConstants.PAGE_LOAD_TIMEOUT, ExpectedConditions.presenceOfElementLocated(secondBlockPage.localSSD));
        driver.findElement(secondBlockPage.localSSD).click();
        Thread.sleep(3000);
        WaitUntil(TimeConstants.PAGE_LOAD_TIMEOUT, ExpectedConditions.presenceOfElementLocated(secondBlockPage.selectLocalSSD));
        List<WebElement> allSSD = driver.findElements(secondBlockPage.selectLocalSSD);
        List<String> sSDName = allSSD.stream().map(el -> el.getText()).collect(Collectors.toList());
        for (int i=0; i<allSSD.size(); i++) {
            if (sSDName.get(i).contains(ssd)) {
                allSSD.get(i).click();
                break;
            }
        }
    }

    public void fillDataCenterLocation(String dtc) throws InterruptedException {
        WaitUntil(TimeConstants.PAGE_LOAD_TIMEOUT, ExpectedConditions.presenceOfElementLocated(secondBlockPage.dataCenterLocation));
        driver.findElement(secondBlockPage.dataCenterLocation).click();
        Thread.sleep(3000);
        WaitUntil(TimeConstants.PAGE_LOAD_TIMEOUT, ExpectedConditions.presenceOfElementLocated(secondBlockPage.selectDataCenterLocation));
        List<WebElement> allDataCentres = driver.findElements(secondBlockPage.selectDataCenterLocation);
        List<String> dataCentresName = allDataCentres.stream().map(el -> el.getText()).collect(Collectors.toList());
        for (int i=0; i<allDataCentres.size(); i++) {
            if (dataCentresName.get(i).contains(dtc)) {
                allDataCentres.get(i).click();
                break;
            }
        }
    }

    public void fillCommittedUsage(String usg) throws InterruptedException {
        WaitUntil(TimeConstants.PAGE_LOAD_TIMEOUT, ExpectedConditions.presenceOfElementLocated(secondBlockPage.committedUsage));
        driver.findElement(secondBlockPage.committedUsage).click();
        Thread.sleep(3000);
        WaitUntil(TimeConstants.PAGE_LOAD_TIMEOUT, ExpectedConditions.presenceOfElementLocated(secondBlockPage.selectCommittedUsage));
        List<WebElement> allUsages = driver.findElements(secondBlockPage.selectCommittedUsage);
        List<String> usagesName = allUsages.stream().map(el -> el.getText()).collect(Collectors.toList());
        for (int i=0; i<allUsages.size(); i++) {
            if (usagesName.get(i).contains(usg)) {
                allUsages.get(i).click();
                break;
            }
        }
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
