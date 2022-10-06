package model.facility;

public class Facility {
   private int id;
   private String name;
   private int area;
   private double cost;
   private int amount_people;
   private String rent_type_id;
//   private String standard_room;
//   private String description_other;
//   private double pool_area;
//   private int number_floors;

   public Facility() {
   }

//   public Facility(int id, String name, int area, double cost, int amount_people, String rent_type, String standard_room, String description_other, double pool_area, int number_floors) {
//      this.id = id;
//      this.name = name;
//      this.area = area;
//      this.cost = cost;
//      this.amount_people = amount_people;
//      this.rent_type = rent_type;
//      this.standard_room = standard_room;
//      this.description_other = description_other;
//      this.pool_area = pool_area;
//      this.number_floors = number_floors;
//   }


   public Facility(int id, String name, int area, double cost, int amount_people, String rent_type_id) {
      this.id = id;
      this.name = name;
      this.area = area;
      this.cost = cost;
      this.amount_people = amount_people;
      this.rent_type_id = rent_type_id;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getArea() {
      return area;
   }

   public void setArea(int area) {
      this.area = area;
   }

   public double getCost() {
      return cost;
   }

   public void setCost(double cost) {
      this.cost = cost;
   }

   public int getAmount_people() {
      return amount_people;
   }

   public void setAmount_people(int amount_people) {
      this.amount_people = amount_people;
   }


   @Override
   public String toString() {
      return "Facility{" +
              "id=" + id +
              ", name='" + name + '\'' +
              ", area=" + area +
              ", cost=" + cost +
              ", amount_people=" + amount_people +
              ", rent_type_id='" + rent_type_id + '\'' +
              '}';
   }
}
