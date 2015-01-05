/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parsexml;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import org.w3c.dom.NodeList;


/**
 *
 * @author victor
 */
public class ParseXml {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // DOM method for parse XML
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder dBuilder = builderFactory.newDocumentBuilder();
            Document document = dBuilder.parse(ParseXml.class.getResourceAsStream("/Exchange_Rates-2.xml")); //bnt currency exchange rate csv file
            document.normalize();
            
            NodeList rootRates = document.getElementsByTagName("ROWSET");
            Node rootRate = rootRates.item(0);
            Element rootElement = (Element) rootRate;
            NodeList rowsetList = rootElement.getElementsByTagName("ROW");
            for(int i = 0;i < rowsetList.getLength();i++){
                Node theRowset = rowsetList.item(i);
                Element rowsetElement = (Element) theRowset ;
                
            
            Node theGold = rowsetElement.getElementsByTagName("GOLD").item(0);
            Element goldElement = (Element) theGold;
            System.out.println(goldElement.getTextContent() +" ");    

            
            Node theCode = rowsetElement.getElementsByTagName("CODE").item(0);
            Element codeElement = (Element) theCode;
            System.out.println(codeElement.getTextContent() +" = ");

            
            Node theReverserate = rowsetElement.getElementsByTagName("REVERSERATE").item(0);
            Element reverserateElement = (Element) theReverserate;
            System.out.println(reverserateElement.getTextContent() +" (BGN)");

                
            }
            
        } catch (ParserConfigurationException e) {
          e.printStackTrace();
        } catch (SAXException | IOException ex) {
            Logger.getLogger(ParseXml.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
