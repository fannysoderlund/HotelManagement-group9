package group9;

public class Customer {
    private String name;
    private String SSN;
    private String address;
    private String phone;
    private boolean checkedIn;

    Customer(String name, String SSN, String address, String phone, boolean checkedIn) {
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

    void setSSN(String SSN) {
        this.SSN = SSN;
    }

    String getAddress() {
        return address;
    }

    void setAddress(String address) {
        this.address = address;
    }

    String getPhone() {
        return phone;
    }

    void setPhone(String phone) {
        this.phone = phone;
    }

    boolean isCheckedIn() {
        return checkedIn;
    }

    void setCheckedIn(boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

    @Override
    public String toString() {
        String checkedIn;
        if (isCheckedIn()) {
            checkedIn = "Customer is checked in";
        } else {
            checkedIn = "Customer is not checked in";
        }
        return "\nName: " + name +
                "\nSSN: " + SSN + "\nAddress: "
                + address + "\nPhone number: " + phone
                + "\n" + checkedIn + "\n";
    }


}
