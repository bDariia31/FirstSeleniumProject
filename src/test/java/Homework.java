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

    @Test
    public void findElementCssSelector()
    {
        WebElement h2 = driver.findElement(By.cssSelector("div.topic-html-content-title h2.topic-html-content-header"));
        System.out.println(h2.getText());
        WebElement h3 = driver.findElement(By.cssSelector("div.column.information>h3"));
        System.out.println(h3.getText());
        WebElement p = driver.findElement(By.cssSelector("div.topic-html-content-body>p"));
        System.out.println(p.getText());
        List<WebElement> li = driver.findElements(By.cssSelector("li"));
        System.out.println(li.size());
        System.out.println("-------------------------------------------");


        WebElement pollblock1 = driver.findElement(By.cssSelector("#poll-block-1>strong"));
        System.out.println(pollblock1.getText());
        WebElement newslettersubscribeblock = driver.findElement(By.cssSelector("div.newsletter-subscribe-block>span"));
        System.out.println(newslettersubscribeblock.getText());
        System.out.println("-------------------------------------------");


        WebElement rightside3 = driver.findElement(By.cssSelector("div.rightside-3>div.block.block-newsletter>div.title>strong"));
        System.out.println(rightside3.getText());
        WebElement title = driver.findElement(By.cssSelector("div.listbox>div.newsletter-subscribe-block>span"));
        System.out.println(title.getText());
        WebElement footerdisclaimer = driver.findElement(By.cssSelector("div.block.block-poll>div.title>strong"));
        System.out.println(footerdisclaimer.getText());
        WebElement footerpoweredby = driver.findElement(By.cssSelector("div.poll>strong"));
        System.out.println(footerpoweredby.getText());

        WebElement elementLi2 = driver.findElement(By.cssSelector("ul.poll-options>li:nth-child(2)"));
        System.out.println(elementLi2.getText());
        WebElement elementLi4 = driver.findElement(By.cssSelector("ul.poll-options>li:nth-child(4)"));
        System.out.println(elementLi4.getText());

    }
     @Test
     public void findElementXpath()
     {
         WebElement h2 = driver.findElement(By.xpath("//div[@class='topic-html-content-title']/h2[@class='topic-html-content-header']"));
         System.out.println(h2.getText());
         WebElement h3 = driver.findElement(By.xpath("//div[@class='column information']/h3"));
         System.out.println(h3.getText());
          WebElement p = driver.findElement(By.xpath("//div[@class='topic-html-content-body']/p"));
         System.out.println(p.getText());
         WebElement p2 = driver.findElement(By.xpath("//div[@class='topic-html-content-body']/p[2]"));
         System.out.println(p2.getText());
         List<WebElement> li = driver.findElements(By.xpath("//li"));
         System.out.println(li.size());
         System.out.println("----------------------------------------");


         WebElement pollblock1 = driver.findElement(By.xpath("//div[@id='poll-block-1']/strong"));
         System.out.println(pollblock1.getText());
         WebElement newslettersubscribeblock = driver.findElement(By.xpath("//div[@id='newsletter-subscribe-block']/span"));
         System.out.println(newslettersubscribeblock.getText());
         System.out.println("-----------------------------------------");


         WebElement rightside3 = driver.findElement(By.xpath("//div[@class='rightside-3']/div[@class='block block-newsletter']//strong"));
         System.out.println(rightside3.getText());
         WebElement title = driver.findElement((By.xpath("//*[@class='listbox']/div[@class='newsletter-subscribe-block']/span")));
         System.out.println(title.getText());
         WebElement footerdisclaimer = driver.findElement(By.xpath("//div[@class='block block-poll']/div[@class='title']/strong"));
         System.out.println(footerdisclaimer.getText());
         WebElement footerpoweredby = driver.findElement(By.xpath("//div[@class='poll']/strong"));
         System.out.println(footerpoweredby.getText());

         WebElement ElementLi2 = driver.findElement(By.xpath("//ul[@class='poll-options']/li[2]"));
         System.out.println(ElementLi2.getText());
         WebElement ElementLi4 = driver.findElement(By.xpath("//ul[@class='poll-options']/li[4]"));
         System.out.println(ElementLi4.getText());



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
