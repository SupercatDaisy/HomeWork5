package com.vytrack.pages;


import org.apache.commons.collections4.Put;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import utilities.BrowserUtils;
import utilities.Wait;

import java.util.List;
import java.util.logging.XMLFormatter;

public class CalendarEventPage extends PageBase {

    @FindBy(css = "a[class='btn main-group btn-primary pull-right ']")
    private WebElement createCalendarEvent;

    @FindBy(className = "select2-chosen")
    private WebElement owner;

    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_start']")
    private WebElement startDate;

    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_end']")
    private WebElement endDate;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_start']")
    private WebElement startTime;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_end']")
    private WebElement endTime;

    @FindBy(className = "grid-header-cell__label")
    private List<WebElement> columnNames;

    @FindBy(xpath = "//div[@class='btn btn-link dropdown-toggle']")
    private WebElement options;

    @FindBy(css = "input[type='number']")
    private WebElement defaultPageNumber;

    @FindBy(css = "button[class='btn dropdown-toggle ']")
    private WebElement PerPageNumber;


    @FindBy(css = "[id^='oro_calendar_event_form_title-uid']")
    private WebElement title;

    @FindBy(css = "iframe[id^='oro_calendar_event_form_description-uid']")
    private WebElement descriptionFrame;

    @FindBy(id = "tinymce")
    private WebElement textArea;

    @FindBy(css = "[class='btn-group pull-right'] > button")
    private WebElement SaveAndClose;

    @FindBy(xpath = "//label[text()='Description']/following-sibling::div//p[1]")
    private WebElement generalInfoDescription;

    @FindBy(xpath = "(//div[@class='control-label'])[1]")
    private WebElement generalInfoTitle;

    @FindBy(xpath = "//table/tbody//td[9]")
    private List<WebElement> threeDots;

    @FindBy(xpath = "//div[@id='bottom-anchor']/following-sibling::ul//a")
    private List<WebElement> threedotMenu;

    @FindBy(css = "a[title='Grid Settings']")
    private WebElement GridSettings;

    @FindBy(xpath = "//tbody[@class='ui-sortable']//tr/td[3]")
    private List<WebElement> GridMenu;

    @FindBy(css = "span[class='grid-header-cell__label']")
    private WebElement onlyTitleDisplay;

    @FindBy(css = "[class='btn-success btn dropdown-toggle']")
    private WebElement SaveAndCloseDrop;

    @FindBy(xpath = "//a[@class='btn-success btn dropdown-toggle']/following-sibling::ul/li")
    private List<WebElement> SaveAndCloseOptions;

    @FindBy(linkText = "Cancel")
    private WebElement Cancel;

    @FindBy(css = "h1[class='oro-subtitle']")
    private WebElement AllCalendarEventsTitle;

    @FindBy(css = "ul[class='ui-timepicker-list']>li")
    private List<WebElement> StartTimeMenu;

    @FindBy(css = "[id^='oro_calendar_event_form_allDay']")
    private WebElement allDayCheck;

    @FindBy(css = "[id^='recurrence-repeat-']")
    private WebElement Repeat;

    @FindBy(css = "[id^='recurrence-repeats-view']")
    private WebElement RepeatOptions;

    @FindBy(css = "[id^='recurrence-repeats-view']:nth-child(2)")
    public WebElement Weekly;

    @FindBy(css = "div[class='controls recurrence-subview-control__items']>div>label>input")
    private WebElement RepeatEveryRadio;

    @FindBy(css ="div[class='controls recurrence-subview-control recurrence-subview-control__items']>div>label>input")
    private WebElement EndsRadio;

    @FindBy(css = "div[class='control-group recurrence-summary alert-info']")
    private WebElement Summary;

    @FindBy(xpath = "//div[@class='controls recurrence-subview-control recurrence-subview-control__items']/div/following-sibling::div/label/input[1]")
    private WebElement After;

    @FindBy(xpath = "//div[@class='controls recurrence-subview-control recurrence-subview-control__items']/div/following-sibling::div/label/input[2]")
    private WebElement NumberOf;

    @FindBy(css = "div[class='recurrence-subview-control__item recurrence-subview-control__item-datetime']>label>input")
    private WebElement ByDate;

    @FindBy(xpath = "//div[@class='recurrence-subview-control__item recurrence-subview-control__item-datetime']/label/following-sibling::span/div/input[2]")
    private WebElement PutDate;

    @FindBy(linkText = "18")
    private WebElement select18;

    @FindBy(css = "input[value='monday']")
    private WebElement Monday;

    @FindBy(css = "input[value='friday']")
    private WebElement Friday;


    public String getDefaultRepeatOptions()
    {
        Select defaultOption =new Select(RepeatOptions);
       return defaultOption.getFirstSelectedOption().getText();
    }

    public void SelectWeekly()
    {
        Select Weekly= new Select(RepeatOptions);
        Weekly.selectByVisibleText("Weekly");
    }

    public List<String> getAllRepeatOptions()
    {
        Select allOptions = new Select(RepeatOptions);
        return BrowserUtils.getTextFromWebElements(allOptions.getOptions());
    }


    public List<WebElement> getThreedotMenu() {
        return threedotMenu;
    }

    public List<WebElement> getThreeDots() {
        return threeDots;
    }

    public List<WebElement> GridSettingMenu() {
        return GridMenu;
    }

    public void ClickGridSettings() {
        wait.until(ExpectedConditions.elementToBeClickable(GridSettings)).click();
    }

