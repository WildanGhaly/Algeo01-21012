import java.io.*;
import java.util.Scanner;

public class Input {
    static Scanner scan = new Scanner(System.in);

    public static int pil() {
        /* 
         * Menerima masukan integer dari keyboard
         * Mengembalikan nilai integer tersebut
         */
        int pilihan = scan.nextInt();
        return pilihan;
    }

    public static double[][] inputMatriks(int row, int col) {
        /* 
         * Membaca jumlah baris (row) dan kolom (col)
         * Menerima masukan matriks dengan tipe elemen double dari keyboard
         * Mengembalikan matriks tersebut
         */
        double[][] m = new double[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                m[i][j] = scan.nextDouble();
            }
        }
        return m;
    }

    public static int[] inputUkuran (){
        int rowCol[] = new int[2];
        while (true){
            
            System.out.println("Masukan dimensi matriks: ");
            System.out.print(">> ");
            rowCol[0] = scan.nextInt();
            rowCol[1] = scan.nextInt();
            if (Primitive.isArrValid(rowCol)){
                break;
            } else {
                System.out.println("Masukan tidak valid, harap ulangi! ");
            }
        }
        return rowCol;
    }

    public static int pilihanInput() {
        /* 
         * Menerima masuka input integer dari keyboard
         * Fungsi akan selalu menerima masukan input sampai input valid (1 atau 2)
         * Mengembalikan pilihan input
         */
        int pilInput;
        while (true) {
            System.out.println("Pilihan masukan input: ");
            System.out.println("1. Melalui keyboard");
            System.out.println("2. Melalui import file");
            System.out.print(">> Pilihan: ");
            pilInput = scan.nextInt();
            if ((pilInput == 1) || (pilInput == 2)) {
                break;
            }
        }
        return pilInput;
    }

    public static int inputDimensi() {
        /* 
         * Menerima masukan input integer dari keyboard
         * Fungsi akan selalu menerima masukan input sampai input valid (X >= 0)
         * Mengembalikan nilai dimensi
         */
        int dimensi;
        while (true) {
            System.out.print(">> Masukkan dimensi matriks: ");
            dimensi = scan.nextInt();
            if (dimensi >= 0) {
                break;
            } else {
                System.out.println("Masukan tidak valid, harap ulangi!");
            }
        }
        return dimensi;
    }

    public static int[] ukuran (String file){
        /* 
         * Fungsi yang menerima nama file dalam bentuk string.
         * Mengembalikan array yang terdiri atas:
         * - indeks 0 array adalah banyak baris
         * - indeks 1 array adalah banyak kolom
         * Jika file tidak ditemukan maka akan mengembalikan null
         */
        try {
            File f = new File (file);

            Scanner sRow = new Scanner(f);
            Scanner sCol = new Scanner(f);

            int row = 0; // baris
            int all = 0; // jumlah seluruh elemen

            while (sRow.hasNextLine()){
                row++;
                sRow.nextLine();
            }

            while (sCol.hasNextDouble()){
                all++;
                sCol.nextDouble();
            }

            int col = all/row; // kolom

            int[] rowCol = new int[2];
            rowCol[0] = row; // Menyimpan nilai baris
            rowCol[1] = col; // Menyimpan nilai kolom 

            sRow.close();
            sCol.close();

            return rowCol;

        } catch (Exception e) {
            return null;
        }
    }

    public static double[][] readMatrix(String file) {
        /* 
         * Fungsi yang menerima nama file dalam bentuk string.
         * Mengembalikan matriks dengan tipe elemen double.
         * Matriks merupakan hasil dari membaca file.
         * Jika nama file tidak ditemukan maka akan mengembalikan null
         */
        File f = new File(file);

        int[] rowCol = ukuran(file);

        if (rowCol == null){
            return null;
        } else {
            try{
                Scanner s = new Scanner(f);
                int row = rowCol[0]; // baris
                int col = rowCol[1]; // kolom

                double[][] m = new double[row][col];

                for (int i = 0; i < row; i++){
                    for (int j = 0; j < col; j++){
                        m[i][j] = s.nextDouble();
                    }
                }
                
                s.close();
                return m;
            } catch (Exception e) {
                return null;
            }
        }
        
    }

    public static String read (){
        /* 
         * Menerima masukan input string dari keyboard.
         * Jika file ditemukan maka fungsi akan mengembalikan nama file tersebut.
         * Jika file tidak ditemukan maka fungsi akan meminta pengulangan input.
         */
        Scanner ss = new Scanner(System.in);
        String file;
        String address;
        while (true){
            Menu.batas();
            System.out.print(">> masukan nama file: ");
            file = ss.nextLine();
            address = ".//test//" + file;
            File f = new File (address);
            try{
                Scanner s = new Scanner(f);
                break;
            } catch (Exception e){
                System.out.println("File tidak ditemukan, harap ulangi!");
            }
        }
        ss.close();
        return address;
    }

    public static double[][] inputPolasi(){
        /* 
         * Melakukan input dari keyboard untuk interpolasi matriks
         */
        int n;
        while (true){
            System.out.print(">> Masukkan nilai n: ");
            n = scan.nextInt();
            if (Primitive.isValid(n)){
                break;
            } else {
                System.out.println("Masukan tidak valid, harap ulangi!");
            }
        }
        double[][] m = new double[n+1][2];
        System.out.println("Masukkan titik-titiknya!");
        m = inputMatriks(n+1, 2);
        return m;
    }

    public static double taksirPolasi(){
        /* 
         * Melakukan input dari keyboard untuk menaksir interpolasi matriks
         */
        double x = scan.nextDouble();
        return x;
    }

}
