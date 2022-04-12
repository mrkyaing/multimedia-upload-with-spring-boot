package prodev.ict.multimediarest.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToOne;


@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CheckIn extends CommonEntity {
    private String mobileUserId;

    private String locationId;

    private String description;

}