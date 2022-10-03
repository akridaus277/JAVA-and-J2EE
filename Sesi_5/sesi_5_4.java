package Sesi_5;

public class sesi_5_4 {
    public static void main(String[] args) {
        String[][]  framework = {
            {"Java","Kotlin"},
            {"React","ReactJs"},
            {"PHP","Laravel"}
        };
        for (int i = 0; i < framework.length; i++) {
            for(String data: framework[i]){
                System.out.println(data);
            }
            
        };
        //cara 1
        for (int i = 0; i < framework.length; i++) {
            for(String data: framework[i]){
                System.out.print(data+ " ");
            }
            System.out.println("");
        };


        System.arraycopy(framework[0], 0, framework[2], 1, 1);
        //cara 2
        for (int i = 0; i < framework.length; i++) {
            for (int j = 0; j < framework[i].length; j++) {
                System.out.print(i+"."+j+" "+framework[i][j]+" ");
            }
            System.out.println("");
        };

        
    }
}
