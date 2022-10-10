package repository;

import model.Facility;

import java.util.List;

public interface IFacilityRepository {
    List<Facility> findAll();
}
