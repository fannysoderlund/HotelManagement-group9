package pack;

import java.util.ArrayList;

public class Booking {
    private Customer customer;
    ArrayList<Rooms> rooms;

    int roomNo;
    long checkInDate;
    long checkOutDate;
    float price;
    int booking_id = -1;
    boolean availability;
    private Object Customer;

    public Booking(Object customer) {
        Customer = customer;
        this.customer = new Customer();
        rooms = new ArrayList<>();
        availability = false;


    }

    public void removeRoom(String roomNo) {
        for (Rooms a : rooms) {
            if (a.getRoomNo() == Integer.parseInt((roomNo))) {
                rooms.remove(a);
            }
        }
    }

    public void addRoom(String roomNo) {
        rooms.add(new Rooms(roomNo));

    }

    public ArrayList<Customer> getCustomer() {
        return (ArrayList<pack.Customer>) Customer;
    }

    public ArrayList<Rooms> getRooms() {
        return rooms;
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


    public void setPrice(float price) {
        this.price = price;
    }

}


