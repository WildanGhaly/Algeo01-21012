
public class Gauss {

    public static double[][] gauss(double[][] m) {
        /*
         * Menerima nilai matriks
         * Mengembalikan nilai matriks setelah dilakukan eliminasi gauss
         */

        int row = m.length;
        // row : jumlah baris pada matriks
        int col = m[0].length;
        // col : jumlah kolom pada matriks

        int endState = (col <= row) ? col - 1 : row;

        int pivotCol = 0;

        for (int k = 0; k < endState; k++) {
            // lakukan looping sampai nilai (pivotCol) SAMA DENGAN (col)-1
            if (col == pivotCol + 1) {
                break;
            }

            while (Primitive.colNol(m, pivotCol) && (pivotCol < col)) {
                // Looping dilakukan untuk melompati KOLOM yang semuanya bernilai NOL
                // Tetapi jika nilai (pivotCol) sudah sama dengan (col), tidak perlu melompati
                // lagi
                // Karena sudah berada di akhir kolom
                pivotCol++;
            }

            double pivot = m[k][pivotCol];

            if (Primitive.zero(pivot)) {
                // Melakukan pengecekan apakah nilai pivot sama dengan NOL
                // Jika NOL maka akan dilakukan pertukaran baris dengan yang pivotnya tidak NOL
                // saat ini TIDAK MUNGKIN semua nilai pivot dalam kolom tersebut bernilai NOL
                // Karena sudah ada pengecekan sebelumnya
                for (int i = k + 1; i < row; i++) {

                    if (!Primitive.zero(m[i][pivotCol])) {
                        m = swapRow(m, k, i);
                        // Melakukan pertukaran baris k dengan i

                        break;

                    }

                }

            }

            // Mengubah nilai pivot dengan matriks yang baru
            // Karena MUNGKIN saja matriks berubah karena pivot bernilai nol
            pivot = m[k][pivotCol];

            if (Primitive.zero(pivot)) {
                // Sebelumnya telah dilakukan kasus ini,
                // Jika nilai pivot masih 0 maka dilakukan continue
                continue;

            } else {
                m = bagiRow(m, pivotCol, k, pivot);
                // Melakukan pembagian baris ke (k) terhadap (pivot)
                // Saat ini akan didapatkan SATU UTAMA

                for (int i = k + 1; i < row; i++) {
                    // Menjadikan kolom di bawah SATU UTAMA bernilai NOL

                    if (Primitive.zero(m[i][pivotCol])) {
                        // Jika nilai setelah (pivot) adalah nol, maka di skip saja
                        continue;
                    }

                    m = elimRow(m, i, pivotCol, k);
                    // Melakukan eliminasi baris bawah agar bernilai NOL

                }

            }

            pivotCol++;

        }

        return m;

    }

    public static double[][] swapRow(double[][] m, int k, int i) {
        /*
         * Menerima matriks (m) lalu menukar baris (k) dan (i) pada matriks
         * Mengembalikan nilai matriks (m) yang baris (k) dan (i) sudah bertukar
         */

        for (int j = 0; j < m[0].length; j++) {
            double temp = m[k][j];
            m[k][j] = m[i][j];
            m[i][j] = temp;
        }

        return m;
    }

    public static double[][] bagiRow(double[][] m, int pivotCol, int i, Double X) {
        /*
         * Menerima matriks (m), kolom dimulai (pivotCol), baris ke (i), dan konstanta
         * (X)
         * Membagi seluruh elemen pada baris ke (i) pada matriks (m) dengan (X)
         */

        for (int j = pivotCol; j < m[0].length; j++) {
            m[i][j] = m[i][j] / X;
        }

        return m;
    }

    public static double[][] elimRow(double[][] m, int i, int pivotCol, int k) {
        /*
         * Menerima matriks (m), baris (i), kolom (pivotCol), dan baris yang menjadi
         * pusat sementara (k)
         * Melakukan eliminasi baris (i) agar bernilai NOL
         */

        double faktor = m[i][pivotCol];

        for (int j = pivotCol; j < m[0].length; j++) {
            m[i][j] = (m[i][j] - (faktor * m[k][j]));
        }

        return m;
    }

}
