package com.welcomeToTheInternet.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FloatingMenuPage {

    WebDriver localDriver;
    public FloatingMenuPage(WebDriver remoteDriver) {
        localDriver = remoteDriver;
        PageFactory.initElements(remoteDriver, this);
    }

    @FindBy(css = "a[href='/floating_menu']")
    @CacheLookup
    WebElement linkFloatingMenuPage;

    @FindBy(css = "a[href='#home']")
    @CacheLookup
    WebElement floatingMenu;

    public void clickFloatingPageLink() {
        linkFloatingMenuPage.click();
    }

    public void scrollDownPage() {
        JavascriptExecutor js = (JavascriptExecutor) localDriver;
        js.executeScript("window.scrollBy(0, 4000)");
    }

    public void checkFloatingMenu() {
        boolean isMenuVisible = localDriver.getPageSource().contains("Home");
        if (isMenuVisible) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }
}
