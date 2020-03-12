import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, XMLStreamException, ParserConfigurationException, SAXException, XPathExpressionException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(".idea/modules.xml"));

        // обьект типа XPath для вычеслениея элементов
        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xpath = xPathFactory.newXPath();
        // /gridbag/row[1]/cell[1] @Sanchor
        // /gridbag/row[1]
        // count(/project/component/output)
        // System.out.println(xpath.evaluate("/project/component/output", document));
        // NodeList list = xpath.evaluate("/project/component/output", document, XPathConstants.NODESET);
    }
}