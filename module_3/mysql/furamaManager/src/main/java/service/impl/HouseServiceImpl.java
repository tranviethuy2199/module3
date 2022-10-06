package service.impl;

import model.facility.House;
import model.person.Customer;
import service.iterface.IHouseService;

import java.util.ArrayList;
import java.util.List;

public class HouseServiceImpl implements IHouseService {
    private static final ArrayList<House> houses = new ArrayList<>();

    @Override
    public List<House> findAll() {
        return null;
    }

    @Override
    public void save(House house) {

    }

    @Override
    public Customer findById(int id) {
        return null;
    }

    @Override
    public void update(House house) {

    }

    @Override
    public void remove(int id) {

    }
}
