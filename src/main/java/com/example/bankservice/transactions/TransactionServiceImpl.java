package com.example.bankservice.transactions;

import com.example.bankservice.transactions.utils.TransactionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    private final Logger log = LoggerFactory.getLogger(TransactionServiceImpl.class);


    public TransactionServiceImpl(TransactionRepository transactionRepository,
                                  TransactionMapper transactionMapper) {
        this.transactionRepository = transactionRepository;
        this.transactionMapper = transactionMapper;
    }
}
