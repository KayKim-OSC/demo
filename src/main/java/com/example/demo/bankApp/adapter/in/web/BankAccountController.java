package com.example.demo.bankApp.adapter.in.web;

import com.example.demo.bankApp.application.port.in.DepositUseCase;
import com.example.demo.bankApp.application.port.in.WithdrawUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class BankAccountController {
    private final DepositUseCase depositUseCase;
    private final WithdrawUseCase withdrawUseCase;

    @PostMapping(value ="/deposit/{id}/{amount}")
    void deposit(@PathVariable final Long id, @PathVariable final BigDecimal amount){
        depositUseCase.deposit(id, amount);
    }

    @PostMapping("/withdraw/{id}/{amount}")
    void withdraw(@PathVariable final Long id, @PathVariable final BigDecimal amount){
        withdrawUseCase.withdraw(id, amount);
    }
}