    public String getTitle() {
        return onlyTitleDisplay.getText().trim();
    }

    public void clickSaveAndCloseDrop() {
        wait.until(ExpectedConditions.elementToBeClickable(SaveAndCloseDrop));
    }

    public void enterCalendarEventTitle(String titleValue) {
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(title)).sendKeys(titleValue);
    }

    public void enterCalendarEventDescription(String description) {
        //wait until frame is available
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(descriptionFrame));
        textArea.sendKeys(description);
        driver.switchTo().defaultContent();//exit from the frame
    }

    public String getGeneralInfoDescriptionText() {
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Description']/following-sibling::div//div")));
        return generalInfoDescription.getText();
    }

    public String getGeneralInfoTitleText() {
        return generalInfoTitle.getText();
    }


    public void clickOnSaveAndClose() {
        wait.until(ExpectedConditions.elementToBeClickable(SaveAndCloseDrop));
        SaveAndCloseDrop.click();
    }


    public List<String> getSaveAndCloseOptions() {
        return BrowserUtils.getTextFromWebElements(SaveAndCloseOptions);
    }


    public void clickCancel() {
        wait.until(ExpectedConditions.elementToBeClickable(Cancel));
        Cancel.click();
    }

    public String getAllCalendarTitle() {
        wait.until(ExpectedConditions.visibilityOf(AllCalendarEventsTitle));
        return AllCalendarEventsTitle.getText().trim();
    }

    public void SelectTime() {
        wait.until(ExpectedConditions.visibilityOf(startTime));
        startTime.click();
        for (WebElement startTimeMenu : StartTimeMenu) {
            if (startTimeMenu.getText().equals("9:00 PM"))
                startTimeMenu.click();
        }
    }

public void clickAllDay()
{
    wait.until(ExpectedConditions.visibilityOf(allDayCheck));
    wait.until(ExpectedConditions.elementToBeClickable(allDayCheck));
    allDayCheck.click();

}

public WebElement getAllDayCheck()
{
    return allDayCheck;
}

public void clickRepeat()
{
    wait.until(ExpectedConditions.elementToBeClickable(Repeat));
    Repeat.click();
}
public WebElement getRepeat()
{
    return Repeat;
}

public WebElement getRepeatEveryRadio()
{
    return RepeatEveryRadio;
}

public WebElement getEndsRadio()
{
    return EndsRadio;
}

public String getSummary()
{
   String summary= Summary.getText();
   summary = summary.replaceAll("\n"," ");
   return summary;
}

public void clickAfterAndType ()
{
    wait.until(ExpectedConditions.elementToBeClickable(After));
    After.click();
    wait.until(ExpectedConditions.elementToBeClickable(NumberOf));
    NumberOf.sendKeys("10");

}
public void justClick()
{
        wait.until(ExpectedConditions.elementToBeClickable(After));
        After.click();
}

public void clickBy()
{
    wait.until(ExpectedConditions.elementToBeClickable(ByDate));
    wait.until(ExpectedConditions.visibilityOf(ByDate));
    ByDate.click();
}

public void PutDate()
{
    wait.until(ExpectedConditions.elementToBeClickable(PutDate));
    PutDate.sendKeys("Nov 18, 2021");
    select18();
}
public void clickDate()
{
    wait.until(ExpectedConditions.elementToBeClickable(PutDate));
    PutDate.click();
}

public void select18()
{
    select18.click();
}

public void SelectMondayAndFriday()
{
    wait.until(ExpectedConditions.elementToBeClickable(Monday));
    Monday.click();
    wait.until(ExpectedConditions.elementToBeClickable(Friday));
    Friday.click();
}

public WebElement getMonday()
{
    return Monday;
}

public WebElement getFriday()
{
    return Friday;
}

    public String getPerPageNumber()
{
    return PerPageNumber.getText().trim();
}


public String getDefaultPageNumber()
{
    return defaultPageNumber.getAttribute("value").trim();
}

public String getOptions()
{
    BrowserUtils.waitForPageToLoad(15);
    wait.until(ExpectedConditions.visibilityOf(options));
    return options.getText().trim();
}


public List<String> getColumnNames(){
    BrowserUtils.waitForPageToLoad(20);
    Wait.wait(2);
    return BrowserUtils.getTextFromWebElements(columnNames);
    }

public String getStartTime()
{
    BrowserUtils.waitForPageToLoad(10);
    wait.until(ExpectedConditions.visibilityOf(startTime));
    return startTime.getAttribute("value");
}

public String getEndTime()
    {
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(endTime));
        return endTime.getAttribute("value");

    }

    public WebElement getStart()
    {
        return startTime;
    }
    public WebElement getEnd()
    {
        return endTime;
    }
    public WebElement getStartDate2()
    {
        return startDate;
    }

    public WebElement getEndDate2()
    {
        return endDate;
    }

public String getStartDate()
{
    BrowserUtils.waitForPageToLoad(10);
    wait.until(ExpectedConditions.visibilityOf(startDate));
    return startDate.getAttribute("value");
}

public String getOwner()
{
    BrowserUtils.waitForPageToLoad(10);
   // wait.until(ExpectedConditions.presenceOfElementLocated(By.className("select2-chosen")));
    wait.until(ExpectedConditions.visibilityOf(owner));
    return owner.getText().trim();
}


public void clickToCreateEvent ()
{
    wait.until(ExpectedConditions.elementToBeClickable(createCalendarEvent)).click();

}


}
