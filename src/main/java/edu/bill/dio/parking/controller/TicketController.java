package edu.bill.dio.parking.controller;

import edu.bill.dio.parking.model.Ticket;
import edu.bill.dio.parking.model.dto.TicketDTO;
import edu.bill.dio.parking.service.TicketService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
@Api(tags = "Tickets Controller")
public class TicketController {
    @Autowired
    TicketService ticketService;
    @PostMapping
    @ApiOperation("Create Ticket")
    ResponseEntity<Ticket> create(@RequestBody TicketDTO dto){
        Ticket ticket = ticketService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(ticket);
    }
    @GetMapping
    @ApiOperation("Find Tickets")
    ResponseEntity<List<Ticket>> findAll(){
        List<Ticket> tickets = ticketService.findAll();
        return ResponseEntity.ok(tickets);
    }
    @GetMapping("/{id}")
    @ApiOperation("Find Ticket")
    ResponseEntity<Ticket> findById(@PathVariable Long id){
        Ticket ticket = ticketService.findById(id);
        return ResponseEntity.ok(ticket);
    }
    @PutMapping("/{id}")
    @ApiOperation("Update Ticket")
    ResponseEntity <Ticket> updateById(@PathVariable Long id,@RequestBody TicketDTO dto){
        Ticket ticket = ticketService.updateById(id,dto);
        return ResponseEntity.ok(ticket);
    }
    @DeleteMapping("/{id}")
    @ApiOperation("Delete Ticket")
    ResponseEntity deleteById(@PathVariable Long id){
        ticketService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
