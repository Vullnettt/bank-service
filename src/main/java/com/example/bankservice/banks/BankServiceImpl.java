package com.example.bankservice.banks;

import com.example.bankservice.banks.utils.BankMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BankServiceImpl implements BankService {

    private final BankRepository bankRepository;
    private final BankMapper bankMapper;

    private final Logger log = LoggerFactory.getLogger(BankServiceImpl.class);

    public BankServiceImpl(BankRepository bankRepository,
                           BankMapper bankMapper) {
        this.bankRepository = bankRepository;
        this.bankMapper = bankMapper;
    }
}
