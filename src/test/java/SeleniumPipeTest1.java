import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumPipeTest1 {
    WebDriver driver;
    String Baseurl;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        Baseurl="http://executeautomation.com/demosite/Login.html" ;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
    }
    @Test
    public void Test1() throws InterruptedException {
        driver.get(Baseurl);
        driver.findElement(By.xpath("//*[@id=\"userName\"]/p[1]/input")).sendKeys("tttt");
        driver.findElement(By.xpath("//*[@id=\"userName\"]/p[2]/input")).sendKeys("aaa");
        driver.findElement(By.xpath("//*[@id=\"userName\"]/p[3]/input")).click();
    }
    @Test
    public void Test2() throws InterruptedException {
        driver.get("https://demosite.executeautomation.com/index.html?UserName=ttt&Password=aaa&Login=Login");
      Select dropdown= new Select(driver.findElement(By.id("TitleId")));
      dropdown.selectByVisibleText("Mr.");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
       driver.findElement(By.xpath("//*[@id=\"Initial\"]")).sendKeys("W");
        driver.findElement(By.xpath("//*[@id=\"FirstName\"]")).sendKeys("Wawa");
        driver.findElement(By.xpath("//*[@id=\"MiddleName\"]")).sendKeys("WM");

       WebElement check1=driver.findElement(By.xpath("//*[@id=\"details\"]/table/tbody/tr[5]/td[2]/input[1]"));
        check1.click();
        WebElement tick1=driver.findElement(By.xpath("//*[@id=\"details\"]/table/tbody/tr[6]/td[2]/input[1]"));
        tick1.click();
        tick1.click();
        driver.findElement(By.xpath("//*[@id=\"details\"]/table/tbody/tr[7]/td/input")).click();
        Thread.sleep(4000);
        driver.findElement(By.linkText("LOGOUT")).click();

    }

    @AfterMethod

    public void CloseBrowser() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();

    }
}
