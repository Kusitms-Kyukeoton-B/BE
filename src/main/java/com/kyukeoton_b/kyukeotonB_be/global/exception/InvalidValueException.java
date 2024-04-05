package com.kyukeoton_b.kyukeotonB_be.global.exception;


import com.kyukeoton_b.kyukeotonB_be.global.code.BaseErrorCode;

public class InvalidValueException extends GeneralException {
    private BaseErrorCode baseErrorCode;
    public InvalidValueException(BaseErrorCode baseErrorCode) {
        super(baseErrorCode);
    }
}