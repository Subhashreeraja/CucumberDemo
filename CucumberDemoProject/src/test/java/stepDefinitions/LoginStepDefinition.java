package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class LoginStepDefinition {

   public static  WebDriver driver;
   public static  WebDriverWait wait;

    @Before
    public void setup() {
    	 System.out.println("-------Before Executing----------");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Given("User is on the HomePage")
    public void user_is_on_the_home_page() {
        driver.get("https://www.demoblaze.com/");
    }

    @When("user click the login link")
    public void user_click_the_login_link() {
        WebElement login = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("login2")));
        login.click();
    }

    @When("user enters username as {string}")
    public void user_enters_username_as(String username) {
        WebElement usernameField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    @When("User enters password as {string}")
    public void user_enters_password_as(String password) {
        WebElement passwordField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("loginpassword")));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    @When("user click the log in button")
    public void user_click_the_log_in_button() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[text()='Log in']"))).click();
    }

    @Then("User should see the welcome message")
    public void user_should_see_the_welcome_message() {
        WebElement welcome = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));

        Assert.assertTrue(welcome.isDisplayed());
        System.out.println("Login Successful: " + welcome.getText());
    }

    @Then("User should see the popup message")
    public void user_should_see_the_popup_message() {
        wait.until(ExpectedConditions.alertIsPresent());

        String alertText = driver.switchTo().alert().getText();
        System.out.println("Alert message: " + alertText);

        driver.switchTo().alert().accept();

        Assert.assertTrue(alertText.contains("Wrong password") 
                || alertText.contains("User does not exist"));
    }

    @Then("User should not be able to login successfully")
    public void user_should_not_be_able_to_login_successfully() {
        wait.until(ExpectedConditions.alertIsPresent());

        String alertText = driver.switchTo().alert().getText();
        System.out.println("Alert message: " + alertText);

        driver.switchTo().alert().accept();

        Assert.assertTrue(alertText.length() > 0);
    }

    @After
    public void tearDown() {
    	 System.out.println("-------After Executing----------");
        driver.quit();
    }
}