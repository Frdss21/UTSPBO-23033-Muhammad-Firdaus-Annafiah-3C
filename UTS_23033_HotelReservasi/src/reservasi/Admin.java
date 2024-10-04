package reservasi;

import java.util.List;

public class Admin {
    public void tambahKamar(Hotel hotel, Kamar kamar) {
        hotel.tambahKamar(kamar);
    }

    public void hapusKamar(Hotel hotel, Kamar kamar) {
        hotel.hapusKamar(kamar);
    }

    public void tambahCustomer(List<Customer> daftarCustomer, Customer customer) {
        daftarCustomer.add(customer);
    }

    public void lihatSemuaPesanan(Hotel hotel) {
        hotel.lihatPesanan();
    }
}