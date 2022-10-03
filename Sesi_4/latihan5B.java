package Sesi_4;
public class latihan5B {
    public static void main(String[] args) {
        int x1,x2,y1,y2;

        y1  = 8;
        y2  = 9;
        System.out.println("Nilai y1 = "+y1);
        System.out.println("Nilai y2 = "+y2);
        x1 = (y1 + y2) * (y1 + y2);
        x2 = (y1%4) * y2;
        System.out.println("Point A");
        System.out.println("Nilai X1 = "+x1);
        System.out.println("Nilai X2 = "+x2);
        System.out.println("Point B");
        System.out.println("X1 besar sama dengan X2 ===> " + (x1>=x2));
        System.out.println("X2 besar sama dengan X1 ===> " + (x1<=x2));
        System.out.println("X1 mod 4 == ++X2 mod 5 ===> " + ( (x1 % 4) == (++x2 % 5) ));
    }
}
