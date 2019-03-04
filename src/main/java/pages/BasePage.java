package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

public class BasePage {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public BasePage (WebDriver driver){
        BasePage.driver = driver;
        wait = new WebDriverWait(driver,15);
    }

    //Wait Wrapper Method
    public void waitVisibility(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }
    public void waitClickable(By elementBy) {
        wait.until(ExpectedConditions.elementToBeClickable(elementBy));
    }

    public void waitLoading() {
        wait.until(ExpectedConditions.attributeContains(By.xpath("//*[@id=\"ajax-indicator:ajax-indicator_start\"]"),"style","display: none"));
    }

    //Click Method
    public void click (By elementBy) {
        waitClickable(elementBy);
        driver.findElement(elementBy).click();
    }

    //ClickText Method
    public void clickText (String Text) {
        By elementBy = By.xpath("//*[text()=\"" + Text + "\"]");
        waitClickable(elementBy);
        driver.findElement(elementBy).click();
    }

    //Write Text
    public void writeText (By elementBy, String text) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).clear();
        driver.findElement(elementBy).sendKeys(text);
    }

    //Read Text
    public String readText (By elementBy) {
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getText();
    }
    
    //Count Elements
    public String countElements (By elementBy) {
        waitVisibility(elementBy);
        return String.valueOf(driver.findElements(elementBy).size());
    }
    
    //Assert
    public void assertEquals (By elementBy, String expectedText) {
        waitVisibility(elementBy);
        Assert.assertEquals(readText(elementBy), expectedText);

    }
    
    //Assert url
    public void assertURL (String str) {
    	waitLoading();
    	waitForLoad();
    	String url = driver.getCurrentUrl();
    	Assert.assertTrue(url.indexOf(str) !=-1? true: false);

    }    
    
    //Assert count
    public void assertCount (By elementBy, String expectedTotal) {
        waitVisibility(elementBy);
        Assert.assertEquals(countElements(elementBy), expectedTotal);

    }    
    
    //Assert list contains
    public void assertListContains(By elementBy, String text) {
        Assert.assertTrue(listofElementsText(elementBy).contains(text));
    }

    //
    public void assertNotExists(By elementBy) {
        Assert.assertFalse(existsElement(elementBy));
    }
    
    //
    public boolean existsElement(By elementBy) {
        try {
            driver.findElement(elementBy);
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }
    
    //
    public boolean existsText(String text) {
        try {
            driver.findElement(By.xpath("(//*[text()=\"" + text + "\"])"));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }
    
    //
    public List<String> listofElementsText(By elementBy) {
    	List<WebElement> elementsRoot = driver.findElements(elementBy);
    	
    	List<String> al=new ArrayList<String>();  
	    for (int i = 0; i < elementsRoot.size(); i++)
	    {
	       al.add(elementsRoot.get(i).getText());
	    }
	    return al;
    }
    
    public void waitForLoad() {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }
}