package org. test.login;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestngProgram {
	
	WebDriver driver;
// Pre condition annotations- Starting with @Before
	@BeforeSuite
	
	public void setUp() {
		System.out.println("Setup system property for chrome");
			
	}
	
	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\eclipse-workspace\\Org.test.myfluiditi\\chromedriver.exe");
		driver =new ChromeDriver();
		System.out.println("Launch chrome browser");
		
	}

	@BeforeClass
	public void enterUrl() {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("http://www.yangoospos.com");
		System.out.println("Enter Url");
		driver.findElement(By.xpath("//input[@formcontrolname=\"username\"]")).sendKeys("admin@yangoostechnologies");
		driver.findElement(By.xpath("//input[@formcontrolname=\"password\"]")).sendKeys("YangoosStage@2k23");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		
	}
	
	@BeforeMethod
	public void login() {
		System.out.println("Login Method");
		
	}
	
	//Test Case Starting with @Test
	@Test(priority=1)
	public void companyCreation() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");
		WebElement setting = driver.findElement(By.xpath("//span[text()=\"Settings \"]"));
		js.executeScript("arguments[0].click();",setting );
		
		WebElement company = driver.findElement(By.xpath("//a[text()=\" Company \"]"));
		js.executeScript("arguments[0].click();", company);
		
		WebElement createCompany = driver.findElement(By.xpath("//button[text()=\" CREATE COMPANY\"]"));
		js.executeScript("arguments[0].click();", createCompany);
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@formcontrolname=\"name\"]")).sendKeys("Automation");
		driver.findElement(By.xpath("//input[@formcontrolname=\"prefixCode\"]")).sendKeys("ATO");
		driver.findElement(By.xpath("//input[@formcontrolname=\"contactNumber\"]")).sendKeys("7094770774");
		driver.findElement(By.xpath("//input[@formcontrolname=\"email\"]")).sendKeys("thanapalan@yangoos.com");
		
		WebElement selectCountry = driver.findElement(By.xpath("(//div[@class=\"ng-select-container\"])[1]"));
		selectCountry.click();
		WebElement selectCountryValue = driver.findElement(By.xpath("//span[text()=\"INDIA\"]"));
		selectCountryValue.click();
		WebElement selectState = driver.findElement(By.xpath("(//div[@class=\"ng-select-container\"])[1]"));
		selectState.click();
		WebElement selectStateValue = driver.findElement(By.xpath("//span[text()=\"Tamil Nadu\"]"));
		selectStateValue.click();
		
		driver.findElement(By.xpath("//input[@formcontrolname=\"city\"]")).sendKeys("Chennai");
		driver.findElement(By.xpath("//textarea[@formcontrolname=\"address\"]")).sendKeys("No.5, ganesh nagar,sholinganallur");
		driver.findElement(By.xpath("//input[@formcontrolname=\"postCode\"]")).sendKeys("600119");
		driver.findElement(By.xpath("(//div[@class=\"ng-input\"])[3]")).click();
		driver.findElement(By.xpath("//span[text()=\"Yes\"]")).click();
		
		driver.findElement(By.xpath("//input[@formcontrolname=\"userLimit\"]")).sendKeys("4");
		driver.findElement(By.xpath("//input[@formcontrolname=\"storeLimit\"]")).sendKeys("2");
		driver.findElement(By.xpath("//button[text()=\" Submit \"]")).click();
		driver.findElement(By.xpath("//input[@formcontrolname=\"itemLimit\"]")).sendKeys("10000");
		driver.findElement(By.xpath("//select[@formcontrolname=\"negativeStockSale\"]")).click();
		driver.findElement(By.xpath("(//option[text()=\"yes\"])[1]")).click();
		
		driver.findElement(By.xpath("(//div[@class=\"ng-input\"])[4]")).click();
		driver.findElement(By.xpath("//span[text()=\"Purchase\"]")).click();
		driver.findElement(By.xpath("//span[text()='repacking_role']")).click();
		driver.findElement(By.xpath("//span[text()='Company Admin Kot']")).click();
		driver.findElement(By.xpath("//select[@formcontrolname=\"weighingScale\"]")).click();
		driver.findElement(By.xpath("(//option[text()=\"yes\"])[2]")).click();
		driver.findElement(By.xpath("(//div[@class=\"ng-input\"])[5]")).click();
	//	driver.findElement(By.xpath("(//span[text()=\"RETAIL\"])[2]")).click();
		//driver.findElement(By.xpath("//span[text()=\"FOOD COURT\"]")).click();
		js.executeScript("window.scrollBy(0,200)");
		
		// Store and user validity
		driver.findElement(By.xpath("(//input[@formcontrolname=\"storeName\"])[1]")).sendKeys("Automation 1");
		driver.findElement(By.xpath("(//input[@formcontrolname=\"validTill\"])[1]")).sendKeys("30-05-2024");
		driver.findElement(By.xpath("(//select[@formcontrolname=\"licenseId\"])[1]")).click();
		driver.findElement(By.xpath("(//option[text()=\"Premium\"])[1]")).click();
		
		driver.findElement(By.xpath("(//input[@formcontrolname=\"storeName\"])[2]")).sendKeys("Automation 2");
		driver.findElement(By.xpath("(//input[@formcontrolname=\"validTill\"])[2]")).sendKeys("30-06-2024");
		driver.findElement(By.xpath("(//select[@formcontrolname=\"licenseId\"])[2]")).click();
		driver.findElement(By.xpath("(//option[text()=\"Premium\"])[2]")).click();
		js.executeScript("window.scrollBy(0,400)");
		
		//code Prefix
		driver.findElement(By.xpath("//input[@formcontrolname=\"prefixCodePaymentMethod\"]")).sendKeys("PMY");
		driver.findElement(By.xpath("//input[@formcontrolname=\"prefixCodeCurrency\"]")).sendKeys("CUR");
		driver.findElement(By.xpath("//input[@formcontrolname=\"prefixCodeUnit\"]")).sendKeys("UNT");
		driver.findElement(By.xpath("//input[@formcontrolname=\"prefixCodeTax\"]")).sendKeys("TAX");
		driver.findElement(By.xpath("//input[@formcontrolname=\"prefixCodeTaxGroup\"]")).sendKeys("TAG");
		js.executeScript("window.scrollBy(0,300)");
		
		WebElement Add = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
		js.executeScript("arguments[0].click();", Add);
		Thread.sleep(5000);
		System.out.println("Company successfully created");
		
		}
	
	@Test(priority=2)
	public void StoreCretion() throws InterruptedException {
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		WebElement Store = driver.findElement(By.xpath("//a[text()=\" Stores \"]"));
		js.executeScript("arguments[0].click();", Store);
		
		driver.findElement(By.xpath("//button[text()=\" CREATE STORE\"]")).click();
	    driver.findElement(By.xpath("(//div[@class=\"ng-input\"])[1]")).click();
	    driver.findElement(By.xpath("//span[text()=\"Automation\"]")).click();
	    driver.findElement(By.xpath("(//div[@class=\"ng-input\"])[2]")).click();
	    driver.findElement(By.xpath("//span[text()=\"Automation 1\"]")).click();
	    driver.findElement(By.xpath("//input[@formcontrolname=\"categoryStoreName\"]")).sendKeys("Automation");
	    driver.findElement(By.xpath("//input[@formcontrolname=\"prefixCode\"]")).sendKeys("ATO");
	    driver.findElement(By.xpath("//input[@formcontrolname=\"contactNumber\"]")).sendKeys("7094770774");
	    driver.findElement(By.xpath("//input[@formcontrolname=\"email\"]")).sendKeys("thanapalan@yangoos.com");
	    driver.findElement(By.xpath("(//div[@class=\"ng-input\"])[3]")).click();
	    driver.findElement(By.xpath("//span[text()='INDIA']")).click();
	    driver.findElement(By.xpath("(//div[@class=\"ng-input\"])[4]")).click();
	    driver.findElement(By.xpath("//span[text()=\"Tamil Nadu\"]")).click();
	    driver.findElement(By.xpath("//input[@formcontrolname=\"city\"]")).sendKeys("Chennai");
	    driver.findElement(By.xpath("//textarea[@formcontrolname=\"address\"]")).sendKeys("No.5,Ganesh nagar, sholinganallur");
	    driver.findElement(By.xpath("//input[@formcontrolname=\"postCode\"]")).sendKeys("600119");
	    driver.findElement(By.xpath("//input[@formcontrolname=\"taxNumber\"]")).sendKeys("ASDFF1234A2S3");
	    driver.findElement(By.xpath("//input[@formcontrolname=\"panNumber\"]")).sendKeys("ASDFS1234S");
	    driver.findElement(By.xpath("(//div[@class=\"ng-input\"])[5]")).click();
	    driver.findElement(By.xpath("//span[text()=\"Yes\"]")).click();
	   
	    driver.findElement(By.xpath("(//div[@class=\"ng-input\"])[6]")).click();
	    driver.findElement(By.xpath("(//div[text()=\" GST (0%) \"])")).click();
	    driver.findElement(By.xpath("(//div[text()=\" GST (3%) \"])")).click();
	    driver.findElement(By.xpath("(//div[text()=\" GST (5%) \"])")).click();
	    driver.findElement(By.xpath("(//div[text()=\" GST (9%) \"])")).click();
	    
	    driver.findElement(By.xpath("(//div[@class=\"ng-input\"])[7]")).click();
	    driver.findElement(By.xpath("//span[text()=\"Indian Rupee\"]")).click();
	    driver.findElement(By.xpath("(//div[@class=\"ng-input\"])[8]")).click();
	    driver.findElement(By.xpath("//span[text()=\"Before Amount\"]")).click();
	    
	    js.executeScript("window.scrollBy(0,200)");
	    driver.findElement(By.xpath("(//div[@class=\"ng-input\"])[9]")).click();
	    driver.findElement(By.xpath("//span[text()=\"Pieces\"]")).click();
	    driver.findElement(By.xpath("//span[text()=\"Volume\"]")).click();
	    driver.findElement(By.xpath("//span[text()=\"Weight\"]")).click();
	    driver.findElement(By.xpath("//span[text()=\"Length\"]")).click();
	    
	    js.executeScript("window.scrollBy(0,200)");
	    driver.findElement(By.xpath("(//div[@class=\"ng-input\"])[10]")).click();
	    driver.findElement(By.xpath("//span[text()=\"Upi\"]")).click();
	    driver.findElement(By.xpath("//input[@formcontrolname=\"userLimit\"]")).sendKeys("1");
	    driver.findElement(By.xpath("//input[@formcontrolname=\"itemLimit\"]")).sendKeys("1000");
	    
	    js.executeScript("window.scrollBy(0,200)");
	    //code prefix
	    driver.findElement(By.xpath("//input[@formcontrolname=\"prefixCodeExpenseCategory\"]")).sendKeys("EXC");
	    driver.findElement(By.xpath("//input[@formcontrolname=\"prefixCodeExpense\"]")).sendKeys("EXC");
	    driver.findElement(By.xpath("//input[@formcontrolname=\"prefixCodeCategory\"]")).sendKeys("CTY");
	    driver.findElement(By.xpath("//input[@formcontrolname=\"prefixCodeItem\"]")).sendKeys("ITM");
	    driver.findElement(By.xpath("//input[@formcontrolname=\"prefixCodeBrand\"]")).sendKeys("BRD");
	    driver.findElement(By.xpath("//input[@formcontrolname=\"prefixCodeSupplier\"]")).sendKeys("SUP");
	    driver.findElement(By.xpath("//input[@formcontrolname=\"prefixCodeCustomer\"]")).sendKeys("CUS");
	    driver.findElement(By.xpath("//input[@formcontrolname=\"prefixCodePurchase\"]")).sendKeys("PUR");
	    driver.findElement(By.xpath("//input[@formcontrolname=\"prefixCodePurchaseReturn\"]")).sendKeys("PUR");
	    driver.findElement(By.xpath("//input[@formcontrolname=\"prefixCodeSale\"]")).sendKeys("SAL");
	    driver.findElement(By.xpath("//input[@formcontrolname=\"prefixCodeSaleReturn\"]")).sendKeys("SAR");
	    
	    //Bank details
	    driver.findElement(By.xpath("//input[@formcontrolname=\"name\"]")).sendKeys("HDFC Bank");
	    driver.findElement(By.xpath("//input[@formcontrolname=\"branchName\"]")).sendKeys("Sholinganallur");
	    driver.findElement(By.xpath("//input[@formcontrolname=\"accountNumber\"]")).sendKeys("1328379933");
	    driver.findElement(By.xpath("//input[@formcontrolname=\"ifscCode\"]")).sendKeys("HDFC52365");
	    driver.findElement(By.xpath("//input[@formcontrolname=\"upiId\"]")).sendKeys("hdfc@1234");
	    driver.findElement(By.xpath("//input[@formcontrolname=\"upilink\"]")).sendKeys("hdfc@1234");
	    
	    //promotion
	    driver.findElement(By.xpath("//input[@formcontrolname=\"pointValue\"]")).sendKeys("1000");
	    driver.findElement(By.xpath("//input[@formcontrolname=\"currencyvalue\"]")).sendKeys("100");
	    driver.findElement(By.xpath("//input[@formcontrolname=\"moneyValue\"]")).sendKeys("10");
	    driver.findElement(By.xpath("//input[@formcontrolname=\"expiredDate\"]")).sendKeys("10-03-2024");
	    
	    //Templates
	    driver.findElement(By.xpath("(//input[@formcontrolname=\"templateName\"])[2]")).click();
	    js.executeScript("window.scrollBy(0,800)");
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("(//input[@name=\"pdfTemplateFormat\"])[1]")).click();
        js.executeScript("window.scrollBy(0,400)");
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("(//input[@name=\"printLabelFormat\"])[4]")).click();
	    
	    driver.findElement(By.xpath("(//div[@class=\"angular-editor-textarea\"])[1]")).sendKeys("purchase items are not returned");
	    driver.findElement(By.xpath("(//div[@class=\"angular-editor-textarea\"])[2]")).sendKeys("Sales items are not returned");
	    driver.findElement(By.xpath("(//div[@class=\"angular-editor-textarea\"])[3]")).sendKeys("POS sale items are not returned");
	    
	    Thread.sleep(2000);
	    WebElement Add = driver.findElement(By.xpath("//button[text()=\"Add\"]"));
		js.executeScript("arguments[0].click();", Add);
	    System.out.println("Store successfully created");
	}
	@Test(priority=3)
	public void userCreation() throws InterruptedException {
		Thread.sleep(5000);
		JavascriptExecutor js= (JavascriptExecutor) driver;
		WebElement User = driver.findElement(By.xpath("//span[text()=\"Users \"]"));
		js.executeScript("arguments[0].click();",User);
		
		driver.findElement(By.xpath("//button[text()=\" CREATE USER\"]")).click();
		
		driver.findElement(By.xpath("//input[@formcontrolname=\"firstName\"]")).sendKeys("Richard");
		driver.findElement(By.xpath("//input[@formcontrolname=\"lastName\"]")).sendKeys("R");
		driver.findElement(By.xpath("//input[@formcontrolname=\"contactNumber\"]")).sendKeys("7094770774");
		driver.findElement(By.xpath("//input[@formcontrolname=\"username\"]")).sendKeys("RichardR");
		driver.findElement(By.xpath("//input[@formcontrolname=\"email\"]")).sendKeys("richardr@gmail.com");
		driver.findElement(By.xpath("//input[@formcontrolname=\"password\"]")).sendKeys("RichardR@123");
		driver.findElement(By.xpath("(//div[@class=\"ng-input\"])[1]")).click();
		driver.findElement(By.xpath("//span[text()=\"Automation\"]")).click();
		driver.findElement(By.xpath("(//div[@class=\"ng-input\"])[2]")).click();
		driver.findElement(By.xpath("//span[text()=\"Automation 1\"]")).click();
		
		driver.findElement(By.xpath("(//div[@class=\"ng-input\"])[3]")).click();
		driver.findElement(By.xpath("//span[text()=\"Company Admin Kot\"]")).click();
		driver.findElement(By.xpath("(//div[@class=\"ng-input\"])[3]")).click();
		driver.findElement(By.xpath("//span[text()=\"Store Admin\"]")).click();
		driver.findElement(By.xpath("(//div[@class=\"ng-input\"])[3]")).click();
		driver.findElement(By.xpath("//span[text()='repacking_role']")).click();
		driver.findElement(By.xpath("(//div[@class=\"ng-input\"])[3]")).click();
		driver.findElement(By.xpath("//span[text()=\"Purchase\"]")).click();
		driver.findElement(By.xpath("(//div[@class=\"ng-input\"])[3]")).click();
		driver.findElement(By.xpath("//span[text()=\"Company Admin\"]")).click();
		
		driver.findElement(By.xpath("(//div[@class=\"ng-input\"])[4]")).click();
		driver.findElement(By.xpath("(//span[text()=\"Automation 1\"])[2]")).click();
		
		driver.findElement(By.xpath("(//div[@class=\"ng-input\"])[5]")).click();
		driver.findElement(By.xpath("(//span[text()=\"Automation\"])[2]")).click();
		
		WebElement Add= driver.findElement(By.xpath("//button[text()=\"Add\"]"));
		js.executeScript("arguments[0].click();", Add);
		
		System.out.println("User created successfully");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//figure[@data-initial=\"YT\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()=\" Logout \"]")).click();
		System.out.println("profile logout successfully ");
	}
	
	@Test(priority=4)
	public void categorycreation() throws InterruptedException {
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@formcontrolname=\"username\"]")).sendKeys("richardr@gmail.com");
		driver.findElement(By.xpath("//input[@formcontrolname=\"password\"]")).sendKeys("RichardR@123");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		driver.findElement(By.xpath("//button[text()=\"OK\"]")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
		WebElement inventory = driver.findElement(By.xpath("//span[text()=\"Inventory \"]"));
		js.executeScript("arguments[0].click();",inventory);
		
		WebElement category= driver.findElement(By.xpath("//a[text()=\" Categories \"]"));
		js.executeScript("arguments[0].click();", category);
		
		driver.findElement(By.xpath("//button[text()=\" CREATE CATEGORY\"]")).click();
		driver.findElement(By.xpath("//input[@formcontrolname=\"name\"]")).sendKeys("Electronics");
		driver.findElement(By.xpath("//div[@class=\"ng-input\"]")).click();
		driver.findElement(By.xpath("//span[text()=\"Electronics\"]")).click();
		
		WebElement Add = driver.findElement(By.xpath("//button[text()=\"Add\"]"));
		js.executeScript("arguments[0].click();", Add);
		
		System.out.println("Category created successfully");
		}
	
	@Test(priority=5)
	public void brandCreation() throws InterruptedException {
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
		WebElement brand = driver.findElement(By.xpath("//a[text()=\" Brands \"]"));
		js.executeScript("arguments[0].click();",brand);
		
		driver.findElement(By.xpath("//button[text()=\" CREATE BRAND\"]")).click();
		driver.findElement(By.xpath("//input[@formcontrolname=\"name\"]")).sendKeys("logitech");
		driver.findElement(By.xpath("//textarea[@formcontrolname=\"description\"]")).sendKeys("Logitech product");
		
		WebElement Add = driver.findElement(By.xpath("//button[text()=\"Add\"]"));
		js.executeScript("arguments[0].click();", Add);
		
		
		System.out.println("Brand created successfully");
		
		
	}
	
	
	@Test(priority=6)
	public void itemCreation() throws InterruptedException {
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
		WebElement item = driver.findElement(By.xpath("//button[text()=\" CREATE ITEM\"]"));
		js.executeScript("arguments[0].click();",item);
		
		driver.findElement(By.xpath("//input[@formcontrolname=\"name\"]")).sendKeys("Mouse");
		driver.findElement(By.xpath("//input[@formcontrolname=\"RegionalName\"]")).sendKeys("wired mouse");
		
		
		
	}
	//Post condition-- starting with @After 
	
	@AfterMethod
	
	public void logout() {
		System.out.println("Logout form the app");
		
	}
	
	@AfterTest
	
	public void deleteAllCookies() {
		System.out.println("Delete All Cookies");
	}
	
	@AfterClass
	public void closeBrowser() {
		//driver.quit();
		
		System.out.println("Close the Browser");
	}
	
}
