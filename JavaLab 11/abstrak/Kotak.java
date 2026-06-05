package abstrak;

// Implements Resizeable
public class Kotak extends BangunDatar implements Resizeable {
    public double panjang;
    public double lebar;

    public Kotak(double panjang, double lebar) {
        super(4);
        this.panjang = panjang;
        this.lebar = lebar;
    }

    @Override
    public void draw() { System.out.println("Menggambar Kotak"); }

    // Method resize() bawaan dari abstract class BangunDatar
    @Override
    public void resize() { }

    // Method resize(double x) dari interface Resizeable
    @Override
    public void resize(double x) {
        this.panjang = this.panjang * x;
        this.lebar = this.lebar * x;
    }

    @Override
    public double getLuas() { return panjang * lebar; }

    @Override
    public double getKeliling() { return 2 * (panjang + lebar); }
}