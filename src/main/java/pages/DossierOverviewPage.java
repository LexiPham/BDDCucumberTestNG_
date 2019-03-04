package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DossierOverviewPage extends BasePage{

    //*********Constructor*********
    public DossierOverviewPage(WebDriver driver) {
        super(driver);
    }

    //*********Web Elements*********
    By inputFilterBy = By.xpath("//*[@data-p-label=\"Filter\"]");

    //*********Page Methods*********
    public DossierOverviewPage inputFilter (String text){
    	writeText(inputFilterBy, text);
        return this;
    }
}
