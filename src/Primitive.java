public class Primitive {
    /*
     * File ini berisi fungsi-fungsi primitif matrix yang kemungkinan dibutuhkan di
     * file lain
     */

    public static String round2String(double X){
        /* 
         * Melakukan pembulatan ke 6 angka di belakang koma tetapi mengembalikannya dalam bentuk string
         */
        return (String.format("%.6f", X));
    }

    public static void displayMatrix(double[][] m) {
        /*
         * I.S. m terdefinisi
         * F.S. Nilai m(i,j) ditulis ke layar per baris per kolom, masing-masing elemen
         * per bariis
         * dipisahkan sebuah spasi. Baris terakhir diakhiri dengan new line
         * Proses : Menulis nilai setiap elemen m ke layar dengan traversal per baris
         * dan per kolom
         * Contoh : menulis matrix 3x3 (tiap akhir baris tidak ada spasi)
         * 1 2 3
         * 4 5 6
         * 7 8 9
         * Tetapi dibulatkan ke 6 angka di belakang koma
         */

        for (int i = 0; i < m.length; i++) {
            System.out.print(round2String(m[i][0]));
            for (int j = 1; j < m[0].length; j++) {
                System.out.print(" " + round2String(m[i][j]));
            }
            System.out.print("\n");
        }
    }

    public static double[][] addMatrix(double[][] m1, double[][] m2) {
        /*
         * prekondisi : m1 berukuran sama dengan m2
         * Mengirim hasil penjumlahan matriks : m1 + m2
         */

        double[][] m3 = new double[m1.length][m1[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++) {
                m3[i][j] = m1[i][j] + m2[i][j];
            }
        }

        return m3;
    }

    public static double[][] subtractMatrix(double[][] m1, double[][] m2) {
        /*
         * prekondisi : m1 berukuran sama dengan m2
         * Mengirim hasil pengurangan matrix : m1 - m2
         */

        double[][] m3 = new double[m1.length][m1[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++) {
                m3[i][j] = m1[i][j] - m2[i][j];
            }
        }

        return m3;
    }

    public static double[][] multiplyMatrix(double[][] m1, double[][] m2) {
        /*
         * prekondisi : Ukuran kolom efektif m1 = ukuran baris efektif m2
         * Mengirim hasil perkalian matriks: salinan m1 * m2
         */

        double[][] m3 = new double[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                m3[i][j] = 0;
                for (int k = 0; k < m2.length; k++) {
                    m3[i][j] += (m1[i][k] * m2[k][j]);
                }
            }
        }
        return m3;
    }

    public static boolean isIdentity(double[][] m) {
        /*
         * Mengirimkan true jika m adalah matriks satuan: isSquare(m) dan
         * setiap elemen diagonal m bernilai 1 dan elemen yang bukan diagonal bernilai 0
         */
        boolean uji = true;
        if (m.length == m[0].length) {
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m.length; j++) {
                    if (i == j) {
                        if (m[i][j] != 1) {
                            uji = false;
                        }
                    } else {
                        if (m[i][j] != 0) {
                            uji = false;
                        }
                    }
                }
            }
        } else {
            uji = false;
        }
        return uji;

    }

    public static double[][] multiplyByConst(double[][] m, double x) {
        /*
         * Mengirimkan hasil perkalian setiap elemen m dengan x
         */
        double[][] mBaru = m.clone();
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                mBaru[i][j] *= m[i][j];
            }
        }
        return mBaru;
    }

    public static boolean zero(double N) {
        /*
         * Mengembalikan true jika nilai N di antara -1.0e-12 dan 1.0e-12
         * Tujuan : agar nilai yang SANGAT KECIL dianggap nol
         */
        double eps = 1.0e-12;
        return ((N > ((-1) * eps)) && (N < eps));
    }

    public static boolean one(double N) {
        /*
         * Mengembalikan true jika nilai N di antara (1 -1.0e-12) dan (1 + 1.0e-12)
         * Tujuan : agar nilai yang SANGAT KECIL dianggap nol
         */
        double eps = 1.0e-12;
        return ((N > 1 + ((-1) * eps)) && (N < 1 + eps));
    }

    public static boolean colNol(double[][] m, int col) {
        /*
         * Menerima nilai kolom (col) dalam matriks (m)
         * Mengembalikan TRUE jika semua nilai matriks (m) pada kolom (col) adalah NOL
         */
        boolean zero = true;
        for (int i = 0; i < m.length; i++) {
            if (!zero(m[i][col])) {
                // Jika ada setidaknya satu nilai yang BUKAN NOL pada kolom (col) maka akan
                // mengembalikan false
                zero = false;
            }
        }
        return zero;
    }

    public static boolean rowNol(double[][] m, int row) {
        /*
         * Menerima nilai baris (row) dalam matriks (m)
         * Mengembalikan TRUE jika semua nilai matriks (m) pada row (row) adalah NOL
         */
        boolean zero = true;
        for (int j = 0; j < m[0].length; j++) {
            if (!zero(m[row][j])) {
                // Jika ada setidaknya satu nilai yang BUKAN NOL pada kolom (col) maka akan
                // mengembalikan false
                zero = false;
            }
        }
        return zero;
    }

    public static double[][] cutMatrixSPL(double[][] matrix1) {

        double[][] matriksSPL = new double[matrix1.length][matrix1[0].length - 1];
        for (int i = 0; i < matriksSPL.length; i++) {
            for (int j = 0; j < matriksSPL[0].length; j++) {
                matriksSPL[i][j] = matrix1[i][j];
            }
        }
        return matriksSPL;
    }

    public static double[] cutMatrixSPLHasil(double[][] matrix1) {
        double[] hasilSPL = new double[matrix1.length];
        for (int i = 0; i < matrix1.length; i++) {
            hasilSPL[i] = matrix1[i][matrix1[0].length - 1];
        }
        return hasilSPL;
    }

    public static double[][] merge(double[][] m1, double[][] m2){
        /* 
         * Menggabungkan nilai matriks m1 dengan m2 dengan nilai baris yang sama
         */
        double[][] m3 = new double[m1.length][m1[0].length + m2[0].length];
        for (int i = 0; i < m1.length; i++){
            for (int j = 0; j < m1[0].length; j++){
                m3[i][j] = m1[i][j];
            }
        }
        for (int i = 0; i < m1.length; i++){
            int jj = 0;
            for (int j = m1[0].length; j < m1[0].length + m2[0].length; j++){
                m3[i][j] = m2[i][jj];
                jj++;
            }
        }
        return m3;
    }

    public static boolean isSquare(double[][] m){
        /* 
         * Mengembalikan true jika matriks m berbentuk persegi
         */
        return (m.length == m[0].length);
    }

    public static boolean rowNolXLast (double[] arr) {
        /* 
         * Mengembalikan true jika seluruh elemen array bernilai nol kecuali yang terakhir
         */
        for (int i = 0; i < arr.length-1; i++){
            if (!zero(arr[i])){
                return false;
            }
        }

        boolean uji = !zero(arr[arr.length-1]) ? true : false;

        return uji;
        
    }

    public static boolean noSolusi(double[][] m) {
        /* 
         * Fungsi yang menerima matriks (m) lalu mengembalikan true jika tidak ada solusi
         * Prekondisi: telah dilakukan eliminasi gauss pada matriks
         */
        for (int i = 0; i < m.length; i++){
            if (rowNolXLast(m[i])){
                return true;
            }
        }
        return false;
    }

    public static double[][] mEff(double[][] m) {
        /* 
         * Menerima matriks (m)
         * Mengembalikan matriks effektif dari (m) (tanpa baris yang semua elemennya NOL)
         */
        int rowZero = 0;
        for (int i = 0; i < m.length; i++){
            if (rowNol(m,i)){
                rowZero++;
            }
        }
        if (rowZero == 0){
            return m;
        } else {
            int rowEff = m.length - rowZero;
            double[][] newM = new double[rowEff][m[0].length];

            for (int i = 0; i < rowEff; i++){
                for (int j = 0; j < m[0].length; j++){
                    newM[i][j] = m[i][j];
                }
            }

            return newM;
        }
    }

    public static void displayHasil (String[] hasil){
        /* 
         * Menampilkan seluruh isi array of string hasil
         */
    
        for (int i = 0; i < hasil.length; i++){
            System.out.println(hasil[i]);
            if (hasil[i] == null){
                break;
            }
        }
    }

    public static boolean isValid (int N){
        /* 
         * Menerima nilai integer N lalu mengembalikan true jika N > 0
         */
        return (N > 0);
    }

    public static boolean isArrValid (int[] N){
        /* 
         * Menerima array of integer N lalu mengembalikan true jika semua elemen N > 0
         */
        
        for (int i = 0; i < N.length; i++){
            if (!isValid(N[i])){
                return false;
            }
        }
        return true;
    }

    public static double[][] identitas (int dimensi){
        /* 
         * Menerima dimensi lalu mengembalikan matriks identitas dengan dimensi tersebut
         */

        double[][] m = new double[dimensi][dimensi];
        for (int i = 0; i < dimensi; i++){
            for (int j = 0; j < dimensi; j++){
                if (i == j){
                    m[i][j] = 1;
                } else {
                    m[i][j] = 0;
                }
            }
        }
        return m;
    }

    public static double[][] cloneM (double[][] m){
        /* 
         * Menduplikasi matriks m
         */
        int row = m.length;
        int col = m[0].length;
        double[][] n = new double[row][col];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                n[i][j] = m[i][j];
            }
        }
        return n;
    }
}
