package com.example.demo.bankApp.adapter.out.persistence;


import com.example.demo.bankApp.application.port.out.LoadAccountPort;
import com.example.demo.bankApp.application.port.out.SaveAccountPort;
import com.example.demo.bankApp.domain.BankAccount;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.http11.filters.SavedRequestInputFilter;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class BankAccountPersistenceAdapter implements LoadAccountPort, SaveAccountPort {

    private final BankAccountMapper bankAccountMapper;
    private final BankAccountRepository bankAccountRepository;

    @Override
    public BankAccount load(Long id){
        BankAccountEntity bankAccountEntity =
                bankAccountRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return bankAccountMapper.toDomain(bankAccountEntity);
    }

    @Override
    public void save(BankAccount bankAccount){
        BankAccountEntity bankAccountEntity = bankAccountMapper.toEntity(bankAccount);
        bankAccountRepository.save(bankAccountEntity);
    }
}
