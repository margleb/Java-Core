
import javax.print.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws FileNotFoundException, PrintException {
        DocFlavor flavor = DocFlavor.SERVICE_FORMATTED.PAGEABLE;
        String mineType = "application/postscript";
        StreamPrintServiceFactory[] factories = StreamPrintServiceFactory.lookupStreamPrintServiceFactories(flavor, mineType);
        OutputStream outputStream = new FileOutputStream("PostService.odd");
        StreamPrintService streamPrintService = factories[0].getPrintService(outputStream);

        InputStream inStream = new FileInputStream("img/java.jpg");
        DocPrintJob job = streamPrintService.createPrintJob();
        Doc doc = new SimpleDoc(inStream, DocFlavor.INPUT_STREAM.JPEG, null);
        job.print(doc, null);
    }
}
