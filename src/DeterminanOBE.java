public class DeterminanOBE {
    public static double determinanOBE(double[][] matrix1) {
        int jmax = matrix1[0].length - 1;
        int j = 0;
        double determinan = 1;
        int swap = 0;
        for (int l = 0; l < matrix1[0].length - 1; l++) {
            for (int i = l; i < matrix1.length; i++) {
                if (matrix1[i][j] != 0) {
                    int tempj = j;
                    double tempvalmatrix = matrix1[i][tempj];
                    determinan /= tempvalmatrix;

                    for (j = tempj; j <= jmax; j++) {

                        matrix1[i][j] /= tempvalmatrix;

                    }
                    j = tempj;
                }
                if (matrix1[l][l] == 0 && swap == 0 && i == matrix1.length - 1) {
                    for (int p = matrix1.length - 1; p > l; p--) {
                        if (matrix1[p][l] == 1) {
                            Gauss.swapRow(matrix1, l, p);
                            swap += 1;
                            i = 0;
                            determinan *= -1;
                            break;
                        }
                    }
                }
                if (i != l && matrix1[i][l] != 0) {
                    for (int k = l; k <= jmax; k++) {
                        matrix1[i][k] -= matrix1[l][k];
                    }
                }
            }
            j += 1;
            swap = 0;
        }
        determinan = matrix1[matrix1.length - 1][matrix1[0].length - 1] / determinan;
        return determinan;
    }

}