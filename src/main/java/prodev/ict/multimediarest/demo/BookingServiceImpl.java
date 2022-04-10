package prodev.ict.multimediarest.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
@Service
@Transactional
public class BookingServiceImpl implements BookingService{
  @Autowired
    private BookingRepository bookingRepository;

    @Override
    public List<Long> getExpiredBookings(LocalDate queryDate) {
        return bookingRepository.getExpiredBookings(queryDate);
    }
    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
}
