import javassist.bytecode.stackmap.BasicBlock;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Handler;

/**
 * Created by saazimi on 15/11/2018.
 */
public class SaxReader {
    private SAXParserFactory saxParserFactory ;
    private  SAXParser saxParser  ;
    private static MyHandler myHandler;

    public static MyHandler getMyHandler() {
        return myHandler;
    }

    public SaxReader(String FileAddress) throws ParserConfigurationException, SAXException {
        saxParserFactory = SAXParserFactory.newInstance();
        saxParser  = saxParserFactory.newSAXParser();
         myHandler = new MyHandler();
//         myHandler.getConnection().CloseFactory();
        try {
            saxParser.parse(FileAddress ,myHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
