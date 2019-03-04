package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.Context;
import pages.ClientOnBoardingPage;
import pages.DossierOverviewPage;
import pages.SearchClientRelationshipPage;
import pages.LoginPage;
import pages.PotalHomePage;
import pages.ValiantPotalHomePage;
import utility.ExcelUtils;
import utility.MailUtils;
import utility.TestContext;
import pages.OperationPage;

public class LoginStepDefinition{
	TestContext testContext;
	ExcelUtils excelUtils;
	MailUtils mailUtils;
	
	LoginPage loginPage;
	PotalHomePage potalHomePage;
	ValiantPotalHomePage valiantPotalHomePage;
	OperationPage operationPage;
	SearchClientRelationshipPage searchClientRelationshipPage;
	ClientOnBoardingPage clientOnBoardingPage;
	DossierOverviewPage dossierOverviewPage;
	
 public LoginStepDefinition(TestContext context) throws Exception {
		testContext = context;
		excelUtils = new ExcelUtils();
		mailUtils = new MailUtils();
	}
	
	@Before
	public void startUp() throws Exception {
		MailUtils.sendEmail("This is subject", "This is body");
		excelUtils.setCellData("Sheet1", "pass", 1, 1);
		excelUtils.setCellData("Sheet1", "pass", 2, 2);
		
		loginPage = testContext.getPageObjectManager().getLoginPage();
		potalHomePage = testContext.getPageObjectManager().getPotalHomePage();
		valiantPotalHomePage = testContext.getPageObjectManager().getValiantPortalHomePage();
		operationPage = testContext.getPageObjectManager().getOperationPage();
		searchClientRelationshipPage = testContext.getPageObjectManager().getSearchClientRelationshipPage();
		dossierOverviewPage = testContext.getPageObjectManager().getDossierOverviewPage();
		clientOnBoardingPage = testContext.getPageObjectManager().getClientOnBoardingPage();
	}
//	@After
//	public void tearDown() {
//		driver.quit();
//	}

	@Given("user \"(.*)\" is already logged in$")
	public void user_is_already_logged_in(String username) throws Exception{
		potalHomePage.goToPortalPage();
		loginPage.goToLoginPage()
				.login(username);
	}

    @Given("^user click on New dossier$")
    public void user_click_on_new_dossier() throws Throwable {
    	valiantPotalHomePage.clickNewDossier();
    }
    
	@When("^user select modify existing credit business and click continue$")
	public void user_select_modify_existing_credit_business_and_click_continue() throws Throwable {
		operationPage.clickContinue();
	}

	@Given("^user search for customer \"([^\"]*)\" and click continues$")
	public void user_search_for_customer_and_click_continues(String name) throws Throwable {
		searchClientRelationshipPage.inputSearch(name)
									.clickFirstRecord()
									.clickContinues();
	}
	
    @Then("^system create a new dossier$")
    public void system_create_a_new_dossier() throws Throwable {
		String dossierId = clientOnBoardingPage.getDossierId(); 
		testContext.scenarioContext.setContext(Context.DOSSIER_ID, dossierId);
    }
    
	@Given("^user click on product tab$")
	public void user_click_on_product_tab() throws Throwable {
		clientOnBoardingPage.clickProductTab();
	}

	@Given("^user click on the tranche$")
	public void user_click_on_the_tranche() throws Throwable {
		clientOnBoardingPage.clickFirstTranche();
	}

	@When("^user click on modify$")
	public void user_click_on_modify() throws Throwable {
		clientOnBoardingPage.clickModify();
	}

	@Then("^user should see only one tranche$")
	public void user_should_see_only_one_tranche() throws Throwable {
		clientOnBoardingPage.verifyToltalOfTranches("1");
	}

	@Then("^user should see the shopping cart tab$")
	public void user_should_see_the_shopping_cart_tab() throws Throwable {
		clientOnBoardingPage.verifyShoppingCart();
	}

	@When("^user click on check out$")
	public void user_click_on_check_out() throws Throwable {
		clientOnBoardingPage.clickCheckout();
	}

	@Then("^user should see \"([^\"]*)\"$")
	public void user_should_see_something(String message) throws Throwable {
		clientOnBoardingPage.verifyMessage(message);
	}

	@When("^user input fixed interest rate \"([^\"]*)\"$")
	public void user_input_fixed_interest_rate_something(String fixedinterestrate) throws Throwable {
		clientOnBoardingPage.inputFixedInterestRate(fixedinterestrate);
	}

	@Then("^user should see red alert icon$")
	public void user_should_see_red_alert_icon() throws Throwable {
		clientOnBoardingPage.verifyFixedInterestRedIcon();
	}
	
    @When("^user click on checkout button$")
    public void user_click_on_checkout_button() throws Throwable {
    	clientOnBoardingPage.clickCheckout();
    }

    @Then("^user should see dossier in execution in Tasklist$")
    public void user_should_see_dossier_in_execution_in_tasklist() throws Throwable {
        throw new PendingException();
    }
    
    @Then("^user should see the message \"([^\"]*)\" on Alerts section$")
    public void user_should_see_the_message_something_on_alerts_section(String message) throws Throwable {
    	clientOnBoardingPage.verifyMessageOnAlerts(message);
    }
    
    @Then("^user should see error message \"([^\"]*)\"$")
    public void user_should_see_error_message_something(String message) throws Throwable {
    	clientOnBoardingPage.verifyMessage(message);
    }
    
    @Then("^user should not see error message \"([^\"]*)\"$")
    public void user_should_not_see_error_message_something(String message) throws Throwable {
    	clientOnBoardingPage.verifyMessageDisappear(message);
    }
    @When("^user click on logout$")
    public void user_click_on_logout() throws Throwable {
    	clientOnBoardingPage.clickLogOut();
    }

    @When("^user click on OK on error popup$")
    public void user_click_on_ok_on_error_popup() throws Throwable {
    	clientOnBoardingPage.clickErrorOK();
    }
    
    @When("^user click on OK on confirm popup$")
    public void user_click_on_ok_on_confirm_popup() throws Throwable {
    	clientOnBoardingPage.clickConfirmationOK();
    }
    
    @Then("^user should see confirmation message \"([^\"]*)\"$")
    public void user_should_see_confirmation_something(String message) throws Throwable {
    	clientOnBoardingPage.verifyMessage(message);
    }
    
    @Then("^user should logout$")
    public void user_should_logout() throws Throwable {
    	clientOnBoardingPage.verifyUrlContains();
    }
    
    @Given("^user click Dossier Overview page$")
    public void user_click_dossier_overview_page() throws Throwable {
    	valiantPotalHomePage.clickDossierOverview ();
    }

    @When("^user search for dossier id$")
    public void user_search_for_dossier_id() throws Throwable {
    	String dossierId = (String)testContext.scenarioContext.getContext(Context.DOSSIER_ID);
    	dossierOverviewPage.inputFilter(dossierId);
    }

    @Then("^verify dossier exists$")
    public void verify_dossier_exists() throws Throwable {
        throw new PendingException();
    }
}

