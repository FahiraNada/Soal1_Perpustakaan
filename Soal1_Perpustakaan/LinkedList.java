/**
 * Single Linked List untuk menyimpan data buku.
 * Operasi: tambah di akhir (push), hapus node terakhir (pop), cari, dan tampil.
 */
public class LinkedList {
    private Node head; // node pertama
    private int size;  // jumlah buku saat ini

    public LinkedList() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    // Tambah buku di AKHIR daftar
    public void push(String kodeBuku, String judul, String penulis) {
        Node baru = new Node(kodeBuku, judul, penulis);
        if (head == null) {
            head = baru; // daftar kosong: node baru menjadi head
        } else {
            Node bantu = head;
            while (bantu.next != null) { // telusuri sampai node terakhir
                bantu = bantu.next;
            }
            bantu.next = baru;
        }
        size++;
    }

    // Hapus buku TERAKHIR. Mengembalikan false jika daftar kosong
    public boolean pop() {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            head = null; // hanya ada satu node
        } else {
            Node bantu = head;
            while (bantu.next.next != null) { // berhenti di node sebelum terakhir
                bantu = bantu.next;
            }
            bantu.next = null; // putus node terakhir
        }
        size--;
        return true;
    }

    // Cari buku berdasarkan kode (tidak membedakan huruf besar/kecil)
    public Node cari(String kodeBuku) {
        Node bantu = head;
        while (bantu != null) {
            if (bantu.kodeBuku.equalsIgnoreCase(kodeBuku)) {
                return bantu;
            }
            bantu = bantu.next;
        }
        return null; // tidak ditemukan
    }

    // Tampilkan semua buku sesuai urutan input
    public void tampilkan() {
        if (head == null) {
            System.out.println("Daftar buku masih kosong.");
            return;
        }
        System.out.println("Daftar Buku:");
        Node bantu = head;
        while (bantu != null) {
            System.out.println("Kode: " + bantu.kodeBuku + " | Judul: " + bantu.judul
                    + " | Penulis: " + bantu.penulis);
            bantu = bantu.next;
        }
        System.out.println("Total Buku: " + size);
    }
}