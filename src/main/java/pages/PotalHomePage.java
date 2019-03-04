package pages;

import managers.FileReaderManager;
import org.openqa.selenium.WebDriver;

public class PotalHomePage extends BasePage{

    //*********Constructor*********
    public PotalHomePage(WebDriver driver) {
        super(driver);
    }

    //*********Web Elements*********
//    By portal_customization = By.xpath("(//a[text()=\"Portal Home\"])[2]");

    //*********Page Methods*********
    public PotalHomePage goToPortalPage (){
        driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
        return this;
    }
}