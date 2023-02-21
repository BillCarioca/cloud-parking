package edu.bill.dio.parking.service;

import edu.bill.dio.parking.model.Ticket;
import edu.bill.dio.parking.model.dto.TicketDTO;
import edu.bill.dio.parking.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;
    public Ticket create(TicketDTO dto){
        Ticket newTicket = new Ticket(dto.getVehicle());
        return ticketRepository.save(newTicket);
    }
    public List<Ticket> findAll(){
        return ticketRepository.findAll();
    }
    public Ticket findById(Long id){
        return ticketRepository.findById(id).get();
    }
    public Ticket updateById(Long id,TicketDTO dto){
        Ticket updateTicket = findById(id);
        updateTicket.setVehicle(dto.getVehicle());
        return ticketRepository.save(updateTicket);
    }
    public void deleteById(Long id){
        ticketRepository.deleteById(id);
    }
}
