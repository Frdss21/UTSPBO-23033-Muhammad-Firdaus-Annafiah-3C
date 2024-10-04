package reservasi;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private final List<Kamar> daftarKamar;
    private final List<Pesanan> daftarPesanan;

    public Hotel() {
        daftarKamar = new ArrayList<>();
        daftarPesanan = new ArrayList<>();
    }
    
    public void tambahKamar(Kamar kamar) {
        daftarKamar.add(kamar);
    }

    public Kamar cariKamar(int nomor, int lantai) {
        for (Kamar kamar : daftarKamar) {
            if (kamar.getNomor() == nomor && kamar.getLantai() == lantai) {
                return kamar;
            }
        }
        return null;
    }

    public void tambahPesanan(Pesanan pesanan) {
        daftarPesanan.add(pesanan);
    }

    public void batalkanPesanan(Pesanan pesanan) {
        if (daftarPesanan.remove(pesanan)) {
            Kamar kamar = (Kamar) pesanan.getKamar();
            if (kamar != null) {
                kamar.setTersedia(true);
            }
        }
    }

    public List<Pesanan> getDaftarPesanan() {
        return daftarPesanan;
    }

    public void lihatPesanan() {
        if (daftarPesanan.isEmpty()) {
            System.out.println("Belum ada pesanan.");
            return;
        }
        
        for (int i = 0; i < daftarPesanan.size(); i++) {
            Pesanan pesanan = daftarPesanan.get(i);
            System.out.println((i + 1) + ". " + pesanan);
        }
    }

    void hapusKamar(Kamar kamar) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}