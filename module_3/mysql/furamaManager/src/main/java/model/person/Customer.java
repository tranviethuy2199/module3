package model.person;

import java.util.Objects;

public class Customer extends Person {
    private String customer_type;
    private String address;

    public Customer() {
    }

    public Customer(int id, String name, String dayOfBirth, String cmnd, String email, String gender, String customer_type, String address) {
        super(id, name, dayOfBirth, cmnd, email, gender);
        this.customer_type = customer_type;
        this.address = address;
    }

    public String getCustomer_type() {
        return customer_type;
    }

    public void setCustomer_type(String customer_type) {
        this.customer_type = customer_type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "customer_type='" + customer_type + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
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
