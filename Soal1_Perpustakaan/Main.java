
import java.util.Scanner;
 
/**
 * Program pengelolaan daftar buku perpustakaan menggunakan Single Linked List.
 */
public class Main {
    static final int MIN_BUKU = 5;       // jumlah data minimal
    static final int MAX_KODE = 5;       // panjang maksimal kodeBuku
 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList daftar = new LinkedList();
        int pilihan = 0;
 
        do {
            System.out.println("\n===== SISTEM DATA BUKU =====");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Cari Buku");
            System.out.println("4. Lihat Semua Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
 
            // Validasi input menu harus berupa angka
            try {
                pilihan = Integer.parseInt(input.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid, masukkan angka 1-5.");
                pilihan = 0;
                continue;
            }
 
            switch (pilihan) {
                case 1:
                    tambahBuku(input, daftar);
                    break;
                case 2:
                    if (daftar.pop()) {
                        System.out.println("Buku terakhir berhasil dihapus!");
                    } else {
                        System.out.println("Tidak ada data untuk dihapus.");
                    }
                    break;
                case 3:
                    cariBuku(input, daftar);
                    break;
                case 4:
                    daftar.tampilkan();
                    if (daftar.getSize() < MIN_BUKU) {
                        System.out.println("(Catatan: data minimal " + MIN_BUKU
                                + " buku, saat ini baru " + daftar.getSize() + ")");
                    }
                    break;
                case 5:
                    System.out.println("Terima kasih. Program selesai.");
                    break;
                default:
                    System.out.println("Menu tidak tersedia, pilih 1-5.");
            }
        } while (pilihan != 5);
 
        input.close();
    }
 
    // Menu 1: input data buku dengan validasi kode maksimal 5 karakter
    static void tambahBuku(Scanner input, LinkedList daftar) {
        String kode;
        while (true) {
            System.out.print("Masukkan Kode Buku: ");
            kode = input.nextLine().trim();
            if (kode.isEmpty()) {
                System.out.println("Kode buku tidak boleh kosong.");
            } else if (kode.length() > 5) {
                System.out.println("Kode buku maksimal " + 5 + " karakter!");
            } else if (daftar.cari(kode) != null) {
                System.out.println("Kode buku sudah digunakan!");
            } else {
                break;
            }
        }
        System.out.print("Masukkan Judul: ");
        String judul = input.nextLine().trim();
        System.out.print("Masukkan Penulis: ");
        String penulis = input.nextLine().trim();
 
        daftar.push(kode, judul, penulis);
        System.out.println("Data berhasil ditambahkan!");
    }
 
    // Menu 3: cari buku berdasarkan kode
    static void cariBuku(Scanner input, LinkedList daftar) {
        System.out.print("Masukkan Kode Buku yang dicari: ");
        String kode = input.nextLine().trim();
        Node hasil = daftar.cari(kode);
        if (hasil != null) {
            System.out.println("Buku ditemukan:");
            System.out.println("Kode: " + hasil.kodeBuku + " | Judul: " + hasil.judul
                    + " | Penulis: " + hasil.penulis);
        } else {
            System.out.println("Buku tidak ditemukan.");
        }
    }
}

