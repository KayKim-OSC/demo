package com.example.demo.bankApp.application.service;

import com.example.demo.bankApp.application.port.in.DepositUseCase;
import com.example.demo.bankApp.application.port.in.WithdrawUseCase;
import com.example.demo.bankApp.application.port.out.LoadAccountPort;
import com.example.demo.bankApp.application.port.out.SaveAccountPort;
import com.example.demo.bankApp.domain.BankAccount;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
@RequiredArgsConstructor
public class BackAccountService implements DepositUseCase, WithdrawUseCase {

    private final LoadAccountPort loadAccountPort;
    private final SaveAccountPort saveAccountPort;

    @Override
    public void deposit(Long id, BigDecimal amount) {
        BankAccount bankAccount = loadAccountPort.load(id);
        bankAccount.deposit(amount);
        saveAccountPort.save(bankAccount);
    }

    @Override
    public boolean withdraw(Long id, BigDecimal amount) {
        BankAccount bankAccount = loadAccountPort.load(id);
        boolean hasWithDraw = bankAccount.withdraw(amount);
        if(hasWithDraw){
            saveAccountPort.save(bankAccount);
        }
        return hasWithDraw;
    }
}
