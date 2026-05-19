public class OverloadMain {
    // Main method utama 
    public static void main(String[] args) {
        System.out.println("Main method utama dijalankan.");

        // Memanggil method main yang di-overload
        main(2026);
        main("Muhammad Ismail Hadi", "A11.2024.15632");
    }

    // Overload main method dengan parameter int
    public static void main(int tahun) {
        System.out.println("Overloaded main dipanggil, Tahun: " + tahun);
    }

    // Overload main method dengan parameter string
    public static void main(String nama, String nim) {
        System.out.println("Overloaded main dipanggil, Mahasiswa: " + nama + " | NIM: " + nim);
    }
}