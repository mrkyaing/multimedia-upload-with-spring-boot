package prodev.ict.multimediarest.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CheckInRepository extends JpaRepository<CheckIn, Long> {
    List<CheckIn> findAllByCreatedDateBetween(LocalDate from, LocalDate to);
}
