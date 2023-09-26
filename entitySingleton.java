package pizzaSingleton;

public class entitySingleton {
    // Single instance of the class
    private static entitySingleton singleInstance = null;

    // Class Attributes
    private String Name;
    private String Address;
    private String Phone;
    private String Email;
    private int JobID;

    // Private constructor to prevent instantiating from outside
    private entitySingleton() {
        Name = "";
        Address = "";
        Phone = "";
        Email = "";
    }

    // Provide global access point to the single instance
    public static entitySingleton getInstance() {
        if (singleInstance == null) {
            singleInstance = new entitySingleton();
        }
        return singleInstance;
    }
    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getAddress() {
        return Address;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getPhone() {
        return Phone;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getEmail() {
        return Email;
    }

    public void setID(int jobID) {
        if (jobID == 0) {
            JobID = 0;
            Name = "";
            Address = "";
            Phone = "";
            Email = "";
        } else if (jobID > 0 && jobID < 9) {
            JobID = jobID;
            Phone = "";
            Email = "";
        } else {
            System.out.print("\n Person not part of the entity. ");
        }
    }

    public int getID() {
        return JobID;
    }

    // Class copy constructor
    public entitySingleton(entitySingleton e) {
        Name = e.Name;
        Address = e.Address;
        Phone = e.Phone;
        Email = e.Email;
        JobID = e.JobID;
    }
}
