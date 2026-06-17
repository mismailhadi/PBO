package Ewallet;

public class WalletTransfer extends Payment {
    public WalletTransfer(){
        super("Wallet Transfer");
    }

    @Override
    public double calculateFee(double amount) {
        return 0.0; // Selalu return 0 (Gratis)
    }

    @Override
    public boolean validate(double amount) {
        return amount > 0.0; // Valid asal nominal positif
    }
}
