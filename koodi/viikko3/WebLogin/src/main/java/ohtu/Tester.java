package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tester {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Beast\\Desktop\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:4567");

        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));

        element.submit();
        
        //Toinen testi --------------------------------------------------------------------------------------------------

        driver.get("http://localhost:4567");

        element = driver.findElement(By.linkText("login"));
        element.click();

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akk1111111111ep");
        element = driver.findElement(By.name("login"));

        element.submit();


        //Kolmas testi --------------------------------------------------------------------------------------------------
        
        driver.get("http://localhost:4567");

        element = driver.findElement(By.linkText("login"));
        element.click();

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekkasdasdssddsssddsdsa");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akk1111111111ep");
        element = driver.findElement(By.name("login"));

        element.submit();

        sleep(3);
       
        
        //Neljäs testi --------------------------------------------------------------------------------------------------
        
        driver.get("http://localhost:4567");

        element = driver.findElement(By.linkText("register new user"));
        element.click();

        element = driver.findElement(By.name("username"));
        element.sendKeys("uusitili");
        element = driver.findElement(By.name("password"));
        element.sendKeys("salasana");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("salasana");
        element = driver.findElement(By.name("signup"));

        element.submit();

        sleep(3);

        driver.quit();

    }

    private static void sleep(int n) {
        try {
            Thread.sleep(n * 1000);
        } catch (Exception e) {
        }
    }
}
