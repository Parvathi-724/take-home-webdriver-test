package dotDash;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.utilities.BaseClass;

import java.util.HashMap;

public class TC106_DynamicContent extends BaseClass {

    @Test
    public void dynamicContent() {

        //Fetch data from Excel
        HashMap<String, String> testData = fnReadTestDataFromExcel("dotdashDatasheet.xlsx", "DynamicContent");
        //Launch browser
        driver.get(baseURL + testData.get("URL"));
        //Get Page content
        String s1 = driver.findElement(By.id("content")).getText();
        //Refresh the page
        driver.navigate().refresh();
        //Get Page content
        String s2 = driver.findElement(By.id("content")).getText();
        //Refresh the page
        driver.navigate().refresh();
        //Get Page content
        String s3 = driver.findElement(By.id("content")).getText();
        SoftAssert assertion = new SoftAssert();
        assertion.assertNotEquals(s1,s2,"Error in content matching");
        assertion.assertNotEquals(s2,s3,"Error in content matching");
        assertion.assertAll();
    }
}