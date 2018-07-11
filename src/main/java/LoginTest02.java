import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
//--
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
//--
import org.openqa.selenium.WebDriver;
//--
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//--
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
//--
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class LoginTest02 {
    private WebDriver driver;

  @Test
  public void f() {
  }
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
      driver.quit();
  }
      
      @Test
      public void verifyLogin() {
    	//Configuracion Chrome driver
    	System.setProperty("webdriver.chrome.driver", "/home/raul/eclipse-workspace/logintest01/chromedriver");
  		driver = new ChromeDriver();
  		//Time wait
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
  		//Maximize page and open the login link
        driver.manage().window().maximize();   		
  		driver.navigate().to("https://sitescan-staging.3dr.com/auth");		
  		//Test flow
  		driver.findElement(By.cssSelector("input[data-test='login-email']")).sendKeys("raul@test.com");
  		driver.findElement(By.cssSelector("input[data-test='login-password']")).sendKeys("abc123");
  		driver.findElement(By.cssSelector("input[data-test='login-password']")).sendKeys(Keys.ENTER);
  		
  		String error = driver.findElement(By.cssSelector("div[data-test='login-error']")).getText();
  		System.out.println(error);
  		Assert.assertEquals(error,"Incorrect username or password");
  		
  }

}
