import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AntrianPasien antrian = new AntrianPasien();
        QueueTransaksi transaksiQueue = new QueueTransaksi(100);
        int pilihan;
        do {
            System.out.println("=== SISTEM ANTRIAN KLINIK ===");
            System.out.println("1. Tambah Pasien ke Antrian");
            System.out.println("2. Lihat Antrian");
            System.out.println("3. Layani Pasien");
            System.out.println("4. Cek Sisa Antrian Pasien");
            System.out.println("5. Lihat Riwayat Transaksi");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Nama Pasien : " );
                    String nama = sc.nextLine();
                    System.out.print("NIK : ");
                    String nik = sc.nextLine();
                    System.out.print("Keluhan : ");
                    String keluhan = sc.nextLine();
                    Pasien p = new Pasien(nama, nik, keluhan);
                    antrian.tambahPasien(p);
                    break;

                case 2:
                    System.out.println("-- Antrian Pasien --");
                    System.out.println("Antrian Pasien:");
                    antrian.tampilkanAntrian();
                    break;

                case 3:
                    Pasien dilayani = antrian.layaniPasien();
                    if (dilayani == null) {
                        System.out.println(">> Tidak ada pasien dalam antrian.");
                        break;
                    }
                    System.out.println("Pasien " + dilayani.nama + " dipanggil");
                    System.out.print("Masukkan ID Dokter: ");
                    String idDokter = sc.nextLine();
                    System.out.print("Masukkan Nama Dokter: ");
                    String namaDokter = sc.nextLine();
                    System.out.print("Masukkan Durasi Layanan (jam): ");
                    int durasi = sc.nextInt();
                    sc.nextLine();
                    Dokter dokter = new Dokter(idDokter, namaDokter);
                    TransaksiLayanan transaksi = new TransaksiLayanan(dilayani, dokter, durasi);
                    transaksiQueue.enqueue(transaksi);
                    System.out.println(">> Pasien telah dilayani, transaksi berhasil dicatat.");
                    break;

                case 4:
                    System.out.println(">> Sisa pasien dalam antrian: " + antrian.jumlahPasien());
                    break;

                case 5:
                    transaksiQueue.tampilkantransaksi();
                    break;

                case 0:
                    System.out.println("Keluar dari program.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
            System.out.println();
        } while (pilihan != 0);
    }
}