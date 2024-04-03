package com.kyukeoton_b.kyukeotonB_be.response.exception;

import com.kyukeoton_b.kyukeotonB_be.response.BaseResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BaseException extends RuntimeException {

    private BaseResponseStatus status;
    private String message;
    private int code;

    public BaseException(BaseResponseStatus status){
        this.status = status;
    }

    public BaseException(String message, int code){
        this.message = message;
        this.code = code;
    }
}