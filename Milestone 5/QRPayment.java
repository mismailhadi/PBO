package Ewallet;

public class QRPayment extends Payment {
    public QRPayment(){
        super("QR Payment");
    }

    @Override
    public double calculateFee(double amount) {
        if (amount <= 100000.0) {
            return 0.0; // Di bawah atau sama dengan 100rb gratis admin
        } else {
            return amount * 0.007; // Di atas 100rb kena potongan 0.7%
        }
    }

    @Override
    public boolean validate(double amount) {
        return amount >= 1000.0; // Minimal transaksi QR 1rb
    }
}
