import java.util.Scanner;

// c. Menambahkan subclass baru dari BangunDatar
class Lingkaran extends BangunDatar {
    double r;

    public Lingkaran(double r) {
        this.r = r;
    }

    @Override
    public float luas() {
        return (float) (Math.PI * r * r);
    }
}

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // a. Membuat Scanner untuk input panjang, lebar, dan tinggi
        System.out.println("Masukkan Panjang:");
        float panjang = scanner.nextFloat();

        System.out.println("Masukkan Lebar:");
        float lebar = scanner.nextFloat();

        // Mengasumsikan objek PersegiPanjang sudah dibuat
        PersegiPanjang persegiPanjang = new PersegiPanjang(panjang, lebar);
        System.out.println("Luas Persegi panjang adalah " + persegiPanjang.luas());

        System.out.println("Masukkan Panjang (Alas):");
        float alas = scanner.nextFloat();

        System.out.println("Masukkan Tinggi:");
        float tinggi = scanner.nextFloat();

        // b. Pemanggilan method untuk menampilkan luas segitiga
        Segitiga segitiga = new Segitiga(alas, tinggi);
        System.out.println("Luas Segitiga siku-siku adalah " + segitiga.luas());

        // c. Memanggil objek dari subclass yang baru dibuat
        System.out.println("Masukkan Jari-jari lingkaran:");
        float jariJari = scanner.nextFloat();
        Lingkaran lingkaran = new Lingkaran(jariJari);
        System.out.println("Luas Lingkaran adalah " + lingkaran.luas());

        scanner.close();
    }
}