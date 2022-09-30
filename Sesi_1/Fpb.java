package Sesi_1;

public class Fpb {
    public static int gcd(int a, int b)
    {
        if (a == 0)
            return b;
 
        return gcd(b % a, a);
    }
    public static void main(String[] args) {
        int x = 13, y = 26, fpb = 1;  
        for(int i = 1; i <= x && i <= y; i++)  
        {   
            if(x%i==0 && y%i==0)  
            fpb = i;  
        }  
        System.out.printf("FPB dari %d dan %d adalah: %d", x, y, fpb);  
        System.out.println();
        System.out.printf("FPB dari %d dan %d adalah: %d", x, y, gcd(x, y)); 
    }
}
