import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
public class DataList {
 
    public static void main(String a[]){
        BufferedReader br = null;
        String strLine = "";
        try {
            br = new BufferedReader( new FileReader("/D:/BCA/sem3/OOP/Module/ECommerce/Try db/ItemPrices.txt"));
            while( (strLine = br.readLine()) != null){
                System.out.println(strLine);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("Unable to read the file.");
        }
     }
}