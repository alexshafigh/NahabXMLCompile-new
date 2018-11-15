import javax.persistence.*;

/**
 * Created by saazimi on 15/11/2018.
 */
@Entity
@Table(name = "Foreign_person_nahab_sample")
public class ForeignRealPerson {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String NationalCode;
    private String IdentificationDocumentNumber;
    private String IdentificationDocumentType;
    private String BirthDate;

    private String BirthCountry_countryid;
    private String BirthCountry_PersianName;
    private String BirthCountry_LatinName;
    private String BirthCountry_Alphabet;
    private String BirthCountry_IsArabic;

    private String FirstName;
    private String LastName;
    private String FatherName;
    private String GrandFatherName;


    private String Nationality_countryid;
    private String Nationality_PersianName;
    private String Nationality_LatinName;
    private String Nationality_Alphabet;
    private String Nationality_IsArabic;

    private String Gender;

    private String ShahabCode;
    private String IsConfirmed;

    private String Status;
    private String ReferenceId;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getReferenceId() {
        return ReferenceId;
    }

    public void setReferenceId(String referenceId) {
        ReferenceId = referenceId;
    }

    private String ErrorCode;
    private String ErrorDescription;

    public ForeignRealPerson() {
        NationalCode="";
        IdentificationDocumentNumber="";
        IdentificationDocumentType="";
        BirthDate="";
        BirthCountry_countryid="";
        BirthCountry_PersianName="";
        BirthCountry_LatinName="";
        BirthCountry_Alphabet="";
        BirthCountry_IsArabic="";
        FirstName="";
        LastName="";
        FatherName="";
        GrandFatherName="";
        Nationality_countryid="";
        Nationality_PersianName="";
        Nationality_LatinName="";
        Nationality_Alphabet="";
        Nationality_IsArabic="";
        Gender ="";
        ShahabCode ="";
        IsConfirmed ="";
        ReferenceId = "";
        Status = "";
        ErrorCode ="";
        ErrorDescription = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNationalCode() {
        return NationalCode;
    }

    public void setNationalCode(String nationalCode) {
        NationalCode = nationalCode;
    }

    public String getIdentificationDocumentNumber() {
        return IdentificationDocumentNumber;
    }

    public void setIdentificationDocumentNumber(String identificationDocumentNumber) {
        IdentificationDocumentNumber = identificationDocumentNumber;
    }

    public String getIdentificationDocumentType() {
        return IdentificationDocumentType;
    }

    public void setIdentificationDocumentType(String identificationDocumentType) {
        IdentificationDocumentType = identificationDocumentType;
    }

    public String getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(String birthDate) {
        BirthDate = birthDate;
    }

    public String getBirthCountry_countryid() {
        return BirthCountry_countryid;
    }

    public void setBirthCountry_countryid(String birthCountry_countryid) {
        BirthCountry_countryid = birthCountry_countryid;
    }

    public String getBirthCountry_PersianName() {
        return BirthCountry_PersianName;
    }

    public void setBirthCountry_PersianName(String birthCountry_PersianName) {
        BirthCountry_PersianName = birthCountry_PersianName;
    }

    public String getBirthCountry_LatinName() {
        return BirthCountry_LatinName;
    }

    public void setBirthCountry_LatinName(String birthCountry_LatinName) {
        BirthCountry_LatinName = birthCountry_LatinName;
    }

    public String getBirthCountry_Alphabet() {
        return BirthCountry_Alphabet;
    }

    public void setBirthCountry_Alphabet(String birthCountry_Alphabet) {
        BirthCountry_Alphabet = birthCountry_Alphabet;
    }

    public String getBirthCountry_IsArabic() {
        return BirthCountry_IsArabic;
    }

    public void setBirthCountry_IsArabic(String birthCountry_IsArabic) {
        BirthCountry_IsArabic = birthCountry_IsArabic;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getFatherName() {
        return FatherName;
    }

    public void setFatherName(String fatherName) {
        FatherName = fatherName;
    }

    public String getGrandFatherName() {
        return GrandFatherName;
    }

    public void setGrandFatherName(String grandFatherName) {
        GrandFatherName = grandFatherName;
    }

    public String getNationality_countryid() {
        return Nationality_countryid;
    }

    public void setNationality_countryid(String nationality_countryid) {
        Nationality_countryid = nationality_countryid;
    }

    public String getNationality_PersianName() {
        return Nationality_PersianName;
    }

    public void setNationality_PersianName(String nationality_PersianName) {
        Nationality_PersianName = nationality_PersianName;
    }

    public String getNationality_LatinName() {
        return Nationality_LatinName;
    }

    public void setNationality_LatinName(String nationality_LatinName) {
        Nationality_LatinName = nationality_LatinName;
    }

    public String getNationality_Alphabet() {
        return Nationality_Alphabet;
    }

    public void setNationality_Alphabet(String nationality_Alphabet) {
        Nationality_Alphabet = nationality_Alphabet;
    }

    public String getNationality_IsArabic() {
        return Nationality_IsArabic;
    }

    public void setNationality_IsArabic(String nationality_IsArabic) {
        Nationality_IsArabic = nationality_IsArabic;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getShahabCode() {
        return ShahabCode;
    }

    public void setShahabCode(String shahabCode) {
        ShahabCode = shahabCode;
    }

    public String getIsConfirmed() {
        return IsConfirmed;
    }

    public void setIsConfirmed(String isConfirmed) {
        IsConfirmed = isConfirmed;
    }

    public String getErrorCode() {
        return ErrorCode;
    }

    public void setErrorCode(String errorCode) {
        ErrorCode = errorCode;
    }

    public String getErrorDescription() {
        return ErrorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        ErrorDescription = errorDescription;
    }
}
