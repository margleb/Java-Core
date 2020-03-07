
import javax.print.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;


public class Main {
    public static void main(String[] args) throws FileNotFoundException, PrintException {
       DocFlavor flavor = DocFlavor.INPUT_STREAM.JPEG;
       PrintService[] services = PrintServiceLookup.lookupPrintServices(flavor, null);
       InputStream inputStream = new FileInputStream("img/java.jpg");
       Doc doc = new SimpleDoc(inputStream, flavor, null);
       if(services.length > 0) {
           DocPrintJob job = services[0].createPrintJob();
           job.print(doc, null);
       }
    }
}
