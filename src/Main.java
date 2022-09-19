import java.util.Scanner;

import Fungsi.*;


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Menu menu = new Menu();

        while (true){
            menu.tampilanMenu();
            System.out.print("\nPilihan: ");
            int Pilihan = scan.nextInt();
            if (Pilihan == 1){
                // Jika dipilih SPL
                while (true){
                    menu.tampilanSubMenu1();
                    System.out.print("\nPilihan sub: ");
                    int pilihanSub = scan.nextInt();

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
                    }
                }


            } else if (Pilihan == 2){
                // Jika dipilih Determinan
                while (true){
                    menu.tampilanSubMenu2();
                    System.out.print("\nPilihan sub: ");
                    int pilihanSub = scan.nextInt(); 
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
                        Determinan determinan = new Determinan();
                        determinan.pencarianDeterminan();
                        break;

                    } else {
                        System.out.println("Masukkan tidak valid, harap ulangi!");
                    }
                }

            } else if (Pilihan == 3){
                // Jika dipilih matriks balikan
                while (true){
                    menu.tampilanSubMenu3();
                    System.out.println("\nPilihan sub: ");
                    int pilihanSub = scan.nextInt();

                    if (pilihanSub == 1){
                        // Metode adjoint
                        // ...

                        break;
                    } else if (pilihanSub == 2) {
                        // Metode Gauss-Jordan
                        // ...

                        break;
                    } else {
                        System.out.println("Masukan tidak valid, harap ulangi!");
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
                break; // Keluar loop
                
            } else {
                System.out.println("Masukan tidak valid, harap ulangi!");
            }
        
        }

        scan.close();
    }
}
