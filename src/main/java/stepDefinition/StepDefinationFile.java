package stepDefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Hello world!
 *
 */
public class StepDefinationFile 
{
   WebDriver driver=null;
   @Given("^User navigates to Orion Portal$") 
   public void initiateWebDriver()
   {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\shiule.maitra\\Desktop\\SeleniumDrivers\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.get("http://ec2-52-32-130-244.us-west-2.compute.amazonaws.com");
	driver.manage().window().maximize();
   }
   
   @When("^I enter the username as \"(.*)\"$") 
   public void setUserName(String arg1)
   {
	   driver.findElement(By.id("login")).sendKeys(arg1);
   }
   
   @When ("^I enter the password as \"(.*)\"$") 
   public void setPassword(String arg2)
   {
	   driver.findElement(By.id("password")).sendKeys(arg2);
   }
   
   @Then("^Login should pass$") 
   public void checkLogin()
   {
	   driver.findElement(By.xpath("//button[text()='Login']")).click();
   }
   
   @When("^I click on Administrator menu$")
   public void clickAdministratorMenu()
   {
	   driver.findElement(By.xpath("//span[contains(text(),'Administrators')]")).click();
	   
   }
   
   @Then("^Scroll down the page$")
   public void scrollDownThePage()
   {
	  /** Actions action=new Actions(driver);
	   action.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Analytics Visualizations')]")));**/
	   JavascriptExecutor jse = (JavascriptExecutor)driver;
	   jse.executeScript("window.scrollBy(0,500)", "");
   }
   
   @Then("^On clicking SearchFunction menu, user navigates to particular menu$")
   public void clickSearchMenu() throws InterruptedException
   {
	   WebDriverWait wait = new WebDriverWait(driver,10);
	   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Search Functions')]")));
	   driver.findElement(By.xpath("//span[contains(text(),'Search Functions')]")).click();
   }
 @When("^I click on Create button$")
 public void clickCreateButton() throws InterruptedException
 {
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//div[@class='clients-list']/preceding-sibling::a")).click();
 }
 
 @Then("^I navigate to Create page$")
 public void checkPage()
 {
	
	 WebDriverWait wait = new WebDriverWait(driver,10);
	 wait.until(ExpectedConditions.titleContains("Create Search Definition | Platform Science"));
	 driver.getCurrentUrl();
 }
 
 @Then ("^I enter all mandatory fields data with filepath$")
 public void enterRequiredPDFFields() throws InterruptedException, AWTException, IOException
 {
	 Thread.sleep(3000);
	 driver.findElement(By.id("title")).sendKeys("Automation_PDF_Title");
	 WebElement type=driver.findElement(By.id("js-form-type"));
	 Select typeDropdown=new Select(type);
	 typeDropdown.selectByValue("pdf");
	//WebElement filePath=driver.findElement(By.id("filetype"));
    driver.findElement(By.id("filetype")).click();
    String workingDir = System.getProperty("user.dir");
	String autoitscriptpath = workingDir + "\\"+ "Script.au";
	String filepath=workingDir + "\\Advanced-java.pdf";
    Runtime.getRuntime().exec(
			"cmd.exe /c Start AutoIt3.exe " + autoitscriptpath + " \""
					+ filepath + "\"");
	 Thread.sleep(3000);
	 
	 //filePath.sendKeys("C:/Users/shiule.maitra/Downloads/Advanced-java.pdf");
	 //driver.findElement(By.id("save")).click();
	// System.out.println(driver.findElement(By.id("success-message")).getText());
	 
 }

}
