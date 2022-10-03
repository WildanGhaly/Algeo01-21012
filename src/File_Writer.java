import java.io.FileWriter;
import java.io.IOException;

public class File_Writer extends Input {

    public static boolean apaMasukFile() {
        /*
         * Melakukan input melalui keyboard pilihan masuk file atau tidak
         */
        int pilihan;
        boolean pil;
        while (true) {
            System.out.println("Apakah hasil mau disimpan ke dalam file?");
            System.out.println("1. YA");
            System.out.println("2. TIDAK");
            System.out.print(">> ");
            pilihan = scan.nextInt();

            if (pilihan == 1) {
                pil = true;
                break;

            } else if (pilihan == 2) {
                pil = false;
                break;

            } else {
                System.out.println("Input tidak valid!");
            }

        }
        return pil;
    }

    public static void writeSPL(double[][] m, double[][] mNew, boolean gauss, String[] hasil, String metode) {
        /*
         * Fungsi untuk menulis hasiil SPL matriks ke dalam file
         * - (m) adalah matriks awal
         * - (mNew) adalah matriks setelah eliminasi gauss (null jika tidak gauss)
         * - (gauss) adalah true jika matriks mNew tidak null
         * - (hasil) adalah solusi dari matriks tersebut
         * - (metode) adalah metode apa yang digunakan untuk menyelesaikan matriks
         */
        int row = m.length;
        int col = m[0].length;
        String namaFile;
        while (true) {
            try {
                System.out.println("Masukkan nama file yang ingin dibuat: ");
                System.out.print(">> ");
                namaFile = scan.next();
                String address = "../test/output/" + namaFile;
                FileWriter writer = new FileWriter(address);
                writer.write("Diberikan matriks di bawah ini!\n");

                for (int i = 0; i < row; i++) {
                    writer.append(Primitive.round2String(m[i][0]) + "");
                    for (int j = 1; j < col; j++) {
                        writer.append(" " + Primitive.round2String(m[i][j]));
                    }
                    writer.append("\n");
                }
                writer.append("\n");

                if (gauss) {
                    writer.append("Dibawah ini adalah hasil dari eliminasinya! \n");
                    for (int i = 0; i < mNew.length; i++) {
                        writer.append(Primitive.round2String(mNew[i][0]) + "");
                        for (int j = 1; j < mNew[0].length; j++) {
                            writer.append(" " + Primitive.round2String(mNew[i][j]));
                        }
                        writer.append("\n");
                    }
                    writer.append("\n");
                }

                writer.append(metode);

                for (int i = 0; i < hasil.length; i++) {
                    writer.append(hasil[i] + "\n");
                }

                System.out.println("File berhasil dibuat di " + address);
                writer.close();

                break;
            } catch (IOException e) {
                System.out.println("Error ditemukan");
            }
        }

    }

    public static void writeDeterminan(double[][] m, String solDeterminan) {
        /*
         * Fungsi untuk menulis hasil determinan matriks ke dalam file
         * - (m) adalah matriks awal
         * - (solDeterminan) adalah solusi determinannya melalui metode apa dan hasilnya
         */
        while (true) {
            try {
                System.out.println("Masukkan nama file yang ingin dibuat: ");
                System.out.print(">> ");
                String namaFile = scan.next();
                String address = "../test/output/" + namaFile;
                FileWriter writer = new FileWriter(address);
                writer.write("Diberikan matriks di bawah ini!\n");

                for (int i = 0; i < m.length; i++) {
                    writer.append(Primitive.round2String(m[i][0]) + "");
                    for (int j = 1; j < m[0].length; j++) {
                        writer.append(" " + Primitive.round2String(m[i][j]));
                    }
                    writer.append("\n");
                }

                writer.append("\n");

                writer.append(solDeterminan);
                System.out.println("File berhasil dibuat di " + address);
                writer.close();
                break;

            } catch (IOException e) {

                System.out.println("Error ditemukan");
            }
        }
    }

