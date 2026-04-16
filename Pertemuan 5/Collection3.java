import java.util.Map;
import java.util.TreeMap;

public class Collection3 {
    public static void main(String[] args) {
        Map<String, String> pengembang = new TreeMap<>();

        pengembang.put("Microsoft", "Bill Gates");
        pengembang.put("Apple", "Steven Paul Jobs");
        pengembang.put("Linux", "Linux Benedict Torvalds");
        pengembang.put("Facebook", "Mark Zuckerberg");
        pengembang.put("Twitter", "Jack Dorsey");
        pengembang.put("Instagram", "Kevin Systrom");

        int no = 1;
        for (Map.Entry<String, String> entry : pengembang.entrySet()) {
            String namaPerusahaan = entry.getKey().toUpperCase();
            
            String namaPengembang = entry.getValue();

            System.out.println(no + ". " + namaPerusahaan + " dikembangkan oleh " + namaPengembang);
            
            no++;
        }
    }
}