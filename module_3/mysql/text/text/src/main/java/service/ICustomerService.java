package service;

import model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    boolean create(Customer customer);

    boolean delete(int idDelete);

    List<Customer> findCustomerByName(String name);
    Customer findCustomerByID(int id);

    boolean edit(Customer customer);
}
