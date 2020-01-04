package group9;


public class Booking {

    private long checkInDate;
    private long checkOutDate;
    private double price;
    private Customer customer;
    private Rooms room;


    Booking(Rooms room, long checkInDate, long checkOutDate, double price, Customer customer) {
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.price = price;
        this.customer = customer;

        }

    long getCheckInDate() {
        return checkInDate;
    }

    void setCheckInDate(long checkInDate) {
        this.checkInDate = checkInDate;
    }

    long getCheckOutDate() {
        return checkOutDate;
    }

    void setCheckOutDate(long checkOutDate) {
        this.checkOutDate = checkOutDate;
    }


    void setPrice(double price) {
        this.price = price;
    }

    double getPrice() {
        return price;
    }

    Customer getCustomer() {
        return customer;
    }

    Rooms getRoom() {
        return room;
    }

    void setRoom(Rooms room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "\nRoom booked: " + room +
                "\nCheck in on: " + checkInDate +
                "\nCheck out on: " + checkOutDate +
                "\nPrice: " + price + "SEK" +
                "\nCustomer who booked: " + customer + "\n";
    }
}




