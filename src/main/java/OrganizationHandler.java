import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.sound.midi.Soundbank;
import java.beans.Beans;
import java.io.EOFException;

/**
 * Created by saazimi on 15/11/2018.
 */
public class OrganizationHandler extends DefaultHandler {


    private boolean bNationalId;
    private boolean bName;
    private boolean bRegisterNumber;
    private boolean bRegisterDate;
    private boolean bRegisterLocation;
    private boolean bShahabCode;
    private boolean bIsConfirmed;

    private boolean bRegisterUnit;
    private boolean bEstablishmentDate;
    private boolean bLegalPersonType;
    private boolean bErrorCode;
    private boolean bErrorDescription;

    public static final String ANSI_GREEN = "\u001B[32m";



    SessionFactory sessionFactory;
    Session session;
    Organization organization;
    long counter ;

//    public Organization getOrganization() {
//        return organization;
//    }


    public OrganizationHandler() {
         organization = new Organization() ;
////        Connection connection ;// = new Connection();
         sessionFactory = new org.hibernate.cfg.Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
         session = sessionFactory.openSession();
         counter = 0 ;

    }

    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {

            if (qName.equalsIgnoreCase("RegisterUnit")) {
                bRegisterUnit = true;
            }


            if (qName.equalsIgnoreCase("LegalPersonType")) {
                bLegalPersonType = true;
            }

            if (qName.equalsIgnoreCase("ErrorCode")) {
                bErrorCode = true;
            }

            if (qName.equalsIgnoreCase("ErrorDescription")) {
                bErrorDescription = true;
            }

           if (qName.equalsIgnoreCase("EstablishmentDate")) {
            bEstablishmentDate = true;
            }

             if (qName.equalsIgnoreCase("CorporatePersonResponse")) {

            }

            if (qName.equalsIgnoreCase("CorporatePerson")) {

            }

            if (qName.equalsIgnoreCase("ReferenceId")) {

            }
            if (qName.equalsIgnoreCase("ShahabInfo")) {

            }

            if (qName.equalsIgnoreCase("NationalId")) {
//                organization.setNationalId(attributes.getValue("NationalId"));
//                System.out.println(attributes.getValue(0));
//                System.out.println(attributes.getValue("NationalId"));
//                System.out.println(attributes.getLocalName(0));
                bNationalId = true;
            }

            if (qName.equalsIgnoreCase("Name")) {
//                organization.setName(attributes.getValue("Name"));
                bName = true;
            }

            if (qName.equalsIgnoreCase("RegisterNumber")) {
//                organization.setRegisterNumber(attributes.getValue("RegisterNumber"));
                bRegisterNumber = true;
            }

            if (qName.equalsIgnoreCase("RegisterDate")) {
//                organization.setRegisterDate(attributes.getValue("RegisterDate"));
                bRegisterDate = true;
            }

            if (qName.equalsIgnoreCase("RegisterLocation")) {
//                organization.setRegisterLocation(attributes.getValue("RegisterLocation"));
                bRegisterLocation = true;
            }

            if (qName.equalsIgnoreCase("ShahabCode")) {
//                organization.setShahabCode(attributes.getValue("ShahabCode"));
                bShahabCode = true;
            }
            if (qName.equalsIgnoreCase("IsConfirmed")) {
//                organization.setIsConfirmed(attributes.getValue("IsConfirmed"));
                bIsConfirmed = true;
//
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



        if (qName.equalsIgnoreCase("CorporatePersonResponse")) {
            if (session.isOpen()) {
                counter ++ ;
                System.out.println(ANSI_GREEN + "Total Number Of Organizations Ever is " +  counter);}
            else {
                throw new SessionException("Session_Is_Close");
            }
            session.beginTransaction();
            session.save(this.organization);
            session.getTransaction().commit();
            organization = null;
            organization = new Organization() ;
        }
    }






    public void characters(char ch[], int start, int length) throws SAXException {


        if (bNationalId) {
            organization.setNationalId( new String(ch, start, length));
            bNationalId = false;
        }

        if (bName) {
            organization.setName( new String(ch, start, length));
            bName = false;
        }

        if (bRegisterNumber) {

            organization.setRegisterNumber(new String(ch, start, length));
            bRegisterNumber = false;
        }

        if (bRegisterDate) {
            organization.setRegisterDate(new String(ch, start, length));
            bRegisterDate = false;
        }


        if (bRegisterLocation) {
            organization.setRegisterLocation(  new String(ch, start, length));
            bRegisterLocation = false;
        }

        if (bShahabCode) {
            organization.setShahabCode( new String(ch, start, length));
            bShahabCode = false;
        }

        if (bEstablishmentDate) {
            organization.setEstablishmentDate( new String(ch, start, length));
            bEstablishmentDate = false;
        }

        if (bLegalPersonType) {
            organization.setLegalPersonType( new String(ch, start, length));
            bLegalPersonType = false;
        }
        if (bErrorCode) {
            organization.setErrorCode( new String(ch, start, length));
            bErrorCode = false;
        }
        if (bErrorDescription) {
            organization.setErrorDescription( new String(ch, start, length));
            bErrorDescription = false;
        }

        if (bIsConfirmed) {
            organization.setIsConfirmed( new String(ch, start, length));
            bIsConfirmed = false;
        }
        if (bRegisterUnit) {
            organization.setRegisterUnit( new String(ch, start, length));
            bRegisterUnit = false;
        }



    }

//    public Connection getConnection() {
//        return connection;
//    }
}
