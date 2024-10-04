package reservasi;

public class Kamar {
    private final int nomor;
    private final int lantai;
    private final String tipe;
    private boolean tersedia;

    private static final int HARGA_REGULER = 100000;
    private static final int HARGA_VIP = 250000;

    public Kamar(int nomor, int lantai, String tipe) {
        this.nomor = nomor;
        this.lantai = lantai;
        this.tipe = tipe;
        this.tersedia = true;
    }

    public int getNomor() {
        return nomor;
    }

    public int getLantai() {
        return lantai;
    }

    public String getTipe() {
        return tipe;
    }

    public boolean isTersedia() {
        return tersedia;
    }

    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }

    public int getHargaPerMalam() {
        return "VIP".equalsIgnoreCase(tipe) ? HARGA_VIP : HARGA_REGULER;
    }

    @Override
    public String toString() {
        return "Kamar " + nomor + " di lantai " + lantai + " (" + tipe + ")";
    }
}