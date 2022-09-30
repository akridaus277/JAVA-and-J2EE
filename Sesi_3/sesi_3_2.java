package Sesi_3;

import java.math.BigDecimal;

public class sesi_3_2 {
    public static void main(String[] args) {
        // double a = 1.1;
        // double b = 1.2;
        // double c = a+b;
        // System.out.println(c);

        // double a = 2.1;
        // double b = 2.2;
        // double c = a+b;
        // System.out.println(c);

        // //bigdecimal cara 1 constructor
        // BigDecimal b1 = new BigDecimal(1.1);
        // //bigdecimal cara 2 value of
        // BigDecimal b2 = BigDecimal.valueOf(1.1);
        // //bigdecimal cara 3 constructor string
        // BigDecimal b3 = new BigDecimal("1.1");

        //bigdecimal cara 1 constructor
        BigDecimal b1 = new BigDecimal(2.1);
        BigDecimal b2 = new BigDecimal(2.2);
        BigDecimal b3 = b1.add(b2);
        System.out.println("cara 1 : "+ b3);

        //bigdecimal cara 2 valueof
        BigDecimal b4 = BigDecimal.valueOf(2.1);
        BigDecimal b5 = BigDecimal.valueOf(2.2);
        BigDecimal b6 = b4.add(b5);
        System.out.println("cara 2 : "+ b6);

        //bigdecimal cara 3 constructor string
        BigDecimal b7 = new BigDecimal("2.1");
        BigDecimal b8 = new BigDecimal("2.2");
        BigDecimal b9 = b7.add(b8);
        System.out.println("cara 3 : "+  b9);
    }
}
