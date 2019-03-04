package managers;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import enums.DriverType;
import enums.EnvironmentType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

public class WebDriverManager {
    private WebDriver driver;
    private static DriverType driverType;
    private static EnvironmentType environmentType;

    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

    public WebDriverManager() {
        driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
        environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
    }

    public WebDriver getDriver() throws MalformedURLException{
        if(driver == null) driver = createDriver();
        return driver;
    }

    private WebDriver createDriver() throws MalformedURLException{
        switch (environmentType) {
            case LOCAL : driver = createLocalDriver();
                break;
            case REMOTE : driver = createRemoteDriver();
                break;
        }
        return driver;
    }

    private WebDriver createRemoteDriver() throws MalformedURLException {
         switch (driverType) {
            case firefox : driver = new FirefoxDriver();
                break;
            case chrome :
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("browserName", FileReaderManager.getInstance().getConfigReader().getBrowser());
                driver = new RemoteWebDriver(new URL("http:/10.124.1.31:4444/wd/hub"), caps);
                break;
            case INTERNETEXPLORER : driver = new InternetExplorerDriver();
                break;
        }

        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
        return driver;
    }

    private WebDriver createLocalDriver() {
        switch (driverType) {
            case firefox : driver = new FirefoxDriver();
                break;
            case chrome :
                driver = new ChromeDriver();
//            	ChromeOptions options = new ChromeOptions();
//            	options.addExtensions(new File("/path/to/extension.crx"));
//            	DesiredCapabilities capabilities = new DesiredCapabilities();
//            	capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//            	driver = new ChromeDriver(capabilities);
                break;
            case INTERNETEXPLORER : driver = new InternetExplorerDriver();
                break;
        }

        if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
        return driver;
    }

    public void closeDriver() {
        driver.close();
        driver.quit();
    }

}