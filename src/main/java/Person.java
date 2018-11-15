/**
 * Created by saazimi on 15/11/2018.
 */
public class Person {
    private String NationalCode;
    private String FirstName;
    private String LastName;
    private String BirthDate;
    private String IssueNumber;
    private String ShahabCode;
    private String IsConfirmed;

    public Person(String nationalCode, String firstName, String lastName, String birthDate, String issueNumber, String shahabCode, String isConfirmed) {
        NationalCode = nationalCode;
        FirstName = firstName;
        LastName = lastName;
        BirthDate = birthDate;
        IssueNumber = issueNumber;
        ShahabCode = shahabCode;
        IsConfirmed = isConfirmed;
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
