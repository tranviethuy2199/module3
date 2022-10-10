package service.impl;

import Repository.BaseRepository;
import model.facility.House;
import model.person.Employee;
import service.iterface.IHouseService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HouseServiceImpl implements IHouseService {
    private static final String INSERT_HOUSE = "INSERT INTO house(`name`,`area`,`cost`,`amount_people`,`rent_type_id`,`description_other_convenience`,`description_other_convenience`) VALUES(?,?,?,?,?,?,?)";
    private static final String SELECT_HOUSE_BY_ID = "SELECT name,area,cost,amount_people,rent_type_id,description_other_convenience,description_other_convenience FROM employee WHERE id =?";
    private static final String SELECT_ALL_HOUSE = "SELECT * FROM house";
    private static final String DELETE_HOUSE = "DELETE FROM house WHERE id = ?";
    private static final String UPDATE_HOUSE = "UPDATE house SET name=? , area=? cost=? ,amount_people=?, rent_type_id=?,description_other_convenience=?,description_other_convenience=? WHERE id=?";


    public HouseServiceImpl(){};

    @Override
    public void insertHouse(House house) throws SQLException {
        try {
            // name,area,cost,amount,rent,des,number
            Connection connection = BaseRepository.getConnectDB();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_HOUSE);
            preparedStatement.setString(1,house.getName());
            preparedStatement.setInt(2,house.getArea());
            preparedStatement.setDouble(3,house.getCost());
            preparedStatement.setInt(4,house.getAmount_people());
            preparedStatement.setString(5,house.getRent_type_id());
            preparedStatement.setString(6,house.getDescription_other_convenience());
            preparedStatement.setInt(7,house.getNumber_of_floors());
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            printSQLException(e);
        }

    }

    @Override
    public House selectHouse(int id) {
        House house = null ;
        try {
            Connection connection = BaseRepository.getConnectDB();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_HOUSE_BY_ID);
            preparedStatement.setInt(1,id);
            System.out.printf(String.valueOf(preparedStatement));
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                // name,area,cost,amount,rent,des,number
                String name = rs.getString("name");
                int area = rs.getInt("area");
                double cost = rs.getDouble("cost");
                int amount_people = rs.getInt("amount_people");
                String rent_type_id = rs.getString("rent_type_id");
                String description_other_convenience = rs.getString("description_other_convenience");
                int number_of_floors = rs.getInt("number_of_floors");
                house = new House(id,name,area,cost,amount_people,rent_type_id,description_other_convenience,number_of_floors);
            }

        }  catch (SQLException e) {
            printSQLException(e);
        }
        return house;
    }

    @Override
    public List<House> selectAllHouse() {
        List<House> houses = new ArrayList<>();
        try {
            Connection connection = BaseRepository.getConnectDB();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_HOUSE);{
                System.out.printf("preparedStatement");
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int area = rs.getInt("area");
                    double cost = rs.getDouble("cost");
                    int amount_people = rs.getInt("amount_people");
                    String rent_type_id = rs.getString("rent_type_id");
                    String description_other_convenience = rs.getString("description_other_convenience");
                    int number_of_floors = rs.getInt("number_of_floors");
                    houses.add(new House(id,name,area,cost,amount_people,rent_type_id,description_other_convenience,number_of_floors));
                }
            }
        }catch (SQLException e) {
            printSQLException(e);
        }
        return houses;
    }

    @Override
    public boolean deleteHouse(int id) throws SQLException {
        boolean rowDeleted = false;
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement statement = connection.prepareStatement(DELETE_HOUSE);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateHouse(House house) throws SQLException {
        boolean rowUpdated = false;
        Connection connection = BaseRepository.getConnectDB();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_HOUSE);
        try {
            // name,area,cost,amount,rent,des,number
            preparedStatement.setString(1,house.getName());
            preparedStatement.setInt(2,house.getArea());
            preparedStatement.setDouble(3,house.getCost());
            preparedStatement.setInt(4,house.getAmount_people());
            preparedStatement.setString(5,house.getRent_type_id());
            preparedStatement.setString(6,house.getDescription_other_convenience());
            preparedStatement.setInt(7,house.getNumber_of_floors());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        }catch (SQLException e) {
            printSQLException(e);
        }
        return rowUpdated;
    }

    @Override
    public List<House> findByName(String name) throws SQLException {
        List<House> houseList = new ArrayList<>();
        List<House> houses = selectAllHouse();
        for (House house : houses) {
            if (house.getName().equals(name)) {
                houseList.add(house);
            }
        }
        return houseList;
    }

    @Override
    public House getHouseById(int id) {
        House house = null;
        try {
            Connection connection = BaseRepository.getConnectDB();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_HOUSE);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                int area = rs.getInt("area");
                double cost = rs.getDouble("cost");
                int amount_people = rs.getInt("amount_people");
                String rent_type_id = rs.getString("rent_type_id");
                String description_other_convenience = rs.getString("description_other_convenience");
                int number_of_floors = rs.getInt("number_of_floors");
                house = new House(id,name,area,cost,amount_people,rent_type_id,description_other_convenience,number_of_floors);

            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return house;
    }

    @Override
    public void addHouseTransaction(House house, int[] permision) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        PreparedStatement pstmtAssignment = null;
        ResultSet rs = null;
        try {
            conn = BaseRepository.getConnectDB();
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(INSERT_HOUSE, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, house.getName());
            pstmt.setInt(1, house.getArea());
            pstmt.setDouble(1, house.getCost());
            pstmt.setInt(1, house.getAmount_people());
            pstmt.setString(1, house.getRent_type_id());
            pstmt.setString(1, house.getDescription_other_convenience());
            pstmt.setInt(1, house.getNumber_of_floors());
            int rowAffected = pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();
            int houseId = 0;
            if (rs.next())
                houseId = rs.getInt(1);
            if (rowAffected == 1) {
                String sqlPivot = "INSERT INTO user_permision(house_id,permision_id) "
                        + "VALUES(?,?)";

                pstmtAssignment = conn.prepareStatement(sqlPivot);

                for (int permisionId : permision) {
                    pstmtAssignment.setInt(1, houseId);
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
    public void deleteHousePro(int id) {
        try {
            Connection connection = BaseRepository.getConnectDB();
            CallableStatement cs = connection.prepareCall(DELETE_HOUSE);
            cs.setInt(1, id);
            cs.executeUpdate();
        } catch (SQLException throwAbles) {
            throwAbles.printStackTrace();
        }
    }

    @Override
    public List<House> selectAllHousePro() throws SQLException {
        List<House> houseList = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_HOUSE);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int area = rs.getInt("area");
                double cost = rs.getDouble("cost");
                int amount_people = rs.getInt("amount_people");
                String rent_type_id = rs.getString("rent_type_id");
                String description_other_convenience = rs.getString("description_other_convenience");
                int number_of_floors = rs.getInt("number_of_floors");
                House house =new House(id,name,area,cost,amount_people,rent_type_id,description_other_convenience,number_of_floors);
                houseList.add(house);
            }
        } catch (SQLException throwAbles) {
            throwAbles.printStackTrace();
        }
        return houseList;
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

}
