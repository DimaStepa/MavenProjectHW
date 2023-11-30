import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.time.Duration;

public class HW2Test {

    /*
    тестирование поля-заполнения
     */

    @Ignore
    @Test
    public void demoQaTextBox() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/text-box");

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement fullName = driver.findElement(By.xpath("//input[@id='userName']"));
        WebElement eMail = driver.findElement(By.xpath("//input[@id='userEmail']"));
        WebElement currentAdress = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        WebElement permamentAdress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));

        fullName.sendKeys("Oleg Komarovv");
        eMail.sendKeys("wwwleningrad@gori.com");
        currentAdress.sendKeys("Мой адрес не дом и не улица");
        permamentAdress.sendKeys("Мой адрес советский союз");
        submitButton.click();

        WebElement findRowName = driver.findElement(By.xpath("//p[@id = 'name']"));
        String findName = findRowName.getText();
        Assert.assertEquals(findName, "Name:Oleg Komarov");

        WebElement findRowEmail = driver.findElement(By.xpath("//p[@id = 'email']"));
        String findEmail = findRowEmail.getText();
        Assert.assertEquals(findEmail, "Email:wwwleningrad@gori.com");

        WebElement findRowCurrentAddress = driver.findElement(By.xpath("//p[@id = 'currentAddress']"));
        String findCurrentAddress = findRowCurrentAddress.getText();
        Assert.assertEquals(findCurrentAddress, "Current Address :Мой адрес не дом и не улица");

        WebElement findRowPermanentAddress = driver.findElement(By.xpath("//p[@id = 'permanentAddress']"));
        String findPermanentAddress = findRowPermanentAddress.getText();
        Assert.assertEquals(findPermanentAddress, "Permananet Address :Мой адрес советский союз");

        driver.quit();
    }

    /*
    тестирование поля-заполнения
     */
    @Ignore
    @Test
    public void demoQaRadioButton() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/radio-button");

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement radioButtonYes = driver.findElement(By.xpath("//*[@for = 'yesRadio']"));
        radioButtonYes.click();
        WebElement radioButtonYesConfirm = driver.findElement(By.xpath("//*[@class ='text-success']"));
        String textRadioButtonYesConfirm = radioButtonYesConfirm.getText();
        Assert.assertEquals(textRadioButtonYesConfirm, "Yes");

        WebElement radioButtonImpressive = driver.findElement(By.xpath("//*[@for = 'impressiveRadio']"));
        radioButtonImpressive.click();
        WebElement radioButtonImpressiveConfirm = driver.findElement(By.xpath("//*[@class ='text-success']"));
        String textRadioButtonImpressiveConfirm = radioButtonImpressiveConfirm.getText();
        Assert.assertEquals(textRadioButtonImpressiveConfirm, "Impressive");

        WebElement noRadioButton = driver.findElement(By.xpath("//*[@id = 'noRadio']"));
        Assert.assertNotNull(noRadioButton.getAttribute("disabled"));

        driver.quit();

    }
}
