package Sesi_8;

import org.junit.Test;

public class NumberGenerator_ThreadNumberTest {
    @Test
    public void testRun(){
        NumberGenerator generator = new NumberGenerator(1000, 2000);
        for (int i = 0; i <3; i++) {
            new ThreadNumber(generator).start();
        } 
    }
}
