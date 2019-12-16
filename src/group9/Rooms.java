package group9;

public class Rooms {

    private int roomNo;
    private int noOfBeds;
    private boolean balcony;
    private double price;
    private boolean availability;

    Rooms(int roomNo, int noOfBeds, boolean balcony, double price, boolean availability) {
        this.roomNo = roomNo;
        this.noOfBeds = noOfBeds;
        this.balcony = balcony;
        this.price = price;
        this.availability = availability;

    }


    double getPrice() {
        return price;
    }


    int getRoomNo() {
        return roomNo;
    }

    void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    int getNoOfBeds() {
        return noOfBeds;
    }

    void setNoOfBeds(int noOfBeds) {
        this.noOfBeds = noOfBeds;
    }

    boolean isBalcony() {
        return  balcony;
    }


    void setPrice(double price) {
        this.price = price;
    }

    boolean isAvailability() {
        return availability;
    }

    void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        String balcony;
        String available;
        if (isBalcony()) {
            balcony = "It does have a balcony";
        } else {
            balcony = "It does not have a balcony";
        }
        if (isAvailability()) {
            available = "It is available";
        } else {
            available = "It is not available";
        }
        return "Room number: " + roomNo +
                ", Number of beds: " + noOfBeds +
                ", " + balcony +
                ", Price: " + price +
                "SEK , " + available;
    }


}
