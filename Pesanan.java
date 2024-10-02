package reservasi;

public class Pesanan {
    private Kamar kamar;
    private Customer customer;
    private int durasi;
    private String alasanPembatalan;

    public Pesanan(Kamar kamar, Customer customer, int durasi) {
        this.kamar = kamar;
        this.customer = customer;
        this.durasi = durasi;
        this.alasanPembatalan = null;
    }

    public Kamar getKamar() {
        return kamar;
    }

    public void setAlasanPembatalan(String alasan) {
        this.alasanPembatalan = alasan;
    }

    @Override
    public String toString() {
        return "Pesanan: " + customer.getNamaLengkap() + " - Kamar: " + kamar.toString() + " untuk " + durasi + " malam." +
               (alasanPembatalan != null ? " (Dibatalkan: " + alasanPembatalan + ")" : "");
    }
}