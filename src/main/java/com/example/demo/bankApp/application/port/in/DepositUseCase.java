package com.example.demo.bankApp.application.port.in;

import java.math.BigDecimal;

public interface DepositUseCase {
    void deposit(Long id, BigDecimal amount);
}
