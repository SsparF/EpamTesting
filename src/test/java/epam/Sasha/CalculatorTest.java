package epam.Sasha;

import epam.Sasha.google.page.CalculatorPage;
import epam.Sasha.google.page.MainPage;
import epam.Sasha.google.page.SearchedPage;
import epam.Sasha.yopMail.CheckLettersPage;
import epam.Sasha.yopMail.RandomYopMailPage;
import epam.Sasha.yopMail.YopMailPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest extends BaseTest{

    @Test
    public void test() throws InterruptedException {
        MainPage mainPage=new MainPage(driver);
        mainPage.open();
        SearchedPage searchedPage=mainPage.searchCalculator(Reader.getProperty("search.value"));
        Assert.assertTrue(searchedPage.isOpened());
        CalculatorPage calculatorPage=searchedPage.goToCalculator();
        Thread.sleep(2000);
        calculatorPage.switchFrame();
        Assert.assertTrue(calculatorPage.isOpened());
        calculatorPage.selectSection(Reader.getProperty("section"));
        calculatorPage.fillNumOfInstances(Reader.getProperty("num.of.instances"));
        calculatorPage.chooseSoftware(Reader.getProperty("software"));
        calculatorPage.fillMachineClass(Reader.getProperty("machine.class"));
        calculatorPage.fillMachineType(Reader.getProperty("machine.type"));
        calculatorPage.clickEddToEstimate1();
        calculatorPage.fillNumOfNodes(Reader.getProperty("num.of.nodes"));
        calculatorPage.clickAddGpu();
        calculatorPage.fillGpuType(Reader.getProperty("gpu.type"));
        calculatorPage.fillNumOfGpu(Reader.getProperty("num.of.gpu"));
        calculatorPage.clickCpuOverCommit();
        calculatorPage.fillLocalSSD(Reader.getProperty("local.ssd"));
        calculatorPage.fillDataCenterLocation(Reader.getProperty("data.center.location"));
        calculatorPage.fillCommittedUsage(Reader.getProperty("committed.usage"));
        calculatorPage.clickEddToEstimate2();
        String originalTotalCost=calculatorPage.totalCost();
        YopMailPage yopMailPage=new YopMailPage(driver);
        calculatorPage.openNewWindow(Reader.getProperty("yop.mail"));
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
