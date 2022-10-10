package service.iterface;

import model.facility.House;
import model.person.Customer;
import model.person.Employee;

import java.sql.SQLException;
import java.util.List;

public interface IHouseService {
//    List<House> findAll();
//
//    void save(House house);
//
//    Customer findById(int id);
//
//    void update(House house);
//
//    void remove(int id);

    public void insertHouse(House house) throws SQLException;

    public House selectHouse(int id);

    public List<House> selectAllHouse();

    public boolean deleteHouse(int id) throws SQLException;

    public boolean updateHouse(House house) throws SQLException;

    List<House> findByName(String name) throws SQLException;

//    public List<House> sort(String sortByName) throws SQLException;

    House getHouseById(int id);

//    void editHouseStore(House house) throws SQLException;

    void addHouseTransaction(House house, int[] permision);

    void deleteHousePro (int id);

    public List<House> selectAllHousePro() throws SQLException;
}
