package epam.Sasha;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest extends BaseTest{

    @Test
    public void test(){
        MainPage mainPage=new MainPage(driver);
        mainPage.open();
        SearchedPage searchedPage=mainPage.searchCalculator("Google Cloud Pricing Calculator");
        Assert.assertTrue(searchedPage.isOpened());
        CalculatorPage calculatorPage=searchedPage.goToCalculator();
        Assert.assertTrue(calculatorPage.isOpened());
        calculatorPage.selectSection();
        calculatorPage.fillFirstModule();
        calculatorPage.fillSecondModule();
        System.out.println(calculatorPage.totalCost());
    }
}
