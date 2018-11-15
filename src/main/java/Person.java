import javax.persistence.*;

/**
 * Created by saazimi on 15/11/2018.
 */
@Entity
@Table(name = "Person_nahab_Sample")
public class Person {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String NationalCode;
    private String FirstName;
    private String LastName;
    private String BirthDate;
    private String IssueNumber;
    private String ShahabCode;
    private String IsConfirmed;
    private String ErrorCode;
    private String ErrorDescription;

    public Person() {
        NationalCode = "";
        FirstName ="";
        LastName ="";
        BirthDate = "";
        IssueNumber = "";
        ShahabCode = "";
        IsConfirmed = "";
        ErrorCode ="";
        ErrorDescription = "";
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

    public String getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(String birthDate) {
        BirthDate = birthDate;
    }

    public String getIssueNumber() {
        return IssueNumber;
    }

    public void setIssueNumber(String issueNumber) {
        IssueNumber = issueNumber;
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
