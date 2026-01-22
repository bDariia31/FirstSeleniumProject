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

  @Test
    public void findElementByXpath()
  {
     //         // tag+[@attribute='value']
      //        // tag+[2]  нумерация начинается с 1
      //       // tag+[@attribute='value1' and @attr2='value2']
      //        // tag+[@attribute='value1' not @attr2='value2']
      //   методы :      text();    contains();  last();

      // driver.findelement(By.cssSelector("h1");
      driver.findElements((By.xpath("//h1")));
      // driver.findElement(By.cssSelector("#city"));
      driver.findElement(By.xpath("//input[@id='city']"));
      //  driver.findElement(By.cssSelector(".telephone"));
      driver.findElement(By.xpath("//a[@class='telephone']"));
      // driver.findElement(By.cssSelector("[href='/search']"));
      driver.findElement(By.xpath("//a[@href='/search']"));
      //      driver.findElement(By.cssSelector("[for='city']"));
      driver.findElement(By.xpath("//label[@for='city']"));


      //  css - contains -> * ; Xpath * -> contains();
     // driver.findElement(By.cssSelector("[href*='car']")); // ищет все пары которые содержат car
      driver.findElement(By.xpath("//a[contains(@href,'car')]"));

      // css - start -> ^ ; Xpath ^ -> starts-with();
      //WebElement element = driver.findElement(By.cssSelector("[href^='/let']"));
       driver.findElement(By.xpath("//a[starts-with(@href,'/let')]"));

       // может искать по тексту
       // Text

      WebElement text1 = driver.findElement(By.xpath("//*[contains(text(),'This car exceeded my expectations')]"));
      WebElement text2 =driver.findElement(By.xpath("//*[contains(.,'This car exceeded my expectations')]"));
      System.out.println(text2.getText());

      WebElement textSpan = driver.findElement(By.xpath("//span[text()=' Latest feedback from our customers ']"));
      System.out.println(textSpan.getText());



//      driver.findElement(By.cssSelector("a.navigation-link[href='/search']"));// tag+class+pare
      WebElement element1 = driver.findElement(By.xpath("//a[@class='navigation-link' and @href='/search']"));
      System.out.println(element1.getText());
//      driver.findElement(By.cssSelector("div.social-networks")); // tag+class
      WebElement element2 = driver.findElement(By.xpath("//div[@class='social-networks']"));
      System.out.println(element2.getText());

      // cssSelector-> div>a  ; Xpath -> div/a - one step
      //cssSelector-> div a   ; Xpath -> div//a - one step or more steps


      // driver.findElement(By.cssSelector(".logo>img")); // > one step below один шаг в низ
      driver.findElement(By.xpath("//a[@class='logo']/img")); // слеш / это один шаг вниз
      //      driver.findElement(By.cssSelector(".feedback .feedback-date")); // <space> one or more steps below пробел от одного до некоторого колисества шагов вниз
      driver.findElement(By.xpath("//div[@class='feedback']//*[@class='feedback-date']")); // двойной слеш это пробел -one or more steps below
      // пробел от одного до некоторого количества шагов вниз


  }
  @Test
    public void findElementByXpathFamily()
  {
      //parent - если родиьель то шаг вверх
      driver.findElement(By.xpath("//h1/parent::*"));
      driver.findElement(By.xpath("//h1/parent::div"));
      driver.findElement(By.xpath("//h1/.."));

      // ancestor
      driver.findElement(By.xpath("//h1/ancestor::*")); // html
      driver.findElement(By.xpath("//h1/ancestor::div")); // two steps above (на верх)
      driver.findElement(By.xpath("//h1/ancestor::div[2]")); // two steps above (на верх)



  }




}

