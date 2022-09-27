public class test {
    public static void main(String[] args) {
        double[][] matrix_a = {
                // { 1 },
                /*
                 * { 5, 12, 14, 2, 1, 3 },
                 * { 0, 2, 1, 7, 4, 3 },
                 * { 3, 0, 0, 2, 8, 1 },
                 * { 4, 1, 2, 3, 5, 6 },
                 * { 7, 8, 9, 11, 13, 14 },
                 * { 0, 0, 0, 0, 0, 0 },
                 */
                { 1, 2, 3 },
                { 2, 5, 3 },
                { 1, 0, 8 },

        };
        double[][] identitas = new double[matrix_a.length][matrix_a[0].length];
        for (int i = 0; i < matrix_a.length; i++) {
            for (int j = 0; j < matrix_a[0].length; j++) {
                if (i != j) {
                    identitas[i][j] = 0;
                } else {
                    identitas[i][j] = 1;
                }
            }
        }
        // printArray(determinanOBE(matrix_a));
        // System.out.print("\n");
        printArray(identitas);
        printArray(matrixbalikanOBE(matrix_a, identitas));

    }

    public static double[][] determinanOBE(double[][] matrix1) {
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
                            swapRow(matrix1, l, p);
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
        System.out.print(determinan + "\n");
        return matrix1;
    }

    public static double[][] matrixbalikanOBE(double[][] matrix1, double[][] identitas) {
        /*
         * double[][] identitas = new double[matrix1.length][matrix1[0].length];
         * for (int i = 0; i < matrix1.length; i++) {
         * for (int j = 0; j < matrix1[0].length; j++) {
         * if (i != j) {
         * identitas[i][j] = 0;
         * } else {
         * identitas[i][j] = 1;
         * }
         * }
         * }
         */
        System.out.print("\n");
        int jmax = matrix1[0].length - 1;
        int j = 0;
        for (int l = 0; l < matrix1[0].length; l++) {
            for (int i = l; i < matrix1.length; i++) {
                if (matrix1[i][j] != 0) {
                    int tempj = j;
                    double tempvalmatrix = matrix1[i][tempj];
                    // double tempvalident = identitas[i][tempj];

                    for (j = tempj; j <= jmax; j++) {
                        System.out.print(matrix1[i][j] + "\n");
                        System.out.print(tempvalmatrix + "\n");
                        matrix1[i][j] /= tempvalmatrix;
                        identitas[i][j] /= tempvalmatrix;
                        System.out.print(matrix1[i][j] + "\n\n");
                    }
                    j = tempj;
                }

                if (i != l && matrix1[i][l] != 0) {
                    for (int k = l; k <= jmax; k++) {
                        matrix1[i][k] -= matrix1[l][k];
                        identitas[i][k] -= identitas[l][k];

                    }
                }

            }
            j += 1;

        }
        printArray(matrix1);
        System.out.print("\n");
        for (int l = 0; l < matrix1.length - 1; l++) {
            for (int i = 0; i < matrix1.length - 1; i++) {
                for (j = 1 + l; j < matrix1[0].length; j++) {
                    if (matrix1[i][j] != 0 && i != j) {
                        matrix1[i][j] -= (matrix1[i][j] * matrix1[l + 1][j]);
                        identitas[i][j] -= (identitas[i][j] * identitas[l + 1][j]);
                        printArray(matrix1);
                        System.out.print("\n");
                    }
                }
            }
        }
        // printArray(identitas);
        System.out.print("\n");
        return matrix1;

    }

    public static void printArray(double[][] matrix1) {
        for (int i = 0; i < matrix1.length; i++) {
            System.out.print("[");
            for (int j = 0; j < matrix1[0].length; j++) {
                System.out.print(matrix1[i][j]);
                if (j < matrix1[0].length - 1) {
                    System.out.print(", ");

                } else {
                    System.out.print("]\n");

                }
            }

        }
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

    public static double[][] matrixInverseSPL(double[][] matrix1) {
        if (matrix1.length != matrix1[0].length) {
            System.out.print("Matriks yang diinput bukan merupakan matriks persegi !");
            return 0;
        } else {
            double[][] matriksSPL = new double[matrix1.length - 1][matrix1[0].length - 1];
            for (int i = 0; i < matriksSPL.length; i++) {
                for (int j = 0; j < matriksSPL[0].length; j++) {
                    matriksSPL[i][j] = matrix1[i][j];
                }
            }
            double[] hasilSPL = new double[matrix1.length];
            for (int i = 0; i < matrix1.length; i++) {
                hasilSPL[i] = matrix1[i][matrix1[0].length - 1];
            }

        }

    }

}
