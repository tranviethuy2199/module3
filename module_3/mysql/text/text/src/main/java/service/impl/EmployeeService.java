package service.impl;

import model.Employee;
import repository.IEmployeeRepository;
import repository.impl.EmployeeRepository;
import service.IEmployeeService;

import java.util.List;

public class EmployeeService implements IEmployeeService {
    private IEmployeeRepository iEmployeeRepository = new EmployeeRepository();
    @Override
    public List<Employee> findAll() {
        return iEmployeeRepository.findAll();
    }

    @Override
    public boolean create(Employee employee) {
        return iEmployeeRepository.create(employee);
    }

    @Override
    public boolean delete(int idDelete) {
        return iEmployeeRepository.delete(idDelete);
    }

    @Override
    public List<Employee> findEmployeeByName(String name) {
        return iEmployeeRepository.findEmployeeByName(name);
    }

    @Override
    public Employee findEmployeeByID(int id) {
        return iEmployeeRepository.findEmployeeByID(id);
    }

    @Override
    public boolean edit(Employee employee) {
        return iEmployeeRepository.edit(employee);
    }


}
