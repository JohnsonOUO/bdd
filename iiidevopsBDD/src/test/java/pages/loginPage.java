package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	
//	WebDriver driver;
	
//	@CacheLookup
	@FindBy(name = "帳號")
	private WebElement txt_username;
//	List<WebElement> txt_username;
	
	@FindBy(name = "password")
	private WebElement txt_password;
	
	@FindBy(className = "el-button")	
	private WebElement btn_login;
	
	public loginPage(WebDriver driver) {
//		this.driver = driver;		
		PageFactory.initElements(driver, this);
//		PageFactory.initElements(AjaxElementLocatorFactory(driver, 30), this);

		if (!driver.getTitle().equals("III DevOps")) {
			throw new IllegalStateException("This is not a login page. The current page is " + driver.getTitle());
		}
	}
	
	public void enterUsername(String username) {
		txt_username.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		txt_password.sendKeys(password);
	}	
	
	public void clickLoginButton() {
		btn_login.click();
	}	
		
	public void login(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickLoginButton();
	}
}
