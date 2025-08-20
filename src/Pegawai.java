// ===== 1. CLASS - Kelas induk untuk semua pegawai =====
abstract class Pegawai {
    // ===== 3. ATRIBUT - Properti yang dimiliki oleh class =====
    // ===== 7. ENCAPSULATION - Menggunakan modifier private untuk menyembunyikan data =====
    private String nip;
    private String nama;
    private int umur;
    private String alamat;
    protected double gajiPokok; // protected agar bisa diakses oleh subclass
    
    // ===== 4. CONSTRUCTOR - Method khusus untuk inisialisasi object =====
    public Pegawai(String nip, String nama, int umur, String alamat, double gajiPokok) {
        this.nip = nip;
        this.nama = nama;
        this.umur = umur;
        this.alamat = alamat;
        this.gajiPokok = gajiPokok;
    }
    
    // ===== 6. ACCESSOR - Method untuk mengambil nilai atribut (getter) =====
    public String getNip() {
        return nip;
    }
    
    public String getNama() {
        return nama;
    }
    
    public int getUmur() {
        return umur;
    }
    
    public String getAlamat() {
        return alamat;
    }
    
    public double getGajiPokok() {
        return gajiPokok;
    }
    
    // ===== 5. MUTATOR - Method untuk mengubah nilai atribut (setter) =====
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public void setUmur(int umur) {
        this.umur = umur;
    }
    
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    public void setGajiPokok(double gajiPokok) {
        this.gajiPokok = gajiPokok;
    }
    
    // ===== 9. POLYMORPHISM - Method abstract yang harus diimplementasi oleh subclass =====
    public abstract double hitungGajiTotal();
    public abstract String getJabatan();
    
    // Method untuk menampilkan informasi pegawai
    public void tampilkanInfo() {
        System.out.println("NIP: " + nip);
        System.out.println("Nama: " + nama);
        System.out.println("Umur: " + umur);
        System.out.println("Alamat: " + alamat);
        System.out.println("Gaji Pokok: Rp " + String.format("%,.0f", gajiPokok));
        System.out.println("Jabatan: " + getJabatan());
        System.out.println("Gaji Total: Rp " + String.format("%,.0f", hitungGajiTotal()));
    }
}