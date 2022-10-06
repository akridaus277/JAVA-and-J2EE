package Sesi_8;

import org.junit.Test;

public class ThreadHelloTest {
    @Test
    public void testRun() {
        for (int i = 0; i < 5; i++) {
            ThreadHello instance = new ThreadHello(String.valueOf(i));
            Thread t = new Thread(instance);
            t.start();
        }
    }
}
