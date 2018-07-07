package by.htp.test.google;

import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTask3 {
	
	private static final String CHROME = "webdriver.chrome.driver";
	private static final String CHROME_PATH = "d:\\chromedriver\\chromedriver.exe";
	
	private WebDriver driver;
	
	@Before
	public void initDriver(){
		System.setProperty(CHROME, CHROME_PATH);
		driver = new ChromeDriver();
	}

	@Test
	public void testSearchFiledExists() throws InterruptedException {
		
		driver.get("http://www.quizful.net/test");

		// wait until page loads up to the footer section:
		WebElement firstPageFooter = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("footer")));
		
		// load all the "A" tags elements:
        List<WebElement> listOfAtags = driver.findElements( By.tagName( "a" ) );
        Iterator<WebElement> iteratorAtags = listOfAtags.iterator();
        // loop through that loaded list, and search for "href" element with "registration" value:
        while( iteratorAtags.hasNext( ) ) {
            WebElement aTagLink = iteratorAtags.next();
            if( aTagLink.getAttribute("href").contains( "registration" ) ) {
            	// if registration link is found, click on it, and exit this loop:
            	aTagLink.click();
                break;
            }
        }
		
        // wait until "registration" page loads up to the footer section:
		WebElement registrationPageFooter = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("footer")));
		
		// find and write values to the user name, password, email, check the corporate check box:
		WebElement loginNameOnSecondPage = driver.findElement(By.id("login"));
		loginNameOnSecondPage.sendKeys("vencislav1");
		
		WebElement password1onSecondPage = driver.findElement(By.name("registrationForm.password"));
		password1onSecondPage.sendKeys("*****************");
		
		WebElement password2onSecondPage = driver.findElement(By.name("registrationForm.repassword"));
		password2onSecondPage.sendKeys("*****************");
		
		WebElement emailOnSecondPage = driver.findElement(By.name("registrationForm.email"));
		emailOnSecondPage.sendKeys("vencislav.bujic@gmail.com");
		
		WebElement checkBoxOnSecondPage = driver.findElement(By.id("corporate"));
		checkBoxOnSecondPage.click();
		
		// pop up a dialog box and prompt user to enter number from captcha field:
		String captchaVal = JOptionPane.showInputDialog("Please enter the captcha value:");
		// the user input from a dialog box is copied automatically to the captcha input text field:
		WebElement captchaOnSecondPage = driver.findElement(By.name("registrationForm.captcha"));
		captchaOnSecondPage.sendKeys( captchaVal );
		
		// find and click on the "submit" button:
		WebElement submitOnSecondPage = driver.findElement(By.name("ok"));
		submitOnSecondPage.click();
		
		Thread.sleep(15000);
		driver.close();
	
	}

}