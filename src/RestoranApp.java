import java.util.ArrayList;
import java.util.Scanner;

class MenuItem {
    String nama;
    double harga;

    public MenuItem(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }
}

public class RestoranApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<MenuItem> menu = new ArrayList<>();

        // Tambahkan menu
        menu.add(new MenuItem("Nasi Goreng", 20000));
        menu.add(new MenuItem("Mie Ayam", 15000));
        menu.add(new MenuItem("Es Teh", 5000));
        menu.add(new MenuItem("Jus Alpukat", 12000));

        System.out.println("=== Daftar Menu Restoran ===");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i).nama + " - Rp " + menu.get(i).harga);
        }

        System.out.print("\nMasukkan nomor menu yang ingin dipesan: ");
        int pilihan = input.nextInt();
        System.out.print("Masukkan jumlah pesanan: ");
        int jumlah = input.nextInt();

        MenuItem itemDipilih = menu.get(pilihan - 1);
        double total = hitungTotal(itemDipilih.harga, jumlah);

        System.out.println("\n=== Nota Pemesanan ===");
        System.out.println("Menu      : " + itemDipilih.nama);
        System.out.println("Harga     : Rp " + itemDipilih.harga);
        System.out.println("Jumlah    : " + jumlah);
        System.out.println("Total     : Rp " + total);
        System.out.println("=======================");
    }

    // 🔹 Custom Live Template (misalnya untuk perhitungan total harga)
    // Template name: calcTotal
    // Template text:
    // double total = (${harga} * ${jumlah}) + (${harga} * ${jumlah} * 0.1);
    // Description: Rumus perhitungan total harga dengan pajak 10%

    static double hitungTotal(double harga, int jumlah) {
        double pajak = 0.1; // 10%
        double total = (harga * jumlah) + (harga * jumlah * pajak);
        return total;
    }
}
