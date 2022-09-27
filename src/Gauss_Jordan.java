import java.util.Scanner;

public class Gauss_Jordan {
    //fungsi untuk menghasilkan Matrix Eselon Baris Tereduksi
    public static double[][] gauss_Jordan(double[][] m) {

        int row = m.length;
        int col = m[0].length;
        // melakukan proses ternary agar
        int endState = (col <= row) ? col-1 : row;
        int colAcuan = 0;
        for (int k = 0; k < endState; k++) {
            // jika sudah sampai kolom terakhir, break
            if (colAcuan == col-1){
                break;
            }
            // cek kolom acuan berelemen 0, apabila 0 maka geser index ke kolom kanannya
            while (Primitive.colNol(m, colAcuan) && (colAcuan < col)){
                colAcuan++;
            }
            double elAcuan = m[k][colAcuan];
            // cek elemen acuan = 0, jika 0 maka tukar dengan yang selain 0
            if (Primitive.zero(elAcuan)) {
                for (int i = k + 1; i < row; i++) {
                    if (!Primitive.zero(m[i][colAcuan])) {
                        Gauss.swapRow(m, k, i);
                        break;
                    }
                }
            }
            // melakukan operasi baris elementer
            elAcuan = m[k][colAcuan];
            if (Primitive.zero(elAcuan)) {
                continue;
            } else {
                Gauss.bagiRow(m, colAcuan, k, elAcuan);
                // proses eliminasi agar menjadi matrix eselon baris tereduksi
                for (int i = 0; i < row; i++) {
                    if ((i == k) || m[i][colAcuan] == 0) {
                        continue;
                    }
                    Gauss.elimRow(m, i, colAcuan, k);
                }
            }
            colAcuan++;
        }
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


        Primitive.displayMatrix(gauss_Jordan(matriks));


        scan.close();
    }

}
