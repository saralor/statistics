package statistics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import statistics.model.Transaction;
import statistics.persistance.TransactionDao;

@Service
public class TransactionService {

    public static final int TIME_LIMIT = 60000;

    @Autowired
    private TransactionDao transactionDao;

    @Autowired
    private StatisticsService statisticsService;

    public void create(Transaction transaction) {
        transactionDao.save(transaction);
        statisticsService.addTransaction(transaction);
    }

}
