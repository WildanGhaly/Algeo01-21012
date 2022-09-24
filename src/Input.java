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

    
}
