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
        calculatorPage.switchFrame();
        Assert.assertTrue(calculatorPage.isOpened());
        calculatorPage.selectSection();
        calculatorPage.fillNumOfInstances();
        calculatorPage.fillMachineType();
        calculatorPage.clickEddToEstimate1();
        calculatorPage.fillNumOfNodes();
        calculatorPage.clickAddGpu();
        calculatorPage.fillGpuType();
        calculatorPage.fillNumOfGpu();
        calculatorPage.clickCpuOverCommit();
        calculatorPage.fillDataCenterLocation();
        calculatorPage.fillCommittedUsage();
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
