package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

public class ClientOnBoardingPage extends BasePage{

    //*********Constructor*********
    public ClientOnBoardingPage(WebDriver driver) {
        super(driver);
    }

    //*********Web Elements*********
    By productTabBy = By.xpath("(//a[text()=\"Product\"])");
    By logOutBy = By.xpath("(//*[text()=\"Logout\"])");
    By confirmationOkBy = By.xpath("//*[contains(@id,'j_id_2r')]");
    By errorOkBy = By.xpath("//*[contains(@id,'cdOkButton')]");
    By shoppingCartTabBy = By.xpath("//a[text()=\"Shopping cart\"]");
    
    By firstMortgageBy = By.xpath("//div[contains(@id,'mortgageList')]/div[1]/div[2]");
    
    By modifyBy = By.xpath("(//*[text()=\"Modify\"]/parent::button[@aria-disabled=\"false\"])");

    By fixedInterestRateBy = By.xpath("//*[@id=\"form:crdhwayCobTab:j_id_1on:productTabView:shoppingCartComponent:j_id_1s9:0:j_id_1si:0:fixedInterest_input\"]");
    By fixedInterestRateRedIconBy = By.xpath("//*[@id=\"form:crdhwayCobTab:j_id_1on:productTabView:shoppingCartComponent:j_id_1s9:0:j_id_1si_data\"]/tr/td[7]/i");
    By totalTrancheBy = By.xpath("//div[contains(@id,'mortgageList')]");
    
    By listAlertsMessageBy = By.xpath("(//div[contains(@id,'alertsSection')]//a)");
    
    By checkOutButtonBy = By.xpath("//a[contains(@id,'checkoutBtn')]");
    
    By dossierIdBy = By.xpath("//*[@id=\"j_id_3i\"]/div/div/div/div[1]");
  
    //*********Page Methods*********
    public ClientOnBoardingPage clickConfirmationOK(){
    	waitLoading();
        click(confirmationOkBy);
        return this;
    }
    
    public ClientOnBoardingPage clickErrorOK(){
        click(errorOkBy);
        return this;
    }
    
    public ClientOnBoardingPage clickLogOut(){
        click(logOutBy);
        return this;
    }
    
    public ClientOnBoardingPage clickProductTab(){
        click(productTabBy);
        return this;
    }

    public ClientOnBoardingPage clickFirstTranche (){
        waitLoading();
        click(firstMortgageBy);
        return this;
    }

    public ClientOnBoardingPage clickModify (){
        click(modifyBy);
        return this;
    }

    public ClientOnBoardingPage clickCheckout(){
        click(checkOutButtonBy);
        return this;
    }

    public ClientOnBoardingPage inputFixedInterestRate(String number){
        writeText(fixedInterestRateBy, number);
        return this;
    }
    
    public String getDossierId() {
    	String[] data = readText(dossierIdBy).split(" ");
    	return data[0];
    }

    //Verify shopping cart
    public ClientOnBoardingPage verifyShoppingCart() {
        assertEquals(shoppingCartTabBy, "Shopping cart");
        return this;
    }
    
    //Verify error message
    public ClientOnBoardingPage verifyMessage(String expectedText) {
    	assertTrue(existsElement(fixedInterestRateRedIconBy));
        return this;
    }

    //Verify error message disappear
    public ClientOnBoardingPage verifyMessageDisappear(String expectedText) {
    	assertTrue(existsText(expectedText));
        return this;
    }
    
    //Verify fixed interest rate red icon
    public ClientOnBoardingPage verifyFixedInterestRedIcon () {
//        assertFalse(existsText(expectedText));
        return this;
    }
    
    //Verify total tranche on shopping cart
    public ClientOnBoardingPage verifyToltalOfTranches(String totalTranche) {
    	assertCount(totalTrancheBy, totalTranche);
		return this;
    }
    
    //Verify message contains on Alerts
    public ClientOnBoardingPage verifyMessageOnAlerts(String message) {
    	assertListContains(listAlertsMessageBy, message);
    	return this;
    }
    
    //Verify url contains
    public ClientOnBoardingPage verifyUrlContains() {
    	assertURL("PortalTaskListCallback.xhtml");
    	return this;
    }
}