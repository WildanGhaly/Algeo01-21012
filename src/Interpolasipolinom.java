public class Interpolasipolinom {
    public static String[] interpolinom(double[][] matrix, double x) {
        double[][] matriksSPL = new double[matrix.length][matrix.length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <= matrix.length; j++) {
                if (j == matrix.length) {
                    matriksSPL[i][j] = matrix[i][1];
                } else {
                    matriksSPL[i][j] = (Math.pow(matrix[i][0], j));
                }

            }
        }
        matriksSPL = Gauss.gauss(matriksSPL);
        double[] solusiSPL = Gauss.satuSolusiDouble(matriksSPL);
        boolean first = true;
        double sum = 0;
        String[] output = new String[solusiSPL.length + 2];
        output[0] = ("f(x) = ");
        int j = 0;
        for (int i = solusiSPL.length - 1; i >= 0; i--) {
            if (i != solusiSPL.length - 1 && solusiSPL[i] != 0 && i != 0) {
                if (first == false) {
                    output[j] += (" + " + solusiSPL[i] + "x^" + i);
                    sum += (Math.pow(x, i) * solusiSPL[i]);
    
                } else {
                    output[j] += (solusiSPL[i] + "x^" + i);
                    sum += (Math.pow(x, i) * solusiSPL[i]);
                    first = false;

                }
            } else if (i == 0 && solusiSPL[i] != 0) {
                output[j] += (" + " + solusiSPL[i]);
                sum += (Math.pow(x, i) * solusiSPL[i]);

            } else if (solusiSPL[i] == 0 && solusiSPL.length > 1) {
                sum += 0;
            } else {
                output[j] += (solusiSPL[i] + "x^" + i);
                sum += (Math.pow(x, i) * solusiSPL[i]);
                first = false;

            }

        }
        output[1] = ("f(" + x + ") = " + sum + "\n");
        return output;

    }
}
