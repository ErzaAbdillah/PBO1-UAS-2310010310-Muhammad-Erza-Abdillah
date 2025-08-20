// ===== 8. INHERITANCE - Class turunan dari Pegawai =====
class PegawaiTetap extends Pegawai {
    private double tunjanganJabatan;
    private double tunjanganKeluarga;
    
    // ===== 4. CONSTRUCTOR - Constructor untuk PegawaiTetap =====
    public PegawaiTetap(String nip, String nama, int umur, String alamat, 
                       double gajiPokok, double tunjanganJabatan, double tunjanganKeluarga) {
        super(nip, nama, umur, alamat, gajiPokok); // memanggil constructor parent class
        this.tunjanganJabatan = tunjanganJabatan;
        this.tunjanganKeluarga = tunjanganKeluarga;
    }
    
    // ===== 6. ACCESSOR - Getter untuk tunjangan =====
    public double getTunjanganJabatan() {
        return tunjanganJabatan;
    }
    
    public double getTunjanganKeluarga() {
        return tunjanganKeluarga;
    }
    
    // ===== 5. MUTATOR - Setter untuk tunjangan =====
    public void setTunjanganJabatan(double tunjanganJabatan) {
        this.tunjanganJabatan = tunjanganJabatan;
    }
    
    public void setTunjanganKeluarga(double tunjanganKeluarga) {
        this.tunjanganKeluarga = tunjanganKeluarga;
    }
    
    // ===== 9. POLYMORPHISM - Implementasi method abstract dari parent class =====
    @Override
    public double hitungGajiTotal() {
        return gajiPokok + tunjanganJabatan + tunjanganKeluarga;
    }
    
    @Override
    public String getJabatan() {
        return "Pegawai Tetap";
    }
}
