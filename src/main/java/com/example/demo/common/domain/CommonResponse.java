package com.example.demo.common.domain;

import com.example.demo.common.exception.constants.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> {

    private int status;
    private Result result;
    private T data;
    private String message;
    private ErrorCode errorCode;

    public static <T> CommonResponse<T> success(T data){
        return (CommonResponse<T>) CommonResponse.builder()
                .status(HttpStatus.OK.value())
                .result(Result.SUCCESS)
                .data(data)
                .build();
    }
    public static CommonResponse fail(HttpStatus httpStatus, String message, ErrorCode errorCode){
        return CommonResponse.builder()
                .status(httpStatus.value())
                .result(Result.FAIL)
                .message(message)
                .errorCode(errorCode)
                .build();
    }
    public static CommonResponse fail(HttpStatus httpStatus, ErrorCode errorCode){
        return fail(httpStatus, null, errorCode);
    }
    public enum Result{
        SUCCESS,FAIL
    }
}
