public class SolusiBanyak extends Primitive{
    public static final int IDX_UNDEF = -1 ;

    public static int satuUtama (double[][] m, int col){
        /* 
         * Fungsi yang menerima masukan matriks (m) dan indeks kolomnya (col).
         * Fungsi mengembalikan indeks baris jika ditemukan satu utama pada kolom dan baris tersebut
         * Fungsi mengembalikan IDX_UNDEF jika tidak ada
         */
        int idx = IDX_UNDEF;
        boolean uji = true; // untuk memastikan hanya satu kali

        for (int i = 0; i < m.length; i++){
            if ((!zero(m[i][col])) && (!one(m[i][col]))){
                return IDX_UNDEF;
            }
            if (one(m[i][col])){
                // Pencarian nilai satu utama
                if (uji){
                    uji = false;
                    idx = i;
                }else {
                    return IDX_UNDEF;
                }
            }
        }
        return idx;
    }

    public static char variabel(int idx, int[] arr, int count){
        /* 
         * Menerima nilai indeks (idx), 
         */
        int val = 97; //ASCII nilai a
        char var = (char) val;
        for (int i = 0; i < count; i++){
            if (arr[i] == idx){
                val += i;
                var = (char) (val);
                return var;
            }
        }
        return 'X';
    }

    public static String[] solusiBanyak (double[][] m){
        /* 
         * Menerima matriks m lalu menyelesaikannya
         * Prekondisi:
         * - Matriks effektif dan solusinya sudah pasti parametrik
         */
        int col = m[0].length;
        String[] hasilS = new String[col-1];
        m = Gauss_Jordan.gauss_Jordan(m);
        // Untuk mempermudah maka dibuat persamaan gauss jordan saja

        int count = 0;
        int[] newVar = new int[col-1];

        for (int i = 0; i < col-1; i++){
            if (satuUtama(m, i) == IDX_UNDEF){
                newVar[count] = i;
                count++;
            }
        }
        
        for (int i = 0; i < col-1; i++){
            String hasil = "";
            int idxSatuUtama = satuUtama(m,i);
            if (idxSatuUtama != IDX_UNDEF){
                hasil += "x" + (i+1) + " = " + m[idxSatuUtama][col-1];

                for (int j = (i+1); j < col-1; j++){
                    double xVal = m[idxSatuUtama][j];
                    if (!zero(xVal)){
                        hasil += (" + (" + (-xVal) + ")" + variabel(j, newVar, count));
                    }
                }
            } else {
                hasil = ("x" + (i+1) + " = " + variabel(i, newVar, count));
            }

            hasilS[i] = hasil;
        }
        
        return hasilS;
    }
}
