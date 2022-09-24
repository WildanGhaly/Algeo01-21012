

/* Program Main untuk dijalankan saat demo */

public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();

        while (true){
            // Melakukan pengulangan sampai input valid (pilihan antara 1 sampai 7)

            menu.tampilanMenu();
            System.out.print("\nPilihan: ");

            int Pilihan = Input.pil();

            if (Pilihan == 1){
                // Jika dipilih SPL
                while (true){
                    // Melakukan pengulangan input sampai input valid

                    menu.tampilanSubMenu1();
                    System.out.print("\nPilihan sub: ");
                    int pilihanSub = Input.pil();

                    if (pilihanSub == 1){
                        // Jika dipilih metode eliminasi Gauss
                        // ...

                        break;
                    } else if (pilihanSub == 2){
                        // Jika dipilih metode eliminasi Gauss-Jordan
                        // ...

                        break;
                    } else if (pilihanSub == 3){
                        // Jika dipilih metode matriks balikan
                        // ...

                        break;
                    } else if (pilihanSub == 4){
                        // Jika dipilih Kaidah Cramer
                        // ...

                        break;
                    } else {
                        System.out.println("Masukan tidak valid, harap ulangi!");
                        // Pesan yang dikeluarkan saat input tidak valid

                    }
                }


            } else if (Pilihan == 2){
                /* Jika dipilih Determinan
                   Akan dibaca matriks dengan dimensi masukan dari keyboard
                   Lalu setiap variabel matriks akan diinput dan akan dihasilkan 
                   matriks tersebut dengan salah satu dari 3 metode */
                menu.batas();

                System.out.print("Masukkan dimensi dari matriks: ");
                int dimensi = Input.pil();
                // Melakukan input pilihan

                // Input matriks :
                double[][] matriks = new double[dimensi][dimensi];
                System.out.println("Masukkan nilai matriks dimensi " + dimensi);
                matriks = Input.inputMatriks(dimensi, dimensi);
                // menerima masukan dari keyboard untuk membentuk matriks
                // matriks akan tersimpan dalam variabel "matriks"

                while (true){
                    // Melakukan pengulangan sampai input benar (subPilihan 1-3)
                    menu.batas();
                    menu.tampilanSubMenu2();
                    System.out.print("\nPilihan sub: ");
                    int pilihanSub = Input.pil(); 

                    if (pilihanSub == 1){
                        // Jika dipilih metode eliminasi Gauss
                        // ...

                        break;
                        
                    } else if (pilihanSub == 2){
                        // Jika dipilih metode eliminasi Gauss-Jordan
                        // ...

                        break;

                    } else if (pilihanSub == 3){
                        // Pencarian dengan Ekspansi Kofaktor
                        menu.batas();
                        double det = Determinan.DeterminanKofaktor(matriks);
                        System.out.println("Berdasarkan kofaktor, nilai determinannya adalah: " + det);
                        menu.batas();
                        break;

                    } else {
                        System.out.println("Masukkan tidak valid, harap ulangi!");
                        // Pesan yang dikeluarkan saat input tidak valid
                        menu.batas();

                    }
                }

            } else if (Pilihan == 3){
                // Jika dipilih matriks balikan
                menu.batas();
                
                System.out.print("Masukkan dimensi matriks: ");
                int dimensi = Input.pil();
                // input pilihan

                // Input matriks:
                double[][] matriks = new double[dimensi][dimensi];
                matriks = Input.inputMatriks(dimensi, dimensi);
                // menerima masukan dari keyboard untuk membentuk matriks
                // matriks akan tersimpan dalam variabel "matriks"

                menu.batas();

                if (Determinan.DeterminanKofaktor(matriks)==0){
                    System.out.println("Matriks tidak memiliki balikan karena nilai determinan 0");
                    menu.batas();
                } else {
                    
                    while (true){

                        // Melakukan pengulangan input sampai input valid
                        menu.tampilanSubMenu3();
                        System.out.print("\nPilihan sub: ");
                        int pilihanSub = Input.pil();

                        if (pilihanSub == 1){
                            // Metode adjoint
                            menu.batas();
                            System.out.println("Nilai inverse berdasarkan metode matriks balikan adalah: ");
                            double[][] balikan = Balikan.balikanKofaktor(matriks);
                            // Saat ini matriks balikan sudah didapatkan

                            // Cetak matriks
                            Primitive.displayMatrix(balikan);
                            menu.batas();

                            break;
                        } else if (pilihanSub == 2) {
                            // Metode Gauss-Jordan
                            // ...

                            break;
                            
                        } else if (pilihanSub == 3) { 
                            menu.batas();

                            // Input inverse matriks:
                            System.out.println("Masukkan nilai inverse matriks dimensi " + dimensi + " x " + dimensi);
                            double[][] invMatriks = new double[dimensi][dimensi];
                            invMatriks = Input.inputMatriks(dimensi, dimensi);
                            // menerima masukan dari keyboard untuk membentuk matriks
                            // inverse matriks yang ingin di cek akan tersimpan dalam variabel "invMatriks"
                            // Saat ini nilai inverse matriks sudah terinput

                            menu.batas();

                            if (Prove_Inverse.buktiInverse(matriks, invMatriks)) {
                                System.out.println("Benar matriks berikut : ");
                                Primitive.displayMatrix(invMatriks);
                                System.out.println("Merupakan inverse dari matriks berikut : ");
                                Primitive.displayMatrix(matriks);
                                System.out.println("Karena hasil perkaliannya merupakan matriks identitas.");
                                menu.batas();
                                break;

                            } else {
                                System.out.println("Matriks berikut : ");
                                Primitive.displayMatrix(invMatriks);
                                System.out.println("BUKAN merupakan inverse dari matriks berikut : ");
                                Primitive.displayMatrix(matriks);
                                System.out.println("Karena hasil perkaliannya bukan merupakan matriks identitas.");
                                menu.batas();
                                break;
                            }

                        } else {
                            System.out.println("Masukan tidak valid, harap ulangi!");
                            // Pesan yang dikeluarkan saat input tidak valid

                        }

                    }

                }


            } else if (Pilihan == 4){
                // Jika dipilih Interpolasi Polinom
                // ...


            } else if (Pilihan == 5){
                // Jika dipilih Interpolasi Bicubic
                // ...


            } else if (Pilihan == 6){
                // Jika dipilih Regresi Linier berganda
                // ...


            } else if (Pilihan == 7){
                break; // Keluar loop dan program selesai

                
            } else {
                System.out.println("Masukan tidak valid, harap ulangi!");
                // Pesan yang dikeluarkan saat input tidak valid

            }
        
        }


    }
}






