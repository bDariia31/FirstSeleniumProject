import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumTest {

    WebDriver driver;


    // before pre-condition (setUp)
    @BeforeMethod
    public void setUp()
    {
        driver = new ChromeDriver(); // если файл найдетчя то создается новый браузер окно
       // driver.get("https://www.google.com"); ссылка на гугл,  запускаем броузер, без истории без всяких догинов
        driver.navigate().to("https://www.google.com"); // запуск браузера уде с историей
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh(); // обновляет сраницу
    }
    // Test

    @Test
    public void openGoogle()
    {
        System.out.println("Google is opened");
    }
    // after conditions (tearDown)
    @AfterMethod
    public void tearDown()
    {
        // driver.quit(); // закрывает все вкладки и браузер
        driver.close(); // закроет только одну вкладку (если одно окно -> то закроется весь браузер )
    }
}
