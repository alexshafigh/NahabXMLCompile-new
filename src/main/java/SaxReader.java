import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by saazimi on 15/11/2018.
 */
public class SaxReader {
    private SAXParserFactory saxParserFactory ;
    private  SAXParser saxParser  ;
    private static OrganizationHandler organizationHandler;
    public static OrganizationHandler getOrganizationHandler()
    {
        return organizationHandler;
    }


    private static PersonHandler personHandler;
    public static PersonHandler getPersonHandler() {
        return personHandler;
    }

    private static ForeignRealPersonHandler foreignRealPersonHandler;
    public static ForeignRealPersonHandler getForeignRealPersonHandler() {
        return foreignRealPersonHandler;
    }

    public SaxReader(String FileAddress) throws ParserConfigurationException, SAXException {
        saxParserFactory = SAXParserFactory.newInstance();
        saxParser  = saxParserFactory.newSAXParser();
//         organizationHandler = new OrganizationHandler();
//         organizationHandler.getConnection().CloseFactory();
//        PersonHandler personHandler = new PersonHandler();
//        ForeignRealPersonHandler foreignRealPersonHandler = new ForeignRealPersonHandler();


//
        File file = new File(FileAddress);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        try {
            org.w3c.dom.Document document = documentBuilder.parse(file);
            document.normalizeDocument();

            org.w3c.dom.Element root = document.getDocumentElement();
            NodeList anodeList = root.getElementsByTagName("a");
            NodeList bnodeList = root.getElementsByTagName("b");
            NodeList cnodeList = root.getElementsByTagName("c");
            NodeList dnodeList = root.getElementsByTagName("d");





            System.out.println(  "anodeList.item(0).getNodeName() " + anodeList.getLength())    ;
            System.out.println(  "bnodeList.item(0).getNodeName() " + bnodeList.getLength())    ;
            System.out.println(  "cnodeList.item(0).getNodeName() " + cnodeList.getLength())    ;
            System.out.println(  "dnodeList.item(0).getNodeName() " + dnodeList.getLength())    ;


            System.out.println(  "dnodeList.item(0).getNodeName() " + dnodeList.item(0).getParentNode().getTextContent())    ;





//            System.out.println(nodeList.getLength());
//            System.out.println(  "nodeList.item(0).getNodeName() " + nodeList.item(0).getNodeName())    ;
//            System.out.println(  "nodeList.item(0).getNodeName().getNodeValue() " + nodeList.item(0).getNodeValue()) ;

//            System.out.println( "nodeList.item(0).getLastChild().getPreviousSibling().getNodeName() " + nodeList.item(0).getFirstChild().getNodeName());
//            System.out.println( "nodeList.item(0).getLastChild().getPreviousSibling().getNodeName() " + nodeList.item(0).getFirstChild().getTextContent());
//
//
//            System.out.println(childNodes.getLength());

//            System.out.println((childNodes.item(0)));
//            System.out.println((childNodes.item(1)));

//
//            for (int itema = 0 ; itema< childNodes.getLength() ; itema++){
//                Node node = childNodes.item(itema);
//
//                if (node != null && node.getNodeType() == Node.ELEMENT_NODE ) {
//                    System.out.println(node.getNodeName());
//                    System.out.println(node.getTextContent());
//                }
//            }

//            int counter = 0;
//            while (counter < nodeList.getLength()){
//                System.out.println(nodeList.item(counter).getNodeName());
//                counter++;
//            }


        } catch (IOException e) {
            e.printStackTrace();
        }

//
//        foreignRealPersonHandler = new ForeignRealPersonHandler();
//        try {
//            saxParser.parse(FileAddress , foreignRealPersonHandler);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

}
