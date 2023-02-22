/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.application.lib;
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
public String serverAdress;
public String port;
public String databaseName;
public String userName;
public String password;
public ArrayList<String> rolev;

public boolean readXML(String xml) {
        rolev = new ArrayList<>();
        Document dom;
        // Make an  instance of the DocumentBuilderFactory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            // use the factory to take an instance of the document builder
            DocumentBuilder db = dbf.newDocumentBuilder();
            // parse using the builder to get the DOM mapping of the    
            // XML file
            dom = db.parse(xml);

            Element doc = dom.getDocumentElement();
            serverAdress = getTextValue(serverAdress, doc, "serverAdress");
            if (serverAdress != null) {
                if (!serverAdress.isEmpty())
                    rolev.add(serverAdress);
            }
            port = getTextValue(port, doc, "port");
            if (port != null) {
                if (!port.isEmpty())
                    rolev.add(port);
            }
            databaseName = getTextValue(databaseName, doc, "databaseName");
            if (databaseName != null) {
                if (!databaseName.isEmpty())
                    rolev.add(databaseName);
            }
            userName = getTextValue(userName, doc, "userName");
            if ( userName != null) {
                if (!userName.isEmpty())
                    rolev.add(userName);
            }
           password = getTextValue(password, doc, "password");
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
    Document dom;
    Element e = null;

    // instance of a DocumentBuilderFactory
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    try {
        // use factory to get an instance of document builder
        DocumentBuilder db = dbf.newDocumentBuilder();
        // create instance of DOM
        dom = db.newDocument();

        // create the root element
        Element rootEle = dom.createElement("SQLite/server");

        // create data elements and place them under root
        e = dom.createElement("serverAdress");
        e.appendChild(dom.createTextNode(serverAdress));
        rootEle.appendChild(e);

        e = dom.createElement("port");
        e.appendChild(dom.createTextNode(port));
        rootEle.appendChild(e);

        e = dom.createElement("databaseName");
        e.appendChild(dom.createTextNode(databaseName));
        rootEle.appendChild(e);

        e = dom.createElement("userName");
        e.appendChild(dom.createTextNode(userName));
        rootEle.appendChild(e);

        e = dom.createElement("password");
        e.appendChild(dom.createTextNode(password));
        rootEle.appendChild(e);
        
        dom.appendChild(rootEle);
        try {
            Transformer tr = TransformerFactory.newInstance().newTransformer();
            tr.setOutputProperty(OutputKeys.INDENT, "yes");
            tr.setOutputProperty(OutputKeys.METHOD, "xml");
            tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            tr.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "SQLite/roles.dtd");
            tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
         
            tr.transform(new DOMSource(dom),new StreamResult(new FileOutputStream(xml)));

        } catch (TransformerException te) {
            System.out.println(te.getMessage());
        }
    } catch (ParserConfigurationException pce) {
        System.out.println("UsersXML: Error trying to instantiate DocumentBuilder " + pce);
    }
}
    private String getTextValue(String def, Element doc, String tag) {
    String value = def;
    NodeList nl;
    nl = doc.getElementsByTagName(tag);
    if (nl.getLength() > 0 && nl.item(0).hasChildNodes()) {
        value = nl.item(0).getFirstChild().getNodeValue();
    }
    return value;
} 
}