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

    public static int[] inputUkuran() {
        int rowCol[] = new int[2];
        while (true) {

            System.out.println("Masukan dimensi matriks: ");
            System.out.print(">> ");
            rowCol[0] = scan.nextInt();
            rowCol[1] = scan.nextInt();
            if (Primitive.isArrValid(rowCol)) {
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

    public static int[] ukuran(String file) {
        /*
         * Fungsi yang menerima nama file dalam bentuk string.
         * Mengembalikan array yang terdiri atas:
         * - indeks 0 array adalah banyak baris
         * - indeks 1 array adalah banyak kolom
         * Jika file tidak ditemukan maka akan mengembalikan null
         */
        try {
            File f = new File(file);

            Scanner sRow = new Scanner(f);
            Scanner sCol = new Scanner(f);

            int row = 0; // baris
            int all = 0; // jumlah seluruh elemen

            while (sRow.hasNextLine()) {
                row++;
                sRow.nextLine();
            }

            while (sCol.hasNextDouble()) {
                all++;
                sCol.nextDouble();
            }

            int col = all / row; // kolom

            int[] rowCol = new int[2];
            rowCol[0] = row; // Menyimpan nilai baris
            rowCol[1] = col; // Menyimpan nilai kolom

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

        if (rowCol == null) {
            return null;
        } else {
            try {
                Scanner s = new Scanner(f);
                int row = rowCol[0]; // baris
                int col = rowCol[1]; // kolom

                double[][] m = new double[row][col];

                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        m[i][j] = s.nextDouble();
                    }
                }

                return m;
            } catch (Exception e) {
                return null;
            }
        }

    }

    public static String read() {
        /*
         * Menerima masukan input string dari keyboard.
         * Jika file ditemukan maka fungsi akan mengembalikan nama file tersebut.
         * Jika file tidak ditemukan maka fungsi akan meminta pengulangan input.
         */
        Scanner ss = new Scanner(System.in);
        String file;
        String address;
        while (true) {
            Menu.batas();
            System.out.print(">> masukan nama file: ");
            file = ss.nextLine();
            address = "../test/" + file;
            File f = new File(address);
            try {
                Scanner s = new Scanner(f);
                break;
            } catch (Exception e) {
                System.out.println("File tidak ditemukan, harap ulangi!");
            }
        }
        return address;
    }

    public static double[] inputTitik() {
        /*
         * Menerima input dari keyboard berupa titik x dan y.
         * Fungsi mengembalikan array of double yang terdiri dari x dan y.
         */
        double[] titik = new double[2];
        titik[0] = scan.nextDouble();
        titik[1] = scan.nextDouble();
        return titik;
    }

    public static boolean isTitikValid(double[][] m, int idx) {
        /*
         * Mengembalikan true jika titik valid
         */
        boolean uji = true;
        for (int i = 0; i < idx; i++) {
            if (m[i][0] == m[idx][0]) {
                uji = false;
            }
        }
        return uji;
    }

    public static double[][] inputPolasi() {
        /*
         * Melakukan input dari keyboard untuk interpolasi matriks
         */
        int n;
        while (true) {
            System.out.print(">> Masukkan nilai n: ");
            n = scan.nextInt();
            if (Primitive.isValid(n)) {
                break;
            } else {
                System.out.println("Masukan tidak valid, harap ulangi!");
            }
        }
        double[][] m = new double[n + 1][2];
        System.out.println("Masukkan titik-titiknya!");
        int titik = 0;
        while (titik < (n + 1)) {
            System.out.print(">> Masukkan titik ke " + (titik + 1) + " : ");
            m[titik] = inputTitik();
            if (isTitikValid(m, titik)) {
                titik++;
            } else {
                System.out.println("Tidak boleh memasukan titik x yang sama, harap ulangi!");
            }

        }
        return m;
    }

    public static double taksirPolasi() {
        /*
         * Melakukan input dari keyboard untuk menaksir interpolasi matriks
         */
        System.out.print(">> Masukkan nilai yang ingin ditaksir: ");
        double x = scan.nextDouble();
        return x;
    }

    public static double[][] inputregresi() {
        int n;
        int m;
        while (true) {
            System.out.print(">> Masukkan nilai n: ");
            n = scan.nextInt();
            System.out.print(">> Masukkan nilai m: ");
            m = scan.nextInt();
            if (Primitive.isValid(n) && Primitive.isValid(m) && m == n) {
                break;
            } else {
                System.out.println("Masukan tidak valid, harap ulangi!");
            }
        }
        double[][] matrix = new double[m][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (j != n) {
                    System.out.print(">> Masukkan x" + (j) + " : ");
                    matrix[i][j] = scan.nextDouble();
                } else {
                    System.out.print(">> Masukkan y" + (i + 1) + " : ");
                    matrix[i][j] = scan.nextDouble();
                }
            }
        }
        return matrix;

    }

    public static double inputhasilFX(double[] hasilfx) {
        boolean first = false;
        double sum = 0;
        double x = 0;
        for (int i = 0; i < hasilfx.length; i++) {
            if (hasilfx[i] != 0) {
                if (first) {
                    System.out.print(">> Masukkan x" + (i) + " : ");
                    x = scan.nextDouble();
                    sum += x * hasilfx[i];
                } else {
                    first = true;
                    sum += hasilfx[i];
                }
            }
        }
        return sum;
    }

}
