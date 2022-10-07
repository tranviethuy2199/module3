package service.iterface;

import model.person.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerService {
//    List<Customer> findAll();
//
//    void save(Customer customer);
//
//    Customer findById(int id);
//
//    void update(Customer customer);
//
//    void remove(int id);
//
//    List<Customer> findByName(String name);

    public void insertCustomer(Customer customer) throws SQLException;

    public Customer selectCustomer(int id);

    public List<Customer> selectAllCustomer();

    public boolean deleteCustomer(int id) throws SQLException;

    public boolean updateCustomer(Customer customer) throws SQLException;

    List<Customer> findByName(String name) throws SQLException;

//    public List<Customer> sort(String sortByName) throws SQLException;

    Customer getCustomerById(int id);

//    void editCustomerStore(Customer customer) throws SQLException;

    void addCustomerTransaction(Customer customer, int[] permision);

    void deleteCustomerPro (int id);

    public List<Customer> selectAllCustomerPro() throws SQLException;

    Customer findById(int id);



}
