public class Primitive {
    /* File ini berisi fungsi-fungsi primitif matrix
     */

    public static void displayMatrix(double[][] m){
        /* I.S. m terdefinisi
         * F.S. Nilai m(i,j) ditulis ke layar per baris per kolom, masing-masing elemen per bariis
         * dipisahkan sebuah spasi. Baris terakhir diakhiri dengan new line
         * Proses : Menulis nilai setiap elemen m ke layar dengan traversal per baris dan per kolom
         * Contoh : menulis matrix 3x3 (tiap akhir baris tidak ada spasi)
            1 2 3
            4 5 6
            7 8 9
         */

        for (int i = 0 ; i < m.length ; i++){
            System.out.print(m[i][0]);
            for (int j = 1 ; j < m[0].length ; j++){
                System.out.print(" " + m[i][j]);
            }
            System.out.print("\n");
        }
    }

    public static double[][] addMatrix(double[][] m1, double[][] m2){
        /* prekondisi : m1 berukuran sama dengan m2
         * Mengirim hasil penjumlahan matriks : m1 + m2
         */

        double[][] m3 = new double[m1.length][m1[0].length];
        for (int i = 0 ; i < m1.length ; i++){
            for (int j = 0 ; j < m1[0].length ; j++){
                m3[i][j] = m1[i][j] + m2[i][j];
            }
        }

        return m3;
    }

    public static double[][] subtractMatrix(double[][]m1, double[][]m2){
        /* prekondisi : m1 berukuran sama dengan m2
         * Mengirim hasil pengurangan matrix : m1 - m2
         */

         double[][] m3 = new double[m1.length][m1[0].length];
         for (int i = 0 ; i < m1.length ; i++){
            for (int j = 0 ; j < m1[0].length ; j++){
                m3[i][j] = m1[i][j] - m2[i][j];
            }
        }

        return m3;
    }

    public static double[][] multiplyMatrix(double[][] m1, double[][] m2){
        /* prekondisi : Ukuran kolom efektif m1 = ukuran baris efektif m2
         * Mengirim hasil perkalian matriks: salinan m1 * m2
         */

         double[][] m3 = new double[m1.length][m2[0].length];
         for (int i = 0 ; i < m1.length ; i++){
            for (int j = 0 ; j < m1[0].length ; j++){
                m3[i][j] = 0;
                for (int k = 0 ; k < m2.length ; k++){
                    m3[i][j] += (m1[i][k] * m2[k][j]);
                }
            }
         }
         return m3;
    }

    public static boolean isIdentity(double[][] m){
        /* Mengirimkan true jika m adalah matriks satuan: isSquare(m) dan
         * setiap elemen diagonal m bernilai 1 dan elemen yang bukan diagonal bernilai 0 
        */
        boolean uji = true;
        if (m.length == m[0].length){
            for (int i = 0; i < m.length ; i++){
                for (int j = 0; j < m.length ; j++){
                    if (i == j){
                        if (m[i][j] != 1){
                            uji = false;
                        }
                    }
                    else{
                        if (m[i][j] != 0){
                            uji = false;
                        }
                    }
                }
            }
        }
        else{
            uji = false;
        }
        return uji;

    }

    public static double[][] multiplyByConst (double[][] m, double x){
        /* Mengirimkan hasil perkalian setiap elemen m dengan x
         */
        double[][] mBaru = m.clone();
        for (int i = 0 ; i < m.length ; i++){
            for (int j = 0 ; j < m.length ; j++){
                mBaru[i][j] *= m[i][j];
            }
        }
        return mBaru;
    }

    


}





















