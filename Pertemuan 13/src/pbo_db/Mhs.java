package pbo_db;

public class Mhs {
    private String nim, nama;
    private double uts, uas, tugas;

    public Mhs(String nim, String nama, double uts, double uas, double tugas) {
        this.nim = nim; this.nama = nama;
        this.uts = uts; this.uas = uas; this.tugas = tugas;
    }

    public double getAkhir() { return (uts * 0.35) + (uas * 0.35) + (tugas * 0.30); }
    
    public char getHuruf(double akhir) {
        if (akhir >= 85) return 'A';
        else if (akhir >= 70) return 'B';
        else return 'C';
    }
    
    public String getPredikat(char h) {
        return (h == 'A') ? "Apik" : (h == 'B') ? "Baik" : "Cukup";
    }
}