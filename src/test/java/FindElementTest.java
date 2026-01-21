import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElementTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp()
    {
      driver= new ChromeDriver();
      driver.get("https://ilcarro.web.app");
      // maximize browser to windows
        driver.manage().window().maximize();
        // wait to upload all alements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @AfterMethod
    public void tearDown()
    {
        if(driver!= null)
        {
            driver.quit();// закрывает все окна текущее и  завершает сесию
           // driver.close(); // закрывает окно текущее не закрывает браузер и не завершает сесию
        }
    }

    @Test
    public void findElementByTagName() // стратегия (tagName) ишет элемент по тегу
    {
        WebElement h1= driver.findElement(By.tagName("h1"));//(By.tagName) - стратегия ,( h1)- локатор
        System.out.println(h1.getText()); // достали текст из элемента h1

        WebElement h2=driver.findElement(By.tagName("h2"));
        System.out.println(h2.getText());

        WebElement link=driver.findElement(By.tagName("a"));
        System.out.println(link.getAttribute("class")); // !!!!

        // list
        List<WebElement> links= driver.findElements(By.tagName("a"));
        System.out.println(links.size());


    }
    @Test
    public void findElementById()
    {
        WebElement city=driver.findElement(By.id("city"));
        System.out.println(city.getAttribute("id"));


        WebElement dates= driver.findElement(By.id("dates"));
        System.out.println(dates.getAttribute("id"));
    }

  @Test
  public void findElementByClassName()
  {
      WebElement telephone = driver.findElement(By.className("telephone"));
      System.out.println(telephone.getText());

      WebElement description=driver.findElement(By.className("description"));
      System.out.println(description.getText());
  }

   @Test
    public  void findElenmentByLinkTest()
   {
       WebElement linkText = driver.findElement(By.linkText("Let the car work"));
       System.out.println(linkText.getText());
   }
@Test
    public void findElementByPatialLinkTest()
{
    WebElement work= driver.findElement(By.partialLinkText("work"));
    System.out.println(work.getText());
}

  @Test
    public void findElementByCssSelecftor()
  {
      // driver.findElement(By.tagName("h1"));
      // tag name "h1" -> css "h1"

      driver.findElement(By.cssSelector("h1"));

      // driver.findElement(By.id("city");
      // id "city"-> css '#city'
      driver.findElement(By.cssSelector("#city"));

      // driver.findElement(By.className("telephone"));
      // class "telephone" -> css ".telephone"
      driver.findElement(By.cssSelector(".telephone"));

      // [attr='par']
      driver.findElement(By.cssSelector("[href='/search']"));

      driver.findElement(By.cssSelector("[for='city']"));

      // contains -> *
      driver.findElement(By.cssSelector("[href*='car']")); // ищет все пары которые содержат car
      // start -> ^
      WebElement element = driver.findElement(By.cssSelector("[href^='/let']"));
      // end to -> $
      driver.findElement(By.cssSelector("[href$='work']"));

      // composite cssSelector составные  css селекторы
       // a.navigation-link[href='/search'] . tag , class и пара
      driver.findElement(By.cssSelector("a.navigation-link[href='/search']"));// tag+class+pare
      driver.findElement(By.cssSelector("div.social-networks")); // tag+class

      driver.findElement(By.cssSelector(".logo>img")); // > one step below один шаг в низ
      driver.findElement(By.cssSelector(".feedback .feedback-date")); // <space> one or more steps below пробел от одного до некоторого колисества шагов вниз

      // <tag> or <id> or <class>:nth-child(n)
      WebElement feedback = driver.findElement(By.cssSelector(".feedback:nth-child(5)"));
      System.out.println(feedback.getText());

      driver.findElement(By.cssSelector("[type='submit']"));
      driver.findElement(By.cssSelector(".title-container span.title")); // class+ <space> + tag+ class



  }
}

