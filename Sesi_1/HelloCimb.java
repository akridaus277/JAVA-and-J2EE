package Sesi_1;

public class HelloCimb{
  public static void main(String[] args) {
    Boolean happy = true;
    boolean sad = false;

    System.out.println("Hello World!");
    if (happy) {
      System.out.println("I am happy!");
    }else if (sad) {
      System.out.println("I am sad!");
    }
    
    int maxDistance = 10;
    int  distanceToHome = 11;
    if (distanceToHome > maxDistance) {
      System.out.println("We are sorry you are not elligible for discount");
    }
    if (distanceToHome <= maxDistance) {
      System.out.println("Congratulation you have 20% discount");
    }

    int speed = 900;
    int maxSpeed = 100;
    int speedForFine = 110;
    if (speed>maxSpeed) {
      if (speed>=speedForFine) {
        System.out.println("kamu kena tilang dan melanggar kecepatan maksimal");
      }else{
        System.out.println("kamu tidak kena tilang tapi melanggar kecepatan maksimal");
      }
    }else{
      System.out.println("kamu tidak kena tilang dan tidak melanggar kecepatan maksimal");

    }
    String string1 = "A";
    String string2 = "a";
    int hasil = string1.compareTo(string2);
    if(hasil < 0){
      System.out.println("string1 < string2, hasil = "+hasil);
    } else if(hasil == 0){
      System.out.println("string1 = string2, hasil = "+hasil);
    }else{
      System.out.println("string1 > string2, hasil = "+hasil);
    }
  }

}
