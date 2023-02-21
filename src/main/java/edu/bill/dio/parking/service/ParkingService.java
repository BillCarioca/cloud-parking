package edu.bill.dio.parking.service;

import edu.bill.dio.parking.model.Ticket;
import edu.bill.dio.parking.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
@Service
public class ParkingService {
    public static final int ONE_HOUR = 60;
    public static final int TWENTY_FOUR_HOUR = 24 * ONE_HOUR;
    public static final double ONE_HOUR_VALUE = 5.00;
    public static final double ADDITIONAL_PER_HOUR_VALUE = 2.00;
    public static final double DAY_VALUE = 20.00;
    @Autowired
    TicketRepository ticketRepository;

    public Double finishTicket(Long id){
        Ticket ticketFinish = ticketRepository.findById(id).get();
        ticketFinish.setExitDate(LocalDateTime.now());
        ticketFinish.setBill(getBill(ticketFinish.getEntryDate()));
        ticketRepository.save(ticketFinish);
        return ticketFinish.getBill();
    }

    private static Double getBill(LocalDateTime entryDate) {
        LocalDateTime exitDate = LocalDateTime.now();
        long minutes = entryDate.until(exitDate, ChronoUnit.MINUTES);
        Double bill = 0.0;
        if (minutes <= ONE_HOUR) {
            return ONE_HOUR_VALUE;
        }
        if (minutes <= TWENTY_FOUR_HOUR) {
            bill = ONE_HOUR_VALUE;
            int hours = (int) (minutes / ONE_HOUR);
            System.out.println(hours);
            for (int i = 0; i < hours; i++) {
                bill += ADDITIONAL_PER_HOUR_VALUE;
            }
            return bill;
        }
        int days = (int) (minutes / TWENTY_FOUR_HOUR);
        System.out.println(days);
        for (int i = 0; i < days; i++) {
            bill += DAY_VALUE;
        }
        return bill;
    }

}
