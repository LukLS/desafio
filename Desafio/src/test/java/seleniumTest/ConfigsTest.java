package seleniumTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class ConfigsTest {

	protected WebDriver driver;
	@BeforeAll
	private void DataSingle() {
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
	}

	void timeOut(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	void deleteXpath(String element){
		driver.findElement(By.xpath(element)).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);

	}
	void clickButton(String element){
		driver.findElement(By.xpath(element)).click();
	}

   void insert(String xpath, String args){
	   driver.findElement(By.xpath(xpath))
			   .sendKeys((args),Keys.ENTER);
   }

	void scroll(){
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		}catch (Exception e){

		}
	}

	void scrollUp(){
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, 0)");
		}catch (Exception e){}
	}

}
