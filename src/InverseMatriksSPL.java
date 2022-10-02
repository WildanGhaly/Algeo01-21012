public class InverseMatriksSPL {
    public static String[] inverseMatrixSPL(double[][] m) {
        double[] hasilSPL = Primitive.cutMatrixSPLHasil(m);
        m = Primitive.cutMatrixSPL(m);
        if (Primitive.isIdentity(InverseMatriksOBE.inverseMatrixOBE(m))) {
            String[] output = new String[1];
            output[0] = "Matriks ini tidak mempunyai inverse!";
            return output;

        } else {
            String[] output = new String[hasilSPL.length];
            double[] solusiSPL = new double[hasilSPL.length];
            m = InverseMatriksOBE.inverseMatrixOBE(m);
            double sum = 0;
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m[0].length; j++) {
                    sum += (m[i][j] * hasilSPL[j]);
                }
                output[i] = ("| x" + (i + 1) + " = " + sum + " |");
                solusiSPL[i] = sum;
                sum = 0;

            }
            return output;
        }

    }
}
