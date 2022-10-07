package service.impl;

import Repository.BaseRepository;
import model.person.Customer;
import model.person.Employee;
import service.iterface.IEmployeeService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService {
    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO `case_study`.`employee`(`name`,`date_of_birth`,`id_card`,`salary`,`phone_number`,`email`,`address`,`position_id`,`education_degree_id`,`division_id`,`username`) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SELECT_EMPLOYEE_BY_ID = "SELECT id,name,date_of_birth,id_card,salary,phone_number,email,address,position_id,education_degree_id,division_id FROM customer WHERE id=?";
    private static final String SELECT_ALL_EMPLOYEE = "SELECT * FROM employee";
    private static final String DELETE_EMPLOYEE_SQL = "DELETE FROM employee WHERE id = ?";
    private static final String UPDATE_EMPLOYEE_SQL = "UPDATE employee SET name = ?,date_of_birth = ?,id_card =? ,phone_number = ? ,email = ?,address = ?,position_id =?,education_degree_id = ? , division_id =? ,username=? WHERE id =?";

    public EmployeeServiceImpl(){};


    @Override
    public void insertEmployee(Employee employee) throws SQLException {
        try (Connection connection = BaseRepository.getConnectDB();
             // name,date,cmnd,salary,phone,email,address,position,education,division
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL)) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getDateOfBirth());
            preparedStatement.setString(3, employee.getCmnd());
            preparedStatement.setDouble(4, employee.getSalary());
            preparedStatement.setString(5, employee.getPhone_number());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setString(7, employee.getAddress());
            preparedStatement.setInt(8, employee.getPosition_id());
            preparedStatement.setInt(9, employee.getEducation_degree());
            preparedStatement.setInt(10, employee.getDivision_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }

    }

    @Override
    public Employee selectEmployee(int id) {
        Employee employee = null ;
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                // name,date,cmnd,salary,phone,email,address,position,education,division
                String name = rs.getString("name");
                String dateOfBirth = rs.getString("date_of_birth");
                String cmnd = rs.getString("id_card");
                double salary = rs.getDouble("salary");
                String phone_number = rs.getString("phone_number");
                String email = rs.getString("email");
                String address = rs.getString("address");
                int position_id = rs.getInt("position_id");
                int education_degree_id = rs.getInt("education_degree_id");
                int division_id = rs.getInt("division_id");
                employee = new Employee(id,name,dateOfBirth,cmnd,email,phone_number, (int) salary,position_id,education_degree_id,division_id,address);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employee;
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
    public List<Employee> selectAllEmployee() {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                // name,date,cmnd,salary,phone,email,address,position,education,division
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String dateOfBirth = rs.getString("date_of_birth");
                String cmnd = rs.getString("id_card");
                double salary = rs.getDouble("salary");
                String phone_number = rs.getString("phone_number");
                String email = rs.getString("email");
                String address = rs.getString("address");
                int position_id = rs.getInt("position_id");
                int education_degree_id = rs.getInt("education_degree_id");
                int division_id = rs.getInt("division_id");
                employees.add(new Employee(id,name,dateOfBirth,cmnd,email,phone_number, (int) salary,position_id,education_degree_id,division_id,address));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employees;
    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        boolean rowDeleted = false;
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEE_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
        boolean rowUpdated = false;
        Connection connection = BaseRepository.getConnectDB();
        PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYEE_SQL);
        try {
            // name,date,cmnd,salary,phone,email,address,position,education,division
            statement.setString(1,String.valueOf(employee.getId()));
            statement.setString(2, employee.getName());
            statement.setString(3, employee.getDateOfBirth());
            statement.setString(4, employee.getCmnd());
            statement.setDouble(5,employee.getSalary());
            statement.setString(6, employee.getPhone_number());
            statement.setString(7, employee.getEmail());
            statement.setString(8, employee.getAddress());
            statement.setInt(9, employee.getEducation_degree());
            statement.setInt(10, employee.getPosition_id());
            statement.setInt(11, employee.getDivision_id());
            rowUpdated = statement.executeUpdate() > 0;
        }catch (SQLException e) {
            printSQLException(e);
        }
        return rowUpdated;
    }

    @Override
    public List<Employee> findByName(String name) throws SQLException {
        List<Employee> employeeList = new ArrayList<>();
        List<Employee> employees = selectAllEmployee();
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                employeeList.add(employee);
            }
        }
        return employeeList;
    }

    @Override
    public Employee getEmployeeById(int id) {
        Employee employee = null;
        try {
            // name,date,cmnd,salary,phone,email,address,position,education,division
            Connection connection = BaseRepository.getConnectDB();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE_SQL);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String dateOfBirth = rs.getString("date_of_birth");
                String cmnd = rs.getString("id_card");
                double salary = rs.getDouble("salary");
                String phone_number = rs.getString("phone_number");
                String email = rs.getString("email");
                String address = rs.getString("address");
                int position_id = rs.getInt("position_id");
                int education_degree_id = rs.getInt("education_degree_id");
                int division_id = rs.getInt("division_id");
                employee = new Employee(id,name,dateOfBirth,cmnd,email,phone_number, (int) salary,position_id,education_degree_id,division_id,address);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employee;
    }

