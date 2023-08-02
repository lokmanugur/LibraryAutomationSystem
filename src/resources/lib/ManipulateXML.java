/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.lib;

import com.ugurtech.library.model.DatabaseModel;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.xml.sax.*;
import org.w3c.dom.*;

/**
 *
 * @author www.lokmanugur.com
 */
public class ManipulateXML {

    public static final ManipulateXML INSTANCE = new ManipulateXML();
    private DatabaseModel databaseModel;
    private final String xmlFilePath = Paths.get("").toAbsolutePath().toString() +"/SQLite/server.xml";
    private Document document;
    private Element element;
    // Make an  instance of the DocumentBuilderFactory
    private final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

    public DatabaseModel readFromXMLFile() {
        databaseModel = new DatabaseModel();
        try {
            // use the factory to take an instance of the document builder
            DocumentBuilder db = dbf.newDocumentBuilder();
            // parse using the builder to get the DOM mapping of the    
            // XML file
            document = db.parse(xmlFilePath);

            Element doc = document.getDocumentElement();
            databaseModel.setIpAdress(getTextValue(doc, "ipAdress"));
            databaseModel.setPortNumber(getTextValue(doc, "port"));
            databaseModel.setDatabaseName(getTextValue(doc, "databaseName"));
            databaseModel.setUserName(getTextValue(doc, "userName"));
            databaseModel.setPassword(getTextValue(doc, "password"));
            databaseModel.setFilePath(getTextValue(doc, "filePath"));

        } catch (ParserConfigurationException | SAXException pce) {
            System.out.println(pce.getMessage());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
        return databaseModel;
    }

    public void addToXMLFile(DatabaseModel databaseModel) throws FileNotFoundException {

        try {
            // use factory to get an instance of document builder
            DocumentBuilder db = dbf.newDocumentBuilder();
            // create instance of DOM
            document = db.newDocument();

            // create the root element
            Element rootEle = document.createElement("server");

            // create data elements and place them under root
            rootEle.appendChild(createDataElement("ipAdress", databaseModel.getIpAdress()));
            rootEle.appendChild(createDataElement("port", databaseModel.getPortNumber()));
            rootEle.appendChild(createDataElement("databaseName", databaseModel.getDatabaseName()));
            rootEle.appendChild(createDataElement("userName", databaseModel.getUserName()));
            rootEle.appendChild(createDataElement("password", databaseModel.getPassword()));
            rootEle.appendChild(createDataElement("filePath", databaseModel.getFilePath()));
            document.appendChild(rootEle);
            try {
                Transformer tr = TransformerFactory.newInstance().newTransformer();
                tr.setOutputProperty(OutputKeys.INDENT, "yes");
                tr.setOutputProperty(OutputKeys.METHOD, "xml");
                tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                tr.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "../SQLite/roles.dtd");
                tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

                tr.transform(new DOMSource(document), new StreamResult(new FileOutputStream(xmlFilePath)));

            } catch (TransformerException te) {
                System.out.println(te.getMessage());
            }
        } catch (ParserConfigurationException pce) {
            System.out.println("UsersXML: Error trying to instantiate DocumentBuilder " + pce);
        }
    }

    private String getTextValue(Element element, String tag) {
        NodeList nodeList;
        nodeList = element.getElementsByTagName(tag);
        if (nodeList.getLength() > 0 && nodeList.item(0).hasChildNodes()) {
            return nodeList.item(0).getFirstChild().getNodeValue();
        }
        return null;
    }
    
    private Element createDataElement(String valueElement,String value){
        element = document.createElement(valueElement);
        element.appendChild(document.createTextNode(value));
        return element;
    }

}
