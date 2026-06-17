package Ewallet;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User user = null;
        boolean loginValid = false;

        System.out.println("========== DIGITAL E-WALLET SYSTEM ==========");
        System.out.println("Silahkan pilih jenis akun untuk simulasi Login:");
        System.out.println("1. Regular User  (Limit Transaksi: Rp2.000.000, Cashback: 1%)");
        System.out.println("2. Premium User  (Limit Transaksi: Rp10.000.000, Cashback: 5%)");
        System.out.println("3. Merchant User (Limit Transaksi: Rp50.000.000, Cashback: 0%)");

        while (!loginValid) {
            System.out.print("Pilih jenis akun (1-3): ");
            String loginInput = scanner.nextLine();

            switch (loginInput) {
                case "1":
                    user = new RegularUser("ID-REG01", "Muhammad Ismail Hadi", "087847596587", 1500000.0);
                    loginValid = true;
                    break;
                case "2":
                    user = new PremiumUser("ID-PRM02", "Muhammad Ismail Hadi", "087847596587", 5000000.0);
                    loginValid = true;
                    break;
                case "3":
                    user = new MerchantUser("ID-MCH03", "Muhammad Ismail Hadi", "087847596587", 15000000.0);
                    loginValid = true;
                    break;
                default:
                    System.out.println("[ERROR] Pilihan tidak valid! Silahkan masukkan angka 1, 2, atau 3.");
            }
        }

        // Menggunakan method abstract baru getAccountType()
        System.out.println("\n>>> Login Berhasil sebagai " + user.getAccountType() + " <<<");
        System.out.println("Selamat datang, " + user.getNama() + "!");
        user.ewallet();

        boolean running = true;

        while (running) {
            System.out.println("\n========== MENU UTAMA E-WALLET ==========");
            System.out.println("1. Cek Saldo & Informasi Profil");
            System.out.println("2. Top Up Saldo");
            System.out.println("3. Pembayaran (Process Payment)");
            System.out.println("4. Lihat Riwayat Transaksi");
            System.out.println("5. Keluar Aplikasi");
            System.out.print("Pilih menu (1-5): ");

            String menuInput = scanner.nextLine();

            switch (menuInput) {
                case "1":
                    System.out.println("\n--- PROFIL & INFORMASI AKUN ---");
                    user.showBalance();
                    System.out.println("Limit Transaksi Akun : Rp" + user.getTransactionLimit());
                    System.out.println("Tingkat Cashback     : " + (user.getCashbackRate() * 100) + "%");
                    break;

                case "2":
                    System.out.print("Masukkan nominal Top Up: Rp");
                    try {
                        double amount = Double.parseDouble(scanner.nextLine());
                        user.topUp(amount);
                    } catch (NumberFormatException e) {
                        System.out.println("[ERROR] Input salah! Nominal Top Up harus berupa angka.");
                    }
                    break;

                case "3":
                    System.out.println("\n--- PILIH METODE PEMBAYARAN ---");
                    System.out.println("1. QR Payment");
                    System.out.println("2. Bank Transfer");
                    System.out.println("3. Wallet Transfer");
                    System.out.print("Pilih metode (1-3): ");
                    
                    String methodInput = scanner.nextLine();
                    Payment paymentMethod = null; 

                    switch (methodInput) {
                        case "1": paymentMethod = new QRPayment(); break;
                        case "2": paymentMethod = new BankTransfer(); break;
                        case "3": paymentMethod = new WalletTransfer(); break;
                        default:
                            System.out.println("[ERROR] Metode pembayaran tidak valid!");
                            continue;
                    }

                    System.out.print("Masukkan nominal Pembayaran: Rp");
                    try {
                        double amount = Double.parseDouble(scanner.nextLine());
                        user.processPayment(paymentMethod, amount);
                    } catch (NumberFormatException e) {
                        System.out.println("[ERROR] Input salah! Nominal pembayaran harus berupa angka.");
                    }
                    break;

                case "4":
                    System.out.println("\n--- RIWAYAT TRANSAKSI ---");
                    user.showTransactionHistory();
                    break;

                case "5":
                    System.out.println("Terima kasih telah menggunakan layanan E-Wallet kami. Sampai jumpa!");
                    running = false;
                    break;

                default:
                    System.out.println("[ERROR] Menu tidak tersedia!");
                    break;
            }
            
            if (running) {
                System.out.println("----------------------------------------");
            }
        }
        scanner.close();
    }
}