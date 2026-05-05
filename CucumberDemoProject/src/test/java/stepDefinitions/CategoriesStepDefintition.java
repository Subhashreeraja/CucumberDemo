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
import java.util.List;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CategoriesStepDefintition {

    WebDriver driver;
    WebDriverWait wait;
    
    @Before
    public void setup() {
        System.out.println("-------Before Executing----------");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://www.demoblaze.com/");

        
    }

 

    @Then("user should see the all categories")
    public void user_should_see_the_all_categories() {
        WebElement phones = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Phones']")));
        WebElement laptops = driver.findElement(
                By.xpath("//a[@id='itemc' and contains(text(),'Laptops')]"));
        WebElement monitors = driver.findElement(
                By.xpath("//a[@id='itemc' and contains(text(),'Monitors')]"));

        Assert.assertTrue(phones.isDisplayed(), "Phones category not visible");
        Assert.assertTrue(laptops.isDisplayed(), "Laptops category not visible");
        Assert.assertTrue(monitors.isDisplayed(), "Monitors category not visible");

        System.out.println("All categories visible: Phones, Laptops, Monitors");
    }

    @When("the user click the laptop section")
    public void the_user_click_the_laptop_section() {
        WebElement laptopLink = wait.until(
                ExpectedConditions.elementToBeClickable(
                		By.linkText("Laptops")));
        laptopLink.click();
    }

    @Then("the user should see the various laptop options")
    public void the_user_should_see_the_various_laptop_options() {
        List<WebElement> laptopItems = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(
                        By.xpath("//div[@class='card h-100']")));
        Assert.assertTrue(laptopItems.size() > 0, "No laptops found!");
        System.out.println("Laptops displayed: " + laptopItems.size() + " item(s)");
    }

    @When("the user click the monitor section")
    public void the_user_click_the_monitor_section() {
        WebElement monitorLink = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[@id='itemc' and contains(text(),'Monitors')]")));
        monitorLink.click();
    }

    @Then("the user should see the various monitor options")
    public void the_user_should_see_the_various_monitor_options() {
        List<WebElement> monitorItems = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(
                        By.xpath("//div[@id='tbodyid']//div[@class='card-block']")));
        Assert.assertTrue(monitorItems.size() > 0, "No monitors found!");
        System.out.println("Monitors displayed: " + monitorItems.size() + " item(s)");
    }

   
}