package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSODefinition {
	
	public static  WebDriver driver;
	   public static  WebDriverWait wait;
	   
	   @Before
	    public void setup() {
	    	 System.out.println("-------Before Executing----------");
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--start-maximized");

	        driver = new ChromeDriver(options);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	        driver.get("https://www.demoblaze.com/");
	        
	    }
	   @Given("user is on the HomePage")
	   public void user_is_on_the_home_page() {
	      
	   }
	   
	   @When("user clicks the login link")
	   public void user_clicks_the_login_link() {
		   wait.until(ExpectedConditions.elementToBeClickable(By.id("login2"))).click();
	
	   }


@When("user enters username as {string} and password as {string}")
public void user_enters_username_as_and_password_as(String username, String password) {
	
   
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logInModal")));

    driver.findElement(By.id("loginusername")).clear();
    driver.findElement(By.id("loginusername")).sendKeys(username);

    driver.findElement(By.id("loginpassword")).clear();
    driver.findElement(By.id("loginpassword")).sendKeys(password);
}
   
@When("user clicks the log in button")
public void user_clicks_the_log_in_button() {
	 wait.until(ExpectedConditions.elementToBeClickable(
             By.xpath("//button[text()='Log in']"))).click();
	
    
}


@Then("User should see the {string}")
public void user_should_see_the(String string) {
    Alert alert=	wait.until(ExpectedConditions.alertIsPresent());

    String alertText = driver.switchTo().alert().getText();
   
     if(alertText.equals("wrong password.")) {
   	 String exp ="wrong password.";
   	 Assert.assertEquals(exp, alertText);
   	 System.out.println("Alert: " + alertText);
        alert.accept();
    }
    else if(alertText.equals("User does not exist.")) {
   	 String exp ="User does not exist.";
   	 Assert.assertEquals(exp, alertText);
   	 System.out.println("Alert: " + alertText);
        alert.accept();
   	 
    }
    else {
   	 String exp ="Please fill out Username and Password.";
   	 Assert.assertEquals(exp, alertText);
   	 System.out.println("Alert: " + alertText);
        alert.accept();
    }       
    
}


@After
public void tearDown() {
	 System.out.println("-------After Executing----------");
    driver.quit();
}

}
