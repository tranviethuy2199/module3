package model.person;

import java.util.Objects;

public class Customer extends Person {
    private int customer_type_id;
    private String address;
    private int gender;



    public Customer() {
    }

    public Customer(int id, String name, String dateOfBirth, String cmnd, String email, int gender, String phone_number, int customer_type_id, String address) {
        super(id, name, dateOfBirth, cmnd, email, phone_number);
        this.customer_type_id = customer_type_id;
        this.address = address;
        this.gender = gender;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getCustomer_type_id() {
        return customer_type_id;
    }

    public void setCustomer_type(int customer_type) {
        this.customer_type_id = customer_type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

//    @Override
//    public String toString() {
//        return "Customer{" +
//                "customer_type='" + customer_type_id + '\'' +
//                ", address='" + address + '\'' +
//                '}';
//    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customer.getId() == customer.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }






}
