package epam.Sasha;

import org.openqa.selenium.By;

public class FirstBlockPage {
    public By numberInstances=new By.ByXPath("//input[@id='input_75']");
    public By software=new By.ByXPath("//md-select-value[@id='select_value_label_67']");
    public By chooseSoftware=new By.ByXPath("//div[@id='select_container_89']//div");
    public By machineClass=new By.ByXPath("//md-select-value[@id='select_value_label_68']");
    public By chooseMachineClass=new By.ByXPath("//div[@id='select_container_93']//div");
    public By machineType=new By.ByXPath("//md-select-value[@id='select_value_label_71']");
    public By selectedMachineType=new By.ByXPath("//md-select-menu[@class='md-overflow']//div[@class='md-text' or @class='md-text ng-binding']");
    public By addEstimate1=new By.ByXPath("(//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple'])[1]");
}
