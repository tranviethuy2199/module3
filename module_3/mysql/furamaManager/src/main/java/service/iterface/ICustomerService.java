package service.iterface;

import model.person.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerService {
    public void insertCustomer(Customer customer) throws SQLException;

    public Customer selectCustomer(int id);

    public List<Customer> selectAllCustomer();

    public boolean deleteCustomer(int id) throws SQLException;

    public boolean updateCustomer(Customer customer) throws SQLException;

    List<Customer> findByName(String name) throws SQLException;

    Customer getCustomerById(int id);


    void addCustomerTransaction(Customer customer, int[] permision);

    void deleteCustomerPro (int id);

    public List<Customer> selectAllCustomerPro() throws SQLException;

    Customer findById(int id);



}
