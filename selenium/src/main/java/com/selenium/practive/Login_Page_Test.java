package com.selenium.practive;

import com.selenium.utils.WebDriverBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Login_Page_Test {

    public static  void main(String args[])
    {
        WebDriver driver= new WebDriverBuilder().withBrowser("chrome").enableMaximized().build();



        driver.get("https://practicetestautomation.com/practice/");


        //test-1
        driver.findElement(By.partialLinkText("Test Login Page")).click();
        driver.findElement(By.xpath("//label[@for='username']/following-sibling::input")).sendKeys("student");
        driver.findElement(By.xpath("//label[@for='password']/following-sibling::input")).sendKeys("Password123");
        driver.findElement(By.id("submit")).click();

        Assert.assertEquals("Logged In Successfully",driver.findElement(By.xpath("//h1[@class='post-title' and contains(text(), 'Logged In Successfully')]")).getText());
        driver.findElement(By.partialLinkText("Log out")).click();



        //Test-2
        driver.findElement(By.xpath("//label[@for='username']/following-sibling::input")).sendKeys("random");
        driver.findElement(By.xpath("//label[@for='password']/following-sibling::input")).sendKeys("Password123");
        driver.findElement(By.id("submit")).click();
        Assert.assertEquals("Your username is invalid!", driver.findElement(By.id("error")).getText());

        //Test-3
        driver.findElement(By.xpath("//label[@for='username']/following-sibling::input")).sendKeys("student");
        driver.findElement(By.xpath("//label[@for='password']/following-sibling::input")).sendKeys("lkjlkjkl");
        driver.findElement(By.id("submit")).click();
        Assert.assertEquals("Your password is invalid!", driver.findElement(By.id("error")).getText());

        driver.quit();

    }

}
