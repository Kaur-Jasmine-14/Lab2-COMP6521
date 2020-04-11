import java.util.Date;

/**
 * Class to define the dataset represented in the file
 */
public class Dataset {
    int EmpID;
    Date LastUpdate;
    String EmName;
    int Gender;
    int Dept;
    int SIN;
    String Address;


    public Dataset(int empID, Date lastUpdate, String emName, int gender, int dept, int SIN, String address) {
        EmpID = empID;
        LastUpdate = lastUpdate;
        EmName = emName;
        Gender = gender;
        Dept = dept;
        this.SIN = SIN;
        Address = address;
    }

    public long getEmpID() {
        return EmpID;
    }

    public Date getLastUpdate() {
        return LastUpdate;
    }
}