import jdk.nashorn.internal.ir.JumpToInlinedFinally;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.ws.rs.core.Configuration;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


/**
 * Created by saazimi on 21/11/2018.
 */
public class DomXmlReader {
    org.w3c.dom.Document document;
    ForeignRealPerson foreignRealPerson;
    private SessionFactory sessionFactory;
    private Session session;


    public DomXmlReader() {
    }

    public DomXmlReader(String FileAddress) throws ParserConfigurationException,SAXException,IOException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        document = documentBuilder.parse(FileAddress);
        document.normalizeDocument();
        sessionFactory = new org.hibernate.cfg.Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        session = sessionFactory.openSession();
        parse();
    }

    public void parse ()
    {


        org.w3c.dom.Element root = document.getDocumentElement();
        NodeList ForeignRealPersonNodeList = root.getElementsByTagName("ForeignRealPerson");

        for (int frpCounter = 0; frpCounter<ForeignRealPersonNodeList.getLength() ; frpCounter++){

            foreignRealPerson = new ForeignRealPerson();
            boolean NationaCodeFlag = false;
            boolean BirthDateFlag = false;
            boolean FirstNameFlag = false;
            boolean LastNameFlag = false;
            boolean FatherNameFlag = false;
            boolean GrandFatherFlag = false;
            boolean GenderFlag = false;
            boolean StatusFlasg = false;
            boolean ReferenceIdFlag = false;
            boolean ErrorCodeFlag = false;
            boolean ErrorDescriptionFlag = false;
            boolean IdentificationDocumentFlag = false;
            boolean NumberFlag = false;
            boolean typeFlag = false;

            boolean BirthCountryFlag = false;
            boolean BirthCountry_countryId = false;
            boolean BirthCountry_PersianFlag = false;
            boolean BirthCountry_latinFlag = false;
            boolean BirthCountry_AlphabetFlag = false;
            boolean BirthCountry_IsArabicFlag = false;

            boolean NationalityFlag = false;
            boolean Nationality_CountryId = true;
            boolean Nationality_PersianNameFlag = true;
            boolean Nationality_LatinNameFlag = true;
            boolean Nationality_AlphabetFlag = true;
            boolean Nationality_IsArabicFlag = true;

            boolean ShahabInfoFlag = false;
            boolean ShahabInfo_ShahabCodeFlag = false;
            boolean ShahabInfo_IsConfirmedFlag = false;




            NodeList childNodeList = ForeignRealPersonNodeList.item(frpCounter).getChildNodes();
            for (int childnodelistcounter = 0 ; childnodelistcounter<childNodeList.getLength() ; childnodelistcounter++)
                if (childNodeList.item(childnodelistcounter).getNodeType() == Node.ELEMENT_NODE )
                    if ( childNodeList.item(childnodelistcounter).getChildNodes().getLength() == 0 )
                    {
                        switch (childNodeList.item(childnodelistcounter).getNodeName()) {
                            case "NationalCode": {
                                 NationaCodeFlag = true;
                                foreignRealPerson.setNationalCode(childNodeList.item(childnodelistcounter).getTextContent());
                            }
                            case "BirthDate":{
                                BirthDateFlag = true;
                                foreignRealPerson.setBirthDate(childNodeList.item(childnodelistcounter).getTextContent());
                            }
                            case "FirstName":{
                                FirstNameFlag = true;
                                foreignRealPerson.setFirstName(childNodeList.item(childnodelistcounter).getTextContent());
                            }
                            case "LastName":{
                                LastNameFlag = true;
                                foreignRealPerson.setLastName(childNodeList.item(childnodelistcounter).getTextContent());
                            }

                            case "FatherName":{
                                FatherNameFlag = true;
                                foreignRealPerson.setFatherName(childNodeList.item(childnodelistcounter).getTextContent());
                            }
                            case "GrandFather":{
                                GrandFatherFlag = true;
                                foreignRealPerson.setGrandFatherName(childNodeList.item(childnodelistcounter).getTextContent());
                           }
                            case "Gender":{
                                GenderFlag = true;
                                foreignRealPerson.setGender(childNodeList.item(childnodelistcounter).getTextContent());
                            }
                            case "Status":{
                                StatusFlasg = true;
                                foreignRealPerson.setStatus(childNodeList.item(childnodelistcounter).getTextContent());
                            }
                            case "ReferenceId":{
                                ReferenceIdFlag = true;
                                foreignRealPerson.setReferenceId(childNodeList.item(childnodelistcounter).getTextContent());
                            }
                            case "ErrorCode":{
                                ErrorCodeFlag = true;
                                foreignRealPerson.setErrorCode(childNodeList.item(childnodelistcounter).getTextContent());
                            }
                            case "ErrorDescription":{
                                ErrorDescriptionFlag = true;
                                foreignRealPerson.setErrorDescription(childNodeList.item(childnodelistcounter).getTextContent());
                            }

                        }
                    }
                    else { // foe identifiying Nodes with child like BirthCountry
                        switch (childNodeList.item(childnodelistcounter).getNodeName()){
                            case "IdentificationDocument":{
                                IdentificationDocumentFlag = true;
                                NodeList childsIdentificationDocument = childNodeList.item(childnodelistcounter).getChildNodes();
                                if (childsIdentificationDocument.getLength() != 0)
                                     {
                                         for (int childsIdentificationDocumentcounter = 0 ;childsIdentificationDocumentcounter <childsIdentificationDocument.getLength() ; childsIdentificationDocumentcounter++ )
                                         {
                                             if (childsIdentificationDocument.item(childsIdentificationDocumentcounter).getNodeName() == "Number")
                                             {
                                                 foreignRealPerson.setIdentificationDocumentNumber(childsIdentificationDocument.item(childsIdentificationDocumentcounter).getTextContent());
                                                 NumberFlag = true;
                                             }
                                             else {
                                                 foreignRealPerson.setIdentificationDocumentType(childsIdentificationDocument.item(childsIdentificationDocumentcounter).getTextContent());
                                                 typeFlag = true;
                                             }
                                         }
                                     }
                                     else {
                                        IdentificationDocumentFlag = false;
                                }
                            }
                            case "BirthCountry":
                                {
                                BirthCountryFlag = true;
                                NodeList BirthCountryNodeList = childNodeList.item(childnodelistcounter).getChildNodes();
                                if (BirthCountryNodeList.getLength() != 0)
                                     {
                                         for (int BirthCountryNodeListcounter = 0 ;BirthCountryNodeListcounter <BirthCountryNodeList.getLength() ; BirthCountryNodeListcounter++ )
                                         {
                                             switch (BirthCountryNodeList.item(BirthCountryNodeListcounter).getNodeName()){
                                                 case "CountryId":{
                                                     foreignRealPerson.setBirthCountry_countryid(BirthCountryNodeList.item(BirthCountryNodeListcounter).getTextContent());
                                                     BirthCountry_countryId = true;
                                                 }
                                                 case "PersianName":{
                                                     foreignRealPerson.setBirthCountry_PersianName(BirthCountryNodeList.item(BirthCountryNodeListcounter).getTextContent());
                                                     BirthCountry_PersianFlag = true;
                                                 }
                                                 case "LatinName":{
                                                     foreignRealPerson.setBirthCountry_LatinName(BirthCountryNodeList.item(BirthCountryNodeListcounter).getTextContent());
                                                     BirthCountry_latinFlag = true;
                                                 }
                                                 case "Alphabet":{
                                                     foreignRealPerson.setBirthCountry_Alphabet(BirthCountryNodeList.item(BirthCountryNodeListcounter).getTextContent());
                                                     BirthCountry_AlphabetFlag = true;
                                                 }
                                                 case "IsArabic":{
                                                     foreignRealPerson.setBirthCountry_IsArabic(BirthCountryNodeList.item(BirthCountryNodeListcounter).getTextContent());
                                                     BirthCountry_IsArabicFlag = true;
                                                 }
                                             }
                                         }
                                     }
                                else {
                                        BirthCountryFlag = false;
                                     }
                                }
                            case "Nationality":{
                                NationalityFlag = true;
                                NodeList NationalityNodeList = childNodeList.item(childnodelistcounter).getChildNodes();
                                if (NationalityNodeList.getLength() != 0)
                                    {
                                        for (int NationalityNodeListcounter = 0 ; NationalityNodeListcounter < NationalityNodeList.getLength() ; NationalityNodeListcounter++)
                                        {
                                            switch (NationalityNodeList.item(NationalityNodeListcounter).getNodeName()){
                                                case "CountryId":{
                                                    foreignRealPerson.setNationality_countryid(NationalityNodeList.item(NationalityNodeListcounter).getTextContent());
                                                    Nationality_CountryId = true;
                                                }
                                                case "PersianName":{
                                                    foreignRealPerson.setNationality_PersianName(NationalityNodeList.item(NationalityNodeListcounter).getTextContent());
                                                    Nationality_PersianNameFlag  = true;
                                                }
                                                case "LatinName":{
                                                    foreignRealPerson.setNationality_LatinName(NationalityNodeList.item(NationalityNodeListcounter).getTextContent());
                                                    Nationality_LatinNameFlag = true;
                                                }
                                                case "Alphabet":{
                                                    foreignRealPerson.setNationality_Alphabet(NationalityNodeList.item(NationalityNodeListcounter).getTextContent());
                                                    Nationality_AlphabetFlag = true;
                                                }
                                                case "IsArabic":{
                                                    foreignRealPerson.setNationality_IsArabic(NationalityNodeList.item(NationalityNodeListcounter).getTextContent());
                                                    Nationality_IsArabicFlag = true;
                                                }
                                            }
                                        }
                                    }
                                    else {
                                    NationalityFlag = false;
                                }
                            }
                            case "ShahabInfo":{
                                ShahabInfoFlag =true;
                                NodeList ShahbInfoNodeList = childNodeList.item(childnodelistcounter).getChildNodes();
                                if (ShahbInfoNodeList.getLength() != 0)
                                {
                                    for (int ShahbInfoNodeListCounter = 0 ; ShahbInfoNodeListCounter < ShahbInfoNodeList.getLength() ; ShahbInfoNodeListCounter ++)
                                    {
                                        switch (ShahbInfoNodeList.item(ShahbInfoNodeListCounter).getNodeName()){
                                            case "ShahabCode":{
                                                    foreignRealPerson.setShahabCode(ShahbInfoNodeList.item(ShahbInfoNodeListCounter).getTextContent());
                                                    ShahabInfo_ShahabCodeFlag = true;
                                            }
                                            case "IsConfirmed":{
                                                    foreignRealPerson.setIsConfirmed(ShahbInfoNodeList.item(ShahbInfoNodeListCounter).getTextContent());
                                                    ShahabInfo_IsConfirmedFlag = true;
                                            }
                                        }
                                    }
                                }
                                else {
                                    ShahabInfoFlag = false;
                                }
                            }
                        }
                    }

                    if (!NationaCodeFlag) foreignRealPerson.setNationalCode("");
                    if(!BirthDateFlag) foreignRealPerson.setBirthDate("");
                    if(!FirstNameFlag) foreignRealPerson.setFirstName("");
                    if(!LastNameFlag) foreignRealPerson.setLastName("");
                    if(!FatherNameFlag) foreignRealPerson.setFatherName("");
                    if(!GrandFatherFlag)foreignRealPerson.setGrandFatherName("");
                    if(!GenderFlag)foreignRealPerson.setGender("");
                    if(!StatusFlasg)foreignRealPerson.setStatus("");
                    if(!ReferenceIdFlag)foreignRealPerson.setReferenceId("");
                    if(!ErrorCodeFlag)foreignRealPerson.setErrorCode("");
                    if (!ErrorDescriptionFlag) foreignRealPerson.setErrorDescription("");

                    if(!IdentificationDocumentFlag)
                    {
                        foreignRealPerson.setIdentificationDocumentNumber("نامشخص");
                        foreignRealPerson.setIdentificationDocumentType("نامشخص");
                    }
                    if(!NumberFlag)foreignRealPerson.setIdentificationDocumentNumber("نامشخص");
                    if(!typeFlag)foreignRealPerson.setIdentificationDocumentType("نامشخص");

                    if (!BirthCountryFlag)
                    {
                        foreignRealPerson.setBirthCountry_countryid("-1");
                        foreignRealPerson.setBirthCountry_PersianName("نامشخص");
                        foreignRealPerson.setBirthCountry_LatinName("نامشخص");
                        foreignRealPerson.setBirthCountry_Alphabet("نامشخص");
                        foreignRealPerson.setBirthCountry_IsArabic("نامشخص");
                    }
                    if(!BirthCountry_countryId)foreignRealPerson.setBirthCountry_countryid("-1");
                    if(!BirthCountry_PersianFlag)foreignRealPerson.setBirthCountry_PersianName("نامشخص");
                    if(!BirthCountry_latinFlag)foreignRealPerson.setBirthCountry_LatinName("نامشخص");
                    if(!BirthCountry_AlphabetFlag)foreignRealPerson.setBirthCountry_Alphabet("نامشخص");
                    if(!BirthCountry_IsArabicFlag)foreignRealPerson.setBirthCountry_IsArabic("نامشخص");


                    if (!NationalityFlag)
                    {
                        foreignRealPerson.setNationality_countryid("-1");
                        foreignRealPerson.setNationality_PersianName("نامشخص");
                        foreignRealPerson.setNationality_LatinName("نامشخص");
                        foreignRealPerson.setNationality_Alphabet("نامشخص");
                        foreignRealPerson.setNationality_IsArabic("نامشخص");
                    }
                    if(!Nationality_CountryId)foreignRealPerson.setNationality_countryid("-1");
                    if(!Nationality_PersianNameFlag)foreignRealPerson.setNationality_PersianName("نامشخص");
                    if(!Nationality_LatinNameFlag)foreignRealPerson.setNationality_LatinName("نامشخص");;
                    if(!Nationality_AlphabetFlag)foreignRealPerson.setNationality_Alphabet("نامشخص");;
                    if(!Nationality_IsArabicFlag)foreignRealPerson.setNationality_IsArabic("نامشخص");;

                    if (!ShahabInfoFlag){
                        foreignRealPerson.setShahabCode("-1111111111111111");
                        foreignRealPerson.setIsConfirmed("");
                    }
                    if (!ShahabInfo_ShahabCodeFlag) foreignRealPerson.setShahabCode("-1111111111111111");
                    if (!ShahabInfo_IsConfirmedFlag) foreignRealPerson.setIsConfirmed("");


                    session.beginTransaction();
                    session.save(foreignRealPerson);
                    session.getTransaction().commit();
                    foreignRealPerson = null;
        }
        session.close();
        sessionFactory.close();
    }
}
