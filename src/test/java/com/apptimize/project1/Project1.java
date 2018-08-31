package com.apptimize.project1;

import java.nio.file.FileSystems;
import java.nio.file.Path;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Project1 {
WebDriver driver;
	
	//Open Browser
	@BeforeSuite
	public void openBrowser() {
		Path path = FileSystems.getDefault().getPath("src/test/resources/geckodriver-v0.21.0-macos/geckodriver");
		//Path path = FileSystems.getDefault().getPath("src/test/resources/geckodriver/geckodriver.exe");
		System.setProperty("webdriver.gecko.driver",path.toString());
		driver=new FirefoxDriver();
	}
	
	//Open URL
	@Parameters({"URL"})
	@Test (priority=2)
	public void fetchURL(String URL) {
		driver.get(URL);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"nav-main\"]/ul[2]/li[2]/a")).click();
	}

	@DataProvider (name="getData")
	public Object[][] getData() {
		Object[][] data=new Object[1][5];
		data[0][0]="Alisha";
		data[0][1]="Gupta";
		data[0][2]="golmushoppi.n.g@gmail.com";
		data[0][3]="Apptimize Candidate";
		data[0][4]="password01";
		return data;
	}

	//SignUp
	@Test (priority=3,dataProvider="getData")
	public void signUp(String firstName,String lastName,String email,String compName,String pwd) {
		driver.findElement(By.id("fname")).sendKeys(firstName);
		driver.findElement(By.id("lname")).sendKeys(lastName);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("company")).sendKeys(compName);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.id("eula")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,150)");
		driver.findElement(By.id("submit")).click();
	}
	
	//Create App
	@Test (priority=4)
	public void createApp() {
		WebDriverWait d=new WebDriverWait(driver,30);
		d.until(ExpectedConditions.visibilityOfElementLocated(By.id("zet-app-name"))).sendKeys("My First App");
		driver.findElement(By.xpath("/html/body/div[3]/ng-view/div/form/div/div/ul[1]/li[2]/span")).click();
		driver.findElement(By.id("zet-create-app")).click();
	}
	
	//Sign Out
	@Test (priority=5)
	public void signOut() throws InterruptedException {
		driver.findElement(By.id("zet-navbar-caretdown")).click();
		Thread.sleep(500);
		driver.findElement(By.id("zet-navbar-signout")).click();
	}
	
	@AfterSuite
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(500);
		driver.close();
	}
}
