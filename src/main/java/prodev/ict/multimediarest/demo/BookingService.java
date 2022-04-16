package prodev.ict.multimediarest.demo;

import java.time.LocalDate;
import java.util.List;

public interface BookingService {
    List<Long> getExpiredBookings(LocalDate bookingDate);
    List<Booking> getAllBookings();
    boolean createBookin(Booking entity);
}
