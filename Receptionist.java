package reservasi;

public class Receptionist extends Admin {
    public void lihatRiwayatCustomer(Customer customer) {
        customer.lihatRiwayatPesanan();
    }
}