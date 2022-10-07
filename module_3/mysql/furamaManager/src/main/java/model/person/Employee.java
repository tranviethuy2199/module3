package model.person;

import java.util.Objects;

public class Employee extends Person {
    private int education_degree;
    private int position_id;
    private int division_id;
    private double salary;
    private String address;

    public Employee() {
    }

    public Employee(int id, String name, String dateOfBirth, String cmnd, String email,
                    String phone_number, int education_degree, int position_id, int division_id, double salary, String address) {
        super(id, name, dateOfBirth, cmnd, email,  phone_number);
        this.education_degree = education_degree;
        this.position_id = position_id;
        this.division_id = division_id;
        this.salary = salary;
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getEducation_degree() {
        return education_degree;
    }

    public void setEducation_degree(int education_degree) {
        this.education_degree = education_degree;
    }

    public int getPosition_id() {
        return position_id;
    }

    public void setPosition_id(int position_id) {
        this.position_id = position_id;
    }

    public int getDivision_id() {
        return division_id;
    }

    public void setDivision_id(int division_id) {
        this.division_id = division_id;
    }
        @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employee.getId() == employee.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }


}
