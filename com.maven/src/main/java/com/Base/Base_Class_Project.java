package com.Base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Base_Class_Project 
{
	public static WebDriver driver;

	public static WebDriver browserLaunch(String name) 
	{

		if (name.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);

			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

		}
		else if (name.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		} else if (name.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		} return driver;
	}


	protected static String getTitle() {
		return driver.getTitle();

	}
	protected static  boolean getText(WebElement elememt) {
		elememt.getText();
		return false;

	}

	protected static void launchUrl(String url) {
		driver.get(url);
	}

	protected static void clickElement(WebElement element) {
		explicitWait(element);
		element.click();
	}

	protected static void passInput(WebElement element, String input) {
		element.sendKeys(input);
	}

	protected static void implicit_Wait(int sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	protected static void explicitWait(WebElement element) {
		WebDriverWait  Wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		Wait.until(ExpectedConditions.visibilityOf(element));

	}

	protected static void thread_sleep(int sec) throws InterruptedException {
		Thread.sleep(sec);
	}

	protected static void screenShot(String name) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\hd\\eclipse-workspace\\Flipkart\\Screenshot\\" + name + ".png");
		FileHandler.copy(source, dest);
	}

	protected static Select dropdownObj(WebElement element) {
		Select s = new Select(element);
		return s;
	}

	protected static void SelectByValue(WebElement element, String Value) {
		dropdownObj(element).selectByValue(Value);
	}

	protected static void SelectByIndex(WebElement element, int num) {
		dropdownObj(element).selectByIndex(num);
	}

	protected static void SelectByVisibleText(WebElement element, String text) {
		dropdownObj(element).selectByVisibleText(text);
	}
	protected static boolean isDisplayed(WebElement element) {
		return element.isDisplayed();
	}
	protected static boolean isEnabled(WebElement elememt) {
		return elememt.isEnabled();

	}

	protected static Actions actionsObj() {
		Actions aca = new Actions(driver);
		return aca;
	}
	protected  static void DragandDrop(WebElement src, WebElement Target) {
		actionsObj().dragAndDrop(src, Target).perform();
	}
	protected static void moveToElement(WebElement element) {
		actionsObj().moveToElement(element);
	}
	protected static void context_Click(WebElement element) {
		actionsObj().contextClick(element).build().perform();
	}
	//frames
	protected static void frameId(String Value) {
		driver.switchTo().frame(Value);
	}
	protected static void frameIndex(int num) {
		driver.switchTo().frame(num);
	}
	protected static void frameWebElement(WebElement element) {
		driver.switchTo().frame(element);
	}
	// click
	protected static void clickButton(WebElement element) {
		element.click();
	}	
	// clear
	protected static void clear(WebElement element) {
		element.clear();
	}
	//submit 
	protected static void submit(WebElement element) {
		element.submit();
	}
	protected static  void closeBrowser() {
		driver.close();
	}
	protected static void terminateBrowser() {
		driver.quit();
	}
	protected static  void javascript() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");


	}
	//public static void main(String[] args) {
	//	browserLaunch("chrome");
	//	launchUrl("https://tutorialsninja.com/demo/index.php?route=account/login");
	//	System.out.println(getTitle());
	//}

	protected static  void doubleClick(WebElement element) {
		actionsObj().doubleClick(element);
	}

}








