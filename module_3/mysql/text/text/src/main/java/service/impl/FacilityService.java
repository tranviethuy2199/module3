package service.impl;

import model.Customer;
import model.Facility;
import repository.IFacilityRepository;
import repository.impl.FacilityRepository;
import service.IFacilityService;

import java.util.List;

public class FacilityService implements IFacilityService {
    private IFacilityRepository iFacilityRepository = new FacilityRepository();
    @Override
    public List<Facility> findAll() {
        return iFacilityRepository.findAll();
    }
}
