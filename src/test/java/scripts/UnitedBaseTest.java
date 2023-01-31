package scripts;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.UnitedBasePage;
import utilities.WindowHandler;

import java.util.List;

public class UnitedBaseTest extends UnitedBase {
    @BeforeMethod
    public void setPage() {
        unitedBasePage = new UnitedBasePage();
    }

    /*
Test Case 1: Validate "Main menu" navigation items
Given user is on "https://www.united.com/en/us"
Then user should see “Main menu” navigation items
|BOOK                              |
|MY TRIPS                          |
|TRAVEL INFO            |
|MILEAGEPLUS® PROGRAM|
|DEALS                             |
|HELP
     */
    @Test(priority = 1, description = "Validate \"Main menu\" navigation items")

    public void validateMainManu() {
        String[] expectedData = {"BOOK", "MY TRIPS", "TRAVEL INFO", "MILEAGEPLUS® PROGRAM","DEALS", "HELP"};
        List<WebElement> actualData = unitedBasePage.mainMenu;

        for (int i = 0; i < actualData.size(); i++) {
            Assert.assertEquals(expectedData[i], actualData.get(i).getText());
        }
    }

    /*
Test Case 2: Validate "Book travel menu" navigation items
Given user is on "https://www.united.com/en/us"
Then user should see "Book travel menu" navigation items
|Book             |
|Flight Status|
|Check-in       |
|My trips
     */

    @Test(priority = 2, description = "Validate \"Book travel menu\" navigation items")

    public void validateBookTravelManu() {

        for (int i = 0; i < unitedBasePage.travelManu.size(); i++) {
            Assert.assertTrue(unitedBasePage.travelManu.get(i).isDisplayed());
        }
    }
/*
Test Case 3: Validate "Round-trip" and "One-way" radio buttons
Given user is on "https://www.united.com/en/us"
Then validate "Roundtrip" radio button is displayed, is enabled and is selected
And validate "One-way" radio button is displayed, is enabled but is not selected
When user clicks on "One-way" radio button
Then validate "One-way" radio button is selected while "Roundtrip" radio button is
deselected
 */
    @Test(priority = 3, description = "Validate \"Round-trip\" and \"One-way\" radio buttons")

    public void validateRadioButtons() {

        //String[] textWayToTrips = {"Roundtrip", "One-way"};
        for (int i = 0; i < unitedBasePage.radioButtonsLabels.size(); i++) {
            Assert.assertTrue(unitedBasePage.radioButtonsLabels.get(i).isDisplayed());
            Assert.assertTrue(unitedBasePage.radioButtonsLabels.get(i).isEnabled());
        }
            Assert.assertTrue(unitedBasePage.radioButtonsInput.get(0).isSelected());
            Assert.assertFalse(unitedBasePage.radioButtonsInput.get(1).isSelected());

            unitedBasePage.radioButtonsInput.get(1).click();
            Assert.assertFalse(unitedBasePage.radioButtonsInput.get(0).isSelected());
            Assert.assertTrue(unitedBasePage.radioButtonsInput.get(1).isSelected());
        }


    @Test(priority = 4, description = "Validate \"Book with miles\" and \"Flexible dates\" checkboxes")

    public void validateCheckBoxes(){
        Assert.assertTrue(unitedBasePage.bookWithMilesLabel.isDisplayed());
        Assert.assertEquals(unitedBasePage.bookWithMilesLabel.getText(),"Book with miles");
        Assert.assertTrue(unitedBasePage.bookWithMilesCheckbox.isEnabled());
        Assert.assertFalse(unitedBasePage.bookWithMilesCheckbox.isSelected());

        Assert.assertTrue(unitedBasePage.flexibleDatesLabel.isDisplayed());
        Assert.assertEquals(unitedBasePage.flexibleDatesLabel.getText(),"Flexible dates");
        Assert.assertTrue(unitedBasePage.flexibleDatesCheckbox.isEnabled());
        Assert.assertFalse(unitedBasePage.flexibleDatesCheckbox.isSelected());

        unitedBasePage.bookWithMilesLabel.click();
        unitedBasePage.flexibleDatesLabel.click();

        Assert.assertTrue(unitedBasePage.bookWithMilesCheckbox.isSelected());
        Assert.assertTrue(unitedBasePage.flexibleDatesCheckbox.isSelected());

        unitedBasePage.bookWithMilesLabel.click();
        unitedBasePage.flexibleDatesLabel.click();

        Assert.assertFalse(unitedBasePage.bookWithMilesCheckbox.isSelected());
        Assert.assertFalse(unitedBasePage.flexibleDatesCheckbox.isSelected());

    }

    @Test(priority = 5, description = "Validate One-way ticket search results \"from Chicago, IL, US (ORD) to " +
            "Miami, FL, US (MIA")
    public void oneWayTicketSearch(){

        unitedBasePage.radioButtonsInput.get(1).click();
        unitedBasePage.fromInputBox.clear();
        unitedBasePage.fromInputBox.sendKeys("Chicago, IL, US (ORD)");
        unitedBasePage.destinationInputBox.clear();
        unitedBasePage.destinationInputBox.sendKeys("Miami, FL, US (MIA)");
        unitedBasePage.date.clear();
        unitedBasePage.date.sendKeys("Feb 28");
        unitedBasePage.date.click();
        unitedBasePage.travelersSelector.click();
        unitedBasePage.plusOneAdult.click();
        unitedBasePage.clickOnCabinTypeOption("Business or First");
        unitedBasePage.findFlightsButton.click();
        WindowHandler.switchToChildWindow();
        Assert.assertTrue(unitedBasePage.result.isDisplayed());
        Assert.assertEquals(unitedBasePage.result.getText(),"DEPART ON: February 28");
    }
}

