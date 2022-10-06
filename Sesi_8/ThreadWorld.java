package Sesi_8;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadWorld extends Thread {
    @Override
    public void run(){
        System.out.println(getName() + " : World");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            Logger.getLogger(ThreadWorld.class.getName()).log(Level.SEVERE,null,e);

        }
    }
}
