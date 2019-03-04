package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ValiantPotalHomePage extends BasePage{

    //*********Constructor*********
    public ValiantPotalHomePage(WebDriver driver) {
        super(driver);
    }

    //*********Web Elements*********
    By portal_customization = By.xpath("(//a[text()=\"Portal Home\"])[2]");
    By test = By.xpath("(//*[text()=\"New Dossier\"])[2]");
    By passwordBy = By.xpath("//*[@id=\"login:login-form:password\"]");
    By loginButtonBy = By.xpath("//*[@id=\"login:login-form:login-command\"]/span");

    //*********Page Methods*********
    public ValiantPotalHomePage clickNewDossier (){
        clickText("New Dossier");
        return this;
    }
    
    public ValiantPotalHomePage clickDossierOverview (){
        clickText("Dossier overview");
        return this;
    }
}