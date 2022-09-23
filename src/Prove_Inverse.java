/**
 * Prove_Inverse
 */
public class Prove_Inverse {
    public static boolean buktiInverse (double[][] m, double[][] mI){
        /* Mengembalikan true jika mI merupakan nilai inverse dari m
         * Mengembalikan false jika bukan
         */
        return (Primitive.isIdentity(Primitive.multiplyMatrix(m, mI)));
        /* isIdentity merupakan matriks identitas
         * Jika perkalian matriks m dengan matriks mI bernilai matriks identitas
         * maka matriks mI merupakan balikan dari matriks m dan sebaliknya
         */ 
    }
    
}





