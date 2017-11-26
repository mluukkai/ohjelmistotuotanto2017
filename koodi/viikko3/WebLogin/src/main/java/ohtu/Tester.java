package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Tester {

    public static void main(String[] args) {
        
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Beast\\Desktop\\chromedriver.exe");
        
        WebDriver driver = new HtmlUnitDriver();

        driver.get("http://localhost:4567");
        
//        sleep(2);
//        
//        WebElement element = driver.findElement(By.linkText("register new user"));
//        element.click();
//
//        String password = "salasana";
//        
//        element.findElement(By.name("username"));
//        
//
//        element.sendKeys("pekka");
//        element = driver.findElement(By.name("password"));
//        element.sendKeys(password);
//        element = driver.findElement(By.name("passwordConfirmation"));
//        element.sendKeys(password);
//        element = driver.findElement(By.name("signup"));
//        element.click();
//        
//
////        sleep(3);
        
        driver.quit();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
