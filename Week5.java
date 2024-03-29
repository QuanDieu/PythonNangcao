package Team2;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Week5 {

    @Test

    public void Testtable(){

    	WebDriver driver;
    	String driverPath = "D:\\geckodriver.exe";
    	System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();        
        
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/test/web-table-element.php");

        //Search element inside 'Popular course' which are sibling of control 'SELENIUM' ,Here first we will find a h2 whose text is ''A few of our most popular courses' ,then we move to its parent element which is a 'div' , inside this div we will find a link whose text is 'SELENIUM' then at last we will find all of the sibling elements of this link('SELENIUM')
        //C�u 1
        List <WebElement> rows = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
        System.out.print(" Rows: " + rows.size());
        //C�u 2
        List <WebElement> cols = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/thead/tr/th"));
        System.out.println(" Columns: "+cols.size());
        //C�u 3
        getRowNumberByValue("REC", driver);
    }
    public static void getRowNumberByValue(String value, WebDriver dr) {
        List <WebElement> rows = dr.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
        for (int i = 0; i < rows.size(); i++) {
            if (rows.get(i).getText().equals(value)) {
                System.out.println("Found item at row " + (i+1));
            }
            System.err.println("Item " + value + " not found at row " + (i+1));
        }
    }
}

