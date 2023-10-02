import com.beust.ah.A;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;


public class StudentRegistrationFormTest {

        private WebDriver driver;
        private String url = "https://demoqa.com/automation-practice-form";

        @BeforeSuite
        public void setUp() {
            driver = new ChromeDriver();
        }

        @BeforeTest
        public void profileSetup() throws InterruptedException {
            driver.manage().window().maximize();
            System.out.println("The profile setup process is completed");
        }

        @BeforeMethod
        public void appSetup() throws InterruptedException {
            driver.get(url);
            System.out.println("The app setup process is completed");
        }

        @Test
        public void textHeaderForm() {

            WebElement mainHeaderForm = driver.findElement(By.xpath("//div[@class = 'main-header']"));
            String textMainHeaderForm = mainHeaderForm.getText();
            Assert.assertEquals(textMainHeaderForm, "Practice Form");

            WebElement titleRegistrationForm = driver.findElement(By.xpath("//h5"));
            String textTitleRegistrationForm = titleRegistrationForm.getText();
            Assert.assertEquals(textTitleRegistrationForm, "Student Registration Form");

        }

        @Test
        public void positiveTest() throws InterruptedException {

            WebElement fieldFirstName = driver.findElement(By.xpath("//input[@id = 'firstName']"));
            WebElement fieldLastName = driver.findElement(By.xpath("//input[@id = 'lastName']"));
//            WebElement fieldEmail = driver.findElement(By.xpath("//input[@id = 'userEmail']"));
            WebElement radioButtonGender = driver.findElement(By.xpath("//label[@for = 'gender-radio-1']"));
            WebElement fieldNumber = driver.findElement(By.xpath("//input[@id = 'userNumber']"));
            WebElement fieldDateofBirth = driver.findElement(By.xpath("//input[@id = 'dateOfBirthInput']"));
//            WebElement fieldHobbies = driver.findElement(By.xpath("//input[@id = 'hobbies-checkbox-1']"));


            fieldFirstName.sendKeys("Oleg");
            fieldLastName.sendKeys("Komarov");
            radioButtonGender.click();
            fieldNumber.sendKeys("89991114488");
//            fieldDateofBirth.sendKeys("10 Oct 1995");

//            JavascriptExecutor jse = (JavascriptExecutor) driver;
//            jse.executeScript("document.body.style.zoom = '70%'");
//
//            Thread.sleep(10000);

            WebElement submitButton = driver.findElement(By.id("submit"));
            submitButton.submit();

            WebElement resultValueStudentName = driver.findElement(By.xpath("//tr/td[2]"));
            String textResultValueStudentName = resultValueStudentName.getText();
            Assert.assertEquals(textResultValueStudentName, "Oleg Komarov");



        }



        @AfterClass
        public void closeUp() {
            driver.close();
            System.out.println("The close_up process is completed");
        }


}
