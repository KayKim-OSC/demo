package com.example.demo.common.exception.constants;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ErrorCode {
    COMMON_SYSTEM_ERROR("일시적인 오류가 발생했습니다. 잠시 후 다시 시도해주세요."),
    COMMON_INVALID_PARAMETER("요청한 값이 올바르지 않습니다."),
    DATA_NOT_FOUND("데이터가 존재하지 않습니다");
    private final String errorMsg;
    public String getErrorMsg(Object... arg){
        return String.format(errorMsg, arg);
    }

}
