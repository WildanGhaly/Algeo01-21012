
import java.awt.image.*;
import java.io.*;


import javax.imageio.*;


public class BikubikIMG {

    static BufferedImage image;

    public static double[][] interpolasiBikubik(int dim){
        /* 
         * ini buat dapet X yang y = Xa
         * nah y itu inputan
         * a itu dicari pake matriks balikan
         */
        int row = dim * dim;
        int col = dim * dim;
        double[][] m = new double[row][col]; // m 16 x 16
        int count;
        int x; int y;

        // m [k] [count]
        for (int k = 0; k < dim * dim; k++){
            x = rotasi(k-1, dim);
            y = lipat(k, dim);
            count = 0;
            for (int j = 0; j < 4; j++){
                for (int i = 0; i < 4; i++){
                    m[k][count] = (Math.pow(x, i)) * (Math.pow(y, j));
                    count++;
                }
            }
        }

        return m;

    }

    public static int rotasi (int x, int dim){
        while (x > dim-2){
            x -= dim;
        }
        return x;
    }


    public static int lipat (int y, int dim){
        return (y/dim) - 1;
    }

    public static double[][] ubahInputPengguna(double[][] m) {
        /* 
         * Mengembalikan matriks 16 x 1
         */

        double[][] hasil = new double[m.length*m.length][1];
        int count = 0;
        for (int i = 0; i < m.length; i++){
            for (int j = 0; j < m[0].length; j++){
                hasil[count][0] = m[i][j];
                count++;
            }
        }

        return hasil;
    }

    public static double[][] cariA(double[][] Xp, double[][] yKotak) {
        /* 
         * Xp itu udah ada
         * Yp itu input pengguna
         * Rumus awal adalah Yp = Xp a
         * Maka a = inv(Xp) Yp
         */
        double[][] Yp = new double[yKotak.length * yKotak.length][1];
        Yp = ubahInputPengguna(yKotak);
        int row = Xp.length;
        int col = Yp[0].length;


        double[][] a = new double[row][col];
        double[][] invXp = new double[row][row];
        invXp = InverseMatriksOBE.inverseMatrixOBE(Xp);

        a = Primitive.multiplyMatrix(invXp, Yp);

        return a;
    }

    public static double[][] kotakinMatriks(double[][] m) {
        /* 
         * Awalnya 16 x 1 jadiin 4 x 4
         */
        int dimensi = (int) Math.sqrt(m.length);
        double[][] mKotak = new double[dimensi][dimensi];
        int count = 0;
        for (int j = 0; j < dimensi; j++){
            for (int i = 0; i < dimensi; i++){
                mKotak[i][j] = m[count][0];
                count++;
            }
        }
        return mKotak;
    }

    public static double solve(double[][] a, double x, double y) {
        /* 
         * saat ini dimensi 4
         * (a) a didapatkan sebelumnya dari a = inv(X) Yp (Yp input)
         */
        int dim = (int) Math.sqrt(a.length);
        double [][] mKotak = new double[dim][dim];
        mKotak = kotakinMatriks(a);
        double sum = 0;
        for (int j = 0; j < dim; j++){
            for (int i = 0; i < dim; i++){
                sum += mKotak[i][j] * (Math.pow(x, i)) * (Math.pow(y, j));
            }
        }
        return sum;
    }

    public static double solver (double x, double y, double[][] yKotak){
        /* 
         * Penyelesaian bikubik
         */
        double[][] Xp = interpolasiBikubik(yKotak.length);
        double[][] a = cariA(Xp, yKotak);
        double hasil = solve(a, x, y);
        return hasil;
    }

    // public static double[][] penyelesaian (double x, double y, double[][] yKotak){
        
        
    //     double[][] Xp = Ujigam.interpolasiBikubik(yKotak.length);
    //     double[][] a = Ujigam.cariA(Xp, yKotak);
    //     double hasil = Ujigam.solve(a, x, y);

    //     return hasil;
    
    
    // }

