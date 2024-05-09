package com.example.bankservice.banks;

import com.example.bankservice.banks.utils.BankMapper;
import org.springframework.stereotype.Service;

@Service
public class BankServiceImpl implements BankService {

    private final BankRepository bankRepository;
    private final BankMapper bankMapper;

    public BankServiceImpl(BankRepository bankRepository,
                           BankMapper bankMapper) {
        this.bankRepository = bankRepository;
        this.bankMapper = bankMapper;
    }
}
