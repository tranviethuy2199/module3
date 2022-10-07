package service.iterface;

import model.person.Customer;
import model.person.Employee;

import java.sql.SQLException;
import java.util.List;

public interface IEmployeeService {
//    List<Employee> findAll();
//
//    void save(Employee employee);
//
//    Employee findById(int id);
//
//    void update(Employee employee);
//
//    void remove(int id);
//
//    List<Employee> findByName(String name);

    public void insertEmployee(Employee employee) throws SQLException;

    public Employee selectEmployee(int id);

    public List<Employee> selectAllEmployee();

    public boolean deleteEmployee(int id) throws SQLException;

    public boolean updateEmployee(Employee employee) throws SQLException;

    List<Employee> findByName(String name) throws SQLException;

//    public List<Employee> sort(String sortByName) throws SQLException;

    Employee getEmployeeById(int id);

//    void editEmployeeStore(Employee employee) throws SQLException;

    void addEmployeeTransaction(Employee employee, int[] permision);

    void deleteEmployeePro (int id);

    public List<Employee> selectAllEmployeePro() throws SQLException;
}
