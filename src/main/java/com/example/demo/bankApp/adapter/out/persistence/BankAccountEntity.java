package com.example.demo.bankApp.adapter.out.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name="account")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountEntity {

    @Id @GeneratedValue
    private Long id;
    private String userName;
    private String bankName;
    private BigDecimal balance;

}
