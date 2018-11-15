import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by saazimi on 15/11/2018.
 */
public class PersonHandler extends DefaultHandler {


    private boolean bNationalCode;
    private boolean bFirstName;
    private boolean bLastName;
    private boolean bBirthDate;
    private boolean bIssueNumber;
    private boolean bShahabCode;
    private boolean bIsConfirmed;

    private boolean bErrorCode;
    private boolean bErrorDescription;

    public static final String ANSI_GREEN = "\u001B[32m";


    SessionFactory sessionFactory;
    Session session;
    Person person;
    long counter ;

//    public Organization getOrganization() {
//        return organization;
//    }


    public PersonHandler() {
         person = new Person();
         sessionFactory = new org.hibernate.cfg.Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
         session = sessionFactory.openSession();
         counter = 0 ;

    }

    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {


            if (qName.equalsIgnoreCase("ErrorCode")) {
                bErrorCode = true;

            }
            if (qName.equalsIgnoreCase("ErrorDescription")) {
                bErrorDescription = true;
            }

            if (qName.equalsIgnoreCase("NationalCode")) {
                bNationalCode = true;
            }

            if (qName.equalsIgnoreCase("FirstName")) {
//                organization.setName(attributes.getValue("Name"));
                bFirstName = true;
            }

            if (qName.equalsIgnoreCase("LastName")) {
//                organization.setRegisterNumber(attributes.getValue("RegisterNumber"));
                bLastName = true;
            }

            if (qName.equalsIgnoreCase("BirthDate")) {
//                organization.setRegisterDate(attributes.getValue("RegisterDate"));
                bBirthDate = true;
            }

            if (qName.equalsIgnoreCase("IssueNumber")) {
//                organization.setRegisterLocation(attributes.getValue("RegisterLocation"));
                bIssueNumber = true;
            }

            if (qName.equalsIgnoreCase("ShahabCode")) {
//                organization.setShahabCode(attributes.getValue("ShahabCode"));
                bShahabCode = true;
            }
            if (qName.equalsIgnoreCase("IsConfirmed")) {
//                organization.setIsConfirmed(attributes.getValue("IsConfirmed"));
                bIsConfirmed = true;
            }
            if (qName.equalsIgnoreCase("ReferenceId")) {

            }
            if (qName.equalsIgnoreCase("ShahabInfo")) {

            }
            if (qName.equalsIgnoreCase("PersonResponse")) {
            }

            if (qName.equalsIgnoreCase("Person")) {
            }

    }
    public void endElement(String uri, String localName,
                           String qName) throws SAXException {

//        if (!End) {
//        } else {
//
//            connection = new Connection();
//            connection.session.beginTransaction();
//            connection.getSession().save(this.organization);
//            connection.session.getTransaction().commit();
////            connection.CloseSession();
////            organization = null;
////            this.organization = new Organization();
////        }
//            End = false;
//        }
        if (qName.equalsIgnoreCase("OfflineNahab")){
                session.close();
                sessionFactory.close();
//            System.exit(0);
        }



        if (qName.equalsIgnoreCase("PersonResponse")) {
            if (session.isOpen()) {
                counter ++ ;
                System.out.println("Total Number Of Organizations Ever is " +  counter);}
            else {
                throw new SessionException("Session_Is_Close");
            }
            session.beginTransaction();
            session.save(this.person);
            session.getTransaction().commit();
            person = null;
            person = new Person() ;
        }
    }






    public void characters(char ch[], int start, int length) throws SAXException {


        if (bNationalCode) {
            person.setNationalCode( new String(ch, start, length));
            bNationalCode = false;
        }

        if (bFirstName) {
            person.setFirstName( new String(ch, start, length));
            bFirstName = false;
        }

        if (bLastName) {

            person.setLastName(new String(ch, start, length));
            bLastName = false;
        }

        if (bBirthDate) {
            person.setBirthDate(new String(ch, start, length));
            bBirthDate = false;
        }


        if (bIssueNumber) {
            person.setIssueNumber(  new String(ch, start, length));
            bIssueNumber = false;
        }

        if (bShahabCode) {
            person.setShahabCode( new String(ch, start, length));
            bShahabCode = false;
        }

        if (bErrorCode) {
            person.setErrorCode( new String(ch, start, length));
            bErrorCode = false;
        }
        if (bErrorDescription) {
            person.setErrorDescription( new String(ch, start, length));
            bErrorDescription = false;
        }

        if (bIsConfirmed) {
            person.setIsConfirmed( new String(ch, start, length));
            bIsConfirmed = false;
        }
    }

}
