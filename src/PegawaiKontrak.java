// ===== 8. INHERITANCE - Class turunan lainnya dari Pegawai =====
class PegawaiKontrak extends Pegawai {
    private int masaKontrak; // dalam bulan
    private double bonusKinerja;
    
    // ===== 4. CONSTRUCTOR - Constructor untuk PegawaiKontrak =====
    public PegawaiKontrak(String nip, String nama, int umur, String alamat, 
                         double gajiPokok, int masaKontrak, double bonusKinerja) {
        super(nip, nama, umur, alamat, gajiPokok);
        this.masaKontrak = masaKontrak;
        this.bonusKinerja = bonusKinerja;
    }
    
    // ===== 6. ACCESSOR - Getter untuk masa kontrak dan bonus =====
    public int getMasaKontrak() {
        return masaKontrak;
    }
    
    public double getBonusKinerja() {
        return bonusKinerja;
    }
    
    // ===== 5. MUTATOR - Setter untuk masa kontrak dan bonus =====
    public void setMasaKontrak(int masaKontrak) {
        this.masaKontrak = masaKontrak;
    }
    
    public void setBonusKinerja(double bonusKinerja) {
        this.bonusKinerja = bonusKinerja;
    }
    
    // ===== 9. POLYMORPHISM - Implementasi method abstract dari parent class =====
    @Override
    public double hitungGajiTotal() {
        return gajiPokok + bonusKinerja;
    }
    
    @Override
    public String getJabatan() {
        return "Pegawai Kontrak (" + masaKontrak + " bulan)";
    }
}