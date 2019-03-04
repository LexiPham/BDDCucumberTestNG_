package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchClientRelationshipPage extends BasePage{

    //*********Constructor*********
    public SearchClientRelationshipPage(WebDriver driver) {
        super(driver);
    }

    //*********Page Variables*********
    String baseURL = "https://hidden:hidden@valiant.axonivy.io/";

    //*********Web Elements*********
    By searchInputBy = By.xpath("//*[@id=\'search-client-relationship-form:j_id_40:searchClientRelationshipTabs:searchClientRelationshipInputText\']");
    By continuesBy = By.xpath("(//*[@id='search-client-relationship-form:countinueSearchPageBtn'][@aria-disabled=\"false\"])");
    By firstRecordBy = By.xpath("//*[@id=\'search-client-relationship-form:j_id_40:searchClientRelationshipTabs:clientRelationshipTable_data\']/tr[1]/td[2]");

    //*********Page Methods*********
    public SearchClientRelationshipPage inputSearch (String text){
        writeText(searchInputBy, text);
        return this;
    }

    public SearchClientRelationshipPage clickFirstRecord(){
        click(firstRecordBy);
        return this;
    }

    public SearchClientRelationshipPage clickContinues (){
        click(continuesBy);
        return this;
    }
}