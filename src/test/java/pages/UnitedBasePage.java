package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.Waiter;

import java.util.List;

public class UnitedBasePage {
   public UnitedBasePage(){
       PageFactory.initElements(Driver.getDriver(), this);
   }
   @FindBy(css = "a[id*=\"headerNav\"]")
    public List<WebElement> mainMenu;
   @FindBy(xpath = "//li[@id=\"travelTab\"]/..//li")
    public List<WebElement> travelManu;
   //////////////////////////////////////////////////////////////////////////////
   @FindBy(css = "div[class*='radioContainer']>label")
    public List<WebElement> radioButtonsLabels;
   @FindBy(css = "div[class*='radioContainer'] input")
    public List<WebElement> radioButtonsInput;
    ////////////////////////////////////////////////////////////////////////////
   @FindBy(id = "award")
    public WebElement bookWithMilesCheckbox;
    @FindBy(css = "div[class*='2SGSV'] span")
    public WebElement bookWithMilesLabel;
    @FindBy(id = "flexibleDates")
    public WebElement flexibleDatesCheckbox;
    @FindBy(css = "#flexDatesLabel>span")
    public WebElement flexibleDatesLabel;
    ////////////////////////////////////////////////////////////////////////////
    @FindBy(id = "bookFlightOriginInput")
    public WebElement fromInputBox;
    @FindBy(id = "bookFlightDestinationInput")
    public WebElement destinationInputBox;
    @FindBy(id = "DepartDate")
    public WebElement date;
    @FindBy(css = "#passengerSelector>button")
    public WebElement travelersSelector;
    @FindBy(xpath = "//button[@aria-label='Substract one Adult']")
    public WebElement plusOneAdult;
    @FindBy(id = "cabinType")
    public WebElement cabinTypeDropdownButton;
    @FindBy(css = ".app-components-ListBox-ListBox__listBoxExpandable--38-ZN>li")
    public List<WebElement> cabinTypeDropdownOptions;
    @FindBy(css = "button[class*='primaryButton--2fg9l']")
    public WebElement findFlightsButton;
    @FindBy(css = "div[class*='-3_5-b']>div")
    public WebElement result;

    public void clickOnCabinTypeOption(String str){
        cabinTypeDropdownButton.click();
        for (WebElement element : cabinTypeDropdownOptions) {
            if(element.getAttribute("aria-label").equals(str)){
                element.click();
                break;
            }
        }
    }
}
