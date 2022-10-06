package service.impl;

import model.person.Customer;
import service.iterface.ICustomerService;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements ICustomerService {
    private static final ArrayList<Customer> customers = new ArrayList<>();

    static {
            customers.add(new Customer(1,"huy","02/01/1999","123456789","huytran211998@gmail.com","nam","gold" ,"Việt Nam"));
            customers.add(new Customer(2,"hoa","02/01/1989","987654321","hoa@gmail.com","nữ","silver" ,"Việt Nam"));
            customers.add(new Customer(3,"jackson","10/01/1990","123456789","jackson@gmail.com","nam","Diamond" ,"Việt Nam"));
            customers.add(new Customer(4,"bidden","20/01/1997","123456789","bidden@gmail.com","nam","gold" ,"Việt Nam"));
            customers.add(new Customer(5,"donal trump","05/01/1988","123456789","donaltrump@gmail.com","nam","Diamond" ,"Việt Nam"));
            customers.add(new Customer(6,"putin","09/01/1995","123456789","puttin@gmail.com","nam","gold" ,"Việt Nam"));
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public void save(Customer customer) {
        customers.add(customer);
    }

    @Override
    public Customer findById(int id) {
        for (Customer customer : customers){
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public void update(Customer customer) {
        int index = customers.indexOf(customer);
        customers.set(index,customer);
    }

    @Override
    public void remove(int id) {
        customers.remove(id);
    }

    @Override
    public List<Customer> findByName(String name) {
        List<Customer> customerList = new ArrayList<>();
        for (Customer customer : customers){
            if (customer.getName().equals(name)) {
                customerList.add(customer);
            }
        }
        return customerList;
    }
}
