

public class Cramer {
    public static double[] cramer(double[][] Matriks) {
        //Prekondisi baris, kolom = N, N+1
        //kamus
        int row = Matriks.length;
        int col = Matriks[0].length;
        double[][] matrixHasil = new double[row][1];
        double[][] matrixVar= new double[row][col-1];
        int colvar = col-1;
        double [] listDet= new double[colvar];  
        //algoritma
        /*Memisahkan matrix A dengan matrix hasil */
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col-1; j++) {
                matrixVar[i][j]=Matriks[i][j];                
            }
        }

        for (int i = 0; i < row; i++) {
            matrixHasil[i][0]=Matriks[i][col-1];    
        }
        double detA = Determinan.DeterminanKofaktor(matrixVar);
        
        for (int i = 0; i < colvar; i++) {
            listDet[i]=Determinan.DeterminanKofaktor(insertMatrixKolom(matrixVar, matrixHasil, i));
        }

        for (int i = 0; i < listDet.length;i++) {
            listDet[i]=listDet[i]/detA;
        }

        return listDet;
    }


    /*Memasukkan matrix hasil ke matrix a*/
    public static double[][] insertMatrixKolom(double[][] MatrixVar, double[][] MatrixHasil, int kolom){
        int row = MatrixVar.length;
        int col = MatrixVar[0].length;
        double[][] MatrixSementara=new double[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                MatrixSementara[i][j]=MatrixVar[i][j];
            }
        }
        for (int i = 0; i < row; i++) {
            MatrixSementara[i][kolom]=MatrixHasil[i][0];
        }
        return MatrixSementara;
    }

    public static String[] solveCramer (double[] hasil){
        /* 
         * Menerima array hasil lalu menjadikannya array of string hasil
         */
        String[] hasilS = new String[hasil.length];
        for (int i = 0; i < hasil.length; i++){
            hasilS[i] = "x" + (i+1) + " = " + hasil[i];
        }
        return hasilS;
    }
}