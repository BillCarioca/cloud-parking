package edu.bill.dio.parking.repository;

import edu.bill.dio.parking.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long> {
}
