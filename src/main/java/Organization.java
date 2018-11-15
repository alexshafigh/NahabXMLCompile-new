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

    public Organization(String nationalId, String name, String registerNumber, String registerDate, String registerLocation, String shahabCode, String isConfirmed) {
        NationalId = nationalId;
        Name = name;
        RegisterNumber = registerNumber;
        RegisterDate = registerDate;
        RegisterLocation = registerLocation;
        ShahabCode = shahabCode;
        IsConfirmed = isConfirmed;
    }

    public Organization() {
        NationalId = "";
        Name = "";
        RegisterNumber = "";
        RegisterDate = "";
        RegisterLocation = "";
        ShahabCode = "";
        IsConfirmed = "";
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
