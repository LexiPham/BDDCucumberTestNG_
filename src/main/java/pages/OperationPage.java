package pages;

import org.openqa.selenium.WebDriver;

public class OperationPage extends BasePage{

    //*********Constructor*********
    public OperationPage(WebDriver driver) {
        super(driver);
    }

    //*********Web Elements*********
//    By portal_customization = By.xpath("(//a[text()=\"Portal Home\"])[2]");

    //*********Page Methods*********
    public OperationPage clickContinue (){
        clickText("Continue");
        return this;
    }
}