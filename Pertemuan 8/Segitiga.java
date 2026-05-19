public class Segitiga extends BangunDatar {
    float alas;
    float tinggi;

    // Constructor
    public Segitiga(float alas, float tinggi) {
        this.alas = alas;
        this.tinggi = tinggi;
    }

    @Override
    public float luas() {
        return (alas * tinggi) / 2;
    }
}