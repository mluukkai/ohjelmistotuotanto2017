package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tester {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:4567");

        sleep(2);
        loginOk(driver);
        usernameOkPasswordNot(driver);
        usernameDoesNotExist(driver);
        driver.close();
        WebDriver driver2 = new ChromeDriver();

        driver2.get("http://localhost:4567");
        createNewUser(driver2);

    }

    private static void loginOk(WebDriver driver) {

        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(1);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));

        sleep(1);
        element.submit();

        sleep(1);
        element = driver.findElement(By.linkText("logout"));
        element.click();

    }

    private static void usernameOkPasswordNot(WebDriver driver) {
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(1);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("ffgg");
        element = driver.findElement(By.name("login"));

        sleep(1);
        element.submit();
        
        element = driver.findElement(By.linkText("back to home"));
        element.click();
        
    }

    private static void usernameDoesNotExist(WebDriver driver) {
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(1);

        element = driver.findElement(By.name("username"));
        element.sendKeys("gunther");
        element = driver.findElement(By.name("password"));
        element.sendKeys("gunther");
        element = driver.findElement(By.name("login"));

        sleep(1);
        element.submit();
        
        element = driver.findElement(By.linkText("back to home"));
        element.click();
    }

    private static void createNewUser(WebDriver driver) {
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();

        sleep(1);

        element = driver.findElement(By.name("username"));
        element.sendKeys("gunther");
        element = driver.findElement(By.name("password"));
        element.sendKeys("gunther3");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("gunther3");
        element = driver.findElement(By.name("signup"));

        sleep(1);
        element.submit();
        
        driver.quit();
    }

    private static void createNewAndLogout(WebDriver driver) {
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("gunther2");
        element = driver.findElement(By.name("password"));
        element.sendKeys("gunther3");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("gunther3");
        element = driver.findElement(By.name("signup"));

        sleep(2);
        element.submit();

        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        sleep(2);
        element = driver.findElement(By.linkText("logout"));
        element.click();
        driver.close();
    }

    private static void sleep(int n) {
        try {
            Thread.sleep(n * 1000);
        } catch (Exception e) {
        }
    }
}
