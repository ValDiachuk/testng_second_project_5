package scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.UnitedBasePage;
import utilities.ConfigReader;
import utilities.Driver;

public class UnitedBase {
    WebDriver driver;
    SoftAssert softAssert;
    UnitedBasePage unitedBasePage;


    @BeforeMethod
    public void setup() {
        driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("appURL"));
        softAssert = new SoftAssert();
        unitedBasePage = new UnitedBasePage();
    }

    @AfterMethod
    public void teardown() {
        //We will quit driver and do other proper clean ups
        softAssert.assertAll();
        Driver.quitDriver();
    }
}
