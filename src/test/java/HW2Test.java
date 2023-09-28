import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HW2Test {

    @Test
    public void demoQaTextBox() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/text-box");

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement fullName = driver.findElement(By.xpath("//input[@id='userName']"));
        WebElement eMail = driver.findElement(By.xpath("//input[@id='userEmail']"));
        WebElement currentAdress = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        WebElement permamentAdress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));

        fullName.sendKeys("Oleg Komarov");
        Thread.sleep(1000);

        eMail.sendKeys("wwwleningrad@gori.com");
        Thread.sleep(1000);

        currentAdress.sendKeys("Мой адрес не дом и не улица");
        Thread.sleep(1000);

        permamentAdress.sendKeys("Мой адрес советский союз");
        Thread.sleep(1000);

        submitButton.click();

        Thread.sleep(1000);
        WebElement findRowName = driver.findElement(By.xpath("//p[@id = 'name']"));
        String findName  = findRowName.getText();
        Assert.assertEquals(findName, "Name:Oleg Komarov");

        WebElement findRowEmail = driver.findElement(By.xpath("//p[@id = 'email']"));
        String findEmail  = findRowEmail.getText();
        Assert.assertEquals(findEmail, "Email:wwwleningrad@gori.com");

        WebElement findRowCurrentAddress = driver.findElement(By.xpath("//p[@id = 'currentAddress']"));
        String findCurrentAddress  = findRowCurrentAddress.getText();
        Assert.assertEquals(findCurrentAddress, "Current Address :Мой адрес не дом и не улица");

        WebElement findRowPermanentAddress = driver.findElement(By.xpath("//p[@id = 'permanentAddress']"));
        String findPermanentAddress  = findRowPermanentAddress.getText();
        Assert.assertEquals(findPermanentAddress, "Permananet Address :Мой адрес советский союз");

        driver.quit();
    }

}
