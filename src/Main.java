import java.util.Scanner;

import Fungsi.*;


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Menu menu = new Menu();
        menu.tampilanMenu();

        System.out.print("\nPilihan: ");
        int Pilihan = scan.nextInt();

        while (true){
            if (Pilihan == 1){
                // Jika dipilih SPL
                // ...


            } else if (Pilihan == 2){
                Determinan determinan = new Determinan();
                determinan.pencarianDeterminan();

            } else if (Pilihan == 3){
                // Jika dipilih matriks balikan
                // ...


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
