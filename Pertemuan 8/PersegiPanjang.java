public class PersegiPanjang extends BangunDatar {
    float panjang;
    float lebar;

    // Constructor
    public PersegiPanjang(float panjang, float lebar) {
        this.panjang = panjang;
        this.lebar = lebar;
    }

    @Override
    public float luas() {
        return panjang * lebar;
    }
}