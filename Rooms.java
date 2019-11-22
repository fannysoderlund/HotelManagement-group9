package pack;



public class Rooms  {
    int roomNo;
    int noOfBeds;
    boolean balcony;
    private double price;

    public double getPrice() {
        return price;
    }

    public Rooms(String roomNo) {
        super();
    }


    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public int getNoOfBeds() {
        return noOfBeds;
    }

    public void setNoOfBeds(int noOfBeds) {
        this.noOfBeds = noOfBeds;
    }

    public boolean isBalcony() {
        return this.balcony = balcony;
    }

    public void setBalcony(boolean balcony) {
        this.balcony = balcony;
    }



    public void setPrice(double price) {
        this.price = price;
    }



    public Rooms(int roomNo, int noOfBeds, boolean balcony, double price, boolean availability) {
        this.roomNo = roomNo;
        this.noOfBeds = noOfBeds;
        this.balcony = balcony;
        this.price = price;

    }
}
