package repository;

import model.Customer;
import model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();
    boolean create(Customer customer);

    boolean delete(int idDelete);

    List<Customer> findCustomerByName(String name);
    Customer findCustomerByID(int id);

    boolean edit(Customer customer);
}
