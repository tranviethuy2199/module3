package service.iterface;

import model.facility.House;
import model.person.Customer;

import java.util.List;

public interface IHouseService {
    List<House> findAll();

    void save(House house);

    Customer findById(int id);

    void update(House house);

    void remove(int id);
}
