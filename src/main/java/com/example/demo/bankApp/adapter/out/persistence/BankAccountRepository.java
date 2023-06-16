package com.example.demo.bankApp.adapter.out.persistence;

import com.example.demo.bankApp.domain.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccountEntity,Long> {
}
