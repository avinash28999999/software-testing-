package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://testffc.nimapinfotech.com/");
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password) {
        driver.findElement(By.id("mat-input-0")).sendKeys(username);
        driver.findElement(By.id("mat-input-1")).sendKeys(password);
        driver.findElement(By.id("kt_login_signin_submit")).click();

        // Validate login success
        String expectedUrl = "https://github.com";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][] {
                {"user1", "password1"},
                {"user2", "password2"}
        };
    }

//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }
}
