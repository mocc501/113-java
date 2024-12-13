import java.io.File;
import java.io.FileReader;
public class CheckedException {
    public static void main(String[] args) {
        try {
            File file = new File("data.txt");
            FileReader reader = new FileReader(file);
        } catch (Exception ex) {
            System.out.println("檔案不存在"+ ex.getMessage());
        }
    }
}
