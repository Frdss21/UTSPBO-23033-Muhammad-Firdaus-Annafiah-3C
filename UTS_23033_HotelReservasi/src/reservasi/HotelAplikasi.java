package reservasi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelAplikasi {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        List<Customer> daftarCustomer = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Selamat datang di aplikasi reservasi hotel!");

            for (int i = 1; i <= 10; i++) {
                hotel.tambahKamar(new Kamar(i, 1, "Reguler"));
            }
            for (int i = 1; i <= 5; i++) {
                hotel.tambahKamar(new Kamar(i, 2, "VIP"));
            }

            boolean selesai = false;
            while (!selesai) {
                System.out.println("\n=== Menu Utama ===");
                System.out.println("1. Tambah Kamar");
                System.out.println("2. Tambah Customer");
                System.out.println("3. Pesan Kamar");
                System.out.println("4. Batalkan Pesanan");
                System.out.println("5. Lihat Daftar Pesanan");
                System.out.println("6. Lihat Riwayat Pemesanan Customer");
                System.out.println("7. Keluar");
                System.out.print("Masukkan pilihan: ");
                
                int pilihan;
                try {
                    pilihan = scanner.nextInt();
                } catch (Exception e) {
                    System.out.println("Input tidak valid. Silakan masukkan angka.");
                    scanner.nextLine(); 
                    continue;
                }

                scanner.nextLine(); 

                switch (pilihan) {
                    case 1 -> {
                        // Tambah kamar baru
                        System.out.print("Masukkan lantai kamar: ");
                        int lantai = scanner.nextInt();
                        System.out.print("Masukkan nomor kamar: ");
                        int nomor = scanner.nextInt();
                        scanner.nextLine(); // Membersihkan buffer
                        System.out.print("Masukkan tipe kamar (Reguler/VIP): ");
                        String tipe = scanner.nextLine();
                        
                        hotel.tambahKamar(new Kamar(nomor, lantai, tipe));
                        System.out.println("Kamar berhasil ditambahkan.");
                    }

                    case 2 -> {
                        // Tambah customer baru
                        System.out.print("Masukkan nama depan customer: ");
                        String namaDepan = scanner.nextLine();
                        System.out.print("Masukkan nama belakang customer: ");
                        String namaBelakang = scanner.nextLine();

                        daftarCustomer.add(new Customer(namaDepan, namaBelakang));
                        System.out.println("Customer berhasil ditambahkan.");
                    }

                    case 3 -> {
                        // Pesan kamar
                        if (daftarCustomer.isEmpty()) {
                            System.out.println("Belum ada customer yang terdaftar. Silakan tambahkan customer terlebih dahulu.");
                        } else {
                            System.out.println("Daftar Customer:");
                            for (int i = 0; i < daftarCustomer.size(); i++) {
                                System.out.println((i + 1) + ". " + daftarCustomer.get(i).getNamaLengkap());
                            }
                            System.out.print("Pilih nomor customer: ");
                            int nomorCustomer = scanner.nextInt();
                            scanner.nextLine();

                            if (nomorCustomer > 0 && nomorCustomer <= daftarCustomer.size()) {
                                Customer customerDipilih = daftarCustomer.get(nomorCustomer - 1);
                                System.out.println("Halo, " + customerDipilih.getNamaLengkap() + "!");

                                System.out.print("Masukkan lantai kamar yang ingin dipesan: ");
                                int lantai = scanner.nextInt();
                                System.out.print("Masukkan nomor kamar yang ingin dipesan: ");
                                int nomorKamar = scanner.nextInt();
                                scanner.nextLine();

                                Kamar kamarDipilih = hotel.cariKamar(nomorKamar, lantai);
                                if (kamarDipilih != null && kamarDipilih.isTersedia()) {
                                    System.out.print("Berapa malam Anda akan menginap? ");
                                    int malam = scanner.nextInt();
                                    scanner.nextLine(); 

                                    customerDipilih.pesanKamar(hotel, kamarDipilih, malam);
                                    int totalBiaya = kamarDipilih.getHargaPerMalam() * malam;
                                    System.out.println("Pesanan berhasil dibuat untuk kamar: " + kamarDipilih);
                                    System.out.println("Total biaya: Rp " + totalBiaya);
                                } else {
                                    System.out.println("Kamar tidak tersedia atau tidak ditemukan.");
                                }
                            } else {
                                System.out.println("Nomor customer tidak valid.");
                            }
                        }
                    }

                    case 4 -> {
                        // Batalkan pesanan
                        if (hotel.getDaftarPesanan().isEmpty()) {
                            System.out.println("Belum ada pesanan yang dibuat.");
                        } else {
                            System.out.println("Daftar Pesanan:");
                            hotel.lihatPesanan();
                            System.out.print("Masukkan nomor pesanan yang ingin dibatalkan: ");
                            int nomorPesanan = scanner.nextInt();
                            scanner.nextLine(); 

                            if (nomorPesanan > 0 && nomorPesanan <= hotel.getDaftarPesanan().size()) {
                                Pesanan pesananDibatalkan = hotel.getDaftarPesanan().get(nomorPesanan - 1);
                                System.out.print("Masukkan alasan pembatalan: ");
                                String alasan = scanner.nextLine();
                                pesananDibatalkan.setAlasanPembatalan(alasan);
                                hotel.batalkanPesanan(pesananDibatalkan);
                                System.out.println("Pesanan berhasil dibatalkan.");
                            } else {
                                System.out.println("Nomor pesanan tidak valid.");
                            }
                        }
                    }

                    case 5 -> {
                        // Lihat daftar pesanan
                        hotel.lihatPesanan();
                    }

                    case 6 -> {
                        // Lihat riwayat pemesanan customer
                        if (daftarCustomer.isEmpty()) {
                            System.out.println("Belum ada customer yang terdaftar.");
                        } else {
                            System.out.println("Daftar Customer:");
                            for (int i = 0; i < daftarCustomer.size(); i++) {
                                System.out.println((i + 1) + ". " + daftarCustomer.get(i).getNamaLengkap());
                            }
                            System.out.print("Pilih nomor customer: ");
                            int nomorCustomer = scanner.nextInt();
                            scanner.nextLine();

                            if (nomorCustomer > 0 && nomorCustomer <= daftarCustomer.size()) {
                                Customer customerDipilih = daftarCustomer.get(nomorCustomer - 1);
                                customerDipilih.lihatRiwayatPesanan();
                            } else {
                                System.out.println("Nomor customer tidak valid.");
                            }
                        }
                    }

                    case 7 -> {
                        // Keluar dari aplikasi
                        System.out.println("Terima kasih telah menggunakan aplikasi reservasi hotel.");
                        selesai = true;
                    }

                    default -> System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                }
            }
        }
    }
}