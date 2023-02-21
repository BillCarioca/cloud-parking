package edu.bill.dio.parking.controller;

import edu.bill.dio.parking.model.Ticket;
import edu.bill.dio.parking.model.dto.TicketDTO;
import edu.bill.dio.parking.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    @Autowired
    TicketService ticketService;
    @PostMapping
    Ticket create(@RequestBody TicketDTO dto){
        return ticketService.create(dto);
    }
    @GetMapping
    List<Ticket> findAll(){
        return ticketService.findAll();
    }
    @GetMapping("/id")
    Ticket findById(@PathVariable Long id){
        return ticketService.findById(id);
    }
    @PutMapping("/id")
    Ticket updateById(@PathVariable Long id,@RequestBody TicketDTO dto){
        return ticketService.updateById(id,dto);
    }
    @DeleteMapping("/id")
    void deleteById(@PathVariable Long id){
        ticketService.deleteById(id);
    }
}
