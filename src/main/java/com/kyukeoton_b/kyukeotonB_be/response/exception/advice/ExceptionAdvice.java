package com.kyukeoton_b.kyukeotonB_be.response.exception.advice;

import com.kyukeoton_b.kyukeotonB_be.response.exception.BaseException;
import com.kyukeoton_b.kyukeotonB_be.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 해당 클래스로 모든 컨트롤러에 대해 전역적으로 예외 처리가 가능합니다.
 */

@RequiredArgsConstructor
@RestControllerAdvice
public class ExceptionAdvice extends ResponseEntityExceptionHandler {

    //BaseException 처리
    @ExceptionHandler(BaseException.class)
    protected BaseResponse<Object> handleBaseException(BaseException ex) {
        if (ex.getStatus() == null) {
            return new BaseResponse<>(false, ex.getMessage(), ex.getCode());
        }
        return new BaseResponse<>(ex.getStatus());
    }

    //@valid -> 에러 발생 시 별도 처리 필요
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    protected ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpHeaders headers,
//                                                                           HttpStatus status, WebRequest request){
//        String errorMessage = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
//        BaseResponse<Object> baseResponse = new BaseResponse<>(false, errorMessage, HttpStatus.BAD_REQUEST.value());
//        return handleExceptionInternal(ex, baseResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
//    }
    // MethodArgumentNotValidException 처리


}
