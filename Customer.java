package reservasi;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String namaDepan;
    private final String namaBelakang;
    private final List<Pesanan> riwayatPesanan;

    public Customer(String namaDepan, String namaBelakang) {
        this.namaDepan = namaDepan;
        this.namaBelakang = namaBelakang;
        this.riwayatPesanan = new ArrayList<>();
    }

    public String getNamaLengkap() {
        return namaDepan + " " + namaBelakang;
    }

    public void pesanKamar(Hotel hotel, Kamar kamar, int malam) {
        Pesanan pesanan = new Pesanan(kamar, this, malam);
        hotel.tambahPesanan(pesanan);
        kamar.setTersedia(false);
        riwayatPesanan.add(pesanan); 
    }

    public void lihatRiwayatPesanan() {
        if (riwayatPesanan.isEmpty()) {
            System.out.println("Belum ada riwayat pemesanan.");
        } else {
            System.out.println("Riwayat Pesanan:");
            for (Pesanan pesanan : riwayatPesanan) {
                System.out.println(pesanan);
            }
        }
    }
}