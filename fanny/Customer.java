package pack;


import java.util.ArrayList;

public class Customer {
    String name;
    String SSN;
    String address;
    long phone;
    boolean checkedIn;



    public String getName() {
        return this.name=name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSSN() {
        return this.SSN =SSN;
    }

    public void setSSN(long SSN) {
        this.SSN = SSN;
    }

    public String getAddress() {
        return this.address= address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhone() {
        return this.phone= phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public boolean isCheckedIn() {
        return this.checkedIn= checkedIn;
    }

    public void setCheckedIn(boolean checkedIn) {
        this.checkedIn = checkedIn;
    }
}