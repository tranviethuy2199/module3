package service.iterface;

import model.person.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();

    void save(Employee employee);

    Employee findById(int id);

    void update(Employee employee);

    void remove(int id);

    List<Employee> findByName(String name);
}
