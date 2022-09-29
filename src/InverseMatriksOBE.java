public class InverseMatriksOBE {
    public static double[][] inverseMatrixOBE(double[][] m) {
        double[][] identitas = new double[m.length][m[0].length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (i != j) {
                    identitas[i][j] = 0;
                } else {
                    identitas[i][j] = 1;
                }
            }
        }
        m = Primitive.merge(m, identitas);
        boolean matriksbalikan = true;
        m = Gauss_Jordan.gauss_Jordan(m);
        for (int i = 0; i < identitas.length; i++) {
            if (m[i][i] == 0) {
                matriksbalikan = false;
                break;
            }
        }
        if (matriksbalikan) {
            for (int i = 0; i < m.length; i++) {
                for (int j = m.length; j < m[0].length; j++) {
                    identitas[i][j - m.length] = m[i][j];
                }
            }
            return identitas;

        } else {
            return identitas;
        }
    }

}