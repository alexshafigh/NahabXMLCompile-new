import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by saazimi on 18/11/2018.
 */
public class ForeignRealPersonHandler extends DefaultHandler{
    private boolean bNationalCode;
    private boolean bIdentificationDocumentType;
    private boolean bIdentificationDocumentNumber;
    private boolean bBirthCountry_Alphabet;
    private boolean bBirthDate;
    private boolean bBirthCountry_countryid;
    private boolean bBirthCountry_PersianName;
    private boolean bNationality_PersianName;
    private boolean bNationality_countryid;
    private boolean bGrandFatherName;
    private boolean bFatherName;
    private boolean bBirthCountry_LatinName;
    private boolean bLastName;
    private boolean bBirthCountry_IsArabic;
    private boolean bFirstName;
    private boolean bNationality_LatinName;
    private boolean bNationality_Alphabet;
    private boolean bNationality_IsArabic;
    private boolean bGender;
    private boolean bShahabCode;
    private boolean bIsConfirmed;
    private boolean bErrorCode;
    private boolean bErrorDescription;

    SessionFactory sessionFactory;
    Session session;
    ForeignRealPerson foreignRealPerson;
    long counter ;

    public ForeignRealPersonHandler() {
        sessionFactory = new org.hibernate.cfg.Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        session = sessionFactory.openSession();
        counter = 0 ;
    }

    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("ForeignRealPersonResponse")) {
            foreignRealPerson = new ForeignRealPerson();

            if (qName.equalsIgnoreCase("NationalCode")) bNationalCode = true;
            if (qName.equalsIgnoreCase("IdentificationDocument")) {
            }
        }
    }



    public void characters(char ch[], int start, int length)
            throws SAXException {
            if(bNationalCode){
                foreignRealPerson.setNationalCode(new String(ch, start, length));
                bNationalCode = false;
            }
    }
}
