package ohtu;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tester {

    private static void clickLinkWithText(String text, WebDriver driver) {
        int trials = 0;
        while (trials++ < 5) {
            try {
                WebElement element = driver.findElement(By.linkText(text));
                element.click();
                break;
            } catch (Exception e) {
                System.out.println(e.getStackTrace());
            }
        }
    }

    public static void main(String[] args) {
        uudenKayttajanLuominenLogout();
        onnistunutKirjautuminen();
        epaonnistunutKirjautuminenEiOleTunnusta();
        epaonnistunutKirjautuminenOikeaKayttajaTunnusVaaraSalasana();
        uudenKayttajanLuominen();
        
    }
    
    private static void uudenKayttajanLuominenLogout() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:4567");

        sleep(2);

        WebElement element = driver.findElement(By.linkText("register new user"));
        clickLinkWithText("register new user", driver);

        sleep(2);

        Random r = new Random();

        element = driver.findElement(By.name("username"));
        element.sendKeys("arto" + r.nextInt(100000));
        
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("signup"));

        sleep(2);
        element.submit();

        sleep(3);
        element = driver.findElement(By.linkText("continue to application mainpage"));
        clickLinkWithText("continue to application mainpage", driver);
        sleep(2);
        element = driver.findElement(By.linkText("logout"));
        clickLinkWithText("logout", driver);
        driver.quit();
    }

    private static void uudenKayttajanLuominen() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:4567");

        sleep(2);

        WebElement element = driver.findElement(By.linkText("register new user"));
        clickLinkWithText("register new user", driver);

        sleep(2);

        Random r = new Random();

        element = driver.findElement(By.name("username"));
        element.sendKeys("arto" + r.nextInt(100000));
        
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("signup"));

        sleep(2);
        element.submit();

        sleep(3);
        driver.quit();
    }

    private static void epaonnistunutKirjautuminenOikeaKayttajaTunnusVaaraSalasana() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:4567");

        sleep(2);

        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("osku");
        element = driver.findElement(By.name("login"));

        sleep(2);
        element.submit();

        sleep(3);

        driver.quit();
    }

    private static void epaonnistunutKirjautuminenEiOleTunnusta() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:4567");

        sleep(2);

        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("osku");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));

        sleep(2);
        element.submit();

        sleep(3);

        driver.quit();
    }

    private static void onnistunutKirjautuminen() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:4567");

        sleep(2);

        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));

        sleep(2);
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
