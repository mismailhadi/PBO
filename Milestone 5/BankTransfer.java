package Ewallet;

public class BankTransfer extends Payment {
    public BankTransfer(){
        super("Bank Transfer");
    }

    @Override
    public double calculateFee(double amount) {
        return 2500.0; // Selalu kembalikan biaya tetap 2500
    }

    @Override
    public boolean validate(double amount) {
        return amount >= 10000.0; // Valid jika transfer minimal 10rb
    }
}
