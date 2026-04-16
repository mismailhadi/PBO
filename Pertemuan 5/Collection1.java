import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Collection1 {
    public static void main(String[] args) {
        List<String> daftarAwal = Arrays.asList(
            "Dilan 1990", "Laskar Pelangi", "Mahaguru", "Mengejar Matahari", 
            "Dilan 1991", "Milea", "Perahu Kertas", "Laskar Pelangi", "Perahu Kertas"
        );

        Set<String> bukuTerurut = new TreeSet<>(daftarAwal);

        System.out.println("Daftar Buku:");
        int nomor = 1;
        for (String buku : bukuTerurut) {
            System.out.println(nomor + ". " + buku);
            nomor++;
        }
    }
}