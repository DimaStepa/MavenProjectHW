import org.example.AbbreivateText;
import org.example.AriphmeticOperation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HW1Test {

    @Test
    public void testSum(){
        Assert.assertEquals(AriphmeticOperation.plus(1,2), 3);
    }

    @Test
    public void testMutiplication(){
        Assert.assertEquals(AriphmeticOperation.multiplication(8,3), 24);
    }

    @Test
    public void testSubsctract(){
        Assert.assertEquals(AriphmeticOperation.substract(55,1), 54);
    }

    @Test
    public void testDiviation(){
        Assert.assertEquals(AriphmeticOperation.diviation(16, 4),4);
    }

    //Extra-задача по сокрашению текста
    @Test
    public void testAbbreviateOne(){
        Assert.assertEquals(AbbreivateText.abbreviateText("Здорова брат! Как жизнь? Как здоровье", 10), "Здорова...");
    }
    @Test
    public void testAbbreviateTwo(){
        Assert.assertEquals(AbbreivateText.abbreviateText("Здорова брат! Как жизнь? Как здоровье", 20), "Здорова брат! Как...");
    }


}
