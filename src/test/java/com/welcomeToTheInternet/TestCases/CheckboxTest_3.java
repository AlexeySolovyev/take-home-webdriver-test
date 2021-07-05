package com.welcomeToTheInternet.TestCases;

import com.welcomeToTheInternet.PageObjects.CheckboxPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class CheckboxTest_3 extends BaseClass{

    @Test
    public void CheckboxTest() throws IOException {
        driver.get(baseURL);
        CheckboxPage checkbox = new CheckboxPage(driver);

        checkbox.clickCheckboxLink();
        logger.info("Navigate to the Checkbox page");
        checkbox.clickCheckbox1();
        logger.info("Clicked to the checkbox1");
        checkbox.clickCheckbox2();
        logger.info("Clicked to the checkbox2");
        boolean isCheckbox1Checked = driver.getPageSource().contains("checked");
        if (isCheckbox1Checked) {
            logger.info("Checkbox1 successfully tested");
            Assert.assertTrue(true);
        } else {
            logger.info("Test failed");
            captureScreen(driver, "Failed enabling checkbox1");
            Assert.fail();
        }

        boolean isCheckbox2Checked = driver.getPageSource().contains(" ");
        if (isCheckbox2Checked) {
            logger.info("Checkbox2 successfully tested");
            Assert.assertTrue(true);
        } else {
            logger.info("Test failed");
            captureScreen(driver, "Failed disabling checkbox2");
            Assert.fail();
        }
    }
}
