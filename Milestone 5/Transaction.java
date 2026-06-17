package Ewallet;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private LocalDateTime timestamp; // waktu transaksi
    private double amount; 
    private String type; //transaksi
    private String status; 

    public Transaction(double amount, String type, String status){
        this.timestamp = LocalDateTime.now(); //menyimpan waktu saat transaksi dibuat (otomatis)
        this.amount = amount;
        this.type = type;
        this.status = status;
    }

    // Mengatur tampilan saat object dicetak
    @Override
    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = timestamp.format(formatter);
        
        return String.format("[%s] %-10s | Rp%,10.2f | Status: %s", 
        formattedDate, type, amount, status);
    }

    // Getter (mengambil data per begian)
    public double getAmount(){
        return amount; 
    }

    public String getType(){
        return type; 
    }
}
