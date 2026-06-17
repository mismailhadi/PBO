package Ewallet;

public class VoucherBelanja extends Promo {
    private double besarDiskon;

    public VoucherBelanja(String namaPromo, double minimalBelanja, double besarDiskon) {
        super(namaPromo, minimalBelanja);
        this.besarDiskon = besarDiskon;
    }

    @Override
    public double hitungDiskon(double amount) {
        if (amount >= minimalBelanja) {
            return besarDiskon;
        }
        return 0.0;
    }
}
