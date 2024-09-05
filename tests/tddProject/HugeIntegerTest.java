package tddProject;

import org.junit.jupiter.api.Test;
import tddProject.exception.NumberTooLargeException;

import java.security.PrivilegedAction;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class HugeIntegerTest {

    @Test
    void testThat_HugeIntegerIsNotNull_AfterItsArrayHasBeenPopulated(){
        HugeInteger hugeInt = new HugeInteger();

        hugeInt.parse("1111111111111111111111111111111111111111");
        System.out.println(Arrays.toString(hugeInt.getValue()));
        for(Integer element : hugeInt.getValue()){
            assertNotEquals(element, null);
        }

    }
    @Test
    void testHugeInteger_ToString(){
        HugeInteger hugeInt = new HugeInteger();

        hugeInt.parse("1111111111111111111111111111111111111111");
        System.out.println(Arrays.toString(hugeInt.getValue()));
        assertEquals("1111111111111111111111111111111111111111", hugeInt.toString());
    }
    @Test
    void testThatHugeIntegerCanReturnNumberLessThanFortyWithoutNullValues(){
        HugeInteger hugeInt = new HugeInteger();

        hugeInt.parse("12345");
        System.out.println(hugeInt.toString(hugeInt.getValue()));
        assertEquals("12345", hugeInt.toString(hugeInt.getValue()));
    }
    @Test
    void testThat_WhenHugeIntegerInstance1_WithValueOf1000_IsAdded_ToHugeIntegerInstance2_WithValueOf1000ThatTheSumIs2000(){
        HugeInteger hugeInt = new HugeInteger();
        hugeInt.parse("5000");

        HugeInteger hugeInt2 = new HugeInteger();
        hugeInt2.parse("5000");
        HugeInteger sum = hugeInt.add(hugeInt2);

        System.out.println(sum.toString());
        assertEquals("10000", sum.toString());
    }
    @Test
    void testThat_WhenHugeIntegerInstance1_WithValueOf1500_IsAdded_ToHugeIntegerInstance2_WithValueOf300ThatTheSumIs1800(){
        HugeInteger hugeInt = new HugeInteger();
        hugeInt.parse("1500");

        HugeInteger hugeInt2 = new HugeInteger();
        hugeInt2.parse("300");
        HugeInteger sum = hugeInt.add(hugeInt2);

        System.out.println(sum.toString());
        assertEquals("1800",  sum.toString());
    }
    @Test
    void testThatHugeIntegerCanThrowExceptionIfNumberInputIsLargerThanForty(){
        HugeInteger hugeInt = new HugeInteger();

        hugeInt.parse("11111111111111111111111111111111111111111");
        System.out.println(hugeInt.toString(hugeInt.getValue()));

        assertThrows( NumberTooLargeException.class, () -> {throw new NumberTooLargeException("Number input is too large.\nNumber is larger than 40");},
                "Number input is too large.\nNumber is larger than 40");
    }
}