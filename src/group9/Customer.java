package group9;

public class Customer {
    private String name;
    private String SSN;
    private String address;
    private long phone;
    private boolean checkedIn;

    Customer(String name, String SSN, String address, long phone, boolean checkedIn) {
        this.name = name;
        this.SSN = SSN;
        this.address = address;
        this.phone = phone;
        this.checkedIn = checkedIn;
    }




    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    long getPhone() {
        return  phone;
    }

    void setPhone(long phone) {
        this.phone = phone;
    }

    boolean isCheckedIn() {
        return  checkedIn;
    }

    void setCheckedIn(boolean checkedIns) {
        this.checkedIn = false;
    }

    @Override
    public String toString() {
        String checkedIn;
        if (isCheckedIn()) {
            checkedIn= "Customer is checked in";
        } else {
            checkedIn= "Customer is not checked in";
        }
        return "Name: " + name +
                ", SSN: " + SSN +
                ", address: " + address +
                ", phone number: " + phone +
                ", " + checkedIn;
    }
}
