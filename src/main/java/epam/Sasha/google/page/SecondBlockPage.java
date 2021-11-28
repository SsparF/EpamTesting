package epam.Sasha.google.page;

import org.openqa.selenium.By;

public class SecondBlockPage {

    public By numberNodes=new By.ByXPath("//input[@id='input_121']");
    public By addGPU=new By.ByXPath("(//div[@class='md-container md-ink-ripple'])[3]");
    public By gPUType=new By.ByXPath("//md-select[@id='select_442']");
    public By selectGPUType=new By.ByXPath("//div[@id='select_container_443']//div");
    public By numberGPU=new By.ByXPath("//md-select[@id='select_444']");
    public By selectNumberGPU=new By.ByXPath("//div[@id='select_container_445']//div");
    public By cPUOverCommit=new By.ByXPath("(//div[@class='md-container md-ink-ripple'])[4]");
    public By localSSD=new By.ByXPath("//md-select-value[@id='select_value_label_118']");
    public By selectLocalSSD=new By.ByXPath("//div[@id='select_container_135']//div");
    public By dataCenterLocation=new By.ByXPath("//md-select-value[@id='select_value_label_119']");
    public By selectDataCenterLocation=new By.ByXPath("//div[@id='select_container_138']//div");
    public By committedUsage=new By.ByXPath("//md-select-value[@id='select_value_label_120']");
    public By selectCommittedUsage=new By.ByXPath("//div[@id='select_container_143']//div");
    public By addEstimate2=new By.ByXPath("(//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple'])[2]");
}
