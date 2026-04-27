package Ewallet;

import java.util.ArrayList;
import java.util.List;

class User {
    private String userId;
    private String nama;
    private String phone;
    private double balance;
    private List<Transaction> transactions; // WAJIB

    public User(String userId, String nama, String phone, double balance) {
        this.userId = userId;
        this.nama = nama;
        this.phone = phone;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    // ===== GETTER =====
    public String getUserId() {
        return userId;
    }

    public String getNama() {
        return nama;
    }

    public String getPhone() {
        return phone;
    }

    public double getBalance() { // FIX
        return balance;
    }

    // ===== SETTER =====
    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // ===== TOP UP =====
    public void topUp(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add(new Transaction(amount, "TOP UP", "SUCCESS"));
            System.out.println("Top up Rp" + amount + " berhasil. Saldo sekarang: Rp" + balance);
        } else {
            transactions.add(new Transaction(amount, "TOP UP", "FAILED"));
            System.out.println("[ERROR] Nominal harus lebih dari 0!");
        }
    }

    // ===== PAY =====
    public void pay(double amount) {
        if (amount <= 0) {
            transactions.add(new Transaction(amount, "PAY", "FAILED"));
            System.out.println("[ERROR] Nominal harus lebih dari 0!");
        } else if (amount > balance) {
            transactions.add(new Transaction(amount, "PAY", "FAILED"));
            System.out.println("[ERROR] Saldo tidak cukup!");
        } else {
            balance -= amount;
            transactions.add(new Transaction(amount, "PAY", "SUCCESS"));
            System.out.println("Pembayaran Rp" + amount + " berhasil. Sisa saldo: Rp" + balance);
        }
    }

    // ===== SHOW PROFILE =====
    public void showBalance() {
        System.out.println("User ID : " + userId);
        System.out.println("Nama    : " + nama);
        System.out.println("Phone   : " + phone);
        System.out.println("Balance : Rp" + balance);
    }

    // ===== RIWAYAT TRANSAKSI =====
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