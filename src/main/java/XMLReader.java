import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.ws.rs.core.Configuration;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by saazimi on 19/11/2018.
 */
public class XMLReader {
    ForeignRealPerson foreignRealPerson;
    private SessionFactory sessionFactory;
    private Session session;

    public XMLReader() {
        sessionFactory = new org.hibernate.cfg.Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        session = sessionFactory.openSession();
    }

    public void Parse(String FileAddress) {


        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            org.w3c.dom.Document document = documentBuilder.parse(FileAddress);
            document.normalizeDocument();


            org.w3c.dom.Element root = document.getDocumentElement();
            NodeList NationalCodenodeList = root.getElementsByTagName("NationalCode");
            NodeList NumbernodeList = root.getElementsByTagName("Number");
            NodeList TypenodeList = root.getElementsByTagName("Type");
            NodeList BirthDatenodeList = root.getElementsByTagName("BirthDate");
            NodeList FirstNamenodeList =  root.getElementsByTagName("FirstName");
            NodeList LastNamenodeList =   root.getElementsByTagName("LastName");
            NodeList FatherNamenodeList = root.getElementsByTagName("FatherName");
            NodeList GrandFathernodeList =root.getElementsByTagName("GrandFather");
            NodeList GendernodeList =    root.getElementsByTagName("Gender");

            NodeList ShahabCodenodeList =root.getElementsByTagName("ShahabCode");
            NodeList IsConfirmednodeList=root.getElementsByTagName("IsConfirmed");


            NodeList NationalityNodeList = root.getElementsByTagName("Nationality");
            NodeList BirthCountryNodeList = root.getElementsByTagName("BirthCountry");





            NodeList ErrorCodenodeList = root.getElementsByTagName("ErrorCode");
            NodeList ErrorDescriptionnodeList=root.getElementsByTagName("ErrorDescription");



            for (int totalNumberOfPersons = 0 ; totalNumberOfPersons <NationalCodenodeList.getLength() ; totalNumberOfPersons++ ){
                foreignRealPerson = new ForeignRealPerson();

                foreignRealPerson.setNationalCode(NationalCodenodeList.item(totalNumberOfPersons).getTextContent());
                foreignRealPerson.setIdentificationDocumentNumber(NumbernodeList.item(totalNumberOfPersons).getTextContent());
                if (TypenodeList.item(totalNumberOfPersons) != null )
                        foreignRealPerson.setIdentificationDocumentType(TypenodeList.item(totalNumberOfPersons).getTextContent());
                else foreignRealPerson.setIdentificationDocumentType("مدرک شناسنایی ناشناس");
                foreignRealPerson.setBirthDate(BirthDatenodeList.item(totalNumberOfPersons).getTextContent());
                if (FirstNamenodeList.item(totalNumberOfPersons) != null )
                    foreignRealPerson.setFirstName(FirstNamenodeList.item(totalNumberOfPersons).getTextContent());
                else foreignRealPerson.setFirstName("");
                if (LastNamenodeList.item(totalNumberOfPersons) != null )
                    foreignRealPerson.setLastName(LastNamenodeList.item(totalNumberOfPersons).getTextContent());
                else foreignRealPerson.setLastName("");
                if (FatherNamenodeList.item(totalNumberOfPersons) != null )
                    foreignRealPerson.setFatherName(FatherNamenodeList.item(totalNumberOfPersons).getTextContent());
                else foreignRealPerson.setFatherName("");
                if (GrandFathernodeList.item(totalNumberOfPersons) != null )
                    foreignRealPerson.setGrandFatherName(GrandFathernodeList.item(totalNumberOfPersons).getTextContent());
                else foreignRealPerson.setGrandFatherName("");

                if (GendernodeList.item(totalNumberOfPersons) != null )
                    foreignRealPerson.setGender(GendernodeList.item(totalNumberOfPersons).getTextContent());
                else foreignRealPerson.setGender("جنسیت نامشخص");

//                foreignRealPerson.setShahabCode(ShahabCodenodeList.item(totalNumberOfPersons).getTextContent());
//                foreignRealPerson.setIsConfirmed(IsConfirmednodeList.item(totalNumberOfPersons).getTextContent());

                foreignRealPerson.setShahabCode("");
                foreignRealPerson.setIsConfirmed("");



                foreignRealPerson.setErrorCode(ErrorCodenodeList.item(totalNumberOfPersons).getTextContent());
                foreignRealPerson.setErrorDescription(ErrorDescriptionnodeList.item(totalNumberOfPersons).getTextContent());
//
//
//                foreignRealPerson.setBirthCountry_countryid("");
//                foreignRealPerson.setBirthCountry_PersianName("");
//                foreignRealPerson.setBirthCountry_LatinName("");
//                foreignRealPerson.setBirthCountry_Alphabet("");
//                foreignRealPerson.setBirthCountry_IsArabic("");
//
//
//                foreignRealPerson.setNationality_countryid("");
//                foreignRealPerson.setNationality_PersianName("");
//                foreignRealPerson.setNationality_LatinName("");
//                foreignRealPerson.setNationality_Alphabet("");
//                foreignRealPerson.setNationality_IsArabic("");

                NodeList BirthCountry_Child_NodeList = BirthCountryNodeList.item(totalNumberOfPersons).getChildNodes();
                NodeList Nationality_Child_NodeList = NationalityNodeList.item(totalNumberOfPersons).getChildNodes();

                for (int counter = 0 ; counter < Nationality_Child_NodeList.getLength() ; counter ++){
                    if (Nationality_Child_NodeList.item(counter).getNodeType() == Node.ELEMENT_NODE)
                        switch (Nationality_Child_NodeList.item(counter).getNodeName()) {
                            case "CountryId":
                                foreignRealPerson.setNationality_countryid(Nationality_Child_NodeList.item(counter).getTextContent());
                            case "PersianName":
                                foreignRealPerson.setNationality_PersianName(Nationality_Child_NodeList.item(counter).getTextContent());
                            case "LatinName":
                                foreignRealPerson.setNationality_LatinName(Nationality_Child_NodeList.item(counter).getTextContent());
                            case "Alphabet":
                                foreignRealPerson.setNationality_Alphabet(Nationality_Child_NodeList.item(counter).getTextContent());
                            case "IsArabic":
                                foreignRealPerson.setNationality_IsArabic(Nationality_Child_NodeList.item(counter).getTextContent());
                        }
                }


                for (int counter = 0 ; counter < BirthCountry_Child_NodeList.getLength() ; counter ++){
                    if (BirthCountry_Child_NodeList.item(counter).getNodeType() == Node.ELEMENT_NODE)
                        switch (BirthCountry_Child_NodeList.item(counter).getNodeName()) {
                            case "CountryId":
                                foreignRealPerson.setBirthCountry_countryid(BirthCountry_Child_NodeList.item(counter).getTextContent());
                            case "PersianName":
                                foreignRealPerson.setBirthCountry_PersianName(BirthCountry_Child_NodeList.item(counter).getTextContent());
                            case "LatinName":
                                foreignRealPerson.setBirthCountry_LatinName(BirthCountry_Child_NodeList.item(counter).getTextContent());
                            case "Alphabet":
                                foreignRealPerson.setBirthCountry_Alphabet(BirthCountry_Child_NodeList.item(counter).getTextContent());
                            case "IsArabic":
                                foreignRealPerson.setBirthCountry_IsArabic(BirthCountry_Child_NodeList.item(counter).getTextContent());
                        }
                }


                session.beginTransaction();
                session.save(foreignRealPerson);
                session.getTransaction().commit();
                foreignRealPerson = null;
            }



        }
        catch (Exception e){
            e.printStackTrace();
        }

        session.close();
        sessionFactory.close();
    }
}