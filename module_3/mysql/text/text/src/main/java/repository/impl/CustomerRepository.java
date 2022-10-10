package repository.impl;

import model.Customer;
import repository.BaseRepository;
import repository.ICustomerRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private static final String SELECT_ALL_CUSTOMER = "SELECT * FROM customer ;";
    private static final String INSERT_CUSTOMER = "INSERT INTO customer (name,date_of_birth,gender,id_card,phone_number,email,address,customer_type_id) VALUE (?,?,?,?,?,?,?,?);";
    private static final String DELETE_CUSTOMER = "delete from customer  WHERE id = ?;";
    private static final String SELECT_CUSTOMER = "SELECT * FROM customer WHERE id =?;";
    private static final String UPDATE_CUSTOMER = "update customer set name = ?, date_of_birth = ?, " +
            "gender = ?, id_card = ?, phone_number = ?,email = ?, " +
            "address = ?, customer_type_id = ? where id = ? ;";
    private static final String FIND_CUSTOMER = "SELECT * FROM customer WHERE name like ? ;";

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int customerId = resultSet.getInt("id");
                String customerName = resultSet.getString("name");
                String customerBirthday = resultSet.getString("date_of_birth");
                int customerGender = resultSet.getInt("gender");
                String customerIdCard = resultSet.getString("id_card");
                String customerPhone = resultSet.getString("phone_number");
                String customerEmail = resultSet.getString("email");
                String customerAddress = resultSet.getString("address");
                int customerTypeId = resultSet.getInt("customer_type_id");
                customers.add(new Customer(customerId, customerName, customerBirthday, customerGender, customerIdCard, customerPhone, customerEmail, customerAddress, customerTypeId));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customers;
    }


    public static void main(String[] args) {
        List<Customer> demo = new CustomerRepository().findAll();
        for(Customer customer : demo) {
            System.out.println(customer);
        }
    }
    @Override
    public boolean create(Customer customer) {

        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER);
            preparedStatement.setString(1, customer.getCustomerName());
            preparedStatement.setString(2, customer.getCustomerBirthday());
            preparedStatement.setInt(3, customer.getCustomerGender());
            preparedStatement.setString(4, customer.getCustomerIdCard());
            preparedStatement.setString(5, customer.getCustomerPhone());
            preparedStatement.setString(6, customer.getCustomerEmail());
            preparedStatement.setString(7, customer.getCustomerAddress());
            preparedStatement.setInt(8, customer.getCustomerTypeId());
            int num = preparedStatement.executeUpdate();
            return num == 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int idDelete) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER);
            preparedStatement.setInt(1, idDelete);
            int num = preparedStatement.executeUpdate();
            return num == 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Customer> findCustomerByName(String name) {
        List<Customer> customers = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_CUSTOMER);
            preparedStatement.setString(1,"%"+name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int customerId = resultSet.getInt("id");
                String customerName = resultSet.getString("name");
                String customerBirthday = resultSet.getString("date_of_birth");
                int customerGender = resultSet.getInt("gender");
                String customerIdCard = resultSet.getString("id_card");
                String customerPhone = resultSet.getString("phone_number");
                String customerEmail = resultSet.getString("email");
                String customerAddress = resultSet.getString("address");
                int customerTypeId = resultSet.getInt("customer_type_id");
                customers.add(new Customer(customerId, customerName, customerBirthday, customerGender, customerIdCard, customerPhone, customerEmail, customerAddress, customerTypeId));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return customers;
    }
    @Override
    public Customer findCustomerByID(int id) {
        Customer customer = new Customer();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int customerId = resultSet.getInt("id");
                String customerName = resultSet.getString("name");
                String customerBirthday = resultSet.getString("date_of_birth");
                int customerGender = resultSet.getInt("gender");
                String customerIdCard = resultSet.getString("id_card");
                String customerPhone = resultSet.getString("phone_number");
                String customerEmail = resultSet.getString("email");
                String customerAddress = resultSet.getString("address");
                int customerTypeId = resultSet.getInt("customer_type_id");
                customer = new Customer(customerId, customerName, customerBirthday, customerGender, customerIdCard, customerPhone, customerEmail, customerAddress, customerTypeId);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customer;
    }

    @Override
    public boolean edit(Customer customer) {
        boolean rowUpdated = false;
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER);
            preparedStatement.setString(1, customer.getCustomerName());
            preparedStatement.setString(2, customer.getCustomerBirthday());
            preparedStatement.setInt(3, customer.getCustomerGender());
            preparedStatement.setString(4, customer.getCustomerIdCard());
            preparedStatement.setString(5, customer.getCustomerPhone());
            preparedStatement.setString(6, customer.getCustomerEmail());
            preparedStatement.setString(7, customer.getCustomerAddress());
            preparedStatement.setInt(8, customer.getCustomerTypeId());
            preparedStatement.setInt(9, customer.getCustomerId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowUpdated;
    }
}
