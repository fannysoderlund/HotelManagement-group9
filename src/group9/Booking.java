package group9;



public class Booking {

    Rooms room;
    long checkInDate;
    long checkOutDate;
    double price;
    Customer customer;


    public Booking(Rooms room, long checkInDate, long checkOutDate, double price, Customer customer) {
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.price = price;
        this.customer = customer;

    }

    public Rooms getRoom() {
        return room;
    }

    public void setRoom(Rooms room) {
        this.room = room;
    }

    public long getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(long checkInDate) {
        this.checkInDate = checkInDate;
    }

    public long getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(long checkOutDate) {
        this.checkOutDate = checkOutDate;
    }


    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Room booked: " + room +
                ", Check in on: " + checkInDate +
                ", Check out on: " + checkOutDate +
                ", Price: " + price + "SEK";
    }
}


