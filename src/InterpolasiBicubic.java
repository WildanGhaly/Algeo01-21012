public class InterpolasiBicubic {
    
    public static double[][] interpolasiBikubik(){
        /* 
         * ini buat dapet X yang y = Xa
         * nah y itu inputan
         * a itu dicari pake matriks balikan
         */
        int row = 16;
        int col = 16;
        double[][] m = new double[row][col]; // m 16 x 16
        int count;
        int x; int y;

        // m [k] [count]
        for (int k = 0; k < 16; k++){
            x = rotasi4(k-1);
            y = lipat4(k);
            count = 0;
            for (int j = 0; j < 4; j++){
                for (int i = 0; i < 4; i++){
                    m[k][count] = (Math.pow(x, i)) * (Math.pow(y, j));
                    count++;
                }
            }
        }

        return m;

    }

    public static int rotasi4 (int x){
        /* 
         * buat ngeloop x (asal referensi yang di spek)
         */
        while (x > 2){
            x -= 4;
        }

        return x;
    }

    public static int lipat4 (int y){
        /* 
         * nge loop y (asal referensi dari spek)
         */
        if (y < 4){
            return -1;
        } else if (y < 8){
            return 0;
        } else if (y < 12){
            return 1;
        } else {
            return 2;
        }
    }

    public static double[][] ubahInputPengguna(double[][] m) {
        // Input pengguna 4x4 jadi 16x1
        double[][] hasil = new double[16][1];
        int count = 0;
        for (int i = 0; i < m.length; i++){
            for (int j = 0; j < m[0].length; j++){
                hasil[count][0] = m[i][j];
                count++;
            }
        }

        return hasil;
    }

    public static double[][] cariA(double[][] Xp, double[][] yKotak) {
        /* 
         * Xp asalnya dari matrix dasar interpolasi bikubik (cek ada di spek)
         * Yp input pengguna
         * Rumus awal adalah Yp = Xp a
         * Maka a = inv(Xp) Yp
         */
        double[][] Yp = new double[16][1];
        Yp = ubahInputPengguna(yKotak);
        int row = Xp.length;
        int col = Yp[0].length;


        double[][] a = new double[row][col];
        double[][] invXp = new double[row][row];
        invXp = InverseMatriksOBE.inverseMatrixOBE(Xp);

        a = Primitive.multiplyMatrix(invXp, Yp);

        return a;
    }

    public static double[][] kotakinMatriks(double[][] m) {
        /* 
         * Awalnya 16 x 1 jadiin 4 x 4
         */
        int dimensi = 4;
        double[][] mKotak = new double[dimensi][dimensi];
        int count = 0;
        for (int j = 0; j < dimensi; j++){
            for (int i = 0; i < dimensi; i++){
                mKotak[i][j] = m[count][0];
                count++;
            }
        }
        return mKotak;
    }

    public static double solve(double[][] a, double x, double y) {
        /* 
         * saat ini dimensi 4x4
         * (a) a didapatkan sebelumnya dari a = inv(X) Yp (Yp input)
         */
        double [][] mKotak = new double[4][4];
        mKotak = kotakinMatriks(a);
        double sum = 0;
        for (int j = 0; j < 4; j++){
            for (int i = 0; i < 4; i++){
                sum += mKotak[i][j] * (Math.pow(x, i)) * (Math.pow(y, j));
            }
        }
        return sum;
    }

}


