package edu.bill.dio.parking.controller;

import edu.bill.dio.parking.model.Ticket;
import edu.bill.dio.parking.model.Vehicle;
import edu.bill.dio.parking.model.dto.VehicleDTO;
import edu.bill.dio.parking.service.VehicleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/vehicles")
@Api(tags = "Vehicles Controller")
public class VehicleController {
    @Autowired
    VehicleService vehicleService;
    @PostMapping
    @ApiOperation("Create Vehicle")
    ResponseEntity<Vehicle> create(@RequestBody VehicleDTO dto){
        Vehicle vehicle = vehicleService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(vehicle);
    }
    @GetMapping
    @ApiOperation("Find Vehicles")
    ResponseEntity<List<Vehicle>> findAll(){
        List<Vehicle> vehicles =vehicleService.findAll();
        return ResponseEntity.ok(vehicles);
    }
    @GetMapping("/{id}")
    @ApiOperation("Find Vehicle by Id")
    ResponseEntity <Vehicle> findById(@PathVariable Long id){
        Vehicle vehicle =vehicleService.findById(id);
        return ResponseEntity.ok(vehicle);
    }
    @GetMapping("/{id}/tickets")
    @ApiOperation("Find Tickets of Vehicle by Id")
    ResponseEntity<Set<Ticket>> findTicketsById(@PathVariable Long id){
        Set<Ticket> tickets =vehicleService.findTicketsById(id);
        return ResponseEntity.ok(tickets);
    }
    @PutMapping("/{id}")
    @ApiOperation("Update Vehicle by Id")
    ResponseEntity<Vehicle> updateById(@PathVariable("id") Long id,@RequestBody VehicleDTO dto){
        Vehicle vehicle = vehicleService.updateById(id,dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(vehicle);
    }
    @DeleteMapping("/{id}")
    @ApiOperation("Delete Vehicle by Id")
    ResponseEntity deleteById(@PathVariable("id") Long id){
        vehicleService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
