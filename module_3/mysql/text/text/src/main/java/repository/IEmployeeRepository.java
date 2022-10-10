package repository;

import model.Employee;

import java.util.List;

public interface IEmployeeRepository {
    List<Employee> findAll();

    boolean create(Employee employee);

    boolean delete(int idDelete);

    List<Employee> findEmployeeByName(String name);
    Employee findEmployeeByID(int id);

    boolean edit(Employee employee);
}