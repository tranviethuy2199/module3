package service.impl;

import model.Customer;
import repository.ICustomerRepository;
import repository.impl.CustomerRepository;
import service.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    ICustomerRepository iCustomerRepository = new CustomerRepository();
    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public boolean create(Customer customer) {
        return iCustomerRepository.create(customer);
    }

    @Override
    public boolean delete(int idDelete) {
        return iCustomerRepository.delete(idDelete);
    }

    @Override
    public List<Customer> findCustomerByName(String name) {
        return iCustomerRepository.findCustomerByName(name);
    }

    @Override
    public Customer findCustomerByID(int id) {
        return iCustomerRepository.findCustomerByID(id);
    }

    @Override
    public boolean edit(Customer customer) {
        return iCustomerRepository.edit(customer);
    }
}
