package epam.Sasha;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest extends BaseTest{

    @Test
    public void test() throws InterruptedException {
        MainPage mainPage=new MainPage(driver);
        mainPage.open();
        SearchedPage searchedPage=mainPage.searchCalculator("Google Cloud Pricing Calculator");
        Assert.assertTrue(searchedPage.isOpened());
        CalculatorPage calculatorPage=searchedPage.goToCalculator();
        Thread.sleep(2000);
        calculatorPage.switchFrame();
        Assert.assertTrue(calculatorPage.isOpened());
        calculatorPage.selectSection("Compute Engine");
        calculatorPage.fillNumOfInstances("4");
        calculatorPage.chooseSoftware("Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)");
        calculatorPage.fillMachineClass("Regular");
        calculatorPage.fillMachineType("e2-standard-8 (vCPUs: 8, RAM: 32GB)");
        calculatorPage.clickEddToEstimate1();
        calculatorPage.fillNumOfNodes("2");
        calculatorPage.clickAddGpu();
        calculatorPage.fillGpuType("NVIDIA Tesla T4");
        calculatorPage.fillNumOfGpu("4");
        calculatorPage.clickCpuOverCommit();
        calculatorPage.fillLocalSSD("24x375 GB");
        calculatorPage.fillDataCenterLocation("Los Angeles (us-west2)");
        calculatorPage.fillCommittedUsage("1 Year");
        calculatorPage.clickEddToEstimate2();
        String originalTotalCost=calculatorPage.totalCost();
        System.out.println(originalTotalCost);
        YopMailPage yopMailPage=new YopMailPage(driver);
        calculatorPage.openNewWindow("https://yopmail.com/");
        Assert.assertTrue(yopMailPage.isOpened());
        RandomYopMailPage randomYopMailPage=yopMailPage.makeMail();
        String randomMail=randomYopMailPage.takeMail();
        randomYopMailPage.switchWindow();
        calculatorPage=new CalculatorPage(driver);
        calculatorPage.switchFrame();
        calculatorPage.sendMail(randomMail);
        calculatorPage.switchWindow();
        randomYopMailPage=new RandomYopMailPage(driver);
        CheckLettersPage checkLettersPage=randomYopMailPage.checkMail();
        Assert.assertTrue(checkLettersPage.isOpened());
        Thread.sleep(5000);
        checkLettersPage.refreshLetters();
        Thread.sleep(5000);
        String totalCostInLetter = checkLettersPage.sentCost();
        Assert.assertEquals(originalTotalCost,totalCostInLetter);
    }
}
