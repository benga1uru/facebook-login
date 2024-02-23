package com.selenium.test.facebook_login;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
        System.out.println( "Starting the Selenium Testing" );
        
        //Referencing the downloaded Chromedriver
        //System.setProperty("webdriver.chrome.driver", "<FilePath>\\chromedriver-win64-122.0.6261.69\\chromedriver.exe");
        
        WebDriverManager.chromedriver().setup();
        
        ChromeOptions chromeOptions = new ChromeOptions();
        // Open in inCognito Mode
        chromeOptions.addArguments("--incognito");
        
        // Run headless
        chromeOptions.addArguments("--headless");
        
        WebDriver driver = new ChromeDriver(chromeOptions);
        
        
        // enable timeout of 5 seconds
        WebDriverWait waitTime = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        
        // Open the browser using the webdriver and access the URL
        driver.get("https://www.facebook.com");
        
        //Enter facebook username
        driver.findElement(By.id("email")).sendKeys("i.curiousmind");
        Thread.sleep(1000);
        
        //Enter facebook password
        driver.findElement(By.id("pass")).sendKeys("password1");
        Thread.sleep(1000);

        //Click Submit
        driver.findElement(By.name("login")).submit();
        Thread.sleep(5000);
        
        
        String title = driver.getTitle();
        // failure title = Log into Facebook
        // success title = Facebook
        System.out.println(title);
        if(title.equalsIgnoreCase("Log into Facebook")) {
        	System.out.println("Login failed!");

        }else if(title.equalsIgnoreCase("Facebook")){
            System.out.println("Login successful!");
        }


        driver.quit();
        
        
        
    }
}
