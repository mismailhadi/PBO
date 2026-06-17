package Ewallet;

public class MerchantUser extends User {
    private double limitTransaksi = 50000000;

    public MerchantUser(String UserId, String nama, String phone, double balance){
        super(UserId, nama, phone, balance);
    }

    // Mengisi abstract method wajib dari class User
    @Override
    public void ewallet() {
        System.out.println("Status Fitur: E-Wallet Bisnis Aktif (Tipe Akun: Merchant User)");
    }

    @Override
    public double getCashbackRate() {
        return 0.0; // Merchant tidak dapat cashback
    }

    @Override
    public double getTransactionLimit() {
        return 50000000.0; // Limit 50 Juta
    }

    // Mengisi abstract method baru
    @Override
    public String getAccountType() {
        return "Merchant User";
    }
}
