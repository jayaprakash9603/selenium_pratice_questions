package com.selenium.practive;


import com.selenium.utils.WebDriverBuilder;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Set;

public class Basics_Of_Selenium {

	public static void main(String[] args) {
		WebDriver driver= new WebDriverBuilder().withBrowser("chrome").enableMaximized().build();



		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		Assert.assertEquals("Radio Button Example",driver.findElement(By.xpath("//legend[contains(.,'Radio Button Example')]")).getText());
		driver.findElement(By.xpath("//label[contains(.,'Radio1')]//input")).click();
		driver.findElement(By.xpath("//label[contains(.,'Radio2')]//input")).click();
		driver.findElement(By.xpath("//label[contains(.,'Radio3')]//input")).click();

		Assert.assertEquals("Suggession Class Example",driver.findElement(By.xpath("//legend[contains(.,'Suggession Class Example')]")).getText());
		driver.findElement(By.id("autocomplete")).sendKeys("testing expense");


		Assert.assertEquals("Dropdown Example",driver.findElement(By.xpath("//legend[contains(.,'Dropdown Example')]")).getText());
		Select select =new Select(driver.findElement(By.id("dropdown-class-example")));
		select.selectByValue("option1");
		select.selectByValue("option2");
		select.selectByValue("option3");


		Assert.assertEquals("Checkbox Example",driver.findElement(By.xpath("//legend[contains(.,'Checkbox Example')]")).getText());


		driver.findElement(By.id("checkBoxOption1")).click();
		driver.findElement(By.id("checkBoxOption2")).click();
		driver.findElement(By.id("checkBoxOption3")).click();


		Assert.assertEquals("Switch Window Example",driver.findElement(By.xpath("//legend[contains(.,'Switch Window Example')]")).getText());

		driver.findElement(By.id("openwindow")).click();
		String parentwindow=driver.getWindowHandle();
		Set<String> getWindowHandles=driver.getWindowHandles();
		for(String handle:getWindowHandles)
		{
			if (!handle.equals(parentwindow)) {
				driver.switchTo().window(handle);
				break;
			}
		}

		System.out.println("page title"+driver.getTitle());

		Assert.assertEquals("Access all our Courses",driver.findElement(By.partialLinkText("Access all our Courses")).getText());
		driver.close();
		driver.switchTo().window(parentwindow);
		driver.findElement(By.id("checkBoxOption1")).click();
		driver.findElement(By.id("checkBoxOption2")).click();
		driver.findElement(By.id("checkBoxOption3")).click();

		Assert.assertEquals("Switch Tab Example",driver.findElement(By.xpath("//legend[contains(.,'Switch Tab Example')]")).getText());
		driver.findElement(By.id("opentab")).click();

		Set<String> gettabs=driver.getWindowHandles();
		for(String handle:gettabs)
		{
			if (!handle.equals(parentwindow)) {
				driver.switchTo().window(handle);
				break;
			}
		}


		System.out.println("page title"+driver.getTitle());

		Assert.assertEquals("Access all our Courses",driver.findElement(By.partialLinkText("Access all our Courses")).getText());
		driver.close();
		driver.switchTo().window(parentwindow);

		driver.findElement(By.id("checkBoxOption1")).click();
		driver.findElement(By.id("checkBoxOption2")).click();
		driver.findElement(By.id("checkBoxOption3")).click();




		Assert.assertEquals("Switch To Alert Example",driver.findElement(By.xpath("//legend[contains(.,'Switch To Alert Example')]")).getText());


		driver.findElement(By.xpath("//input[@placeholder='Enter Your Name']")).sendKeys("Entering the name");

		driver.findElement(By.id("alertbtn")).click();

		Alert alert=driver.switchTo().alert();
		System.out.println("alert Text"+alert.getText());
		alert.accept();

		driver.findElement(By.id("confirmbtn")).click();



		System.out.println("confirm text"+alert.getText());
		alert.dismiss();




//		driver.quit();



	}

}
