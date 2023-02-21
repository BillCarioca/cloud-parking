package edu.bill.dio.parking.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Vehicle {
    @Id
    private Long id;
    private String license;
    private String state;
    private String model;
    private String color;
    @OneToMany
    @JsonIgnore
    private Set<Ticket> ticketSet = new LinkedHashSet<>();
    public Vehicle() {    }
    public Vehicle(String license, String state, String model, String color) {
        this.license = license;
        this.state = state;
        this.model = model;
        this.color = color;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getLicense() {
        return license;
    }
    public void setLicense(String license) {
        this.license = license;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public Set<Ticket> getTicketSet() {
        return ticketSet;
    }
    public void setTicketSet(Set<Ticket> ticketSet) {
        this.ticketSet = ticketSet;
    }
}
