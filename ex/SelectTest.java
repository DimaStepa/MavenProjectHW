public class SelectTest {
    import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.runner.BaseTest;

import java.util.stream.Collectors;

    /*
     * Please ignore the `BaseTest` part
     * Описание в видео-уроке
     * https://www.youtube.com/watch?v=O6R1OMk8kr0&list=PL6Gtav8N4O7gjpnb9u89ZYU9g22GQPSjq&index=62
     */
    public class SelectTest extends BaseTest {


        void goToSelectPage() {
            //goes to https://www.selenium.dev/selenium/web/selectPage.html
            getDriver().findElement(By.linkText("selectPage.html")).click();
        }

        @Test
        public void testSimpleDropDown() throws Exception {
            goToSelectPage();
            final WebElement selectWithoutMultiple = getDriver().findElement(By.id("selectWithoutMultiple"));
            Select simpleDropDown = new Select(selectWithoutMultiple);
            simpleDropDown.selectByValue("two");

            String newValue = selectWithoutMultiple.getAttribute("value");
            System.out.println(newValue);
            Assert.assertEquals("two", newValue);

            Thread.sleep(5000);
        }

        @Test
        public void testMultipleSelect() throws Exception {
            goToSelectPage();
            WebElement selectElement = getDriver().findElement(By.id("selectWithMultipleEqualsMultiple"));
            Select multiSelect = new Select(selectElement);
            // First Option is selected already via HTML.
            multiSelect.deselectByIndex(0);
            multiSelect.selectByIndex(2);
            multiSelect.selectByVisibleText("Cheddar");

            System.out.println(selectElement.getAttribute("value"));
            System.out.println(multiSelect.getAllSelectedOptions().stream().map(WebElement::getText).collect(Collectors.toList()));
            Thread.sleep(5000);
        }


        @Test
        void testLongList() throws Exception {
            goToSelectPage();
            WebElement selectElement = getDriver().findElement(By.id("selectWithMultipleLongList"));
            Select select = new Select(selectElement);
            select.selectByVisibleText("five");
            select.selectByVisibleText("six");

            System.out.println(selectElement.getAttribute("value"));
            System.out.println(select.getAllSelectedOptions().stream().map(WebElement::getText).collect(Collectors.toList()));
            Thread.sleep(5000);
        }

    }

}
