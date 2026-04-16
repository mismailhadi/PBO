import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Collection2 {
    public static void main(String[] args) {
        List<String> daftarAwal = Arrays.asList(
            "Dilan 1990", "Laskar Pelangi", "Mahaguru", "Mengejar Matahari", 
            "Dilan 1991", "Milea", "Perahu Kertas", "Laskar Pelangi", "Perahu Kertas"
        );
        Set<String> bukuTerurut = new TreeSet<>(daftarAwal);

        System.out.println("Daftar Buku secara Urut:");
        int nomor = 1;
        for (String buku : bukuTerurut) {
            System.out.println(nomor + ". " + buku);
            nomor++;
        }
        System.out.println();

        String bukuDipinjam = "Mahaguru";
        
        if (bukuTerurut.contains(bukuDipinjam)) {
            System.out.println("Buku " + bukuDipinjam + " ada");
            System.out.println();
            
            bukuTerurut.remove(bukuDipinjam);
        } else {
            System.out.println("Buku " + bukuDipinjam + " tidak ada");
            System.out.println();
        }

        System.out.println("Daftar Buku setelah " + bukuDipinjam + " dipinjam:");
        nomor = 1;
        
        for (String buku : bukuTerurut) {
            System.out.println(nomor + ". " + buku);
            nomor++;
        }
    }
}