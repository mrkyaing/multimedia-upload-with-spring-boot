package prodev.ict.multimediarest.demo;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Booking extends CommonEntity {
    @Enumerated(value = EnumType.STRING)
    private STATUS status = STATUS.PENDING;
    private LocalDate bookingDate;
}