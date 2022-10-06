package Sesi_8;
public class Demonstration4 {
    public static void main(String[] args) {
        Thread4A thread4A = new Thread4A();
        Thread4B thread4B = new Thread4B();
        Thread4C thread4C = new Thread4C();

        thread4A.start();
        thread4B.start();
        thread4C.start();
    }
}

class Thread4A extends Thread{
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread4A prints -> "+i);
            if (i == 2) {
                System.out.println("Going to interrupt the thread");
                interrupt();
                System.out.println("Is Thread4A interrupted?"+Thread.interrupted());
            }
        }
        System.out.println("Exit-Thread4A");

    }
}
class Thread4B extends Thread{
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread4B prints -> "+i);
            if (i == 3) {
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Exit-Thread4B");
            
    }
}
class Thread4C extends Thread{
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread4C prints -> "+i);
            if (i == 4) {
                try {
                    Thread.yield();
                } catch (Exception e) {
                    // TODO: handle exception
                }
                
            }
        }
        System.out.println("Exit-Thread4C");
            
    }
}
