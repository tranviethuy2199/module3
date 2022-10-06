package model.person;

import java.util.Objects;

public class Employee extends Person {
    private String education_degree;
    private String position_id;
    private String division;

    public Employee() {
    }

    public Employee(int id, String name, String dayOfBirth, String cmnd, String email, String gender, String education_degree, String position_id, String division) {
        super(id, name, dayOfBirth, cmnd, email, gender);
        this.education_degree = education_degree;
        this.position_id = position_id;
        this.division = division;
    }

    public String getEducation_degree() {
        return education_degree;
    }

    public void setEducation_degree(String education_degree) {
        this.education_degree = education_degree;
    }

    public String getPosition_id() {
        return position_id;
    }

    public void setPosition_id(String position_id) {
        this.position_id = position_id;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
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
