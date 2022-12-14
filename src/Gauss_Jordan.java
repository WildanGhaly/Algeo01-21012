//Gauss_Jordan
public class Gauss_Jordan {

    // fungsi untuk menghasilkan Matrix Eselon Baris Tereduksi
    public static double[][] gauss_Jordan(double[][] m) {

        int row = m.length;
        int col = m[0].length;
        // melakukan proses ternary agar
        int endState = (col <= row) ? col - 1 : row;
        int colAcuan = 0;
        for (int k = 0; k < endState; k++) {
            // jika sudah sampai kolom terakhir, break
            if (colAcuan == col - 1) {
                break;
            }
            // cek kolom acuan berelemen 0, apabila 0 maka geser index ke kolom kanannya
            while (Primitive.colNol(m, colAcuan) && (colAcuan < col)) {
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
    
    public static String[] solveSPLgj (double[][] m) {
        /* 
         * Menyelesaikan SPL hasil eliminasi gauss
         */
        int row;
        int col;
        String[] noSol = {"Tidak ada solusi"};

        if (Primitive.noSolusi(m)){
            return noSol;
        } else {
            double[][] mEff = Primitive.mEff(m);
            row = mEff.length;
            try {
                col = mEff[0].length;    
            } catch (ArrayIndexOutOfBoundsException err){
                col = 0;
            }

            if (row == (col-1)){
                // Baris efektif SAMA dengan kolom efektif dikurang satu
                // Maka solusi satu
                return Gauss.satuSolusi(mEff);

            } else if (row < col - 1){
                // Baris efektif KURANG dari kolom efektif dikurang satu
                // Maka solusinya banyak T_T
                return SolusiBanyak.solusiBanyakGJ(mEff);
                
            } else {
                // Baris efektif LEBIH dari kolom efektif dikurang satu
                // Maka tidak ada solusi
                return noSol;
            }
        }
    }

}