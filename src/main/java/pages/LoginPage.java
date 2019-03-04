package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    //*********Constructor*********
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //*********Web Elements*********
    By portal_customization = By.xpath("(//a[text()=\"Portal Home\"])[2]");
    By usernameBy = By.xpath("//*[@id=\"login:login-form:username\"]");
    By passwordBy = By.xpath("//*[@id=\"login:login-form:password\"]");
    By loginButtonBy = By.xpath("//*[@id=\"login:login-form:login-command\"]/span");

    //*********Page Methods*********
    public LoginPage goToLoginPage (){
        click(portal_customization);
        return this;
    }
    public LoginPage login (String username){
        writeText(usernameBy,username);
        writeText(passwordBy, "hidden");
        click(loginButtonBy);
        return this;
    }

//    //Verify Username Condition
//    public LoginPage verifyLoginUserName (String expectedText) {
//        assertEquals(errorMessageUsernameBy, expectedText);
//        return this;
//    }
//
//    //Verify Password Condition
//    public LoginPage verifyLoginPassword (String expectedText) {
//        assertEquals(errorMessagePasswordBy, expectedText);
//        return this;
//    }
}