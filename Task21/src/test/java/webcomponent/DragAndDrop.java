package webcomponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {

	public static void main(String[] args) throws Exception {
        // Set the path to the ChromeDriver executable
        WebDriverManager.chromedriver().setup();
        
        // Initialize the WebDriver (ChromeDriver)
        WebDriver driver = new ChromeDriver();

        try {
            // Maximize the browser window
            driver.manage().window().maximize();

            // Navigate to the URL
            driver.navigate().to("https://jqueryui.com/droppable/");
            Thread.sleep(3000);
            
            // Switch to the iframe that contains the draggable and droppable elements
            WebElement iframe = driver.findElement(By.className("demo-frame"));
            driver.switchTo().frame(iframe);
            Thread.sleep(3000);
            
            // Find the source element (drag me to my target)
            WebElement sourceElement = driver.findElement(By.id("draggable"));
            Thread.sleep(3000);
            
            // Find the target element (drop here)
            WebElement targetElement = driver.findElement(By.id("droppable"));
            Thread.sleep(3000);
            
            // Perform the drag and drop operation
            Actions actions = new Actions(driver);
            actions.dragAndDrop(sourceElement, targetElement).perform();
            Thread.sleep(3000);
            
            // Verify the drag and drop operation by checking the color property of the target element
            String targetElementColor = targetElement.getCssValue("background-color");
            System.out.println("Target Element Background Color: " + targetElementColor);

            // Verify that the text of the target element has changed to "Dropped!"
            String targetElementText = targetElement.getText();
            System.out.println("Target Element Text: " + targetElementText);

            // Validate the operation
            if (targetElementColor.equals("rgba(255, 250, 144, 1)") && targetElementText.equals("Dropped!")) {
                System.out.println("Drag and Drop operation was successful.");
            } else {
                System.out.println("Drag and Drop operation failed.");
            }

        } finally {
            // Close the browser
            driver.quit();
        }
    }

}
