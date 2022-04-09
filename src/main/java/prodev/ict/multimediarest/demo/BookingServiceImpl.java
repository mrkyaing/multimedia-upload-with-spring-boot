package prodev.ict.multimediarest.demo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class BookingServiceImpl implements BookingService{
  private BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public List<Long> getExpiredBookings(LocalDate queryDate) {
        return bookingRepository.getExpiredBookings(queryDate);
    }
}
