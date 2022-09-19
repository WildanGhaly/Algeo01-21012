import java.util.Scanner;

public class Determinan {

    public static double[][] subMatriks (double[][] A, int row, int col){
        // Fungsi yang mengembalikan sub matriks dari matriks A tanpa melibatkan baris "row" dan kolom "col"
        // Dimensi matriks yang dikembalikan adalah dimensi matriks A yang dikurangi 1

        int Row2 = 0;
        int Col2;
        double[][] mBaru = new double[A.length-1][A.length-1];

        
        for (int i = 0 ; i < A.length ; i++){
            Col2 = 0;
            for (int j = 0 ; j < A.length ; j++){

                // Pencarian Minor Entry dari matriks A[row][col]
                // Untuk menghitung mBaru, tidak melibatkan baris row dan kolom col
                if ((i != row) && (j != col)){
                    mBaru[Row2][Col2] = A[i][j];

                    Col2++;

                if (Col2 == A.length - 1){
                    Col2 = 0; //Kolom kembali menjadi ke-0 karena sudah terisi semua di baris tersebut
                    Row2++; //Ganti baris di saat semua kolom sudah terisi di baris tersebut
                }

                }
            }
        }
        return mBaru;
    }
    
    public static double DeterminanKofaktor (double[][] M){
        // Merupakan fungsi yang mengembalikan nilai determinan dari matriks M.
        // Cara yang digunakan dalam fungsi ini adalah dengan metode ekspansi kofaktor

        int tanda = 1; // Untuk tanda positif atau negatif perhitungan pada kofaktor
        double sum = 0; // sum sebagai hasil akhir perhitungan determinan, dimulai dari 0
        double[][] kofaktor; // variabel "kofaktor" menjadi minor entri

        if (M.length == 1){ // Merupakan akhir dari rekursif, yaitu saat dimensi matriks tersisa 1x1
            return M[0][0];
        }

        for (int i = 0 ; i < M.length ; i++){
            kofaktor = subMatriks(M,0,i); // Mendapatkan minor entri matriks M di indeks 0,1
            sum += (tanda * M[0][i] * DeterminanKofaktor(kofaktor));
            tanda *= (-1);
            // pencarian determinan dengan kofaktor dilakukan pada baris pertama matriks
            // tanda akan selalu berganti seiring pertambahan i
        }

        return sum;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Masukkan dimensi dari matriks: ");
        int dimensi = scan.nextInt();

        double[][] matriks = new double[dimensi][dimensi];

        System.out.println("Masukkan nilai matriks dimensi " + dimensi);
        for (int i = 0 ; i < dimensi ; i++){
            for (int j = 0 ; j < dimensi ; j++){
                matriks[i][j] = scan.nextDouble();
            }
        }

        System.out.println("Nilai determinannya adalah: " + DeterminanKofaktor(matriks));


        scan.close();
    }

}
