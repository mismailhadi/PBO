package Ewallet;

// Abstract class tambahan untuk fitur voucher belanja
public abstract class Promo {
    protected String namaPromo;
    protected double minimalBelanja;

    public Promo(String namaPromo, double minimalBelanja) {
        this.namaPromo = namaPromo;
        this.minimalBelanja = minimalBelanja;
    }

    public String getNamaPromo() {
        return namaPromo;
    }

    // Abstract method yang harus diisi oleh jenis promo spesifik
    public abstract double hitungDiskon(double amount);
}
