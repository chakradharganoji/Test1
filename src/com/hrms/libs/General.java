package com.hrms.libs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.hrms.utility.Log;


public class General extends Global{
	//private String txt_password;

	//Re-Usable fun:
	
	public void openApplication() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Owner\\Desktop\\Testing Traing\\Softwares\\Drivers\\chromedriver.exe");
		 driver = new ChromeDriver();
		driver.navigate().to(url);
		System.out.println("Application Opened"); //java Console
		Reporter.log("Application Opened"); //htmlReport
		Log.info("Application Opened");//log file
		driver.manage().window().maximize();
		if (driver.getTitle().equals("OrangeHRM")) {
			System.out.println("Title matched");
			Log.info("Title matched");//log file
		}
		else {
			System.out.println("Title not matched");
			System.out.println(driver.getTitle());
		}
		
	}
	
public void login() {
		
		driver.findElement(By.name(txt_User)).sendKeys(U);
		driver.findElement(By.name(txt_Pass )).sendKeys(P);
		driver.findElement(By.name(btn_Login)).click();
		
	}
		
		public void addEmployee(String firstname,String lastname) {
		
		//Thread.sleep(3000);
		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.linkText("PIM"))).perform();
		System.out.println("Mouseover completed");
		//driver.findElement(By.linkText("menu_pim_viewEmployeeList")).click();
		//Thread.sleep(3000);
		//driver.switchTo().frame("rightMenu");
	driver.findElement(By.linkText("Add Employee")).click();
		//Thread.sleep(3000);
		driver.findElement(By.id("firstName")).sendKeys(firstname);
		driver.findElement(By.id("lastName")).sendKeys(lastname);
		driver.findElement(By.id("btnSave")).click();
		//Thread.sleep(6000);
		System.out.println("New Employee added");
		Log.info("New Employee added");//log file
		//driver.switchTo().defaultContent();
		//driver.findElement(arg0)
		
	}
		public void deleteEmployee() {
			
			Actions ac = new Actions(driver);
			ac.moveToElement(driver.findElement(By.linkText("PIM"))).perform();
			System.out.println("Mouseover completed");
			//driver.findElement(By.linkText("menu_pim_viewEmployeeList")).click();
			//Thread.sleep(3000);
			//driver.switchTo().frame("rightMenu");
		driver.findElement(By.linkText("Employee List")).click();
			//Thread.sleep(3000);
		//driver.findElement(By.name("empsearch[employee_name][empName]")).sendKeys(firstname+lastname);
			driver.findElement(By.name("empsearch[id]")).sendKeys("0286");
			WebDriverWait wait = new WebDriverWait(driver,5000);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("searchBtn"))));
			//driver.findElement(By.id("btnLogin")).click();
			driver.findElement(By.id("searchBtn")).click();
			WebDriverWait wait1 = new WebDriverWait(driver,5000);
			wait1.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("ohrmList_chkSelectRecord_69"))));
			driver.findElement(By.id("ohrmList_chkSelectRecord_69")).click();
			driver.findElement(By.name("btnDelete")).click();
			driver.findElement(By.id("dialogDeleteBtn")).click();
			System.out.println(" Employee deleted");
			//driver.switchTo().defaultContent();
			//driver.findElement(arg0)
			
			
		}
public void deleteByEmployeeName(String firstname,String lastname) throws Exception {
			
			Actions ac = new Actions(driver);
			ac.moveToElement(driver.findElement(By.linkText("PIM"))).perform();
			System.out.println("Mouseover completed");
			//driver.findElement(By.linkText("menu_pim_viewEmployeeList")).click();
			//Thread.sleep(3000);
			//driver.switchTo().frame("rightMenu");
		driver.findElement(By.linkText("Employee List")).click();
			//Thread.sleep(3000);
		System.out.println("firstname passed for seaching "+firstname);
		//driver.findElement(By.name(txt_Pass )).sendKeys(P);
		driver.findElement(By.xpath("//*[@id=\"empsearch_employee_name_empName\"]")).sendKeys(firstname);
		Thread.sleep(2000);
			//driver.findElement(By.name("empsearch[id]")).sendKeys("0286");
			//WebDriverWait wait = new WebDriverWait(driver,5000);
			//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("searchBtn"))));
			//driver.findElement(By.id("btnLogin")).click();
			driver.findElement(By.id("searchBtn")).click();
			Thread.sleep(2000);
			//WebDriverWait wait1 = new WebDriverWait(driver,5000);
			//wait1.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("ohrmList_chkSelectRecord_69"))));
			selectRow(firstname,lastname);
			//driver.findElement(By.id("ohrmList_chkSelectRecord_69")).click();
			
			driver.findElement(By.name("chkSelectRow[]")).click();
			driver.findElement(By.name("btnDelete")).click();
			driver.findElement(By.id("dialogDeleteBtn")).click();
			System.out.println(" Employee deleted");
			//driver.switchTo().defaultContent();
			//driver.findElement(arg0)
			
			
}
public void selectRow(String firstname, String lastname) {
    // Get the grid
    WebElement grid = driver.findElement(By.id("resultTable"));
    System.out.println("Grid Element Found");

    // Get all the rows
    By locAllRows = By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody");
    System.out.println("LocallRowsFound");
    List<WebElement> allRows = grid.findElements(locAllRows);

    // Loop through each row and compare actual emp. no. with expected emp. no.
    for(WebElement row : allRows) {
        // Emp No. is 4th column
        By gfirstname  = By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr[1]/td[3]/a");
        System.out.println("gFirstname Found");
        By glastname = By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr/td[4]/a");
        System.out.println("glastname Found");
        // Get the Emp. No.
        String gfirstname2 = row.findElement(gfirstname).getText();
        System.out.println("gfirstname2 Found"+gfirstname2);
        String glastname2 = row.findElement(glastname).getText();
        System.out.println("glastname2 Found"+glastname2);
        // Compare actual vs expected
        if(firstname.equals(gfirstname2)&& lastname.equals(glastname2)) {
        	System.out.println("Condition matched");
        	row.click(); // Select row
            System.out.println("Selected row " + (allRows.indexOf(row) + 1) + " having Emp. name. " + firstname);
            break;  // exit the for loop
        }
    }
}

		public void logout() {
			WebDriverWait wait = new WebDriverWait(driver,5000);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("welcome"))));
			driver.findElement(By.id("welcome")).click();
			WebDriverWait wait1 = new WebDriverWait(driver,5000);
			wait1.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"welcome-menu\"]/ul/li[3]/a"))));
			driver.findElement(By.xpath("//*[@id=\"welcome-menu\"]/ul/li[3]/a")).click();
			System.out.println("Logout Completed");
			Log.info("Logout completed");//log file
			
			
			
		}
	public void closeApplication()
	{
		driver.close();
		System.out.println("Application Closed");
		Log.info("Application closed");//log file
		
	}
	
	


}
