
public class Menu {
    /* Class ini berisi beberapa method untuk bagian MENU
     * Class Menu ini HANYA memiliki method yang dapat digunakan untuk DITAMPILKAN ke LAYAR
     */

    public void tampilanMenu() {
        /* Menampilkan daftar MENU UTAMA pada layar */
        System.out.println("Menu");
        System.out.println("1. Sistem Persamaan Linier");
        System.out.println("2. Determinan");
        System.out.println("3. Matriks balikan");
        System.out.println("4. Interpolasi Polinom");
        System.out.println("5. Interpolasi Bicubic");
        System.out.println("6. Regresi linier berganda");
        System.out.println("7. Keluar");
    }
    public void tampilanSubMenu1() {
        /* Menampilkan daftar SUB MENU PERTAMA pada layar */
        System.out.println("Sub menu");
        System.out.println("1. Metode eliminasi Gauss");
        System.out.println("2. Metode eliminasi Gauss-Jordan");
        System.out.println("3. Metode matriks balikan");
        System.out.println("4. Kaidah Crammer");
    }

    public void tampilanSubMenu2() {
        /* Menampilkan daftar SUB MENU KEDUA pada layar */
        System.out.println("Sub menu");
        System.out.println("1. Metode OBE");
        System.out.println("2. Ekspansi kofaktor");
    }

    public void tampilanSubMenu3() {
        /* Menampilkan daftar SUB MENU KETIGA pada layar */
        System.out.println("Sub menu");
        System.out.println("1. Metode adjoin");
        System.out.println("2. Metode Operasi Baris Elementer");
    }

    public static void batas(){
        /* Menampilkan batas berupa garis pada layar */
        System.out.println("=================================================");
        System.out.println("=================================================");
    }

}