    public static void writeInverse(double[][] m, String hasil, double[][] invM, boolean adaBalikan, boolean kofaktor,
            double[][] m1, double[][] m2) {
        /*
         * Fungsi untuk menulis hasil inverse matriks ke dalam file
         * - (m) adalah matriks awal
         * - (hasil) adalah penjelasan metode apa yang digunakan
         * - (invM) adalah inverse matriksnya (bisa null)
         * - (adaBalikan) bernilai true jika matriks memiliki balikan
         * - (kofaktor) bernilai true jika metode yang digunakan adalah ekspansi
         * kofaktor
         * - (m1) adalah matriks kofaktornya jika kofaktor, m Awal gabung jika bukan
         * menggunakan metode kofaktor
         * - (m2) adalah matriks adjointnya jika kofaktor, m Akhir gabung jika bukan
         * menggunakan metode kofaktor
         */

        while (true) {
            try {
                System.out.println("Masukkan nama file yang ingin dibuat: ");
                System.out.print(">> ");
                String namaFile = scan.next();
                String address = "../test/output/" + namaFile;
                FileWriter writer = new FileWriter(address);
                writer.write("Diberikan matriks berikut\n");

                for (int i = 0; i < m.length; i++) {
                    writer.append(Primitive.round2String(m[i][0]) + "");
                    for (int j = 1; j < m[0].length; j++) {
                        writer.append(" " + Primitive.round2String(m[i][j]));
                    }
                    writer.append("\n");
                }
                writer.append("\n");

                if (kofaktor) {
                    writer.append("Berikut adalah matriks kofaktornya\n");
                    for (int i = 0; i < m1.length; i++) {
                        writer.append(Primitive.round2String(m1[i][0]) + "");
                        for (int j = 1; j < m1[0].length; j++) {
                            writer.append(" " + Primitive.round2String(m1[i][j]));
                        }
                        writer.append("\n");
                    }

                    writer.append("\nBerikut adalah matriks adjoinnya\n");
                    for (int i = 0; i < m2.length; i++) {
                        writer.append(Primitive.round2String(m2[i][0]) + "");
                        for (int j = 1; j < m2[0].length; j++) {
                            writer.append(" " + Primitive.round2String(m2[i][j]));
                        }
                        writer.append("\n");
                    }
                    writer.append("\n");

                } else { // identitas
                    writer.append("Berikut adalah matriks sebelum pengoperasian\n");
                    for (int i = 0; i < m1.length; i++) {
                        writer.append(Primitive.round2String(m[i][0]) + "");
                        for (int j = 1; j < m1[0].length; j++) {
                            writer.append(" " + Primitive.round2String(m1[i][j]));
                        }
                        writer.append("\n");
                    }

                    writer.append("\nBerikut adalah matriks setelah pengoperasian\n");
                    for (int i = 0; i < m2.length; i++) {
                        writer.append(Primitive.round2String(m2[i][0]) + "");
                        for (int j = 1; i < m2[0].length; j++) {
                            writer.append(" " + Primitive.round2String(m2[i][j]));
                        }
                        writer.append("\n");
                    }
                    writer.append("\n");
                }

                writer.append(hasil); // print penjelasan dan metode

                if (adaBalikan) {
                    for (int i = 0; i < invM.length; i++) {
                        writer.append(Primitive.round2String(invM[i][0]) + "");
                        for (int j = 1; i < invM[0].length; j++) {
                            writer.append(Primitive.round2String(m[i][j]) + " ");
                        }
                        writer.append("\n");
                    }
                }

                System.out.println("File berhasil dibuat di " + address);
                writer.close();

                break;

            } catch (IOException e) {

                System.out.println("Error ditemukan");
            }
        }
    }

    public static void writePolinom(double[][] m, String[] solusi) {
        /* 
         * 
         */
        while (true) {
            try {
                System.out.println("Masukkan nama file yang ingin dibuat: ");
                System.out.print(">> ");
                String namaFile = scan.next();
                String address = "../test/output/" + namaFile;
                FileWriter writer = new FileWriter(address);
                writer.write("Diberikan titik-titik berikut (x,y)\n");
                for (int i = 0; i < m.length; i++) {
                    writer.append(
                            "(" + Primitive.round2String(m[i][0]) + " , " + Primitive.round2String(m[i][1]) + ")\n");
                }

                writer.append("\nBerdasarkan interpolasi polinom, didapatkan persamaan berikut:");
                for (int i = 0; i < solusi.length; i++) {
                    writer.append(solusi + "\n");
                }
                writer.close();

            } catch (IOException e) {
                System.out.println("Error ditemukan");
            }
        }
    }

    public static void writeBikubik(double[][] m, double x, double y, double hasil, String metode) {
        /*
         * Fungsi untuk menulis hasil interpolasi bikubik dari matriks m
         * (m) adalah matriks awal
         */
        int row = m.length;
        int col = m[0].length;

        while (true) {
            try {
                System.out.println("Masukkan nama file yang ingin dibuat: ");
                System.out.print(">> ");
                String namaFile = scan.next();
                String address = "../test/output/" + namaFile;
                FileWriter writer = new FileWriter(address);
                writer.write("Diberikan matriks berikut\n");

                for (int i = 0; i < row; i++) {
                    writer.append(Primitive.round2String(m[i][0]) + "");
                    for (int j = 1; j < col; j++) {
                        writer.append(" " + Primitive.round2String(m[i][j]));
                    }
                    writer.append("\n");
                }
                writer.append("\n");

                writer.append(metode);

                writer.close();

            } catch (IOException e) {
                System.out.println("Error ditemukan");
            }
        }
    }

    public static void writeRegresi(double[][] m, String[] solusi) {
        /*
         * Fungsi untuk menulis hasil regresi linier berganda dalam file
         * (m) adalah matriks awal
         * (solusi) adalah solusi dari regresi linier berganda terhadap m
         */
        while (true) {
            try {
                System.out.println("Masukkan nama file yang ingin dibuat: ");
                System.out.print(">> ");
                String namaFile = scan.next();
                String address = "../test/output/" + namaFile;
                FileWriter writer = new FileWriter(address);
                writer.write("Diberikan matriks berikut\n");

                for (int i = 0; i < m.length; i++) {
                    writer.append(Primitive.round2String(m[i][0]) + "");
                    for (int j = 1; j < m[0].length; j++) {
                        writer.append(" " + Primitive.round2String(m[i][j]));
                    }
                    writer.append("\n");
                }

                writer.append("\nBerdasarkan regresi linier berganda, didapatkan persamaan berikut:\n");

                for (int i = 0; i < solusi.length; i++) {
                    writer.append(solusi[i]);
                }

                writer.close();
                break;

            } catch (IOException e) {
                System.out.println("Error ditemukan");
            }
        }
    }
}
