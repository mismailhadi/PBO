package Ewallet;

import java.util.ArrayList;
import java.util.List;

public abstract class User {
    private String userId;
    private String nama;
    private String phone;
    private double balance;
    private List<Transaction> transactions; // daftar riwayat transaksi

    public User(String userId, String nama, String phone, double balance) {
        this.userId = userId;
        this.nama = nama;
        this.phone = phone;
        this.balance = balance;
        this.transactions = new ArrayList<>(); //menyimpan daftar riwayat transaksi
    }

    // User jadi abstract method
    public abstract void ewallet();

    // Diubah menjadi abstract method
    public abstract double getTransactionLimit();
    public abstract String getAccountType(); // Method baru penanda tipe akun
    public abstract double getCashbackRate();

    // GETTER 
    public String getUserId() {
        return userId;
    }

    public String getNama() { // mengambil data dari atribut private harus lewat method
        return nama;           
    }

    public String getPhone() {
        return phone;
    }

    public double getBalance() { 
        return balance;
    }

    // SETTER
    public void setNama(String nama) { // mengubah nilai atribut
        this.nama = nama;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // TOP UP
    public void topUp(double amount) { // mencatat riwayat topup
        if (amount > 0) {
            balance += amount;
            transactions.add(new Transaction(amount, "TOP UP", "SUCCESS")); 
            System.out.println("Top up Rp" + amount + " berhasil. Saldo sekarang: Rp" + balance);
        } else {
            transactions.add(new Transaction(amount, "TOP UP", "FAILED"));
            System.out.println("[ERROR] Nominal harus lebih dari 0!");
        }
    }

    // PAY 
    public void pay(double amount) throws SaldoKurangException {
        if (amount <= 0) {
            transactions.add(new Transaction(amount, "PAY", "FAILED"));
            System.out.println("[ERROR] Nominal harus lebih dari 0!"); 
            return;
        } 
        // Menggunakan SaldoKurangException jika saldo tidak cukup
        if (amount > balance) {
            transactions.add(new Transaction(amount, "PAY", "FAILED"));
            throw new SaldoKurangException("[ERROR TRANSACTION] Saldo tidak cukup! Transaksi dibatalkan.");
        }
        balance -= amount;
        transactions.add(new Transaction(amount, "PAY", "SUCCESS"));
        System.out.println("Pembayaran Rp" + amount + " berhasil. Sisa saldo: Rp" + balance);
    }

    // PROCESS PAYMENT
    public void processPayment(Payment p, double amount) {
        System.out.println("\n--- Memproses " + p.getMethodName() + " ---");

        if (!p.validate(amount)) {
            System.out.println("[ERROR] Transaksi tidak valid! Nominal tidak memenuhi syarat " + p.getMethodName());
            return;
        }

        if (amount > getTransactionLimit()) {
            System.out.println("[ERROR] Transaksi gagal! Melebihi limit akun Anda (Maks: Rp" + getTransactionLimit() + ")");
            return;
        }

        double fee = p.calculateFee(amount);
        double totalBill = amount + fee;

        System.out.println("Nominal Belanja : Rp" + amount);
        System.out.println("Biaya Admin     : Rp" + fee);
        System.out.println("Total Tagihan   : Rp" + totalBill);

        double saldoSebelum = this.balance;
        
        // Menangkap exception saat pemanggilan method pay
        try {
            pay(totalBill);
            
            // Jika berhasil lolos proses pay (saldo berkurang)
            if (this.balance < saldoSebelum) {
                double cashback = amount * getCashbackRate();
                if (cashback > 0) {
                    System.out.println("\n[BONUS] Anda berhak mendapatkan cashback!");
                    topUp(cashback);
                }
            }
        } catch (SaldoKurangException e) {
            System.out.println(e.getMessage());
        }
    }

    // Menampilkan profile 
    public void showBalance() {
        System.out.println("User ID : " + userId);
        System.out.println("Nama    : " + nama);
        System.out.println("Phone   : " + phone);
        System.out.println("Balance : Rp" + balance);
    }

    // menampilkan semua Riwayat Transaksi 
    public void showTransactionHistory() {
        if (transactions.isEmpty()) {
            System.out.println("Belum ada transaksi.");
        } else {
            for (Transaction t : transactions) {
                System.out.println(t);
            }
        }
    }
}