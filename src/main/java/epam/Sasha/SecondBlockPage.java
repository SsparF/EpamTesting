package epam.Sasha;

import org.openqa.selenium.By;

public class SecondBlockPage {

    public By numberNodes=new By.ByXPath("//input[@id='input_121']");
    public By addGPU=new By.ByXPath("(//div[@class='md-container md-ink-ripple'])[3]");
    public By gPUType=new By.ByXPath("//md-select[@id='select_442']");
    public By selectGPUType=new By.ByXPath("//md-option[@id='select_option_449']");
    public By numberGPU=new By.ByXPath("//md-select[@id='select_444']");
    public By selectNumberGPU=new By.ByXPath("//md-option[@id='select_option_454']");
    public By cPUOverCommit=new By.ByXPath("(//div[@class='md-container md-ink-ripple'])[4]");
    public By dataCenterLocation=new By.ByXPath("//md-select-value[@id='select_value_label_119']");
    public By selectDataCenterLocation=new By.ByXPath("//md-option[@id='select_option_288']");
    public By committedUsage=new By.ByXPath("//md-select-value[@id='select_value_label_120']");
    public By selectCommittedUsage=new By.ByXPath("//md-option[@id='select_option_140']");
    public By addEstimate2=new By.ByXPath("(//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple'])[2]");
}
