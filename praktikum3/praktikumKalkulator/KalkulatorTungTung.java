package praktikum3.praktikumKalkulator;
import java.util.*;
public class KalkulatorTungTung {
   
    public static void Penjumlahan (int a, int b){
        //method ini static
        //method ini merupakan penjumlahan dua buah bilangan yakni variabel a dan b
        int nilai = a + b;
        System.out.println("Hasil penjumlahan kedua bilangan tersebut adalah " + nilai);
        
    }

    public static void Pengurangan (int a, int b){
        //yang ini method static jadi tidak perlu diinisiasi
        //method ini merupakan pengurangan dua buah variabel a dan b
        int nilai = a - b;
        System.out.println("Hasil pengurangan kedua bilangan tersebut adalah " + nilai);

    }

    public double Perkalian (double a, double b){
        //method ini merupakan perkalian dua buah bilangan yakni variabel a dan b
        //method ini bertipe non-statiic, jadi harus diinisiasi pake objek. Method di bawah juga non-static
        double nilai = a * b;
        System.out.println("Hasil perkalian kedua bilangan tersebut adalah " + nilai);
        return nilai;
        
    }

    public double Pembagian (double a, double b){
        //method ini merupakan pembagian dua bua bilangan yakni variabel a dan be
        //kalo penyebutnya 0, seperti yang kita ketahui maka hasilnnya adalah tidak terdefinisi
        if (b == 0){
            System.out.println("Hasilnya tidak terdefinisi. Masukkan angka selain 0!");
            return 0;
        //klo penyebutnya ga sama dengan 0,  maka hasilnya adalah a / b. Oiya hasilnya itu dalam bentuk decimal
        } else {
            double nilai = a / b;
            System.out.printf("Hasil pembagian kedua bilangan tersebut adalah %.2f \n", nilai);
            return nilai;
        }
    }

    public double Sederhana (double a, double b){
        if (b == 0){
            System.out.println("Hasilnya tidak terdefinisi. Masukkan angka selain 0!");
            return 0;
        }

        //memanggil method fpb
        double fpb = fpb((int) a, (int) b);//mengubah tipe data a dan b menjadi integer. Karena modulus hanya bisa diaplikasikan pada integer
        
        //menyederhanakan pecahan dengan membagi variabel a dan b dengan fpb kemudian menyimpan ke masing-masing variabel
        double pembilangBaru = a / fpb;
        double penyebutBaru = b / fpb;

        System.out.println("Hasil pecahan yang telah disederhanakan adalah " + (int) pembilangBaru + "/" + (int) penyebutBaru);
        return pembilangBaru / penyebutBaru;
    }

    //ini adalah method yang digunakan untuk mencari FPB menggunakan metode Euclidean
    //metode Euclidean adalah algoritma yang pake modulus, jadi kayak mengurangi bilangan secara berulang sampe ketemu FPB nya (sisanya 0). Saya gabisa terlalu ngejelasinnya, saya kasih contoh aja
    //48 mod 18 = 12
    //18 mod 12 = 6
    //12 mod 6 = 0
    //jadi FPB nya adalah 6
    //kenapa saya ga pake faktorisasi (konsep pohon)? sebenarnya bisa-bisa aja, tapi kalo pake faktorisasi
    //sekalinya ketemu bilangan yang besar, maka tidaklah efisien 
    private int fpb (int x, int y){
        // Loop berjalan hingga sisa pembagian (modulus) menjadi 0
        while (y != 0) {//loop berjalan sampe y = 0
            int temp = y;// Simpan nilai y sementara
            y = x % y;// Hitung sisa pembagian x oleh y
            x = temp;//memperbarui nilai x dengan nilai y yang baru
        }
        return x;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        //ini adalah inisialisasi untuk class KalkulatorTungTung agar dapat menggunakan method bertipe non-static
        KalkulatorTungTung oyii = new KalkulatorTungTung();

        while (true) {
            System.out.println("============================================");
            System.out.println("Pilih operasi matematika yang kamu inginkan");
            System.out.println("1. Penjumlahan");
            System.out.println("2. Pengurangan");
            System.out.println("3. Perkalian");
            System.out.println("4. Pembagian");
            System.out.println("5. Keluar");
            System.out.print("Pilihan kamu: ");
            int pilihan = input.nextInt();

            if (pilihan == 5) break;
            
            switch (pilihan) {
                case 1:
                    System.out.println("====================================================");
                    System.out.print("Masukkan bilangan pertama: ");
                    int a = input.nextInt();
                    System.out.print("Masukkan bilangan kedua: ");
                    int b = input.nextInt();
                    
                    //memanggil method bertipe static
                    KalkulatorTungTung.Penjumlahan(a, b);
                    System.out.println("====================================================");
                    break;
                
                case 2:
                    System.out.println("====================================================");
                    System.out.print("Masukkan bilangan pertama: ");
                    a = input.nextInt();
                    System.out.print("Masukkan bilangan kedua: ");
                    b = input.nextInt();
                    
                    //memanggil method bertipe static
                    KalkulatorTungTung.Pengurangan(a, b);
                    System.out.println("====================================================");
                    break;

                case 3: 
                    System.out.println("====================================================");
                    System.out.print("Masukkan bilangan pertama: ");
                    a = input.nextInt();
                    System.out.print("Masukkan bilangan kedua: ");
                    b = input.nextInt();
                    
                    //oyii merupakan objek yang saya gunakan sebagai inisialisasi untuk class KalkulatorTungTung yang memiliki method Perkalian bertipe non-static
                    oyii.Perkalian(a, b);
                    System.out.println("====================================================");
                    break;

                case 4: 
                    System.out.println("====================================================");
                    System.out.print("Masukkan bilangan pertama: ");
                    a = input.nextInt();
                    System.out.print("Masukkan bilangan kedua: ");
                    b = input.nextInt();
                    
                    //oyii merupakan objek yang saya gunakan sebagai inisialisasi untuk class KalkulatorTungTung yang memiliki method Pembagian bertipe non-static
                    oyii.Pembagian(a, b);

                    //saya membuat while loop agar user dapat memilih apakah user ingin menyederhanakan hasil pembagian atau tidak
                    while (true) {
                        System.out.println("Apakah kamu ingin menyederhanakan pecahan tersebut? ");
                        System.out.println("1. Ya");
                        System.out.println("2. Tidak");
                        System.out.print("Pilihan Kamu: ");
                        int pilihan1 = input.nextInt();
                        
                        //klo user pilih 1, maka pecahan tersebut akan disederhanakan, misal 18/4 menjadi 9/2
                        if (pilihan1 == 1) {
                            oyii.Sederhana(a, b);
                            break;
                        } else{
                            System.out.println("Baiklah, noted, siap, dimengerti!");
                            break;
                        }
                    }
                    System.out.println("====================================================");
                    break;

                default:
                    System.out.println("Pilihan tidak tersedia");
                    break;
            }
            
        }
        input.close();
        System.out.println("====================================================");
        System.out.println("Terima kasih sudah menggunakan Kalkulator Tung Tung!");
        System.out.println("====================================================");
    }
}
