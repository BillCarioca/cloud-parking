package edu.bill.dio.parking.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Ticket {
    @Id
    private Long id;
    @ManyToOne
    private Vehicle vehicle;
    private LocalDateTime entryDate = LocalDateTime.now();
    private LocalDateTime exitDate;
    private Double bill;
    public Ticket() {    }
    public Ticket(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    public LocalDateTime getEntryDate() {
        return entryDate;
    }
    public void setEntryDate(LocalDateTime entryDate) {
        this.entryDate = entryDate;
    }
    public LocalDateTime getExitDate() {
        return exitDate;
    }
    public void setExitDate(LocalDateTime exitDate) {
        this.exitDate = exitDate;
    }
    public Double getBill() {
        return bill;
    }
    public void setBill(Double bill) {
        this.bill = bill;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
