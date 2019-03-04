package managers;

import org.openqa.selenium.WebDriver;
import pages.ClientOnBoardingPage;
import pages.DossierOverviewPage;
import pages.SearchClientRelationshipPage;
import pages.LoginPage;
import pages.PotalHomePage;
import pages.ValiantPotalHomePage;
import pages.OperationPage;

public class PageObjectManager {
    private WebDriver driver;
    private ClientOnBoardingPage clientOnBoardingPage;
    private SearchClientRelationshipPage searchClientRelationshipPage;
    private LoginPage loginPage;
    private PotalHomePage potalHomePage;
    private ValiantPotalHomePage valiantPotalHomePage;
    private OperationPage operationPage;
    private DossierOverviewPage dossierOverviewPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public PotalHomePage getPotalHomePage(){
        return (potalHomePage == null) ? potalHomePage = new PotalHomePage(driver) : potalHomePage;
    }
    
    public DossierOverviewPage getDossierOverviewPage(){
        return (dossierOverviewPage == null) ? dossierOverviewPage = new DossierOverviewPage(driver) : dossierOverviewPage;
    }

    public LoginPage getLoginPage(){
        return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
    }

    public ValiantPotalHomePage getValiantPortalHomePage(){
        return (valiantPotalHomePage == null) ? valiantPotalHomePage = new ValiantPotalHomePage(driver) : valiantPotalHomePage;
    }

    public OperationPage getOperationPage(){
        return (operationPage == null) ? operationPage = new OperationPage(driver) : operationPage;
    }

    public ClientOnBoardingPage getClientOnBoardingPage(){
        return (clientOnBoardingPage == null) ? clientOnBoardingPage = new ClientOnBoardingPage(driver) : clientOnBoardingPage;
    }

    public SearchClientRelationshipPage getSearchClientRelationshipPage() {
        return (searchClientRelationshipPage == null) ? searchClientRelationshipPage = new SearchClientRelationshipPage(driver) : searchClientRelationshipPage;
    }

}