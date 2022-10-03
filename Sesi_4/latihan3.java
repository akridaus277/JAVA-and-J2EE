package Sesi_4;

public class latihan3 {
    public static void main(String[] args) {
        // Buat Variabel Awal
        int a = 0;
        int b = 0;
        int c = 9;
        int d = 9;
        // Print ke 1
        System.out.println("Print   ke 1");
        System.out.println("A = "   + a++); // hasil : 0
        System.out.println("B = "   + ++b); // hasil : 1
        System.out.println("C = "   + c--); // hasil : 9
        System.out.println("D = "   + --d); // hasil : 8
        // Print ke 2
        System.out.println("Print   ke 2");
        System.out.println("A = "   + a++); // hasil : 1
        System.out.println("B = "   + ++b); // hasil : 2
        System.out.println("C = "   + c--); // hasil : 8
        System.out.println("D = "   + --d); // hasil : 7
        // Print ke 3
        System.out.println("Print   ke 3");
        System.out.println("A = "   + a++); // hasil : 2
        System.out.println("B = "   + ++b); // hasil : 3
        System.out.println("C = "   + c--); // hasil : 7
        System.out.println("D = "   + --d); // hasil : 6
        // Print ke 4
        System.out.println("Print   ke 4");
        System.out.println("A = "   + a++); // hasil : 3
        System.out.println("B = "   + ++b); // hasil : 4
        System.out.println("C = "   + c--); // hasil : 6
        System.out.println("D = "   + --d); // hasil : 5
    }
}
