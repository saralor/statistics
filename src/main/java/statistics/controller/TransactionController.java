package statistics.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import statistics.model.Transaction;
import statistics.service.TransactionService;

import static java.lang.System.currentTimeMillis;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static statistics.service.TransactionService.TIME_LIMIT;

@Controller
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @RequestMapping(value = "/transactions", method = POST)
    public ResponseEntity<Void> create(@Valid @NotNull @RequestBody Transaction transaction) {
        if (currentTimeMillis() - transaction.getTimestamp() > TIME_LIMIT) {
            // Assume that we are to save a transaction only if it happened within the last minute
            return new ResponseEntity<>(NO_CONTENT);
        } else {
            transactionService.create(transaction);
            return new ResponseEntity<>(CREATED);
        }
    }

}
