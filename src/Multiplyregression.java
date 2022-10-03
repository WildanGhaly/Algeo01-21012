public class Multiplyregression {
    public static String[] multiplyRegression(double[][] matrix) {
        double[][] matriksSPL = Gauss.gauss(matrix);
        double[] solusiSPL = Gauss.satuSolusiDouble(matriksSPL);
        String[] output = new String[solusiSPL.length + 2];
        boolean first = true;
        double sum = 0;
        int j = 0;
        output[0] = ("f(x) = ");
        for (int i = 0; i < solusiSPL.length; i++) {
            if (i != 0 && solusiSPL[i] != 0) {
                if (first == false) {
                    output[j] += (" + " + solusiSPL[i] + "x" + i);

                } else {
                    output[j] += Double.toString(solusiSPL[i]);
                    first = false;

                }
            } else if (solusiSPL[i] == 0 && solusiSPL.length > 1) {
                sum += 0;
            } else {
                output[j] += Double.toString(solusiSPL[i]);
                first = false;

            }
        }

        return output;

    }

}
