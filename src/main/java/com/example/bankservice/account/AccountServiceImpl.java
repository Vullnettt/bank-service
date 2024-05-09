package com.example.bankservice.account;

import com.example.bankservice.account.utils.AccountMapper;
import com.example.bankservice.bank.Bank;
import com.example.bankservice.bank.BankDto;
import com.example.bankservice.bank.BankService;
import com.example.bankservice.bank.utils.BankMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    private final BankService bankService;
    private final BankMapper bankMapper;
    public AccountServiceImpl(AccountRepository accountRepository,
                              AccountMapper accountMapper,
                              BankService bankService,
                              BankMapper bankMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
        this.bankService = bankService;
        this.bankMapper = bankMapper;
    }

    @Transactional
    @Override
    public AccountDto createAccount(Long bankId, AccountDto accountDto) {
        BankDto bankDto = bankService.findById(bankId);
        Bank bank = new Bank();
        bankMapper.mapDtoToEntity(bankDto, bank);

        AccountEntity accountEntity = new AccountEntity();

        accountMapper.mapDtoToEntity(accountDto, accountEntity);

        accountEntity.setBank(bank);

        accountEntity.setCreatedAt(LocalDateTime.now());
        accountEntity.setCreatedBy(1L);
        accountEntity.setUpdatedAt(LocalDateTime.now());
        accountEntity.setUpdatedBy(1L);

        bank.getAccounts().add(accountEntity);

        accountRepository.save(accountEntity);

        accountMapper.mapEntityToDto(accountEntity, accountDto);

        return accountDto;
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<AccountEntity> accountEntities = accountRepository.findByDeletedAtIsNull();
        List<AccountDto> accountDtos = new ArrayList<>();

        accountEntities.forEach(accountEntity -> {
            AccountDto accountDto = new AccountDto();
            accountMapper.mapEntityToDto(accountEntity, accountDto);
            accountDtos.add(accountDto);
        });

        return accountDtos;
    }

    @Override
    public double getAccountBalance(Long id) {
        AccountEntity accountEntity = accountRepository.findByIdAndDeletedAtIsNull(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Account with id: " + id + " is not found!"
                ));

        return accountEntity.getBalance();
    }

    @Override
    public AccountDto findById(Long id) {
        AccountEntity accountEntity = accountRepository.findByIdAndDeletedAtIsNull(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Account with id: " + id + " is not found!"
                ));

        AccountDto accountDto = new AccountDto();
        accountMapper.mapEntityToDto(accountEntity, accountDto);

        return accountDto;
    }
}
