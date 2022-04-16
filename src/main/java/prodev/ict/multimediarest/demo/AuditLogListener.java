package prodev.ict.multimediarest.demo;

import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;

public class AuditLogListener extends AbstractEntityListener<ProductEntity> {
    @PostPersist
    public void onCreate(ProductEntity entity) {
        // Custom updates on the modified entity, if any.
        doCreate(entity);
    }
    @PostUpdate
    public void onUpdate(ProductEntity entity) {
        // Custom updates on the modified entity, if any.
        doUpdate(entity);
    }
    @PostRemove
    public void onDelete(ProductEntity entity) {
        // Custom updates on the modified entity, if any.
        doDelete(entity);
    }
    @Override
    public AuditLogEntity mapAuditEntity(ProductEntity entity) {
        // Populate the audit entity from data in the modified entity.
       return  null;
    }
}