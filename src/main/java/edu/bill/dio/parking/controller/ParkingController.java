package edu.bill.dio.parking.controller;

import edu.bill.dio.parking.handler.BusinessException;
import edu.bill.dio.parking.model.Ticket;
import edu.bill.dio.parking.repository.TicketRepository;
import edu.bill.dio.parking.service.ParkingService;
import edu.bill.dio.parking.service.TicketService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bill")
@Api(tags = "Bill Parking Controller")
public class ParkingController {
    @Autowired
    TicketService ticketService;
    @Autowired
    ParkingService parkingService;

    @GetMapping
    @ApiOperation("Find Ticket not Paid")
    ResponseEntity<Set<Ticket>> findAllBill(){
        Set<Ticket> ticketsNotPaid= ticketService.findAll().stream().filter(x -> x.getExitDate()==null).collect(Collectors.toSet());
        return ResponseEntity.ok(ticketsNotPaid);
    }
    @PutMapping("/{id}")
    @ApiOperation("Paid Ticket")
    ResponseEntity<Double> finishTicket(@PathVariable Long id,@RequestBody boolean confirmation){
        if (confirmation) {
            Double bill = parkingService.finishTicket(id);
            return ResponseEntity.ok(bill);
        } else throw new BusinessException("Ticket not Finish!");
    }

}
