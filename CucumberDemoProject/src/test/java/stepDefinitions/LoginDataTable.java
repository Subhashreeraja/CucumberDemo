package stepDefinitions;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginDataTable {
	
WebDriver driver;
WebDriverWait wait;

@Before
public void setup() {
	 System.out.println("-------Before Executing----------");
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--start-maximized");

    driver = new ChromeDriver(options);
    wait = new WebDriverWait(driver, Duration.ofSeconds(25));
    driver.get("https://www.demoblaze.com/");
    
}
@Given("user is on the Demoblazepage")
public void user_is_on_the_demoblazepage() {
   
}
@When("user enters valid credentials")
public void user_enters_valid_credentials(DataTable dataTable) {

    System.out.println("Credentials Entered");

    List<List<String>> form = dataTable.asLists(String.class);
    String username = form.get(0).get(0);
    String password = form.get(0).get(1);

    wait.until(ExpectedConditions.elementToBeClickable(By.id("login2"))).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
    driver.findElement(By.id("loginusername")).sendKeys(username);
    driver.findElement(By.id("loginpassword")).sendKeys(password);
    driver.findElement(By.xpath("//button[text()='Log in']")).click();
}
@Then("user should be able to login successfully and new page open")
public void user_should_be_able_to_login_successfully_and_new_page_open() {
	WebElement welcomeMsg = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));

    if (welcomeMsg.getText().contains("Welcome")) {
        System.out.println("Login Successful");
    } else {
    	System.out.println("Login not successful");
    }
     
}


@After
public void tearDown() {
	 System.out.println("-------After Executing----------");
    driver.quit();
}

}
