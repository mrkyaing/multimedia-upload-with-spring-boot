package prodev.ict.multimediarest.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
@Service
@Transactional
public class CheckInServiceImpl implements CheckInService{
    @Autowired
    CheckInRepository checkInRepository;
    @Override
    public List<CheckIn> findAllByCreatedDateBetween(LocalDate from, LocalDate to) {
        return checkInRepository.findAllByCreatedDateBetween(from,to);
    }

    @Override
    public List<CheckIn> getAllCheckIn() {
        return checkInRepository.findAll();
    }
}
