import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        // DOM анализатор
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        // прочитываем документ по указаному адресу, получаем древовидную структур XML-документа
        Document document  = builder.parse(new File(".idea/workspace.xml"));

        // возращает корневой элемент
        Element element = document.getDocumentElement();
        // извлекаем дочерние элементы по отношению к данному
        NodeList nodeList = element.getChildNodes();
        // метод getLength() - общее количество элеменетов
        for(int i = 0; i < nodeList.getLength(); i++) {
            // Метод item() возвращает элемент набора данных по указанному индексу
            Node child = nodeList.item(i);
            // игнарирование всех разделителей
            if (child instanceof Element) {
                // получтить nег
                // System.out.println(((Element) nodeList.item(i)).getTagName());
            }
        };
        printElement(nodeList, 0);
    }
    // выводим все теги
    static void printElement(NodeList nodeList, int tabs) {
        for(int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i) instanceof Element) {

                String value = "";
                // если не пустой текст, если первый элемент с не пустой информацией, и если это не переход на новую строку
                if(!nodeList.item(i).getTextContent().trim().isEmpty() &&
                !((Text)nodeList.item(i).getFirstChild()).getData().trim().isEmpty()
                && !((Text)nodeList.item(i).getFirstChild()).getData().trim().equals("\n")) {
                    // берем текст
                    Text text = (Text)nodeList.item(i).getFirstChild();
                    value += " = " + text.getData().trim();
                }
                System.out.println(getTab(tabs) + ((Element) nodeList.item(i)).getTagName());
                // выводим узел если у него есть атрибут name
                if((((Element) nodeList.item(i)).hasAttribute("name"))) {
                    System.out.println(((Element) nodeList.item(i)).getAttribute("name"));
                }

                // проверка на наличие дочернего элемента
                if(nodeList.item(i).hasChildNodes()) {
                    // рекрусивный вызов функции
                    printElement(nodeList.item(i).getChildNodes(), ++tabs);
                }
            }
        };
    }
    // табуляция
    static String getTab(int tabs) {
        String str = "";
        for(int i = 0; i < tabs; i++) {
            str += "\t";
        }
        return str;
    }
}