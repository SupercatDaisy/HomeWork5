package com.vytrack.tests;

import com.vytrack.pages.CalendarEventPage;
import com.vytrack.pages.LoginPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DateTimeUtilities;
import utilities.Wait;

import javax.script.ScriptEngine;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeWork5 extends TestBase {

    LoginPage loginPage=new LoginPage();
    CalendarEventPage calendarEventPage=new CalendarEventPage();

    @Test(description = "Test Case 1")
    public void TestersMeeting ()
    {
        LoginPage loginPage=new LoginPage();
        CalendarEventPage calendarEventPage=new CalendarEventPage();

        test=report.createTest("Verify that options are available");
        loginPage.login();
     //   CalendarEventPage calendarEventPage=new CalendarEventPage();
        calendarEventPage.navigateTo("Activities","Calendar Events");
        int random = (int) (Math.random() * (calendarEventPage.getThreeDots().size()));
        actions.moveToElement(calendarEventPage.getThreeDots().get(random)).build().perform();
        for (WebElement each : calendarEventPage.getThreedotMenu()){
            Assert.assertTrue(each.isDisplayed());
        }
        test.pass("Menu verified Successfully");
    }


    @Test(description = "Test Case 2")
    public void GridOptions()
    {
        LoginPage loginPage=new LoginPage();
        CalendarEventPage calendarEventPage=new CalendarEventPage();

        test=report.createTest("Verify that title column is displayed");
        loginPage.login();
       // CalendarEventPage calendarEventPage= new CalendarEventPage();
        calendarEventPage.navigateTo("Activities","Calendar Events");
        calendarEventPage.ClickGridSettings();
        for (int i = 1; i <calendarEventPage.GridSettingMenu().size() ; i++) {
            calendarEventPage.GridSettingMenu().get(i).click();
        }
        Assert.assertEquals("TITLE",calendarEventPage.getTitle());
        test.pass("Only Title is displayed");
    }

    @Test(description = "Test Case 3")
    public void SaveOptions ()
    {
        LoginPage loginPage=new LoginPage();
        CalendarEventPage calendarEventPage=new CalendarEventPage();

        test=report.createTest("Verify that Save options are available");
        loginPage.login();
       // CalendarEventPage calendarEventPage=new CalendarEventPage();
        calendarEventPage.navigateTo("Activities","Calendar Events");
        calendarEventPage.clickToCreateEvent();
        calendarEventPage.clickOnSaveAndClose();
        List<String> expected = new ArrayList<>(Arrays.asList("Save and Close","Save And New","Save"));
        for (int i = 0; i <expected.size() ; i++) {
            Assert.assertTrue(calendarEventPage.getSaveAndCloseOptions().get(i).equalsIgnoreCase(expected.get(i)));
        }
        test.pass("Options are displayed");

    }

    @Test(description = "Test Case 4")
    public void VerifyTitle()
    {   LoginPage loginPage=new LoginPage();
        CalendarEventPage calendarEventPage=new CalendarEventPage();

        test=report.createTest("Verify that All Calendar Events page sub is displayed");
        loginPage.login();
        calendarEventPage.navigateTo("Activities","Calendar Events");
        calendarEventPage.clickToCreateEvent();
        calendarEventPage.clickCancel();
        Wait.wait(2);
        Assert.assertEquals(calendarEventPage.getAllCalendarTitle(),"All Calendar Events");
        test.pass("Subtitle is displayed");
    }

    @Test(description = "Test Case 5")
    public void TimeDifference()
    {
        LoginPage loginPage=new LoginPage();
        CalendarEventPage calendarEventPage=new CalendarEventPage();

        test=report.createTest("Verify that time difference is 1 hour");
        loginPage.login();
        calendarEventPage.navigateTo("Activities","Calendar Events");
        calendarEventPage.clickToCreateEvent();
        Assert.assertEquals(DateTimeUtilities.getTimeDifference(calendarEventPage.getStartTime(), calendarEventPage.getEndTime(), "h:mm a"), 1);
        test.pass("Time Difference verified Successfully");
    }

    @Test(description = "Test Case 6")
    public void VerifySelectTime()
    {
        LoginPage loginPage=new LoginPage();
        CalendarEventPage calendarEventPage=new CalendarEventPage();

        test=report.createTest("Verify that time is 1 hour ahead selected");
        loginPage.login();
        calendarEventPage.navigateTo("Activities","Calendar Events");
        calendarEventPage.clickToCreateEvent();
        calendarEventPage.SelectTime();
        Wait.wait(2);
        Assert.assertEquals(calendarEventPage.getEndTime(),"10:00 PM");

    }

    @Test(description = "Test Case 7")
    public  void VerifyStartEnd()
    {
        LoginPage loginPage=new LoginPage();
        CalendarEventPage calendarEventPage=new CalendarEventPage();

        test=report.createTest("Verify that start and end date input boxes are displayed");
        loginPage.login();
        calendarEventPage.navigateTo("Activities","Calendar Events");
        calendarEventPage.clickToCreateEvent();
        calendarEventPage.clickAllDay();
        Assert.assertTrue(calendarEventPage.getAllDayCheck().isSelected());
        Wait.wait(2);
        Assert.assertFalse(calendarEventPage.getStart().isDisplayed());
        Assert.assertFalse(calendarEventPage.getEnd().isDisplayed());
        Assert.assertTrue(calendarEventPage.getStartDate2().isDisplayed());
        Assert.assertTrue(calendarEventPage.getEndDate2().isDisplayed());
    }

    @Test(description = "Test Case 8")
    public void VerifyDaily()
    {
        LoginPage loginPage=new LoginPage();
        CalendarEventPage calendarEventPage=new CalendarEventPage();

        test=report.createTest("Verify that “Daily” is selected by default and following options are available in “Repeats” drop-down:");
        loginPage.login();
        calendarEventPage.navigateTo("Activities","Calendar Events");
        calendarEventPage.clickToCreateEvent();
        calendarEventPage.clickRepeat();
        Assert.assertTrue(calendarEventPage.getRepeat().isSelected());
        Assert.assertEquals(calendarEventPage.getDefaultRepeatOptions(),"Daily");
        List<String> expected = new ArrayList<>(Arrays.asList("Daily","Weekly","Monthly","Yearly"));
        for (int i = 0; i <expected.size() ; i++) {
            Assert.assertTrue(expected.get(i).equalsIgnoreCase(calendarEventPage.getAllRepeatOptions().get(i)));
        }

    }

    @Test(description = "Test Case 9")
    public void MessageDisplay ()
    {
        LoginPage loginPage=new LoginPage();
        CalendarEventPage calendarEventPage=new CalendarEventPage();

        test=report.createTest("Verify that following message as a summary is displayed: Summary: Daily every 1 day");
        loginPage.login();
        calendarEventPage.navigateTo("Activities","Calendar Events");
        calendarEventPage.clickToCreateEvent();
        calendarEventPage.clickRepeat();
        Assert.assertTrue(calendarEventPage.getRepeat().isSelected());
        Assert.assertTrue(calendarEventPage.getRepeatEveryRadio().isSelected());
        Assert.assertTrue(calendarEventPage.getEndsRadio().isSelected());
        Assert.assertEquals(calendarEventPage.getSummary(),"Summary: Daily every 1 day");
    }

    @Test(description = "Test Case 10")
    public void After10()
    {
        LoginPage loginPage=new LoginPage();
        CalendarEventPage calendarEventPage=new CalendarEventPage();

        test=report.createTest("Verify that following message as a summary is displayed: Summary: Daily every 1 day, end after 10 occurrences");
        loginPage.login();
        calendarEventPage.navigateTo("Activities","Calendar Events");
        calendarEventPage.clickToCreateEvent();
        calendarEventPage.clickRepeat();
        calendarEventPage.clickAfterAndType();
        calendarEventPage.justClick();
        Assert.assertEquals(calendarEventPage.getSummary(),"Summary: Daily every 1 day, end after 10 occurrences");
    }

    @Test(description = "Test Case 11")
    public void SummaryDate()
    {
        LoginPage loginPage=new LoginPage();
        CalendarEventPage calendarEventPage=new CalendarEventPage();

        test=report.createTest("Verify that following message as a summary is displayed: Summary: Daily every 1 day, end by Nov 18, 2021");
        loginPage.login();
        calendarEventPage.navigateTo("Activities","Calendar Events");
        calendarEventPage.clickToCreateEvent();
        calendarEventPage.clickRepeat();
        calendarEventPage.clickBy();
        calendarEventPage.PutDate();
        Assert.assertEquals(calendarEventPage.getSummary(),"Summary: Daily every 1 day, end by Nov 18, 2021");
    }

    @Test(description = "Test Case 12")
    public void Weekly()
    {
        LoginPage loginPage=new LoginPage();
        CalendarEventPage calendarEventPage=new CalendarEventPage();

        test=report.createTest("Verify that following message as a summary is displayed: Summary: Weekly every 1 week on Monday, Friday");
        loginPage.login();
        calendarEventPage.navigateTo("Activities","Calendar Events");
        calendarEventPage.clickToCreateEvent();
        calendarEventPage.clickRepeat();
        calendarEventPage.SelectWeekly();
        calendarEventPage.SelectMondayAndFriday();
        Assert.assertTrue(calendarEventPage.getMonday().isSelected());
        Assert.assertTrue(calendarEventPage.getFriday().isSelected());
        Assert.assertEquals(calendarEventPage.getSummary(),"Summary: Weekly every 1 week on Monday, Friday");

    }

}











































































































































































