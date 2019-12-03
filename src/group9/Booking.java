package group9;



public class Booking {

    int roomNo;
    long checkInDate;
    long checkOutDate;
    double price;


    public Booking(int roomNo, long checkInDate, long checkOutDate, double price) {
        this.roomNo = roomNo;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.price = price;
    }


    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
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

    @Override
    public String toString() {
        return "Room booked: " + roomNo +
                ", Check in on: " + checkInDate +
                ", Check out on: " + checkOutDate +
                ", Price: " + price + "SEK";
    }
}


