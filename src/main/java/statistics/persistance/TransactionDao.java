package statistics.persistance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import statistics.model.Transaction;
import statistics.service.StatisticsService;
import statistics.service.TransactionService;

@Repository
@org.springframework.transaction.annotation.Transactional
public class TransactionDao {

    @Autowired
    private EntityManager entityManager;

    /**
     * Important: When directly invoking this method, the given transaction will NOT be added to the queue of transactions in {@link
     * StatisticsService}, thus it won't be reflected in the statistics that service provides. To get it added, use {@link
     * TransactionService#create(Transaction)} instead of this method
     */
    public void save(Transaction transaction) {
        getEntityManager().persist(transaction);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
