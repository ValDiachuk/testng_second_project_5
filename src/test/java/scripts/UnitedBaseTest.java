package scripts;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.UnitedBasePage;
import utilities.WindowHandler;

public class UnitedBaseTest extends UnitedBase {
    @BeforeMethod
    public void setPage() {
        unitedBasePage = new UnitedBasePage();
    }

    @Test(priority = 1, description = "Validate that main menu is displayed")

    public void validateMainManu() {
        for (int i = 0; i < unitedBasePage.mainMenu.size(); i++) {
            Assert.assertTrue(unitedBasePage.mainMenu.get(i).isDisplayed());
        }
    }

    @Test(priority = 2, description = "Validate book travel manu is displayed ")

    public void validateBookTravelManu() {
        for (int i = 0; i < unitedBasePage.travelManu.size(); i++) {
            Assert.assertTrue(unitedBasePage.travelManu.get(i).isDisplayed());
        }
    }

    @Test(priority = 3, description = "Validate \"Round-trip\" and \"One-way\" radio buttons")

    public void validateRadioButtons() {

        //String[] textWayToTrips = {"Roundtrip", "One-way"};
        for (int i = 0; i < unitedBasePage.radioButtonsLabels.size(); i++) {
            Assert.assertTrue(unitedBasePage.radioButtonsLabels.get(0).isDisplayed());
            Assert.assertTrue(unitedBasePage.radioButtons.get(0).isEnabled());
            Assert.assertFalse(unitedBasePage.radioButtons.get(0).isSelected());
            //Assert.assertEquals(unitedBasePage.radioButtons.get(i).getText(), textWayToTrips[i]);

            Assert.assertTrue(unitedBasePage.radioButtons.get(1).isDisplayed());
            Assert.assertTrue(unitedBasePage.radioButtons.get(1).isEnabled());
            Assert.assertFalse(unitedBasePage.radioButtons.get(1).isSelected());

            unitedBasePage.radioButtons.get(1).click();
            Assert.assertFalse(unitedBasePage.radioButtons.get(1).isSelected());
            Assert.assertFalse(unitedBasePage.radioButtons.get(0).isSelected());

        }
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

        unitedBasePage.radioButtons.get(1).click();
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

