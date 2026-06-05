package abstrak;

public class MainBangunDatar {
    public static void main(String[] args) {
        Kotak k = new Kotak(5, 4);
        System.out.println("Luas Kotak: " + k.getLuas());
        System.out.println("Keliling Kotak: " + k.getKeliling());

        System.out.println("-----------------");

        Segitiga s = new Segitiga(3, 4);
        System.out.println("Luas Segitiga: " + s.getLuas());
        System.out.println("Keliling Segitiga: " + s.getKeliling());
    }
}