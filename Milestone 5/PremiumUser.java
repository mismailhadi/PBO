package Ewallet;

public class PremiumUser extends User implements Cashback {
    private double limitTransaksi = 10000000;

    public PremiumUser(String UserId, String nama, String phone, double balance){
        super(UserId, nama, phone, balance);
    }

    // Mengisi abstract method wajib dari class User
    @Override
    public void ewallet() {
        System.out.println("Status Fitur: E-Wallet VIP Aktif (Tipe Akun: Premium User)");
    }

    @Override
    public double getCashbackRate() {
        return 0.05; // Cashback 5%
    }

    @Override
    public double getTransactionLimit() {
        return 10000000.0; // Limit 10 Juta
    }

    // Mengisi abstract method baru
    @Override
    public String getAccountType() {
        return "Premium User";
    }
}