//    @Override
//    public void editEmployeeStore(Employee employee) throws SQLException {
//        try (Connection connection = BaseRepository.getConnectDB();
//             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE_SQL);) {
//            // name,date,cmnd,salary,phone,email,address,position,education,division
//            preparedStatement.setString(1, employee.getName());
//            preparedStatement.setString(2, employee.getDateOfBirth());
//            preparedStatement.setString(3, employee.getCmnd());
//            preparedStatement.setDouble(10,employee.getSalary());
//            preparedStatement.setString(5, employee.getPhone_number());
//            preparedStatement.setString(4, employee.getEmail());
//            preparedStatement.setString(9,employee.getAddress());
//            preparedStatement.setInt(6, employee.getEducation_degree());
//            preparedStatement.setInt(7, employee.getPosition_id());
//            preparedStatement.setInt(8, employee.getDivision());
//            System.out.println(preparedStatement);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//
//            printSQLException(e);
//
//        }
//    }

    @Override
    public void addEmployeeTransaction(Employee employee, int[] permision) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        PreparedStatement pstmtAssignment = null;
        ResultSet rs = null;
        try {
            conn = BaseRepository.getConnectDB();
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(INSERT_EMPLOYEE_SQL, Statement.RETURN_GENERATED_KEYS);
            // name,date,cmnd,salary,phone,email,address,position,education,division
            pstmt.setString(1, employee.getName());
            pstmt.setString(2, employee.getDateOfBirth());
            pstmt.setString(3, employee.getCmnd());
            pstmt.setDouble(9,employee.getSalary());
            pstmt.setString(5, employee.getPhone_number());
            pstmt.setString(4, employee.getEmail());
            pstmt.setString(10, employee.getAddress());
            pstmt.setInt(6, employee.getEducation_degree());
            pstmt.setInt(7, employee.getPosition_id());
            pstmt.setInt(8, employee.getDivision_id());
            int rowAffected = pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();
            int employeeId = 0;
            if (rs.next())
                employeeId = rs.getInt(1);
            if (rowAffected == 1) {
                String sqlPivot = "INSERT INTO user_permision(employee_id,permision_id) "
                        + "VALUES(?,?)";

                pstmtAssignment = conn.prepareStatement(sqlPivot);

                for (int permisionId : permision) {
                    pstmtAssignment.setInt(1, employeeId);
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
    public void deleteEmployeePro(int id) {
        try {
            Connection connection = BaseRepository.getConnectDB();
            CallableStatement cs = connection.prepareCall(DELETE_EMPLOYEE_SQL);
            cs.setInt(1, id);
            cs.executeUpdate();
        } catch (SQLException throwAbles) {
            throwAbles.printStackTrace();
        }
    }

    @Override
    public List<Employee> selectAllEmployeePro() throws SQLException {
        List<Employee> employeeList = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String dateOfBirth = rs.getString("date_of_birth");
                String cmnd = rs.getString("id_card");
                String email = rs.getString("email");
                String phone_number = rs.getString("phone_number");
                int position_id = rs.getInt("position_id");
                int education_degree_id = rs.getInt("education_degree_id");
                int division_id = rs.getInt("division_id");
                String address = rs.getString("address");
                double salary = rs.getDouble("salary");
                Employee employee =new Employee(id,name,dateOfBirth,cmnd,email,phone_number, (int) salary,position_id,education_degree_id,division_id,address);
                employeeList.add(employee);
            }
        } catch (SQLException throwAbles) {
            throwAbles.printStackTrace();
        }
        return employeeList;
    }

    public Employee findById(int id) {
        List<Employee> employees = selectAllEmployee();
        for (Employee employee : employees ){
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }
//    private static final List<Employee> employees = new ArrayList<>();
//
//    static {
//        employees.add(new Employee(1 , "huy","02/01/1999","12345679","huytran211998@gmail.com","nam" , "cao đẳng" ,"chuyên viên" ,"marketing" ));
//        employees.add(new Employee(2 , "hoàng","07/07/1998","12345679","hoangtran211998@gmail.com","nam" , "trung cấp" ,"giám sát" ,"marketing"));
//        employees.add(new Employee(3 , "hoàng","02/10/1998","12345679","hoangnguyen211998@gmail.com","nam" , "đại học" ,"quản lý" ,"sale"));
//        employees.add(new Employee(4 , "hưng","08/08/1997","12345679","hungtran211998@gmail.com","nam" , "cao đẳng" ,"lễ tân" ,"phục vụ"));
//        employees.add(new Employee(5 , "hùng","28/02/199","12345679","hungtran211998@gmail.com","nam" , "cao đẳng" ,"phục vụ" ,"phục vụ"));
//    }
//
//    @Override
//    public List<Employee> findAll() {
//        return employees;
//    }
//
//    @Override
//    public void save(Employee employee) {
//        employees.add(employee);
//    }
//
//    @Override
//    public Employee findById(int id) {
//        for (Employee employee1 : employees){
//            if (employee1.getId() == id) {
//                return employee1;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public void update(Employee employee) {
//       int index = employees.indexOf(employee);
//       employees.set(index,employee);
//    }
//
//    @Override
//    public void remove(int id) {
//        employees.remove(id);
//    }
//
//    @Override
//    public List<Employee> findByName(String name) {
//        List<Employee> employeeList = new ArrayList<>();
//        for (Employee employee : employees){
//            if (employee.getName().equals(name)) {
//                employeeList.add(employee);
//            }
//        }
//        return employeeList;
//    }
}
