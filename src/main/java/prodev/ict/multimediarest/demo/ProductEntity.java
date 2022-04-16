package prodev.ict.multimediarest.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

@Entity
@Table(name = "product")
@EntityListeners(AuditLogListener.class)
public class ProductEntity {
    @Column(name = "productId")
    private String productId;
    @Column(name = "productname")
    private String productname;
    @Column(name = "status")
    private String status;
}