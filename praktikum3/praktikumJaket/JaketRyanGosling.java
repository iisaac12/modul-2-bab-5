package praktikum3.praktikumJaket;

import java.util.Scanner;

public class JaketRyanGosling {
    //seperti yang telah diperintahkan, berikut adalah implementasi variabelnya
    private static final int hargaJaketSigma_A = 100000;
    private static final int hargaJaketSigma_B = 125000;
    private static final int hargaJaketSigma_C = 175000;

    public int hargaJaketSigma (String tipe, int jumlah){
        int hargaPerJaket = 0;//saya mengisi variabel tersebut dengan 0, sebagai nilai awal

        //toUpperCase ini mengabaikan case sensitive
        switch (tipe.toUpperCase()) {
            case "A":
            //kalo tipe A dibeli lebih dari 100 buah, maka harga per jaketnya akan dipotong 5000
                if (jumlah > 100) {
                    hargaPerJaket = 95000;
                } else {
                    //kalo yang dibeli kurang dari 100, maka variabel hargaPerJaket akan diisi oleh variabel final hargaJaketSigma_A
                    hargaPerJaket = hargaJaketSigma_A;
                }
                break;
            
            case "B":
            //kalo tipe B dibeli lebih dari 100 buah, maka harga per jaketnya akan dipotong 5000
                if (jumlah > 100){
                    hargaPerJaket = 120000;
                } else {
                    //kalo yang dibeli kurang dari 100, maka variabel hargaPerJaket akan diisi oleh variabel final hargaJaketSigma_B
                    hargaPerJaket = hargaJaketSigma_B;
                }
                break;

            case "C":
            //kalo tipe C dibeli lebih dari 100 buah, maka harga per jaketnya akan dipotong 5000
                if (jumlah > 100){
                    hargaPerJaket = 160000;
                } else {
                    //kalo yang dibeli kurang dari 100, maka variabel hargaPerJaket akan diisi oleh variabel final hargaJaketSigma_C
                    hargaPerJaket = hargaJaketSigma_C;
                }
                break;
            default:
                System.out.println("Jenis Jaket Ryan Gosling kamu tidak ada!");
                return 0;
        }
        //ini adalah perhitungan total harga jaket
        return hargaPerJaket * jumlah;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //ini adalah inisialisasi atau pembuatan objek jaket untuk dapat mengakses method" yang ada di class JaketRyanGosling
        JaketRyanGosling jaket = new JaketRyanGosling();
        System.out.println("==============================================================================");
        System.out.println("Selamat datangg di Jaket Ryan Gosling, toko  jaket paling SIGMA di Indonesia!");
        System.out.println("==============================================================================");

        while (true) {
            System.out.println("Kamu ingin memilih jenis jaket sigma yang apa?");
            System.out.println("A. Jaket Sigma A");
            System.out.println("B. Jaket Sigma B");
            System.out.println("C. Jaket Sigma C");
            System.out.println("X. Keluar");
            System.out.print("Pilihan kamu: ");
            String pilihan = input.nextLine();

            if (pilihan.equalsIgnoreCase("X")) break;

            System.out.print("Masukkan jumlah jaket yang ingin kamu beli: ");
            int jumlah = input.nextInt();
            input.nextLine();

            int totalHarga = jaket.hargaJaketSigma(pilihan, jumlah);
            System.out.println("==============================================================================");
            System.out.println("Total harga yang harus kamu bayar adalah Rp. " + totalHarga);
            System.out.println("==============================================================================");
        }
        System.out.println("============================================================================================");
        System.out.println("Terima kasih sudah berbelanja di Jaket Ryan Gosling, toko  jaket paling SIGMA di Indonesia!");
        System.out.println("============================================================================================");
        input.close();
    }
}
