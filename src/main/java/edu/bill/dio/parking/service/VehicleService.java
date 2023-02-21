package edu.bill.dio.parking.service;

import edu.bill.dio.parking.model.Vehicle;
import edu.bill.dio.parking.model.dto.VehicleDTO;
import edu.bill.dio.parking.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    @Autowired
    VehicleRepository vehicleRepository;
    public Vehicle create(VehicleDTO dto){
        Vehicle newVehicle = new Vehicle(dto.getLicense(), dto.getState(), dto.getModel(), dto.getColor());
        return vehicleRepository.save(newVehicle);
    }
    public List<Vehicle> findAll(){
        return vehicleRepository.findAll();
    }
    public Vehicle findById(long id){
        return vehicleRepository.findById(id).get();
    }
    public Vehicle updateById(Long id, VehicleDTO dto){
        Vehicle vehicleUpdate = findById(id);
        vehicleUpdate.setLicense(dto.getLicense());
        vehicleUpdate.setState(dto.getState());
        vehicleUpdate.setModel(dto.getModel());
        vehicleUpdate.setColor(dto.getColor());
        return vehicleRepository.save(vehicleUpdate);
    }
    public void deleteById(Long id){
        vehicleRepository.deleteById(id);
    }
}
