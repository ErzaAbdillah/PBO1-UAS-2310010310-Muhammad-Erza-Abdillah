// ===== 1. CLASS - Class utama untuk menjalankan program =====
import java.util.Scanner;
import java.util.ArrayList;

public class SistemManajemenPNS {
    // ===== 13. ARRAY - Menggunakan ArrayList untuk menyimpan data pegawai =====
    private static ArrayList<Pegawai> daftarPegawai = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        // Menambahkan data contoh
        inisialisasiData();
        
        int pilihan;
        
        // ===== 11. PERULANGAN - Do-while loop untuk menu utama =====
        do {
            tampilkanMenu();
            pilihan = inputPilihan();
            prosesMenu(pilihan);
        } while (pilihan != 5);
        
        System.out.println("Terima kasih telah menggunakan Sistem Manajemen PNS!");
        input.close();
    }
    
    // Method untuk inisialisasi data contoh
    private static void inisialisasiData() {
        // ===== 2. OBJECT - Membuat instance dari class =====
        daftarPegawai.add(new PegawaiTetap("12345", "Budi Santoso", 35, "Jakarta", 5000000, 1500000, 500000));
        daftarPegawai.add(new PegawaiKontrak("67890", "Siti Aminah", 28, "Bandung", 4000000, 12, 300000));
        daftarPegawai.add(new PegawaiTetap("11111", "Ahmad Wijaya", 42, "Surabaya", 6000000, 2000000, 750000));
    }
    
    // Method untuk menampilkan menu
    private static void tampilkanMenu() {
        System.out.println("\n=== SISTEM MANAJEMEN PNS ===");
        System.out.println("1. Tambah Pegawai");
        System.out.println("2. Tampilkan Semua Pegawai");
        System.out.println("3. Cari Pegawai");
        System.out.println("4. Statistik Gaji");
        System.out.println("5. Keluar");
        System.out.print("Pilih menu (1-5): ");
    }
    
    // ===== 14. ERROR HANDLING - Menangani input yang tidak valid =====
    private static int inputPilihan() {
        try {
            return Integer.parseInt(input.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid! Masukkan angka 1-5.");
            return 0; // Nilai default untuk pilihan tidak valid
        }
    }
    
    // ===== 10. SELEKSI - Switch-case untuk memproses pilihan menu =====
    private static void prosesMenu(int pilihan) {
        switch (pilihan) {
            case 1:
                tambahPegawai();
                break;
            case 2:
                tampilkanSemuaPegawai();
                break;
            case 3:
                cariPegawai();
                break;
            case 4:
                tampilkanStatistikGaji();
                break;
            case 5:
                System.out.println("Keluar dari program...");
                break;
            default:
                System.out.println("Pilihan tidak valid! Silakan pilih 1-5.");
        }
    }
    
    // ===== 12. IO SEDERHANA - Input dan output data pegawai =====
    private static void tambahPegawai() {
        System.out.println("\n=== TAMBAH PEGAWAI ===");
        
        try {
            System.out.print("Masukkan NIP: ");
            String nip = input.nextLine();
            
            // Validasi NIP tidak boleh kosong dan harus unik
            if (nip.trim().isEmpty()) {
                System.out.println("NIP tidak boleh kosong!");
                return;
            }
            
            // ===== 11. PERULANGAN - For-each loop untuk cek duplikasi NIP =====
            for (Pegawai p : daftarPegawai) {
                if (p.getNip().equals(nip)) {
                    System.out.println("NIP sudah ada dalam sistem!");
                    return;
                }
            }
            
            System.out.print("Masukkan Nama: ");
            String nama = input.nextLine();
            
            System.out.print("Masukkan Umur: ");
            int umur = Integer.parseInt(input.nextLine());
            
            // ===== 10. SELEKSI - Validasi umur =====
            if (umur < 18 || umur > 60) {
                System.out.println("Umur harus antara 18-60 tahun!");
                return;
            }
            
            System.out.print("Masukkan Alamat: ");
            String alamat = input.nextLine();
            
            System.out.print("Masukkan Gaji Pokok: ");
            double gajiPokok = Double.parseDouble(input.nextLine());
            
            System.out.print("Jenis Pegawai (1=Tetap, 2=Kontrak): ");
            int jenis = Integer.parseInt(input.nextLine());
            
            // ===== 10. SELEKSI - If-else untuk menentukan jenis pegawai =====
            if (jenis == 1) {
                System.out.print("Masukkan Tunjangan Jabatan: ");
                double tunjanganJabatan = Double.parseDouble(input.nextLine());
                
                System.out.print("Masukkan Tunjangan Keluarga: ");
                double tunjanganKeluarga = Double.parseDouble(input.nextLine());
                
                // ===== 2. OBJECT - Membuat object PegawaiTetap =====
                daftarPegawai.add(new PegawaiTetap(nip, nama, umur, alamat, gajiPokok, 
                                                  tunjanganJabatan, tunjanganKeluarga));
                System.out.println("Pegawai tetap berhasil ditambahkan!");
                
            } else if (jenis == 2) {
                System.out.print("Masukkan Masa Kontrak (bulan): ");
                int masaKontrak = Integer.parseInt(input.nextLine());
                
                System.out.print("Masukkan Bonus Kinerja: ");
                double bonusKinerja = Double.parseDouble(input.nextLine());
                
                // ===== 2. OBJECT - Membuat object PegawaiKontrak =====
                daftarPegawai.add(new PegawaiKontrak(nip, nama, umur, alamat, gajiPokok, 
                                                    masaKontrak, bonusKinerja));
                System.out.println("Pegawai kontrak berhasil ditambahkan!");
                
            } else {
                System.out.println("Jenis pegawai tidak valid!");
            }
            
        } catch (NumberFormatException e) {
            // ===== 14. ERROR HANDLING - Menangani input angka yang tidak valid =====
            System.out.println("Format input salah! Pastikan memasukkan angka yang benar.");
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
    
    // Method untuk menampilkan semua pegawai
    private static void tampilkanSemuaPegawai() {
        System.out.println("\n=== DAFTAR SEMUA PEGAWAI ===");
        
        // ===== 10. SELEKSI - Cek apakah daftar kosong =====
        if (daftarPegawai.isEmpty()) {
            System.out.println("Tidak ada data pegawai.");
            return;
        }
        
        // ===== 11. PERULANGAN - For loop dengan index untuk menampilkan data =====
        for (int i = 0; i < daftarPegawai.size(); i++) {
            System.out.println("\n--- Pegawai ke-" + (i + 1) + " ---");
            // ===== 9. POLYMORPHISM - Pemanggilan method yang sama dengan implementasi berbeda =====
            daftarPegawai.get(i).tampilkanInfo();
        }
    }
    
    // Method untuk mencari pegawai berdasarkan NIP
    private static void cariPegawai() {
        System.out.println("\n=== CARI PEGAWAI ===");
        System.out.print("Masukkan NIP yang dicari: ");
        String nipCari = input.nextLine();
        
        boolean ditemukan = false;
        
        // ===== 11. PERULANGAN - Enhanced for loop untuk pencarian =====
        for (Pegawai pegawai : daftarPegawai) {
            // ===== 10. SELEKSI - Pengecekan kesamaan NIP =====
            if (pegawai.getNip().equalsIgnoreCase(nipCari)) {
                System.out.println("\nPegawai ditemukan:");
                pegawai.tampilkanInfo();
                ditemukan = true;
                break;
            }
        }
        
        if (!ditemukan) {
            System.out.println("Pegawai dengan NIP " + nipCari + " tidak ditemukan.");
        }
    }
    
    // Method untuk menampilkan statistik gaji
    private static void tampilkanStatistikGaji() {
        System.out.println("\n=== STATISTIK GAJI ===");
        
        if (daftarPegawai.isEmpty()) {
            System.out.println("Tidak ada data pegawai.");
            return;
        }
        
        double totalGaji = 0;
        double gajiTertinggi = 0;
        double gajiTerendah = Double.MAX_VALUE;
        int jumlahPegawaiTetap = 0;
        int jumlahPegawaiKontrak = 0;
        
        // ===== 11. PERULANGAN - For-each loop untuk perhitungan statistik =====
        for (Pegawai pegawai : daftarPegawai) {
            double gaji = pegawai.hitungGajiTotal();
            totalGaji += gaji;
            
            // ===== 10. SELEKSI - Mencari gaji tertinggi =====
            if (gaji > gajiTertinggi) {
                gajiTertinggi = gaji;
            }
            
            // ===== 10. SELEKSI - Mencari gaji terendah =====
            if (gaji < gajiTerendah) {
                gajiTerendah = gaji;
            }
            
            // ===== 9. POLYMORPHISM - instanceof untuk mengecek tipe object =====
            if (pegawai instanceof PegawaiTetap) {
                jumlahPegawaiTetap++;
            } else if (pegawai instanceof PegawaiKontrak) {
                jumlahPegawaiKontrak++;
            }
        }
        
        double rataRataGaji = totalGaji / daftarPegawai.size();
        
        // ===== 12. IO SEDERHANA - Output statistik =====
        System.out.println("Total Pegawai: " + daftarPegawai.size());
        System.out.println("Pegawai Tetap: " + jumlahPegawaiTetap);
        System.out.println("Pegawai Kontrak: " + jumlahPegawaiKontrak);
        System.out.println("Total Gaji Keseluruhan: Rp " + String.format("%,.0f", totalGaji));
        System.out.println("Rata-rata Gaji: Rp " + String.format("%,.0f", rataRataGaji));
        System.out.println("Gaji Tertinggi: Rp " + String.format("%,.0f", gajiTertinggi));
        System.out.println("Gaji Terendah: Rp " + String.format("%,.0f", gajiTerendah));
    }
}