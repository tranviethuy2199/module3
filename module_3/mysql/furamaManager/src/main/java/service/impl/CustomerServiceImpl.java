package service.impl;

import Repository.BaseRepository;
import model.person.Customer;
import service.iterface.ICustomerService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements ICustomerService {
    private static final String INSERT_CUSTOMER_SQL = "INSERT INTO `case_study`.`customer` (`customer_type_id`, `name`, `date_of_birth`, `gender`, `id_card`, `phone_number`, `email`, `address`)\n" +
            " VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "SELECT customer_type_id,name,date_of_birth,gender,id_card,phone_number,email,address FROM customer WHERE id = ?";
    private static final String SELECT_ALL_CUSTOMER = "SELECT * FROM customer";
    private static final String DELETE_USERS_SQL = "DELETE FROM customer WHERE id = ?";
    private static final String UPDATE_USERS_SQL = "UPDATE customer SET customer_type_id = ?,name = ?,date_of_birth = ?,id_card = ?,email= ?,phone_number = ? ,gender = ?,address = ? WHERE id =?";

    public CustomerServiceImpl() {
    }

    ;


    @Override
    public void insertCustomer(Customer customer) throws SQLException {
        Connection connection = BaseRepository.getConnectDB();
        try (
                // customer_type_id, name, date_of_birth, gender, id_card, phone_number, email, address
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL)) {
            preparedStatement.setInt(1, customer.getCustomer_type_id());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setString(3, customer.getDateOfBirth());
            preparedStatement.setInt(4, Integer.parseInt(String.valueOf(customer.getGender())));
            preparedStatement.setString(5, customer.getCmnd());
            preparedStatement.setString(6, customer.getPhone_number());
            preparedStatement.setString(7, customer.getEmail());
            preparedStatement.setString(8, customer.getAddress());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }

    }

    @Override
    public Customer selectCustomer(int id) {
        Customer customer = null;
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                // customer_type_id, name, date_of_birth, gender, id_card, phone_number, email, address
                int customer_type_id = rs.getInt("customer_type_id");
                String name = rs.getString("name");
                String dateOfBirth = rs.getString("date_of_birth");
                int gender = Integer.parseInt(rs.getString("gender"));
                String cmnd = rs.getString("id_card");
                String phone_number = rs.getString("phone_number");
                String email = rs.getString("email");
                String address = rs.getString("address");
                customer = new Customer(id, name, dateOfBirth, cmnd, email, gender, phone_number, customer_type_id, address);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customer;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    @Override
    public List<Customer> selectAllCustomer() {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int customer_type_id = rs.getInt("customer_type_id");
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String dateOfBirth = rs.getString("date_of_birth");
                int gender = Integer.parseInt(rs.getString("gender"));
                String cmnd = rs.getString("id_card");
                String phone_number = rs.getString("phone_number");
                String email = rs.getString("email");
                String address = rs.getString("address");
                customers.add(new Customer(id, name, dateOfBirth, cmnd, email, gender, phone_number, customer_type_id, address));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customers;
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        boolean rowDeleted = false;
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        boolean rowUpdated = false;
        Connection connection = BaseRepository.getConnectDB();
        CallableStatement cs = connection.prepareCall("{call editCustomer(?,?,?,?,?,?,?,?,?)}");
        try {


            cs.setString(1, String.valueOf(customer.getId()));
            cs.setString(2, String.valueOf(customer.getCustomer_type_id()));
            cs.setString(3, customer.getName());
            cs.setString(4, customer.getDateOfBirth());
            cs.setInt(5, customer.getGender());
            cs.setString(6, customer.getCmnd());
            cs.setString(7, customer.getPhone_number());
            cs.setString(8, customer.getEmail());
            cs.setString(9, customer.getAddress());

            rowUpdated = cs.executeUpdate() > 0;
        }catch (SQLException throwAbles) {
            throwAbles.printStackTrace();
        }
        return rowUpdated;
    }

    @Override
    public List<Customer> findByName(String name) throws SQLException {
        List<Customer> customerList = new ArrayList<>();
        List<Customer> customers = selectAllCustomer();
        for (Customer customer : customers) {
            if (customer.getName().equals(name)) {
                customerList.add(customer);
            }
        }
        return customerList;
    }

    @Override
    public Customer getCustomerById(int id) {
        Customer customer = null;
        try {
            Connection connection = BaseRepository.getConnectDB();
            CallableStatement callableStatement = connection.prepareCall(UPDATE_USERS_SQL);
            callableStatement.setInt(1, id);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                // customer_type_id, name, date_of_birth, gender, id_card, phone_number, email, address
                int customer_type_id = rs.getInt("customer_type_id");
                String name = rs.getString("name");
                String dateOfBirth = rs.getString("date_of_birth");
                int gender = Integer.parseInt(rs.getString("gender"));
                String cmnd = rs.getString("id_card");
                String phone_number = rs.getString("phone_number");
                String email = rs.getString("email");
                String address = rs.getString("address");
                customer = new Customer(id, name, dateOfBirth, cmnd, email, gender, phone_number, customer_type_id, address);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customer;
    }

//    @Override
//    public void editCustomerStore(Customer customer) throws SQLException {
//        Connection connection = BaseRepository.getConnectDB();
//        PreparedStatement PreparedStatement = connection.prepareStatement(UPDATE_USERS_SQL);
//
//        try {
//            PreparedStatement.setInt(1, customer.getCustomer_type_id());
//            PreparedStatement.setString(2, customer.getName());
//            PreparedStatement.setString(3, customer.getDateOfBirth());
//            PreparedStatement.setInt(4, customer.getGender());
//            PreparedStatement.setString(5, customer.getCmnd());
//            PreparedStatement.setString(6, customer.getPhone_number());
//            PreparedStatement.setString(7, customer.getEmail());
//            PreparedStatement.setString(8, customer.getAddress());
//            System.out.println(PreparedStatement);
//            PreparedStatement.executeUpdate();
//        } catch (SQLException throwAbles) {
//            throwAbles.printStackTrace();
//        }
//
//    }

    @Override
    public void addCustomerTransaction(Customer customer, int[] permision) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        PreparedStatement pstmtAssignment = null;
        ResultSet rs = null;
        try {
            conn = BaseRepository.getConnectDB();
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(INSERT_CUSTOMER_SQL, Statement.RETURN_GENERATED_KEYS);
            // customer_type_id, name, date_of_birth, gender, id_card, phone_number, email, address
            pstmt.setInt(1, customer.getCustomer_type_id());
            pstmt.setString(2, customer.getName());
            pstmt.setString(3, customer.getDateOfBirth());
            pstmt.setInt(4, customer.getGender());
            pstmt.setString(5, customer.getCmnd());
            pstmt.setString(6, customer.getPhone_number());
            pstmt.setString(7, customer.getEmail());
            pstmt.setString(8, customer.getAddress());
            int rowAffected = pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();
            int customerId = 0;
            if (rs.next())
                customerId = rs.getInt(1);
            if (rowAffected == 1) {
                String sqlPivot = "INSERT INTO user_permision(cutomer_id,permision_id) "
                        + "VALUES(?,?)";

                pstmtAssignment = conn.prepareStatement(sqlPivot);

                for (int permisionId : permision) {
                    pstmtAssignment.setInt(1, customerId);
                    pstmtAssignment.setInt(2, permisionId);
                    pstmtAssignment.executeUpdate();
                }
                conn.commit();
            } else {
                conn.rollback();
            }
        } catch (SQLException ex) {
            try {
                if (conn != null)
                    conn.rollback();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (pstmtAssignment != null) pstmtAssignment.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    @Override
    public void deleteCustomerPro(int id) {
        try {
            Connection connection = BaseRepository.getConnectDB();
            PreparedStatement preparedStatement = connection.prepareCall(DELETE_USERS_SQL);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwAbles) {
            throwAbles.printStackTrace();
        }
    }

    @Override
    public List<Customer> selectAllCustomerPro() throws SQLException {
        List<Customer> customerList = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                // customer_type_id, name, date_of_birth, gender, id_card, phone_number, email, address
                int id = rs.getInt("id");
                int customer_type_id = rs.getInt("customer_type_id");
                String name = rs.getString("name");
                String dateOfBirth = rs.getString("date_of_birth");
                int gender = Integer.parseInt(rs.getString("gender"));
                String cmnd = rs.getString("id_card");
                String phone_number = rs.getString("phone_number");
                String email = rs.getString("email");
                String address = rs.getString("address");
                Customer customer = new Customer(id, name, dateOfBirth, cmnd, email, gender, phone_number, customer_type_id, address);
                customerList.add(customer);
            }
        } catch (SQLException throwAbles) {
            throwAbles.printStackTrace();
        }
        return customerList;
    }

    public Customer findById(int id) {
        List<Customer> customers = selectAllCustomer();
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }
//
//    static {
//            customers.add(new Customer(1,"huy","02/01/1999","123456789","huytran211998@gmail.com","nam","gold" ,"Việt Nam"));
//            customers.add(new Customer(2,"hoa","02/01/1989","987654321","hoa@gmail.com","nữ","silver" ,"Việt Nam"));
//            customers.add(new Customer(3,"jackson","10/01/1990","123456789","jackson@gmail.com","nam","Diamond" ,"Việt Nam"));
//            customers.add(new Customer(4,"bidden","20/01/1997","123456789","bidden@gmail.com","nam","gold" ,"Việt Nam"));
//            customers.add(new Customer(5,"donal trump","05/01/1988","123456789","donaltrump@gmail.com","nam","Diamond" ,"Việt Nam"));
//            customers.add(new Customer(6,"putin","09/01/1995","123456789","puttin@gmail.com","nam","gold" ,"Việt Nam"));
//    }

//    @Override
//    public List<Customer> findAll() {
//        return customers;
//    }
//
//    @Override
//    public void save(Customer customer) {
//        customers.add(customer);
//    }
//
//    @Override
//    public Customer findById(int id) {
//        for (Customer customer : customers){
//            if (customer.getId() == id) {
//                return customer;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public void update(Customer customer) {
//        int index = customers.indexOf(customer);
//        customers.set(index,customer);
//    }
//
//    @Override
//    public void remove(int id) {
//        customers.remove(id);
//    }
//
//    @Override
//    public List<Customer> findByName(String name) {
//        List<Customer> customerList = new ArrayList<>();
//        for (Customer customer : customers){
//            if (customer.getName().equals(name)) {
//                customerList.add(customer);
//            }
//        }
//        return customerList;
//    }
}
