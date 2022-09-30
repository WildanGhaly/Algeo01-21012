

/* Program Main untuk dijalankan saat demo */

public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();

        while (true){
            // Melakukan pengulangan sampai input valid (pilihan antara 1 sampai 7)

            menu.tampilanMenu();
            System.out.print("\n>> Pilihan: ");

            int Pilihan = Input.pil();

            if (Pilihan == 1){
                // Jika dipilih SPL

                // Melakukan pilihan input antara  menginput dengan KEYBOARD atau dari FILE
                int pilInput = Input.pilihanInput();
                if (pilInput == 1){
                    /* Jika pilihan input 1 maka akan diminta masukan melalui keyboard 
                    */

                    int[] rowCol = Input.inputUkuran();
                    int row = rowCol[0];
                    int col = rowCol[1];
                    double[][] m = new double[row][col];
                    m = Input.inputMatriks(row, col);

                    while (true){
                    // Melakukan pengulangan input sampai input valid

                        menu.tampilanSubMenu1();
                        System.out.print("\n>> Pilihan sub: ");
                        int pilihanSub = Input.pil();
        

                        if (pilihanSub == 1){
                            // Jika dipilih metode eliminasi Gauss
                            double[][] mNew = new double[row][col];
                            mNew = Gauss.gauss(m);
                            System.out.println("Berdasarkan eliminasi gauss, matriksnya menjadi: ");
                            Primitive.displayMatrix(mNew);
                            System.out.println("Solusi dari persamaan diatas adalah: ");
                            String[] hasil = Gauss.solveSPL(mNew);
                            Primitive.displayHasil(hasil);

                            break;

                        } else if (pilihanSub == 2){
                            // Jika dipilih metode eliminasi Gauss-Jordan
                            double[][] mNew = new double[row][col];
                            mNew = Gauss_Jordan.gauss_Jordan(m);
                            System.out.println("Berdasarkan eliminasi Gauss-Jordan, matriksnya menjadi: ");
                            Primitive.displayMatrix(mNew);
                            System.out.println("Solusi dari persamaan diatas adalah: ");
                            String[] hasil = Gauss_Jordan.solveSPLgj(mNew);
                            Primitive.displayHasil(hasil);

                            break;

                        } else if (pilihanSub == 3){
                            // Jika dipilih metode matriks balikan
                            System.out.println("Berdasarkan inverse matriks, solusinya adalah: ");
                            InverseMatriksSPL.inverseMatrixSPL(m);

                            break;

                        } else if (pilihanSub == 4){
                            // Jika dipilih Kaidah Cramer
                            if (Determinan.DeterminanKofaktor(m) == 0){
                                System.out.println("Solusi tidak dapat ditentukan dengan aturan crammer karena determinan A = 0");
                            
                            } else {
                                String[] hasil = Crammer.solveCrammer(Crammer.crammer(m));
                                System.out.println("Berdasarkan aturan crammer, solusinya adalah: ");
                                Primitive.displayHasil(hasil);

                            }

                            break;

                        } else {
                            System.out.println("Masukan tidak valid, harap ulangi!");
                            // Pesan yang dikeluarkan saat input tidak valid

                        }
                    }

                } else if (pilInput == 2){
                    /* Jika pilihan input 2 maka akan diminta nama file yang ingin diolah */
                    String file = Input.read();
                    double[][] m = Input.readMatrix(file);
                    int row = m.length;
                    int col = m[0].length;
                    while (true){
                        // Melakukan pengulangan input sampai input valid
    
                        menu.tampilanSubMenu1();
                        System.out.print("\n>> Pilihan sub: ");
                        int pilihanSub = Input.pil();
        

                        if (pilihanSub == 1){
                            // Jika dipilih metode eliminasi Gauss
                            double[][] mNew = new double[row][col];
                            mNew = Gauss.gauss(m);
                            System.out.println("Berdasarkan eliminasi gauss, matriksnya menjadi: ");
                            Primitive.displayMatrix(mNew);
                            System.out.println("Solusi dari persamaan diatas adalah: ");
                            String[] hasil = Gauss.solveSPL(mNew);
                            Primitive.displayHasil(hasil);

                            break;

                        } else if (pilihanSub == 2){
                            // Jika dipilih metode eliminasi Gauss-Jordan
                            double[][] mNew = new double[row][col];
                            mNew = Gauss_Jordan.gauss_Jordan(m);
                            System.out.println("Berdasarkan eliminasi Gauss-Jordan, matriksnya menjadi: ");
                            Primitive.displayMatrix(mNew);
                            System.out.println("Solusi dari persamaan diatas adalah: ");
                            String[] hasil = Gauss_Jordan.solveSPLgj(mNew);
                            Primitive.displayHasil(hasil);

                            break;

                        } else if (pilihanSub == 3){
                            // Jika dipilih metode matriks balikan
                            System.out.println("Berdasarkan inverse matriks, solusinya adalah: ");
                            InverseMatriksSPL.inverseMatrixSPL(m);

                            break;

                        } else if (pilihanSub == 4){
                            // Jika dipilih Kaidah Cramer
                            if (Determinan.DeterminanKofaktor(m) == 0){
                                System.out.println("Solusi tidak dapat ditentukan dengan aturan crammer karena determinan A = 0");
                            
                            } else {
                                String[] hasil = Crammer.solveCrammer(Crammer.crammer(m));
                                System.out.println("Berdasarkan aturan crammer, solusinya adalah: ");
                                Primitive.displayHasil(hasil);

                            }

                            break;

                        } else {
                            System.out.println("Masukan tidak valid, harap ulangi!");
                            // Pesan yang dikeluarkan saat input tidak valid

                        }
                    }
                }

            } else if (Pilihan == 2){
                /* Jika dipilih Determinan
                   Akan dibaca matriks dengan dimensi masukan dari keyboard
                   Lalu setiap variabel matriks akan diinput dan akan dihasilkan 
                   matriks tersebut dengan salah satu dari 3 metode */

                // Melakukan pilihan input antara  menginput dengan KEYBOARD atau dari FILE
                int pilInput = Input.pilihanInput();
                if (pilInput == 1){
                    /* Jika pilihan input 1 maka akan diminta masukan melalui keyboard */

                    int dimensi = Input.inputDimensi();
                    // Melakukan input pilihan

                    // Input matriks :
                    double[][] m = new double[dimensi][dimensi];
                    System.out.println("Masukkan nilai matriks berdimensi " + dimensi);
                    m = Input.inputMatriks(dimensi, dimensi);
                    // menerima masukan dari keyboard untuk membentuk matriks
                    // matriks akan tersimpan dalam variabel "matriks"

                    while (true){
                    // Melakukan pengulangan sampai input benar (subPilihan 1-3)
                        Menu.batas();
                        menu.tampilanSubMenu2();
                        System.out.print("\n>> Pilihan sub: ");
                        int pilihanSub = Input.pil(); 

                        if (pilihanSub == 1){
                            Menu.batas();
                            double det = DeterminanOBE.determinanOBE(m);
                            Primitive.displayMatrix(m);
                            System.out.println("Berdasarkan OBE, nilai determinannya adalah: " + det);
                            Menu.batas();
                            break;
                            
                        } else if (pilihanSub == 2){
                            // Pencarian dengan Ekspansi Kofaktor
                            Menu.batas();
                            double det = Determinan.DeterminanKofaktor(m);
                            System.out.println("Berdasarkan kofaktor, nilai determinannya adalah: " + det);
                            Menu.batas();
                            break;

                        } else {
                            System.out.println("Masukkan tidak valid, harap ulangi!");
                            // Pesan yang dikeluarkan saat input tidak valid

                        }
                    }

                } else if (pilInput == 2){
                    /* Jika pilihan input 2 maka akan diminta nama file yang ingin diolah */
                    String file = Input.read();
                    double[][] m = Input.readMatrix(file);

                    if (Primitive.isSquare(m)){
                        while (true){

                            // Melakukan pengulangan sampai input benar (subPilihan 1-3)
                            Menu.batas();
                            menu.tampilanSubMenu2();
                            System.out.print("\n>> Pilihan sub: ");
                            int pilihanSub = Input.pil(); 
        
                            if (pilihanSub == 1){
                                // Jika dipilih metode OBE
                                Menu.batas();
                                double det = DeterminanOBE.determinanOBE(m);
                                Primitive.displayMatrix(m);
                                System.out.println("Berdasarkan OBE, nilai determinannya adalah: " + det);
                                Menu.batas();
                                break;
        
                            } else if (pilihanSub == 2){
                                // Pencarian dengan Ekspansi Kofaktor
                                Menu.batas();
                                double det = Determinan.DeterminanKofaktor(m);
                                System.out.println("Berdasarkan kofaktor, nilai determinannya adalah: " + det);
                                Menu.batas();
                                break;
        
                            } else {
                                System.out.println("Masukkan tidak valid, harap ulangi!");
                                // Pesan yang dikeluarkan saat input tidak valid
        
                            }
                        }
                    } else {
                        System.out.println("Determinan tidak dapat ditentukan karena bukan matriks persegi");
                    }

                }

            } else if (Pilihan == 3){
                // Jika dipilih matriks balikan

                // Melakukan pilihan input antara  menginput dengan KEYBOARD atau dari FILE
                int pilInput = Input.pilihanInput();
                if (pilInput == 1){
                    /* Jika pilihan input 1 maka akan diminta masukan melalui keyboard */
                
                    // Melakukan input pada dimensi matriks
                    int dimensi = Input.inputDimensi();


                    // Input matriks:
                    double[][] matriks = new double[dimensi][dimensi];
                    matriks = Input.inputMatriks(dimensi, dimensi);
                    // menerima masukan dari keyboard untuk membentuk matriks
                    // matriks akan tersimpan dalam variabel "matriks"

                    Menu.batas();

                    if (Determinan.DeterminanKofaktor(matriks)==0){
                        System.out.println("Matriks tidak memiliki balikan karena nilai determinan 0");
                        Menu.batas();
                    } else {
                    
                    while (true){

                        // Melakukan pengulangan input sampai input valid
                        menu.tampilanSubMenu3();
                        System.out.print("\n>> Pilihan sub: ");
                        int pilihanSub = Input.pil();

                        if (pilihanSub == 1){
                            // Metode adjoint
                            Menu.batas();
                            System.out.println("Matriks kofaktornya adalah: ");
                            double[][] kofaktor = Balikan.kofaktorMatriks(matriks);
                            Primitive.displayMatrix(kofaktor);

                            System.out.println("Matriks adjoinnya adalah: ");
                            double[][] adjoin = Balikan.transpose(kofaktor);
                            Primitive.displayMatrix(adjoin);

                            System.out.println("Nilai inverse berdasarkan metode matriks balikan adalah: ");
                            double[][] balikan = Balikan.balikanKofaktor(matriks);
                            // Saat ini matriks balikan sudah didapatkan

                            // Cetak matriks
                            Primitive.displayMatrix(balikan);
                            Menu.batas();

                            break;
                        } else if (pilihanSub == 2) {
                            // Metode Identitas
                            // ...

                            break;
                            
                        } else {
                            System.out.println("Masukan tidak valid, harap ulangi!");
                            // Pesan yang dikeluarkan saat input tidak valid
                            Menu.batas();

                        }

                    }

                }

                } else if (pilInput == 2){
                    /* Jika pilihan input 2 maka akan diminta nama file yang ingin diolah */
                    String file = Input.read();
                    double[][] m = Input.readMatrix(file);
                    
                    if (m != null){

                        Menu.batas();
    
                        if ((Determinan.DeterminanKofaktor(m)==0) || (!Primitive.isSquare(m))){
                            System.out.println("Matriks tidak memiliki balikan karena nilai determinan 0");
                            Menu.batas();

                        } else {
                        
                            while (true){
        
                                // Melakukan pengulangan input sampai input valid
                                menu.tampilanSubMenu3();
                                System.out.print("\n>> Pilihan sub: ");
                                int pilihanSub = Input.pil();
        
                                if (pilihanSub == 1){
                                    // Metode adjoint
                                    Menu.batas();
                                    System.out.println("Matriks kofaktornya adalah: ");
                                    double[][] kofaktor = Balikan.kofaktorMatriks(m);
                                    Primitive.displayMatrix(kofaktor);
        
                                    System.out.println("Matriks adjoinnya adalah: ");
                                    double[][] adjoin = Balikan.transpose(kofaktor);
                                    Primitive.displayMatrix(adjoin);
        
                                    System.out.println("Nilai inverse berdasarkan metode matriks balikan adalah: ");
                                    double[][] balikan = Balikan.balikanKofaktor(m);
                                    // Saat ini matriks balikan sudah didapatkan
        
                                    // Cetak matriks
                                    Primitive.displayMatrix(balikan);
                                    Menu.batas();
        
                                    break;
                                } else if (pilihanSub == 2) {
                                    // Metode Identitas
                                    // ...
        
                                    break;
                                    
                                }
                            }
                        } 
                    } else {
                        System.out.println("Matriks tidak ditemukan atau tidak ada");
                    }
                }
            
            } else if (Pilihan == 4){
                // Jika dipilih Interpolasi Polinom

                // Melakukan pilihan input antara  menginput dengan KEYBOARD atau dari FILE
                int pilInput = Input.pilihanInput();
                if (pilInput == 1){
                    /* Jika pilihan input 1 maka akan diminta masukan melalui keyboard */ 
                    // ...  
                } else if (pilInput == 2){
                    /* Jika pilihan input 2 maka akan diminta nama file yang ingin diolah */
                    // ...
                }

            } else if (Pilihan == 5){
                // Jika dipilih Interpolasi Bicubic

                // Melakukan pilihan input antara  menginput dengan KEYBOARD atau dari FILE
                int pilInput = Input.pilihanInput();
                if (pilInput == 1){
                    /* Jika pilihan input 1 maka akan diminta masukan melalui keyboard */ 
                    // ...  
                } else if (pilInput == 2){
                    /* Jika pilihan input 2 maka akan diminta nama file yang ingin diolah */
                    // ...
                }


            } else if (Pilihan == 6){
                // Jika dipilih Regresi Linier berganda

                 // Melakukan pilihan input antara  menginput dengan KEYBOARD atau dari FILE
                int pilInput = Input.pilihanInput();
                if (pilInput == 1){
                    /* Jika pilihan input 1 maka akan diminta masukan melalui keyboard */
                    // ...  
                } else if (pilInput == 2){
                    /* Jika pilihan input 2 maka akan diminta nama file yang ingin diolah */
                    // ...
                }


            } else if (Pilihan == 7){
                System.out.println("|||||||||||||   |||     |||       ||||||       ||||||   |||   |||  |||| ");
                System.out.println("     |||        |||     |||      |||  |||      ||| |||  |||   ||| |||   ");
                System.out.println("     |||        |||||||||||     ||||||||||     |||  ||| |||   ||||||    ");
                System.out.println("     |||        |||     |||    |||      |||    |||   ||||||   ||| |||   ");
                System.out.println("     |||        |||     |||   |||        |||   |||    |||||   |||  |||| ");
                System.out.println();
                System.out.println("|||       |||   |||||||||||   |||     |||  ");
                System.out.println("  |||   |||     |||     |||   |||     |||  ");
                System.out.println("    |||||       |||     |||   |||     |||  ");
                System.out.println("     |||        |||     |||   |||     |||  ");
                System.out.println("     |||        |||||||||||   |||||||||||  ");


                break; 
                // Keluar loop dan program selesai

                
            } else {
                System.out.println("Masukan tidak valid, harap ulangi!");
                // Pesan yang dikeluarkan saat input tidak valid

            }
        
        }


    }
}







