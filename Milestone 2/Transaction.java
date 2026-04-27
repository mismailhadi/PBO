package Ewallet;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private LocalDateTime timestamp;
    private double amount;
    private String type;
    private String status;

    public Transaction(double amount, String type, String status){
        this.timestamp = LocalDateTime.now();
        this.amount = amount;
        this.type = type;
        this.status = status;
    }

    // Method untuk memudahkan pencetakan riwayat ke terminal
    @Override
    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = timestamp.format(formatter);
        
        return String.format("[%s] %-10s | Rp%,10.2f | Status: %s", 
        formattedDate, type, amount, status);
    }

    // Getter (Opsional, jika ingin mengambil data per kolom)
    public double getAmount(){
        return amount; 
    }

    public String getType(){
        return type; 
    }
}
