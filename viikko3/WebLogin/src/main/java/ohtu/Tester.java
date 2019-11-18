package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Tester {

    public static void main(String[] args) {
        WebDriver driver = new HtmlUnitDriver();

        driver.get("http://localhost:4567");
        
        sleep(2);
        
        System.out.println(driver.getPageSource());
        
        //WebElement element = driver.findElement(By.linkText("login"));
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();

        sleep(2);
        
        System.out.println(driver.getPageSource());
        
        element = driver.findElement(By.name("username"));
        
        //olemassa oleva käyttäjä
        //element.sendKeys("pekka");
        
        //uusi käyttäjä
        element.sendKeys("pavlo2");
        
        element = driver.findElement(By.name("password"));
        
        //Pekan oikea salasana
        //element.sendKeys("akkep");
        
        // väärä salasana
        //element.sendKeys("pekka");
        
        //pavlon salasana
        element.sendKeys("koirakoira");
        
        element = driver.findElement(By.name("passwordConfirmation"));
        
        element.sendKeys("koirakoira");
        
        //element = driver.findElement(By.name("login"));
        element = driver.findElement(By.name("signup"));
        
        sleep(2);
        element.submit();

        sleep(3);
        
        System.out.println(driver.getPageSource());
        
        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        
        sleep(2);
        
        System.out.println(driver.getPageSource());
        
        element = driver.findElement(By.linkText("logout"));    
        element.click();
        
        sleep(2);
        
        System.out.println(driver.getPageSource());
        
        driver.quit();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
