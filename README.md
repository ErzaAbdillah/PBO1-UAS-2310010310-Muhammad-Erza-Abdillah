# Proyek Akhir Pemrograman Berbasis Objek 1

Proyek ini adalah aplikasi Sistem Manajemen PNS (Pegawai Negeri Sipil) menggunakan Java sebagai tugas akhir dari mata kuliah pemrograman berbasis objek 1.

## Deskripsi

Aplikasi ini adalah sistem manajemen untuk mengelola data PNS yang terdiri dari pegawai tetap dan pegawai kontrak. Aplikasi menyediakan fitur untuk menambah pegawai, menampilkan semua pegawai, mencari pegawai berdasarkan NIP, dan menampilkan statistik gaji.

Aplikasi ini mengimplementasikan beberapa konsep penting dalam pemrograman berorientasi objek (OOP) seperti Class, Object, Atribut, Method Constructor, Method Mutator, Method Accessor, Encapsulation, Inheritance, Polymorphism, Seleksi, Perulangan, IO Sederhana, Array, dan Error Handling.

## Penjelasan Kode

Berikut adalah bagian kode yang relevan dengan konsep OOP yang dijelaskan:

1. **Class** adalah template atau blueprint dari object. Pada kode ini, `Pegawai`, `PegawaiTetap`, `PegawaiKontrak`, dan `SistemManajemenPNS` adalah contoh dari class.

```java
public abstract class Pegawai {
    ...
}

public class PegawaiTetap extends Pegawai {
    ...
}

public class PegawaiKontrak extends Pegawai {
    ...
}

public class SistemManajemenPNS {
    ...
}
```

2. **Object** adalah instance dari class. Pada kode ini, pembuatan object pegawai adalah contoh implementasinya.

```java
daftarPegawai.add(new PegawaiTetap("12345", "Budi Santoso", 35, "Jakarta", 5000000, 1500000, 500000));
daftarPegawai.add(new PegawaiKontrak("67890", "Siti Aminah", 28, "Bandung", 4000000, 12, 300000));
```

3. **Atribut** adalah variabel yang ada dalam class. Pada kode ini, `nip`, `nama`, `umur`, `alamat`, `gajiPokok` adalah contoh atribut.

```java
private String nip;
private String nama;
private int umur;
private String alamat;
protected double gajiPokok;
```

4. **Constructor** adalah method yang pertama kali dijalankan pada saat pembuatan object. Pada kode ini, constructor ada di dalam class `Pegawai`, `PegawaiTetap`, dan `PegawaiKontrak`.

```java
public Pegawai(String nip, String nama, int umur, String alamat, double gajiPokok) {
    this.nip = nip;
    this.nama = nama;
    this.umur = umur;
    this.alamat = alamat;
    this.gajiPokok = gajiPokok;
}

public PegawaiTetap(String nip, String nama, int umur, String alamat, 
                   double gajiPokok, double tunjanganJabatan, double tunjanganKeluarga) {
    super(nip, nama, umur, alamat, gajiPokok);
    this.tunjanganJabatan = tunjanganJabatan;
    this.tunjanganKeluarga = tunjanganKeluarga;
}
```

5. **Mutator** atau setter digunakan untuk mengubah nilai dari suatu atribut. Pada kode ini, `setNama`, `setUmur`, `setAlamat` adalah contoh method mutator.

```java
public void setNama(String nama) {
    this.nama = nama;
}

public void setUmur(int umur) {
    this.umur = umur;
}

public void setAlamat(String alamat) {
    this.alamat = alamat;
}
```

6. **Accessor** atau getter digunakan untuk mengambil nilai dari suatu atribut. Pada kode ini, `getNama`, `getNip`, `getUmur`, `getAlamat`, `getGajiPokok` adalah contoh method accessor.

```java
public String getNama() {
    return nama;
}

public String getNip() {
    return nip;
}

public int getUmur() {
    return umur;
}
```

7. **Encapsulation** adalah konsep menyembunyikan data dengan membuat atribut menjadi private dan hanya bisa diakses melalui method. Pada kode ini, atribut `nip`, `nama`, `umur`, `alamat` dienkapsulasi dan hanya bisa diakses melalui method getter dan setter.

```java
private String nip;
private String nama;
private int umur;
private String alamat;
protected double gajiPokok; // protected agar bisa diakses oleh subclass
```

8. **Inheritance** adalah konsep di mana sebuah class bisa mewarisi property dan method dari class lain. Pada kode ini, `PegawaiTetap` dan `PegawaiKontrak` mewarisi `Pegawai` dengan sintaks `extends`.

```java
class PegawaiTetap extends Pegawai {
    ...
}

class PegawaiKontrak extends Pegawai {
    ...
}
```

9. **Polymorphism** adalah konsep di mana sebuah nama dapat digunakan untuk merujuk ke beberapa tipe atau bentuk objek berbeda. Pada kode ini, method abstract `hitungGajiTotal()` dan `getJabatan()` diimplementasi secara berbeda di setiap subclass, dan penggunaan `instanceof` untuk mengecek tipe object.

