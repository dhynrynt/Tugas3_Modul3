import java.util.Scanner;

class Room {
    private String type;
    private int pricePerNight;

    public Room(String type, int pricePerNight) {
        this.type = type;
        this.pricePerNight = pricePerNight;
    }

    public String getType() {
        return type;
    }

    public int getPricePerNight() {
        return pricePerNight;
    }
}

class Booking {
    private String customerName;
    private Room room;
    private int nights;

    public Booking(String customerName, Room room, int nights) {
        this.customerName = customerName;
        this.room = room;
        this.nights = nights;
    }

    public int calculateTotal() {
        return room.getPricePerNight() * nights;
    }

    public void printReceipt() {
        System.out.println("\n=== STRUK PEMESANAN ===");
        System.out.println("Nama Pelanggan : " + customerName);
        System.out.println("Tipe Kamar     : " + room.getType());
        System.out.println("Harga/Malam    : Rp" + room.getPricePerNight());
        System.out.println("Lama Menginap  : " + nights + " malam");
        System.out.println("Total Bayar    : Rp" + calculateTotal());
        System.out.println("Terima kasih telah memesan di hotel kami!");
    }
}

// === Class utama untuk menjalankan program ===
public class HotelBookingAfter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== SISTEM PEMESANAN KAMAR HOTEL ===");
        System.out.print("Masukkan nama pelanggan: ");
        String nama = input.nextLine();

        // Gunakan array untuk menyimpan tipe kamar
        Room[] rooms = {
                new Room("Standar", 300000),
                new Room("Deluxe", 500000),
                new Room("Suite", 800000)
        };

        System.out.println("\nPilih tipe kamar:");
        for (int i = 0; i < rooms.length; i++) {
            System.out.println((i + 1) + ". " + rooms[i].getType() + " - Rp" + rooms[i].getPricePerNight() + "/malam");
        }

        int pilihan;
        do {
            System.out.print("Masukkan pilihan (1-3): ");
            pilihan = input.nextInt();
        } while (pilihan < 1 || pilihan > 3);

        System.out.print("Masukkan jumlah malam menginap: ");
        int malam = input.nextInt();

        Room kamarDipilih = rooms[pilihan - 1];
        Booking pesanan = new Booking(nama, kamarDipilih, malam);
        pesanan.printReceipt();
    }

}

