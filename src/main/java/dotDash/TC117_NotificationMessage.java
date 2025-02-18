package dotDash;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.utilities.BaseClass;

import java.util.HashMap;

public class TC117_NotificationMessage extends BaseClass {

    @Test
    public void notificationMessage() {

        //Fetch data from Excel
        HashMap<String, String> testData = fnReadTestDataFromExcel("dotdashDatasheet.xlsx", "NotificationMsg");
        //Launch browser
        driver.get(baseURL + testData.get("URL"));
        SoftAssert assertion = new SoftAssert();
        //Click on Click here multiple times and valid msg using assertion
        for (int i=0;i<4;i++){
            driver.findElement(By.xpath("//div[@id='content']/div/p/a")).click();
            String msg = driver.findElement(By.id("flash")).getText();
            assertion.assertTrue(msg.contains("Action successful")||msg.contains("Action unsuccesful, please try again")||msg.contains("Action Unsuccessful"));
        }

    }
}