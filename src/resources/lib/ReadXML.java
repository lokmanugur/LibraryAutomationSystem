/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.lib;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.xml.sax.*;
import org.w3c.dom.*;
/**
 *
 * @author Administrator
 */
public class ReadXML {
    private String serverAdress;
    private String port;
    private String databaseName;
    private String userName;
    private String password;
    private ArrayList<String> rolev;
    // Make an  instance of the DocumentBuilderFactory
    private final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

    public String getServerAdress() {
        return serverAdress;
    }

    public void setServerAdress(String serverAdress) {
        this.serverAdress = serverAdress;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<String> getRolev() {
        return rolev;
    }

    public void setRolev(ArrayList<String> rolev) {
        this.rolev = rolev;
    }

    
public boolean readXML(String xml) {
        rolev = new ArrayList<>();
        Document document;
        try {
            // use the factory to take an instance of the document builder
            DocumentBuilder db = dbf.newDocumentBuilder();
            // parse using the builder to get the DOM mapping of the    
            // XML file
            document = db.parse(xml);

            Element doc = document.getDocumentElement();
            serverAdress = getTextValue(doc, "serverAdress");
            if (serverAdress != null) {
                if (!serverAdress.isEmpty())
                    rolev.add(serverAdress);
            }
            port = getTextValue(doc, "port");
            if (port != null) {
                if (!port.isEmpty())
                    rolev.add(port);
            }
            databaseName = getTextValue(doc, "databaseName");
            if (databaseName != null) {
                if (!databaseName.isEmpty())
                    rolev.add(databaseName);
            }
            userName = getTextValue(doc, "userName");
            if ( userName != null) {
                if (!userName.isEmpty())
                    rolev.add(userName);
            }
           password = getTextValue(doc, "password");
            if ( password != null) {
                if (!password.isEmpty())
                    rolev.add(password);
                else rolev.add("");
            }else rolev.add("");
            return true;

        } catch (ParserConfigurationException | SAXException pce) {
            System.out.println(pce.getMessage());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
        return false;
    } 


public void saveToXML(String xml) throws FileNotFoundException {
    Document document;
    Element element;
    try {
        // use factory to get an instance of document builder
        DocumentBuilder db = dbf.newDocumentBuilder();
        // create instance of DOM
        document = db.newDocument();

        // create the root element
        Element rootEle = document.createElement("server");

        // create data elements and place them under root
        element = document.createElement("serverAdress");
        element.appendChild(document.createTextNode(serverAdress));
        rootEle.appendChild(element);

        element = document.createElement("port");
        element.appendChild(document.createTextNode(port));
        rootEle.appendChild(element);

        element = document.createElement("databaseName");
        element.appendChild(document.createTextNode(databaseName));
        rootEle.appendChild(element);

        element = document.createElement("userName");
        element.appendChild(document.createTextNode(userName));
        rootEle.appendChild(element);

        element = document.createElement("password");
        element.appendChild(document.createTextNode(password));
        rootEle.appendChild(element);
        
        document.appendChild(rootEle);
        try {
            Transformer tr = TransformerFactory.newInstance().newTransformer();
            tr.setOutputProperty(OutputKeys.INDENT, "yes");
            tr.setOutputProperty(OutputKeys.METHOD, "xml");
            tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            tr.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "../SQLite/roles.dtd");
            tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
         
            tr.transform(new DOMSource(document),new StreamResult(new FileOutputStream(xml)));

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
}