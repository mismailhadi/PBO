package waktu;

public class Hi {
    int number1;
    int number2;

    Hi(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    // bertipe function
    int kali() {
        int c;
        c = number1 * number2;
        return c;
    }

    void cetak() {
        System.out.println("Angka 1: " + number1);
        System.out.println("Angka 2: " + number2);
    }
}
