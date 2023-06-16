package com.example.demo.bankApp.adapter.out.persistence;

import com.example.demo.bankApp.domain.BankAccount;
import org.springframework.stereotype.Component;

@Component
public class BankAccountMapper {

    public BankAccount toDomain(BankAccountEntity entity){
        return BankAccount.builder()
                .id(entity.getId())
                .userName(entity.getUserName())
                .bankName(entity.getBankName())
                .balance(entity.getBalance())
                .build();
    }
    public BankAccountEntity toEntity(BankAccount account){
        return BankAccountEntity.builder()
                .userName(account.getUserName())
                .bankName(account.getBankName())
                .balance(account.getBalance())
                .build();
    }
}
