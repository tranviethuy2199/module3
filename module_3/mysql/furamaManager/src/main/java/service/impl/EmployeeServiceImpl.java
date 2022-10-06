package service.impl;

import model.person.Employee;
import service.iterface.IEmployeeService;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService {
    private static final List<Employee> employees = new ArrayList<>();

    static {
        employees.add(new Employee(1 , "huy","02/01/1999","12345679","huytran211998@gmail.com","nam" , "cao đẳng" ,"chuyên viên" ,"marketing" ));
        employees.add(new Employee(2 , "hoàng","07/07/1998","12345679","hoangtran211998@gmail.com","nam" , "trung cấp" ,"giám sát" ,"marketing"));
        employees.add(new Employee(3 , "hoàng","02/10/1998","12345679","hoangnguyen211998@gmail.com","nam" , "đại học" ,"quản lý" ,"sale"));
        employees.add(new Employee(4 , "hưng","08/08/1997","12345679","hungtran211998@gmail.com","nam" , "cao đẳng" ,"lễ tân" ,"phục vụ"));
        employees.add(new Employee(5 , "hùng","28/02/199","12345679","hungtran211998@gmail.com","nam" , "cao đẳng" ,"phục vụ" ,"phục vụ"));
    }

    @Override
    public List<Employee> findAll() {
        return employees;
    }

    @Override
    public void save(Employee employee) {
        employees.add(employee);
    }

    @Override
    public Employee findById(int id) {
        for (Employee employee1 : employees){
            if (employee1.getId() == id) {
                return employee1;
            }
        }
        return null;
    }

    @Override
    public void update(Employee employee) {
       int index = employees.indexOf(employee);
       employees.set(index,employee);
    }

    @Override
    public void remove(int id) {
        employees.remove(id);
    }

    @Override
    public List<Employee> findByName(String name) {
        List<Employee> employeeList = new ArrayList<>();
        for (Employee employee : employees){
            if (employee.getName().equals(name)) {
                employeeList.add(employee);
            }
        }
        return employeeList;
    }
}
