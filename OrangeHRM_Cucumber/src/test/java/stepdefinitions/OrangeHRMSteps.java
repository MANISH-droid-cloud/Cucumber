package stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OrangeHRMSteps 
{

	public static WebDriver driver;
	
	@Given("^i open browser with url \"([^\"]*)\"$")
	public void launchApp(String url)  
	{
	  
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		
	}

	@Then("^i should see login page$")
	public void i_should_see_login_page() 
	{
		if(driver.findElement(By.id("btnLogin")).isDisplayed())
		{
			System.out.println("System Displayed Login Page");
		}
	  
	}

	@When("^i enter username as \"([^\"]*)\"$")
	public void i_enter_username_as(String uid) 
	{
		driver.findElement(By.id("txtUsername")).sendKeys(uid);
	}

	@When("^i enter password as \"([^\"]*)\"$")
	public void i_enter_password_as(String pwd) 
	{
		driver.findElement(By.id("txtPassword")).sendKeys(pwd);
	}

	@When("^i click login$")
	public void i_click_login() 
	{
		driver.findElement(By.id("btnLogin")).click();
	}

	@Then("^i should see admin module$")
	public void i_should_see_admin_module() 
	{
		if(driver.findElement(By.linkText("Admin")).isDisplayed())
		{
			System.out.println("System displayed Admin Module");
		}
	}

	@When("^i click logout$")
	public void i_click_logout() 
	{
		driver.findElement(By.partialLinkText("Welcome")).click();
		driver.findElement(By.linkText("Logout")).click();
	 
	}

	@When("^i close browser$")
	public void i_close_browser() 
	{
	    driver.close();	
	}
	
	@Then("^i should see error message$")
	public void i_should_see_error_message() 
	{
	    String errmsg;
	    errmsg = driver.findElement(By.id("spanMessage")).getText();
	    if(errmsg.toLowerCase().contains("invalid"))
	    {
	    	System.out.println("System displayed appropriate error message for invalid data");
	    }		
	}
	
	@When("^i goto add employee page$")
	public void i_goto_add_employee_page() 
	{
		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.linkText("Add Employee")).click();
	    
	}

	@When("^i enter firstname as \"([^\"]*)\"$")
	public void i_enter_firstname_as(String fname) 
	{
	    driver.findElement(By.id("firstName")).sendKeys(fname);
	}

	@When("^i enter lastname as \"([^\"]*)\"$")
	public void i_enter_lastname_as(String lname) 
	{
		driver.findElement(By.id("lastName")).sendKeys(lname);
	}

	@When("^i click save$")
	public void i_click_save() 
	{
		driver.findElement(By.id("btnSave")).click();
	}
	
}
