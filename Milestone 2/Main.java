package Ewallet;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //ambil input dari user

        // Inisialisasi User
        User user = new User("ID-001", "Muhammad Ismail Hadi", "087847596587", 0);

        boolean running = true; //program terus jalan saat true

        while (running) {
            System.out.println("\n========== E-WALLET MENU ==========");
            System.out.println("1. Cek Saldo & Profil");
            System.out.println("2. Top Up");
            System.out.println("3. Pembayaran (Pay)");
            System.out.println("4. Riwayat Transaksi");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");

            String input = scanner.nextLine(); //input dibaca sebagai string kemudian konversi ke int

            switch (input) {

                case "1":
                    System.out.println("\n--- Profil User ---");
                    user.showBalance();
                    break;

                case "2":
                    System.out.print("Masukkan nominal Top Up: ");
                    try {
                        double amount = Double.parseDouble(scanner.nextLine());

                        if (amount <= 0) {
                            System.out.println("[ERROR] Nominal harus lebih dari 0!");
                        } else {
                            user.topUp(amount); //otomatis buat Transaction
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("[ERROR] Input harus berupa angka!");
                    }
                    break;

                case "3":
                    System.out.print("Masukkan nominal Pembayaran: ");
                    try {
                        double amount = Double.parseDouble(scanner.nextLine());

                        if (amount <= 0) {
                            System.out.println("[ERROR] Nominal harus lebih dari 0!");
                        } else {
                            user.pay(amount); //otomatis validasi saldo + transaction
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("[ERROR] Input harus berupa angka!");
                    }
                    break;

                case "4":
                    System.out.println("\n--- Riwayat Transaksi ---");
                    user.showTransactionHistory();
                    break;

                case "5":
                    System.out.println("Terima kasih telah menggunakan E-Wallet!");
                    running = false;
                    break;

                default:
                    System.out.println("[ERROR] Menu tidak tersedia. Pilih 1-5!");
                    break;
            }

            if (running) {
                System.out.println("-----------------------------------");
            }
        }

        scanner.close();
    }
}
