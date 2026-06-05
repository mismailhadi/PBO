package abstrak;

public class Sepeda extends Kendaraan {
    private boolean isAuto;

    // Constructor
    public Sepeda(boolean isAuto) {
        this.isAuto = isAuto;
    }

    public void jenis() {
        if (isAuto) {
            System.out.println("Sepeda otomatis");
        } else {
            System.out.println("Sepeda kayuh");
        }
    }

    // Mengimplementasikan abstract method dari Kendaraan.java
    @Override
    public void nyalakan() {
        if (isAuto) {
            System.out.println("Mesin sepeda otomatis dinyalakan.");
        } else {
            System.out.println("Sepeda siap dikayuh.");
        }
    }
}