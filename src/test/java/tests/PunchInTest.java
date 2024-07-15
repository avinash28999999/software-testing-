package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PunchInTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://testffc.nimapinfotech.com/");
    }

    @Test
    public void punchInTest() {
        // Perform login first
        driver.findElement(By.id("username")).sendKeys("demousername");
        driver.findElement(By.id("password")).sendKeys("demopassword");
        driver.findElement(By.id("loginButton")).click();

        // Perform PunchIn action
        driver.findElement(By.id("punchInButton")).click();

        // Verify the toast/popup message
        String toastMessage = driver.findElement(By.id("toastMessage")).getText();
        Assert.assertEquals(toastMessage, "Expected PunchIn Success Message");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
