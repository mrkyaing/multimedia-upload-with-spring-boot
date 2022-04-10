package prodev.ict.multimediarest.demo;


import java.time.LocalDateTime;
import java.util.List;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {
  private BookingService bookingService;
  private BookingRepository bookingRepository;

    public Scheduler(BookingService bookingService,BookingRepository bookingRepository) {
        this.bookingService = bookingService;
        this.bookingRepository = bookingRepository;
    }
    @Scheduled(cron = "59 0 0 * * *")//every 5 seconds
    public void deleteOverDueDateBooking() {
        LocalDateTime now=LocalDateTime.now();
        System.out.println("Java cron job expression:: " + now);
        List<Long> bookings=bookingService.getExpiredBookings(now.toLocalDate());
        for(Long bookingId:bookings)
        {
            System.out.println(bookingId);
            bookingRepository.reject(bookingId);
       }
    }
}