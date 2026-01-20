import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Homework
{
    WebDriver driver;

    @BeforeMethod
    public void setUp()
    {
        driver =new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void findElementByTagName()
    {
       WebElement h2= driver.findElement(By.tagName("h2"));
        System.out.println(h2.getText());
        WebElement h3= driver.findElement(By.tagName("h3"));
        System.out.println(h3.getText());
       WebElement p= driver.findElement(By.tagName("p"));
        System.out.println(p.getText());
        List<WebElement> li =driver.findElements(By.tagName("li"));
        System.out.println(li.size());

    }
    @Test
    public void findElementById()
    {
      WebElement pollblock1= driver.findElement(By.id("poll-block-1"));
        System.out.println(pollblock1.getAttribute("id"));
        WebElement newslettersubscribeblock = driver.findElement(By.id("newsletter-subscribe-block"));
        System.out.println(newslettersubscribeblock.getAttribute("id"));

    }

    @Test
    public void findElementByClass()
    {
        WebElement rightside3=driver.findElement(By.className("rightside-3"));
        System.out.println(rightside3.getText());
        WebElement title= driver.findElement(By.className("title"));
        System.out.println(title.getText());
        WebElement footerdisclaimer=driver.findElement(By.className("footer-disclaimer"));
        System.out.println(footerdisclaimer.getText());
        WebElement footerpoweredby =driver.findElement(By.className("footer-poweredby"));
        System.out.println(footerpoweredby.getText());


    }

    @AfterMethod
    public void tearDown()
    {
        if (driver!=null)
        {
            driver.quit();
        }
    }


}
