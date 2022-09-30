import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstTestNGTestCase {
    WebDriver driver;
    @BeforeTest
    void openbroswer() {
        System.setProperty("webdriver.chrome.driver", "C:\\software\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
    }
    @Test(priority = 1)
    void computers() throws InterruptedException {
        System.out.println("home data");
        driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/a")).click();
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[1]/div/div[1]/div/h2/a")).click();
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[3]/div/div[2]/h2/a")).click();
        Thread.sleep(2000);
    }
    @Test(priority = 2)
    void addToCart() throws InterruptedException {
        driver.findElement(By.id("add-to-cart-button-3")).click();
        Thread.sleep(4000);
        WebElement popuppath = driver.findElement(By.xpath("//p[text() ='The product has been added to your ']"));
        String popup = popuppath.getText();
        Assert.assertEquals(popup, "The product has been added to your shopping cart");
        driver.findElement(By.xpath("/html/body/div[6]/div[4]/div[1]/div[3]/ul/li[4]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.className("qty-input")).clear();
        Thread.sleep(2000);
        driver.findElement(By.className("qty-input")).sendKeys("2");
    }
    @Test(priority = 3)
    void updateshoppingCart() throws InterruptedException {

        driver.findElement(By.xpath("//*[text()='Update shopping cart']")).click();
        driver.findElement(By.xpath("//*[text()='I agree with the terms of service and I adhere to them unconditionally']")).click();
        driver.findElement(By.id("checkout")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='Checkout as Guest']")).click();
    }
    @Test(priority = 4)
    void billingAddress() throws InterruptedException {
        driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys("shusi");
        driver.findElement(By.id("BillingNewAddress_LastName")).sendKeys("shah");
        driver.findElement(By.id("BillingNewAddress_Email")).sendKeys("shusi123@gmail.com");
        driver.findElement(By.id("BillingNewAddress_Company")).sendKeys("ABC.co");
        driver.findElement(By.id("BillingNewAddress_CountryId")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("BillingNewAddress_CountryId")).sendKeys("United Kingdom");
        Thread.sleep(3000);
        driver.findElement(By.id("BillingNewAddress_City")).sendKeys("Corby");
        driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("Little station");
        driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("NN188GT");
        driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("07721829997");
        driver.findElement(By.id("BillingNewAddress_FaxNumber")).sendKeys("234 435 456 7887");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[text()='Continue']")).click();
        Thread.sleep(3000);
    }
    @Test(priority = 5)
    void shippingMethod() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[3]/div[2]/form/div[2]/button")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[text()='Credit Card']")).click();
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[4]/div[2]/div/button")).click();
        Thread.sleep(3000);
    }
    @Test(priority = 6)
    void paymentInformation() throws InterruptedException {
        driver.findElement(By.id("CardholderName")).sendKeys("Shusi");
        driver.findElement(By.id("CardNumber")).sendKeys("4657568707831019");
        driver.findElement(By.id("ExpireYear")).click();
        driver.findElement(By.id("ExpireYear")).sendKeys("2025");
        driver.findElement(By.id("CardCode")).sendKeys("678");
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[5]/div[2]/div/button")).click();
        Thread.sleep(3000);
    }
    @Test(priority = 7)
    void confirmOrder() throws InterruptedException {
        driver.findElement(By.xpath("//*[text()='Confirm']")).click();
        Thread.sleep(3000);
    }
    @AfterTest
    void closebrowser() {
        driver.close();
    }
}
