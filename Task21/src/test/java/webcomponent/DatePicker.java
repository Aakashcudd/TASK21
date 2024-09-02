package webcomponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {

	 public static void main(String[] args) throws Exception {
	        // Set the path to the ChromeDriver executable
	        WebDriverManager.chromedriver().setup();

	        // Initialize the WebDriver (ChromeDriver)
	        WebDriver driver = new ChromeDriver();

	        try {
	            // Maximize the browser window
	            driver.manage().window().maximize();

	            // Navigate to the URL
	            driver.navigate().to("https://jqueryui.com/datepicker/");
                Thread.sleep(3000);
                
	            // Switch to the iframe that contains the datepicker
	            WebElement iframe = driver.findElement(By.className("demo-frame"));
	            driver.switchTo().frame(iframe);
	            Thread.sleep(2000);
	            
	            // Click on the datepicker input field to open the datepicker
	            WebElement datePicker = driver.findElement(By.id("datepicker"));
	            datePicker.click();
	            Thread.sleep(2000);
	            
	            // Click on the "Next" button to go to the next month
	            WebElement nextButton = driver.findElement(By.xpath("//a[@title='Next']"));
	            nextButton.click();
	            Thread.sleep(2000);
	            
	            // Select the date "22" from the datepicker
	            WebElement dateToSelect = driver.findElement(By.xpath("//a[text()='22']"));
	            dateToSelect.click();
	            Thread.sleep(2000);
	            
	            // Get the selected date and print it to the console
	            String selectedDate = datePicker.getAttribute("value");
	            System.out.println("Selected Date: " + selectedDate);

	        } finally {
	            // Close the browser window
	            driver.quit();
	        }
	    }
}
