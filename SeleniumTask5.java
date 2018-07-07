package by.htp.test.google;
//

import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTask5 {
	
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
		
		driver.get("https://www.it-academy.by/");

		// wait until page loads up to the footer section:
		WebElement firstPageFooter = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated( By.className("page-footer") ) );
		
		
		WebElement listOfGroups = driver.findElement( By.className("panel-section-inner") );
		List<WebElement> nameOfListGroups = listOfGroups.findElements( By.className("panel-section-list__item") );
		System.out.println( "Size of 1 group is: " + nameOfListGroups.size() );
		List<WebElement> nameOfListGroupsByTag = listOfGroups.findElements(By.tagName("span"));
		System.out.println( "Size of 2 group is: " + nameOfListGroupsByTag.size() );
		
		WebElement one1 = nameOfListGroupsByTag.get(1);
		String stringone1 = one1.getText();
		System.out.println("String one1 = " + stringone1);
		//String zerofirstname = nameOfListGroupsByTag.get(1).getAttribute(By.linkText(linkText);
		//System.out.println("Zero first name is: " + zerofirstname);
		//List<WebElement> alllinkspresent=driver.findElements(By.tagName(“a”));
		String veryfirstname = nameOfListGroups.get(1).getText();
		System.out.println("Very first name is: " + veryfirstname);
		//nameOfListGroups.
		//String Text = driver.findElement(By.id(“Text”)).getText(); 
		Iterator<WebElement> iteratorOfGroups = nameOfListGroups.iterator();
		WebElement firstelement = iteratorOfGroups.next();
		WebElement secondelement = firstelement.findElement(By.className("list-item__page-link"));
		String nameofelement = secondelement.getText();
		//String Text = secondelement.findElement(By.id("Text"));
		System.out.println( "name of first group is: " + nameofelement );
		
		
//		// load all the "A" tags elements:
//        List<WebElement> listOfAtags = driver.findElements( By.tagName( "a" ) );
//        Iterator<WebElement> iteratorAtags = listOfAtags.iterator();
//        // loop through that loaded list, and search for "href" element with "registration" value:
//        while( iteratorAtags.hasNext( ) ) {
//            WebElement aTagLink = iteratorAtags.next();
//            if( aTagLink.getAttribute("href").contains( "registration" ) ) {
//            	// if registration link is found, click on it, and exit this loop:
//            	aTagLink.click();
//                break;
//            }
//        }

		
		Thread.sleep(5000);
		driver.close();
	
	}

}