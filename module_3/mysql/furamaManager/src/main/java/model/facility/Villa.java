package model.facility;

public class Villa extends Facility{
    private String description_other_convenience;
    private int number_of_floors;
    private int pool_area;

    public Villa() {
    }

    public Villa(int id, String name, int area, double cost, int amount_people, String rent_type_id, String description_other_convenience, int number_of_floors, int pool_area) {
        super(id, name, area, cost, amount_people, rent_type_id);
        this.description_other_convenience = description_other_convenience;
        this.number_of_floors = number_of_floors;
        this.pool_area = pool_area;
    }

    public String getDescription_other_convenience() {
        return description_other_convenience;
    }

    public void setDescription_other_convenience(String description_other_convenience) {
        this.description_other_convenience = description_other_convenience;
    }

    public int getNumber_of_floors() {
        return number_of_floors;
    }

    public void setNumber_of_floors(int number_of_floors) {
        this.number_of_floors = number_of_floors;
    }
}
