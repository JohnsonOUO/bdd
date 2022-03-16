package StepDefinitions;


import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.loginPage;

public class StepDefinitions {
	
	static WebDriver driver = null;
	
	loginPage login;
	
	@Given("Open a new chrome browser and navigate to iiidevops")
	public void open_a_new_chrome_browser_and_navigate_to_iiidevops() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setAcceptInsecureCerts(true);
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver");
		
		driver = new ChromeDriver(chromeOptions);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		
		driver.manage().window().maximize();
		
		driver.get("https://iso.iiidevops.org");
	}
	
	@When("Wait for {double} seconds")
	public void wait_for_seconds(Double seconds) throws InterruptedException {
		Thread.sleep((long) (seconds * 1000));
	}
	
	@When("Log in iiidevops with username {string} and password {string}")
	public void log_in_iiidevops_with_username_and_password(String username, String password) {
		login = new loginPage(driver);
		login.login(username, password);
	}
	
	@Then("Successfully log into iiidevops")
	public void successfully_log_into_iiidevops() {
		Assert.assertEquals(driver.getCurrentUrl(),"https://iso.iiidevops.org/#/overview/dashboard");
		System.out.println("success");
	}
	
	@When("close browser")
	public void close_browser() {
		driver.close();
		driver.quit();
	}
}
