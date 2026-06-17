package Ewallet;

public class RegularUser extends User implements Cashback {
    private double limitTransaksi = 2000000;

    public RegularUser(String UserId, String nama, String phone, double balance){
        super(UserId, nama, phone, balance);
    }

    // Mengisi abstract method wajib dari class User
    @Override
    public void ewallet() {
        System.out.println("Status Fitur: E-Wallet Aktif (Tipe Akun: Regular User)");
    }

    @Override
    public double getCashbackRate() {
        return 0.01; // Cashback 1%
    }

    @Override
    public double getTransactionLimit() {
        return 2000000.0; // Limit 2 Juta
    }

    // Mengisi abstract method baru
    @Override
    public String getAccountType() {
        return "Regular User";
    }
}
