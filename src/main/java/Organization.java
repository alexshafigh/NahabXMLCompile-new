import javax.persistence.*;

/**
 * Created by saazimi on 15/11/2018.
 */
@Entity
@Table(name = "organization_nahab")
public class Organization {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String NationalId;
    private String Name;
    private String RegisterNumber;
    private String RegisterDate;
    private String RegisterLocation;
    private String ShahabCode;
    private String IsConfirmed;

    private String RegisterUnit;
    private String EstablishmentDate;
    private String LegalPersonType;
    private String ErrorCode;
    private String ErrorDescription;

    public Organization(String nationalId, String name, String registerNumber, String registerDate,
                        String registerLocation, String shahabCode, String isConfirmed , String registerUnit ,
                        String establishmentDate , String legalPersonType ) {
        NationalId = nationalId;
        Name = name;
        RegisterNumber = registerNumber;
        RegisterDate = registerDate;
        RegisterLocation = registerLocation;
        ShahabCode = shahabCode;
        IsConfirmed = isConfirmed;
        RegisterUnit = registerUnit;
        EstablishmentDate = establishmentDate;
        LegalPersonType = legalPersonType;
    }

    public Organization() {
        NationalId = "";
        Name = "";
        RegisterNumber = "";
        RegisterDate = "";
        RegisterLocation = "";
        ShahabCode = "";
        IsConfirmed = "";
        RegisterUnit = "";
        EstablishmentDate = "";
        LegalPersonType = "";
        ErrorCode = "";
        ErrorDescription = "";

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegisterUnit() {
        return RegisterUnit;
    }

    public void setRegisterUnit(String registerUnit) {
        RegisterUnit = registerUnit;
    }

    public String getEstablishmentDate() {
        return EstablishmentDate;
    }

    public void setEstablishmentDate(String establishmentDate) {
        EstablishmentDate = establishmentDate;
    }

    public String getLegalPersonType() {
        return LegalPersonType;
    }

    public void setLegalPersonType(String legalPersonType) {
        LegalPersonType = legalPersonType;
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

    public String getNationalId() {
        return NationalId;
    }

    public void setNationalId(String nationalId) {
        NationalId = nationalId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getRegisterNumber() {
        return RegisterNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        RegisterNumber = registerNumber;
    }

    public String getRegisterDate() {
        return RegisterDate;
    }

    public void setRegisterDate(String registerDate) {
        RegisterDate = registerDate;
    }

    public String getRegisterLocation() {
        return RegisterLocation;
    }

    public void setRegisterLocation(String registerLocation) {
        RegisterLocation = registerLocation;
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
}
