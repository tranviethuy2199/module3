package model.facility;

public class Room extends Facility{
    private String facilty_free;

    public Room() {
    }

    public Room(int id, String name, int area, double cost, int amount_people, String rent_type_id, String facilty_free) {
        super(id, name, area, cost, amount_people, rent_type_id);
        this.facilty_free = facilty_free;
    }

    public String getFacilty_free() {
        return facilty_free;
    }

    public void setFacilty_free(String facilty_free) {
        this.facilty_free = facilty_free;
    }

    @Override
    public String toString() {
        return "Room{" +
                "facilty_free='" + facilty_free + '\'' +
                '}';
    }
}
