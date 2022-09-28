public class InverseMatriksSPL {
    public static void inverseMatrixSPL(double[][] m) {
        double[] hasilSPL = Primitive.cutMatrixSPLHasil(m);
        m = Primitive.cutMatrixSPL(m);
        if (Primitive.isIdentity(InverseMatriksOBE.inverseMatrixOBE(m))) {
            System.out.print("Matriks ini tidak mempunyai inverse!");
        } else {
            double[] solusiSPL = new double[hasilSPL.length];
            m = InverseMatriksOBE.inverseMatrixOBE(m);
            double sum = 0;
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m[0].length; j++) {
                    sum += (m[i][j] * hasilSPL[j]);
                }
                System.out.print("| x" + (i + 1) + " = " + sum + " |");
                solusiSPL[i] = sum;
                sum = 0;

            }
        }

    }
}
