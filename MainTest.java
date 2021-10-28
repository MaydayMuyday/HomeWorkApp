package lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {
    @Test
    public void oneMethodTest() {
        int[] in = new int[]{3, 2, 3, 1, 4, 2, 1, 3};
        int[] out = new int[]{2, 1, 3};
        Assertions.assertArrayEquals(out, Main.oneMethod(in));
    }

    @Test
    public void oneMethodTest2() {
        int[] in = new int[]{1, 6, 6, 5, 3, 7};
        Assertions.assertThrows(RuntimeException.class, () -> {
            Main.oneMethod(in);
        });
    }

    @Test
    public void twoMethodTest() {
        int[] in = new int[]{5, 1, 3, 4, 7};
        Assertions.assertFalse(Main.twoMethod(in));
    }
    @Test
    public void twoMethodTest2(){
        int[] in = new int[]{4,1,4};
        Assertions.assertTrue(Main.twoMethod(in));

    }
}