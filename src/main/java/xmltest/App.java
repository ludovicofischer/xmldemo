/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package xmltest;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;

public class App {
    private static DocumentBuilderFactory newDocumentBuilderFactory() {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setFeature("http://xml.org/sax/features/external-general-entities", false);
            dbf.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            dbf.setFeature("http://javax.xml.XMLConstants/feature/secure-processing", true);
            dbf.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            return dbf;
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    private static DocumentBuilder newDocumentBuilder() {
        try {
            return newDocumentBuilderFactory().newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) throws IOException, SAXException {
        String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?><document>🌰</document>";
        InputSource source = new InputSource(new StringReader(xml));
        Document doc = newDocumentBuilder().parse(source);
        System.out.println(doc.getDocumentElement().getFirstChild().getTextContent());
    }
}
