package edu.bill.dio.parking.controller;

import edu.bill.dio.parking.model.Vehicle;
import edu.bill.dio.parking.model.dto.VehicleDTO;
import edu.bill.dio.parking.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    @Autowired
    VehicleService vehicleService;
    @PostMapping
    Vehicle create(@RequestBody VehicleDTO dto){
        return vehicleService.create(dto);
    }
    @GetMapping
    List<Vehicle> findAll(){
        return vehicleService.findAll();
    }
    @GetMapping("/id")
    Vehicle findById(@PathVariable Long id){
        return vehicleService.findById(id);
    }
    @PutMapping("/id")
    Vehicle updateById(@PathVariable("id") Long id,@RequestBody VehicleDTO dto){
        return vehicleService.updateById(id,dto);
    }
    @DeleteMapping("/id")
    void deleteById(@PathVariable("id") Long id){
        vehicleService.deleteById(id);
    }
}
