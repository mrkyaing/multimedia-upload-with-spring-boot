package prodev.ict.multimediarest.demo;

import java.time.LocalDate;
import java.util.List;

public interface CheckInService {
    List<CheckIn> findAllByCreatedDateBetween(LocalDate from, LocalDate to);
    List<CheckIn> getAllCheckIn();
}
