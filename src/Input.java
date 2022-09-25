import java.util.Scanner;

public class Input {
    static Scanner scan = new Scanner(System.in);

    public static int pil(){
        int pilihan = scan.nextInt();
        return pilihan;
    }

    public static double[][] inputMatriks(int row, int col){
        double[][] m = new double[row][col];
        for (int i = 0 ; i < row ; i++){
            for (int j = 0 ; j < col ; j++){
                m[i][j] = scan.nextDouble();
            }
        } 
        return m;
    }

    public static int pilihanInput(){
        int pilInput;
        while (true){
            System.out.println("Pilihan masukan input: ");
            System.out.println("1. Melalui keyboard");
            System.out.println("2. Melalui import file");
            System.out.print(">> Pilihan: ");
            pilInput = scan.nextInt();
            if ((pilInput == 1) || (pilInput == 2)){
                break;
            }
        }
        return pilInput;
    }






    
}
