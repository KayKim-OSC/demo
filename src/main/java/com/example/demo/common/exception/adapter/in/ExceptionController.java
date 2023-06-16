package com.example.demo.common.exception.adapter.in;

import com.example.demo.common.domain.CommonResponse;
import com.example.demo.common.exception.constants.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
@Slf4j
public class ExceptionController {
    @ExceptionHandler(value = NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CommonResponse onNosuchElementException(NoSuchElementException e){
        return CommonResponse.fail(HttpStatus.NOT_FOUND, ErrorCode.DATA_NOT_FOUND.getErrorMsg(),ErrorCode.DATA_NOT_FOUND);
    }
}
