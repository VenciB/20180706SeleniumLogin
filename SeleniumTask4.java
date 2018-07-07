package by.htp.test.google;

import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTask4 {
	
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
		
		// load all the "A" tags elements on the profile page:
		List<WebElement> listOfAtagsOnUpdateMain = driver.findElements( By.tagName( "a" ) );
		Iterator<WebElement> iteratorAtagsOnUpdateMain = listOfAtagsOnUpdateMain.iterator();
		// loop through that loaded list, and search for "href" element with "loginForm" value:
		while( iteratorAtagsOnUpdateMain.hasNext( ) ) {
			WebElement aTagLink = iteratorAtagsOnUpdateMain.next();
		    if( aTagLink.getAttribute("href").contains( "LoginAction.loginForm" ) ) {
		    // if registration link is found, click on it, and exit this loop:
		    	aTagLink.click();
		        break;
		    }
		}
		
        // wait until "login" page loads up to the footer section:
		WebElement registrationPageFooter = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("footer")));
		
		// find and write values to the user name, password, email, check the corporate check box:
		WebElement loginNameOnLoginPage = driver.findElement(By.id("login"));
		loginNameOnLoginPage.sendKeys("vencislav1");
		
		WebElement passwordonLoginPage = driver.findElement(By.name("loginForm.password"));
		passwordonLoginPage.sendKeys("*********");
				
		// find and click on the "submit" button to login:
		WebElement submitOnLoginPage = driver.findElement(By.name("ok"));
		submitOnLoginPage.click();
		
		// wait until "main" page loads up to the footer section:
		WebElement mainPageFooter = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("footer")));
				
		// load all the "A" tags elements on the profile page:
		List<WebElement> listOfAtagsOnProfile = driver.findElements( By.tagName( "a" ) );
		Iterator<WebElement> iteratorAtagsOnProfile = listOfAtagsOnProfile.iterator();
		// loop through that loaded list, and search for "href" element with "loginForm" value:
		while( iteratorAtagsOnProfile.hasNext( ) ) {
			WebElement aTagLink = iteratorAtagsOnProfile.next();
		    if( aTagLink.getAttribute("href").contains( "user/" ) ) {
		    // if registration link is found, click on it, and exit this loop:
		    	aTagLink.click();
		        break;
		    }
		}
		

		// wait until "main" page loads up to the footer section:
		WebElement profilePageFooter = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("footer")));
				
		// load all the "A" tags elements on the profile page:
		List<WebElement> listOfAtagsOnUpdateProfile = driver.findElements( By.tagName( "a" ) );
		Iterator<WebElement> iteratorAtagsOnUpdateProfile = listOfAtagsOnUpdateProfile.iterator();
		// loop through that loaded list, and search for "href" element with "loginForm" value:
		while( iteratorAtagsOnUpdateProfile.hasNext( ) ) {
			WebElement aTagLink = iteratorAtagsOnUpdateProfile.next();
		    if( aTagLink.getAttribute("href").contains( "ProfileAction.settings" ) ) {
		    // if registration link is found, click on it, and exit this loop:
		    	aTagLink.click();
		        break;
		    }
		}
		
		// wait until "main" page loads up to the footer section:
		WebElement profileUpdatePageFooter = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("footer")));
		
		// find "Personal data" section, and populate first, last name, birth year, web site, 
		// company name, country and city, time zone, about text field:
		WebElement elementUpdatePersonalData = driver.findElement(By.id("profile-personal-form"));
		WebElement imageForElementUpdatePersonalData = elementUpdatePersonalData.findElement(By.className("arrow"));
		imageForElementUpdatePersonalData.click();
		
		WebElement firstNameTextField = elementUpdatePersonalData.findElement(By.name("personalForm.name"));
		firstNameTextField.clear();
		firstNameTextField.sendKeys("Vencislav");
		
		WebElement surnameTextField = elementUpdatePersonalData.findElement(By.name("personalForm.surname"));
		surnameTextField.clear();
		surnameTextField.sendKeys("Bujic");
		
		WebElement birthyearTextField = elementUpdatePersonalData.findElement(By.name("personalForm.birthyear"));
		birthyearTextField.clear();
		birthyearTextField.sendKeys("1918");
		
		WebElement websiteTextField = elementUpdatePersonalData.findElement(By.name("personalForm.site"));
		websiteTextField.clear();
		websiteTextField.sendKeys("www.vencislav.com");
		
		WebElement companyTextField = elementUpdatePersonalData.findElement(By.name("personalForm.company"));
		companyTextField.clear();
		companyTextField.sendKeys("RSG");
		
		Select dropdownCountry = new Select(elementUpdatePersonalData.findElement(By.name("personalForm.countryId")));
		dropdownCountry.selectByValue("oZVNlxVHBHow");
		
		Select dropdownCity = new Select(elementUpdatePersonalData.findElement(By.name("personalForm.cityId")));
		dropdownCity.selectByValue("y7u5fKXs4Cs6");
		
		Select dropdownTimeZone = new Select(elementUpdatePersonalData.findElement(By.name("personalForm.zone")));
		dropdownTimeZone.selectByValue("Europe/Sofia");
		
		WebElement aboutTextField = elementUpdatePersonalData.findElement(By.name("personalForm.about"));
		aboutTextField.clear();
		aboutTextField.sendKeys("My name is Vencislav Bujic. I know programming language JAVA, Selenium, HTML, SQL.");
		
		Thread.sleep(5000);
		
		// submit all the above information in "Personal data" section:
		WebElement saveButtonOnPersonalDate = elementUpdatePersonalData.findElement(By.name("personalForm.save"));
		saveButtonOnPersonalDate.click();
		
		/**
		 * now to the section "Notifications" and open it, uncheck two checkboxes, and submit it:
		*/
		
		// wait until "main" page loads up to the footer section:
		profileUpdatePageFooter = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("footer")));
				
		openProfile();
		
		// wait until "main" page loads up to the footer section:
		profileUpdatePageFooter = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("footer")));
		
		WebElement elementUpdateNotifications = driver.findElement(By.id("profile-notifications-form"));
		imageForElementUpdatePersonalData = elementUpdateNotifications.findElement(By.className("arrow"));
		imageForElementUpdatePersonalData.click();
		
		WebElement checkBoxNotifications = elementUpdateNotifications.findElement(By.name("notificationsForm.notificationsEnabled") );
		checkBoxNotifications.click();
		
		WebElement checkBoxDeliveries = elementUpdateNotifications.findElement(By.name("notificationsForm.deliveryEnabled") );
		checkBoxDeliveries.click();
		
		Thread.sleep(3000);
		
		// submit all the above information in "Personal data" section:
		WebElement saveButtonOnNotifications = elementUpdateNotifications.findElement(By.name("notificationsForm.save"));
		saveButtonOnNotifications.click();
		
		
		/**
		 * now to the section "Privacy" and open it, check radio button "only me", and submit it:
		*/
		
		// wait until "main" page loads up to the footer section:
		profilePageFooter = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("footer")));
		
		openProfile();
		
		WebElement elementUpdatePrivacy = driver.findElement(By.id("profile-privacy-form"));
		imageForElementUpdatePersonalData = elementUpdatePrivacy.findElement(By.className("arrow"));
		imageForElementUpdatePersonalData.click();
		
		
		List<WebElement> listOfRadioButtonVisiabilityGroup = elementUpdatePrivacy.findElements(By.name("privacyForm.profileVisibility") );
		
		WebElement oneRadio = null;
		String radioValue = "";
		// loop the elements in radio button group, and search for value "closed", and click on it:
		for( int i = 0; i < listOfRadioButtonVisiabilityGroup.size() ; i++ ) {
			oneRadio = listOfRadioButtonVisiabilityGroup.get( i );
			radioValue = oneRadio.getAttribute( "value" );
			if ( radioValue.equalsIgnoreCase("closed" ) ) {
				oneRadio.click();
				break;
			}
		}
		
		// submit all the above information in "Privacy" section:
		WebElement saveButtonOnPrivacy = elementUpdatePrivacy.findElement(By.name("privacyForm.save"));
		saveButtonOnPrivacy.click();
		
		
		Thread.sleep(5000);
		driver.close();
	
	}
	
	private void openProfile() {
		// load all the "A" tags elements on the profile page:
		List<WebElement> listOfAtagsOnUpdateProfile = driver.findElements( By.tagName( "a" ) );
		Iterator<WebElement> iteratorAtagsOnUpdateProfile = listOfAtagsOnUpdateProfile.iterator();
		// loop through that loaded list, and search for "href" element with "loginForm" value:
		while( iteratorAtagsOnUpdateProfile.hasNext( ) ) {
			WebElement aTagLink = iteratorAtagsOnUpdateProfile.next();
		    if( aTagLink.getAttribute("href").contains( "ProfileAction.settings" ) ) {
		    // if registration link is found, click on it, and exit this loop:
		    	aTagLink.click();
		        break;
		    }
		}
	}
	

}