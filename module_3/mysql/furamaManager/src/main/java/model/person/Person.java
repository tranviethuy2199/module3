package model.person;

import java.util.Objects;

public class Person {
    private int id;
    private String name;
    private String dateOfBirth;
    private String cmnd;
    private String email;
    private String phone_number;

    public Person() {
    }

    public Person(int id, String name, String dateOfBirth, String cmnd, String email,  String phone_number) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.cmnd = cmnd;
        this.email = email;
        this.phone_number = phone_number;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dayOfBirth) {
        this.dateOfBirth = dayOfBirth;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dayOfBirth='" + dateOfBirth + '\'' +
                ", cmnd='" + cmnd + '\'' +
                ", email='" + email + '\'' +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }

    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Customer customer = (Customer) o;
//        return id == customer.getId();
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }


}
