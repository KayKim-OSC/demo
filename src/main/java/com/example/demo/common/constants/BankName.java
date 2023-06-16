package com.example.demo.common.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum BankName {
    WOORI("우리"),
    HANA("하나"),
    KAKAO("카카오"),
    ETC("기타");
    private final String name;

    public  String getBankName(Object... arg){
        return String.format(name, arg);
    }
}
