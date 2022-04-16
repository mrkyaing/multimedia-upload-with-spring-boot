package prodev.ict.multimediarest.demo;

import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.time.LocalDateTime;

public abstract class AbstractEntityListener<E> {

    void doCreate(E entity) {
        postProcess(entity,"CREATE");
    }
    void doUpdate(E entity) {
        postProcess(entity, "UPDATE");
    }
    void doDelete(E entity) {
        postProcess(entity, "DELETE");
    }
    private void postProcess(E entity, String action) {
        TransactionSynchronizationManager.registerSynchronization(
                new TransactionSynchronizationAdapter() {
                    @Override
                    public void afterCompletion(int status) {
                        if (status == STATUS_COMMITTED) {
                            persist(entity, action);
                        }
                    }
                });
    }
    private void persist(E entity, String action) {
        EntityManagerFactory entityManagerFactory = AuditUtil.getBean(EntityManagerFactory.class);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CommonEntity auditEntity = mapAuditEntity(entity);
        auditEntity.setAuditAction(action);
        auditEntity.setCreatedDate(LocalDateTime.now());
        entityManager.getTransaction().begin();
        entityManager.persist(auditEntity);
        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    abstract CommonEntity mapAuditEntity(E entity);
}