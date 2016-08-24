import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaiduTest {
  private WebDriver driver;
  private String baseUrl;

  @Before
  public void setUp() throws Exception {
    DesiredCapabilities firefoxCap = DesiredCapabilities.firefox();
    firefoxCap.setBrowserName("firefox");

    driver = new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"),firefoxCap);
    baseUrl = "https://www.baidu.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testBaidu() throws Exception {
    driver.get(baseUrl);
    driver.findElement(By.id("kw")).clear();
    driver.findElement(By.id("kw")).sendKeys("google");
    driver.findElement(By.id("su")).click();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    assertEquals("Google", driver.findElement(By.cssSelector("a > em")).getText());
  }

  @After
  public void tearDown() throws Exception {
    driver.close();
  }

  }
