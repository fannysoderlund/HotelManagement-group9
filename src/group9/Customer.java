package group9;

public class Customer {
    private String name;
    private String SSN;
    private String address;
    private String phone;
    private boolean checkedIn;

    public Customer(String name, String SSN, String address, String phone, boolean checkedIn) {
        this.name = name;
        this.SSN = SSN;
        this.address = address;
        this.phone = phone;
        this.checkedIn = checkedIn;
    }


    public String getName() {
        return name;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(boolean checkedIn) {
        this.checkedIn = false;
    }

    @Override
    public String toString() {
        String checkedIn;
        if (isCheckedIn()) {
            checkedIn = "Customer is checked in";
        } else {
            checkedIn = "Customer is not checked in";
        }
        return "Name: " + name + "   " + "SSN: " + SSN + "   " + "address: " + address + "   " + ", phone number: " + phone + ",    " + checkedIn;
    }


}
