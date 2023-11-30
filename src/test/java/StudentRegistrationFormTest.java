import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;


public class StudentRegistrationFormTest {
    private WebDriver driver;

    static class variablesDmitryS {
        private static final String URL = "https://demoqa.com/automation-practice-form";
        private static final String FIRST_NAME = "Oleg";
        private static final String LAST_NAME = "Komarov";
        private static final String EMAIL = "testmail@yandex.ru";
        private static final String NUMBER = "89991114488";
        private static final String CURRENT_ADDRESS = "3 метра над уровнем неба";
    }

    @BeforeMethod
    public void appSetup(){
        driver = new ChromeDriver();
        driver.get(variablesDmitryS.URL);
        driver.manage().window().maximize();
        System.out.println("The app setup process is completed");
    }
    @Ignore
    @Test(description = "проверка содержания хидера")
    public void textHeaderForm() {
        WebElement mainHeaderForm = driver.findElement(By.xpath("//div[@class = 'main-header']"));
        String textMainHeaderForm = mainHeaderForm.getText();
        Assert.assertEquals(textMainHeaderForm, "Practice Form");
        WebElement titleRegistrationForm = driver.findElement(By.xpath("//h5"));
        String textTitleRegistrationForm = titleRegistrationForm.getText();
        Assert.assertEquals(textTitleRegistrationForm, "Student Registration Form");
    }
    @Ignore
    @Test(description = "позитивный кейс, заполнение всех полей")
    public void testPositiveTestAllParameters() throws InterruptedException {
        WebElement fieldFirstName = driver.findElement(By.xpath("//input[@id = 'firstName']"));
        WebElement fieldLastName = driver.findElement(By.xpath("//input[@id = 'lastName']"));
        WebElement fieldEmail = driver.findElement(By.xpath("//input[@id='userEmail']"));
        WebElement radioButtonGender = driver.findElement(By.xpath("//label[@for = 'gender-radio-1']"));
        WebElement fieldNumber = driver.findElement(By.xpath("//input[@id = 'userNumber']"));
        WebElement fieldDateOfBirth = driver.findElement(By.xpath("//input[@id = 'dateOfBirthInput']"));
        WebElement fieldSubjects = driver.findElement(By.xpath("//*[@id='subjectsInput']"));
        WebElement fieldCurrentAddress = driver.findElement(By.xpath("//textarea[@id = 'currentAddress']"));
        fieldFirstName.sendKeys(variablesDmitryS.FIRST_NAME);
        fieldLastName.sendKeys(variablesDmitryS.LAST_NAME);
        fieldEmail.sendKeys(variablesDmitryS.EMAIL);
        radioButtonGender.click();
        fieldNumber.sendKeys(variablesDmitryS.NUMBER);
        fieldDateOfBirth.click();
        fieldDateOfBirth.clear();
        Thread.sleep(5000);
        fieldDateOfBirth.sendKeys("Aug 2023-11");
        Thread.sleep(5000);
        fieldSubjects.sendKeys("c");
        fieldSubjects.sendKeys(Keys.ENTER);
        fieldCurrentAddress.sendKeys(variablesDmitryS.CURRENT_ADDRESS);
        Thread.sleep(5000);
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.submit();
        WebElement resultValueStudentName = driver.findElement(By.xpath("//tr/td[2]"));
        String textResultValueStudentName = resultValueStudentName.getText();
        Assert.assertEquals(textResultValueStudentName, variablesDmitryS.FIRST_NAME + " " + variablesDmitryS.LAST_NAME);
    }

    @AfterMethod
    public void closeUp() {
        driver.close();
        System.out.println("The close_up process is completed");
        driver.quit();
        System.out.println("The quit process is completed");
    }
}
