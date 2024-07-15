package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddCustomerTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://testffc.nimapinfotech.com/");
    }

    @Test(dataProvider = "customerData")
    public void addCustomerTest(String customerName, String customerEmail) {
        // Perform login
        driver.findElement(By.id("username")).sendKeys("valid_username");
        driver.findElement(By.id("password")).sendKeys("valid_password");
        driver.findElement(By.id("loginButton")).click();

        // Navigate to Add Customer page
        driver.findElement(By.id("addCustomerButton")).click();

        // Add customer details
        driver.findElement(By.id("customerName")).sendKeys(customerName);
        driver.findElement(By.id("customerEmail")).sendKeys(customerEmail);
        driver.findElement(By.id("saveButton")).click();

        // Validate customer addition
        String successMessage = driver.findElement(By.id("successMessage")).getText();
        Assert.assertEquals(successMessage, "Customer added successfully");
    }

    @DataProvider(name = "customerData")
    public Object[][] customerData() {
        return new Object[][] {
                {"Customer1", "customer1@example.com"},
                {"Customer2", "customer2@example.com"}
        };
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
