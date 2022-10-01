public class Multiplyregression {
    public static void multiplyRegression(double[][] matrix, double x) {
        double[][] matriksSPL = Gauss.gauss(matrix);
        double[] solusiSPL = Gauss.satuSolusiDouble(matriksSPL);
        boolean first = true;
        double sum = 0;
        System.out.print("f(x) = ");
        for (int i = 0; i < solusiSPL.length; i++) {
            if (i != 0 && solusiSPL[i] != 0) {
                if (first == false) {
                    System.out.print(" + " + solusiSPL[i] + "x" + i);
                    sum += (x * solusiSPL[i]);
                } else {
                    System.out.print(solusiSPL[i]);
                    sum += (x * solusiSPL[i]);
                    first = false;
                }
            } else if (solusiSPL[i] == 0 && solusiSPL.length > 1) {
                sum += 0;
            } else {
                System.out.print(solusiSPL[i]);
                sum += (x * solusiSPL[i]);
                first = false;
            }
        }
        System.out.print("\n");
        System.out.print("f(" + x + ") = " + sum + "\n");

    }

}
