package abstrak;

public class MainSepeda {
    public static void main(String[] args) {
        Sepeda sepedaKu = new Sepeda(false); // Mengatur isAuto menjadi false
        sepedaKu.jenis();
        sepedaKu.nyalakan();
    }
}