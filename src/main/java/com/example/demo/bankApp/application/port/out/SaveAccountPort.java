package com.example.demo.bankApp.application.port.out;

import com.example.demo.bankApp.domain.BankAccount;

public interface SaveAccountPort {
    void save(BankAccount bankAccount);
}
