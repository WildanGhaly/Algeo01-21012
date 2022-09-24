import java.io.*;
import java.util.*;

public class File_Reader {
    public static double[][] readFile(String fileName, int rows, int cols) {
        /* Menerima nama file (fileName), jumlah baris (rows), dan jumlah kolom (cols)
         * Lalu mengembalikannya dalam bentuk matriks dengan tipe elemen double
         */
        double[][] m = new double[rows][cols];
        
        System.out.println("Nama file yang diinput adlalah: " + fileName);
    
        FileReader fr = null;

        try {
            fr = new FileReader(fileName);
        } catch (FileNotFoundException fe) {
            System.out.println("File tidak ditemukan atau tidak ada");
        }

        // membuka fungsi scanner
        Scanner scan = new Scanner(fr);
    
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                double input = scan.nextDouble();
                m[i][j] = input;
            }
        }

        // menutup fungsi scanner
        scan.close();

        // Mengembalikan nilai dalam bentuk matriks
        return m;

    }












}
