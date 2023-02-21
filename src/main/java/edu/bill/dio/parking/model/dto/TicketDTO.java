package edu.bill.dio.parking.model.dto;

import edu.bill.dio.parking.model.Vehicle;

public class TicketDTO {
    Vehicle vehicle;
    public TicketDTO() {
    }
    public TicketDTO(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
