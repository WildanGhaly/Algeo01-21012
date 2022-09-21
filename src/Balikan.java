

public class Balikan {
    public static double[][] kofaktorMatriks(double[][] matriks){
        /* Prekondisi : matriks yang diterima adalah matriks berbentuk persegi 
         * kofaktorMatriks akan mengembalikan matriks dalam bentuk kofaktornya
         */
        double[][] kofaktor = new double[matriks.length][matriks.length];
        int tanda = 1;

        for (int i = 0 ; i < matriks.length ; i++){
            for (int j = 0 ; j < matriks.length ; j++){
                kofaktor[i][j] = tanda * Determinan.DeterminanKofaktor(Determinan.subMatriks(matriks, i, j));
                tanda *= (-1); // Nilai kofaktor dengan jumlah i dan j ganjil akan dikali (-1)
            }
        }

        return kofaktor;
    }

    public static double[][] transpose(double[][] matriks){
        /* Matriks yang diterima sembarang
         * Nilai yang dikembalikan adalah bentuk matriks yang telah diTranspose
         */
        double[][] tMatriks = new double[matriks.length][matriks.length];
        for (int i = 0 ; i < matriks.length ; i++){
            for (int j = 0 ; j < matriks.length ; j++){
                tMatriks[i][j] = matriks[j][i];
            }
        }



        return tMatriks;
    }

    public static double[][] balikanKofaktor(double[][] matriks){
        /* Prekondisi : matriks yang diterima sudah dalam bentuk persegi
         * Nilai yang dikembalikan adalah bentuk matriks yang telah diinvers
         * dengan memanfaatkan metode matriks balikan dengan cara kofaktor
         */
        double[][] mBalikan =  new double[matriks.length][matriks.length];

        // Nilai kofaktor matriks akan didapat dengan cara:
        double[][] kofaktor = kofaktorMatriks(matriks);

        // Nilai adjoint matriks akan didapat dengan cara:
        double[][] adjoint = transpose(kofaktor);

        for (int i = 0 ; i < matriks.length ; i++){
            for (int j = 0 ; j < matriks.length ; j++){
                // Rumus matriks balikan adalah (adjoint matriks) / (determinan matriks)
                mBalikan[i][j] =  adjoint[i][j] / Determinan.DeterminanKofaktor(matriks) + 0.0;
                // Ditambahkan 0.0 agar tidak ada nilai negatif 0.0 (-0.0)
            }
        }


        return mBalikan;
    }
}   




