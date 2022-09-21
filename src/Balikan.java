public class Balikan {
    public double[][] kofaktorMatriks(double[][] matriks, int row, int col){
        double[][] kofaktor = new double[row-1][col-1];

        for (int i = 0 ; i < matriks.length ; i++){
            for (int j = 0 ; j < matriks.length ; j++){
                kofaktor[i][j] = Determinan.DeterminanKofaktor(Determinan.subMatriks(matriks, i, j));
            }
        }

        return kofaktor;
    }

    public double[][] transpose(double[][] matriks){
        
        double[][] tMatriks = new double[matriks.length][matriks.length];
        for (int i = 0 ; i < matriks.length ; i++){
            for (int j = 0 ; j < matriks.length ; j++){
                tMatriks[i][j] = matriks[j][i];
            }
        }



        return tMatriks;
    }
}
