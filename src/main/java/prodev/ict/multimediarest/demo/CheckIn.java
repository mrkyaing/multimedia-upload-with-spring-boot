package prodev.ict.multimediarest.demo;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;


@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditLogListener.class)
public class CheckIn extends CommonEntity {
    private String mobileUserId;
    private String locationId;
    private String description;
}