    public static int[][] noColor() throws IOException{
        /* 
         * Gambar jadi matrix
         */
        File file = new File(".//test//einstein.jpg");
        BufferedImage img = ImageIO.read(file);

        int width = img.getWidth();
        int height = img.getHeight();
        int[][] imgArr = new int[width][height];
        Raster raster = img.getData();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                imgArr[i][j] = raster.getSample(i, j, 0);
            }
        }
        return imgArr;
    } 
    public static double[][] antiBulat (int[][] m){
        /* 
         * ganti tipe dari integer ke double (matrix)
         */
        double[][] antiBul = new double[m.length][m[0].length];
        for (int i = 0; i < m.length; i++){
            for (int j = 0; j < m[0].length; j++){
                antiBul[i][j] = (double) m[i][j];
            }
        }
        return antiBul;
    }

    public static double[][] subMatrix (double[][] matrix, int i, int j){
        double[][] subMatrix = new double[4][4];
        int iii = 0, jjj = 0;
        for (int ii = i ; ii < subMatrix.length + i ; ii++){
            jjj = 0;
            for (int jj = j ; jj < subMatrix[0].length + j ; jj++){    
                    subMatrix[iii][jjj] = matrix[ii][jj];
                jjj++;
            }
            iii++;
        }
        return subMatrix;
    }

    public static double[][] beyondLimit (double[][] image){
        double[][] newImage= new double[image.length+2][image[0].length+2];
        int ii=1,jj=1;
        newImage[0][0]=image[0][0];
        newImage[newImage.length-1][0] = image[image.length-1][0];
        newImage[0][newImage[0].length-1]=image[0][image[0].length-1];
        newImage[newImage.length-1][newImage[0].length-1]=image[image.length-1][image[0].length-1];
        for (int i = 0; i < image.length; i++) {
            newImage[ii][0]=image[i][0];
            newImage[ii][newImage[0].length-1]=image[i][image[0].length-1];
            ii++;
        }
        for (int j = 0; j < image.length; j++) {
            newImage[0][jj]=image[0][j];
            newImage[newImage.length-1][jj]=image[image.length-1][j];
            jj++;
        }
        ii=1;
        jj=1;
        for (int i = 0; i < image.length; i++) {
            jj=1;
            for (int j = 0; j < image.length; j++) {
                newImage[ii][jj]=image[i][j];
                jj++;
            }
            ii++;
        }
        return newImage;
    }
    
    public static double[][] mBik(double[][] beonLimit) {
        /* 
         * Ini matriks hasil bikubik
         * dimensinya -1 dari matriks asal
         */
        int row = beonLimit.length - 1;
        int col = beonLimit[0].length - 1;
        double[][] mKub = new double[row][col];

        for (int i = 0; i < row -3; i++){
            for (int j = 0; j < col -3; j++){
                mKub[i][j] = solver(0.5, 0.5, subMatrix(mKub, i, j));
            }
        }

        return mKub;
    }

    public static double[][] gede(double[][] m) {
        /* 
         * Gedein bentuk matriks (dah bener)
         * bagian yang kosong diisi dengan -1
         */
        int row = 2 * m.length;
        int col = 2 * m[0].length;
        double[][] mNew = new double[row][col];

        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if ((i % 2 == 0) && (j % 2 == 0)){
                    mNew[i][j] = m[i/2][j/2];
                } else {
                    mNew[i][j] = -1;
                }
            }
        }
        return mNew;
    }

    public static double[][] solusiIMG(double[][] mAwal){

        int row = mAwal.length * 2;
        int col = mAwal[0].length * 2;
        double[][] mBig = new double[mAwal.length * 2][mAwal[0].length * 2];
        mBig = gede(mAwal);
        double[][] mBeyond = beyondLimit(mBig);

        for (int i = 2; i < row; i++ ){
            for (int j = 2; j < col; j++){
                if (i % 2 == 0 && i % 2 ==0){
                    mBeyond[i][j] = mAwal[i/2][j/2];
                } else if (i % 2 != 0 && i % 2 != 0){
                    mBeyond[i][j] = mBik(mBeyond)[i/2 - 1][j/2 - 1];
                } else if (i % 2 == 0 && j % 2 != 0){
                    mBeyond[i][j] = (mBeyond[i-1][j] + mBeyond[i+1][j])/2;
                } else {
                    mBeyond[i][j] = (mBeyond[i][j-1] + mBeyond[i][j+1])/2;
                }
            }
        }
        return mBeyond;
    }

    
    public static int[][] bulat(double[][] m){
        /* 
         * Buletin semua elemen ke int
         */
        int[][] bulat = new int[m.length][m[0].length];
        for (int i = 0; i < m.length; i++){
            for (int j = 0; j < m[0].length; j++){
                bulat[i][j] = (int) m[i][j];
            }
        }
        return bulat;
    }

    // public static void main(String... args) throws IOException {
    //     int w = 600, h = 600;
    
    //     BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_BYTE_GRAY);
    //     WritableRaster raster = bi.getRaster();
        
    //     int[][] m = bulat(cobaSolve(antiBulat(noColor())));


    //     for(int i=0; i<w; i++)
    //         for(int j=0; j<h; j++)
    //             raster.setSample(i,j,0,m[i][j]);
    
    //     ImageIO.write(bi, "jpg", new File("testarr.jpg"));
    // }

    public static void main(String... args) throws IOException {
        int w = 300, h = 300;
    
        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster raster = bi.getRaster();
        
        int[][] m = bulat(solusiIMG(antiBulat(noColor())));

        for(int i=0; i<w; i++)
            for(int j=0; j<h; j++)
                raster.setSample(i,j,0,m[i][j]);
    
        ImageIO.write(bi, "jpg", new File("../test/output/BiggerImage.jpg"));
        System.out.println("File berhasil disimpan di ../test/output/BiggerImage.jpg");
    }
}
