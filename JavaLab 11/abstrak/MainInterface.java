package abstrak;

public class MainInterface {
    public static void main(String[] args) {
        // a. Mendefinisikan objek kotak (panjang = 4, lebar = 5)
        Kotak kotakKu = new Kotak(4, 5);

        // b. Cetak luas dan keliling objek sebelum diubah
        System.out.println("=== Sebelum Resize ===");
        System.out.println("Luas Kotak: " + kotakKu.getLuas());
        System.out.println("Keliling Kotak: " + kotakKu.getKeliling());

        // c. Ubah ukuran panjang dan lebar sebesar 2x
        kotakKu.resize(2.0);

        // d. Cetak kembali luas dan keliling objek setelah diubah
        System.out.println("\n=== Setelah Resize (2x) ===");
        System.out.println("Luas Kotak: " + kotakKu.getLuas());
        System.out.println("Keliling Kotak: " + kotakKu.getKeliling());
    }
}