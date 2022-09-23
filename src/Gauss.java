


import java.util.Scanner;


public class Gauss {
    
    public static double[][] jadiSatu (double[][] A, double[] B){ 
        /* prekondisi : matriks A yang diterima sudah dalam bentuk persegi
         * mengembalikan nilai matriks dengan dimensi A[i][j+1] 
         * matriks dikembalikan dalam bentuk gabungan A dan B
         */

        double[][] merge = new double[A.length][A.length + 1];
        for (int i = 0 ; i < A.length ; i++){
            for (int j = 0 ; j <= A.length ; j++){
                if (j == A.length){
                    merge[i][j] = B[i];
                } else {
                    merge[i][j] = A[i][j];
                }
            }
        }

        return merge;
    }



    
    public static double[][] gauss (double[][] m){
        


        return m;
    }











    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int dimensi = scan.nextInt();
        double[][] matriks = new double[dimensi][dimensi];

        for (int i = 0 ; i < dimensi ; i++){
            for (int j = 0 ; j < dimensi ; j++){
                matriks[i][j] = scan.nextDouble();
            }
        }


        Primitive.displayMatrix(gauss(matriks));


        scan.close();
    }
    
}









