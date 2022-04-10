package prodev.ict.multimediarest.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository< Booking, Long > {
   @Query(value = "SELECT b.id FROM Booking b where b.status='PENDING' AND b.booking_Date<=:queryDate and b.booking_Time='23:59'",nativeQuery = true)
   List<Long> getExpiredBookings(LocalDate queryDate);

    @Transactional
    @Modifying
    @Query("update Booking b set b.status = 'REJECT' where b.id = :id")
    void reject(Long id);

    @Transactional
    @Modifying
    @Query("update Booking b set b.status = 'APPROVED' where b.id = :id")
    void confirm(Long id);
}