```java
// Method abstract di parent class
public abstract double hitungGajiTotal();
public abstract String getJabatan();

// Implementasi berbeda di PegawaiTetap
@Override
public double hitungGajiTotal() {
    return gajiPokok + tunjanganJabatan + tunjanganKeluarga;
}

// Implementasi berbeda di PegawaiKontrak
@Override
public double hitungGajiTotal() {
    return gajiPokok + bonusKinerja;
}

// Penggunaan instanceof
if (pegawai instanceof PegawaiTetap) {
    jumlahPegawaiTetap++;
} else if (pegawai instanceof PegawaiKontrak) {
    jumlahPegawaiKontrak++;
}
```

10. **Seleksi** adalah statement kontrol yang digunakan untuk membuat keputusan berdasarkan kondisi. Pada kode ini, digunakan seleksi `if-else`, `switch-case`, dan validasi kondisi.

```java
// If-else untuk validasi umur
if (umur < 18 || umur > 60) {
    System.out.println("Umur harus antara 18-60 tahun!");
    return;
}

// Switch-case untuk memproses pilihan menu
switch (pilihan) {
    case 1:
        tambahPegawai();
        break;
    case 2:
        tampilkanSemuaPegawai();
        break;
    default:
        System.out.println("Pilihan tidak valid!");
}
```

11. **Perulangan** adalah statement kontrol yang digunakan untuk menjalankan blok kode berulang kali. Pada kode ini, digunakan `do-while`, `for`, dan `for-each` loop.

```java
// Do-while loop untuk menu utama
do {
    tampilkanMenu();
    pilihan = inputPilihan();
    prosesMenu(pilihan);
} while (pilihan != 5);

// For loop dengan index
for (int i = 0; i < daftarPegawai.size(); i++) {
    System.out.println("\n--- Pegawai ke-" + (i + 1) + " ---");
    daftarPegawai.get(i).tampilkanInfo();
}

// For-each loop untuk pencarian
for (Pegawai pegawai : daftarPegawai) {
    if (pegawai.getNip().equalsIgnoreCase(nipCari)) {
        pegawai.tampilkanInfo();
        ditemukan = true;
        break;
    }
}
```

12. **Input Output Sederhana** digunakan untuk menerima input dari user dan menampilkan output ke user. Pada kode ini, digunakan class `Scanner` untuk menerima input dan method `System.out.println` untuk menampilkan output.

```java
Scanner input = new Scanner(System.in);
System.out.print("Masukkan NIP: ");
String nip = input.nextLine();

System.out.print("Masukkan Nama: ");
String nama = input.nextLine();

System.out.println("=== DAFTAR SEMUA PEGAWAI ===");
pegawai.tampilkanInfo();
```

13. **Array** adalah struktur data yang digunakan untuk menyimpan beberapa nilai dalam satu variabel. Pada kode ini, menggunakan `ArrayList` untuk menyimpan koleksi object pegawai.

```java
private static ArrayList<Pegawai> daftarPegawai = new ArrayList<>();

// Menambah data ke ArrayList
daftarPegawai.add(new PegawaiTetap("12345", "Budi Santoso", 35, "Jakarta", 5000000, 1500000, 500000));

// Akses data dari ArrayList
daftarPegawai.get(i).tampilkanInfo();
```

14. **Error Handling** digunakan untuk menangani error yang mungkin terjadi saat runtime. Pada kode ini, digunakan `try-catch` untuk menangani `NumberFormatException` dan exception lainnya.

```java
private static int inputPilihan() {
    try {
        return Integer.parseInt(input.nextLine());
    } catch (NumberFormatException e) {
        System.out.println("Input tidak valid! Masukkan angka 1-5.");
        return 0;
    }
}

try {
    int umur = Integer.parseInt(input.nextLine());
    double gajiPokok = Double.parseDouble(input.nextLine());
} catch (NumberFormatException e) {
    System.out.println("Format input salah! Pastikan memasukkan angka yang benar.");
} catch (Exception e) {
    System.out.println("Terjadi kesalahan: " + e.getMessage());
}
```

## Fitur Aplikasi

1. **Tambah Pegawai** - Menambahkan data pegawai baru (tetap/kontrak) dengan validasi input
2. **Tampilkan Semua Pegawai** - Menampilkan daftar lengkap semua pegawai dengan informasi detail
3. **Cari Pegawai** - Mencari pegawai berdasarkan NIP tertentu
4. **Statistik Gaji** - Menampilkan statistik seperti total gaji, rata-rata, gaji tertinggi dan terendah
5. **Validasi Input** - Sistem validasi untuk memastikan data yang dimasukkan valid
6. **Error Handling** - Penanganan error untuk input yang tidak sesuai format

## Usulan Nilai

| No  | Materi         |  Nilai  |
| :-: | -------------- | :-----: |
|  1  | Class          |    5    |
|  2  | Object         |    5    |
|  3  | Atribut        |    5    |
|  4  | Constructor    |    5    |
|  5  | Mutator        |    5    |
|  6  | Accessor       |    5    |
|  7  | Encapsulation  |    5    |
|  8  | Inheritance    |    5    |
|  9  | Polymorphism   |   10    |
| 10  | Seleksi        |    5    |
| 11  | Perulangan     |    5    |
| 12  | IO Sederhana   |   10    |
| 13  | Array          |   15    |
| 14  | Error Handling |   15    |
|     | **TOTAL**      | **100** |


## Pembuat

Nama: Muhammad Erza Abdillah 
NPM: 2310010310  
Mata Kuliah: Pemrograman Berbasis Objek 1

Link Youtube Video:  https://youtu.be/LV8Gk0fLMcM
