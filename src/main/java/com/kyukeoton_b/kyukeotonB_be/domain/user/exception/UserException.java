package com.kyukeoton_b.kyukeotonB_be.domain.user.exception;

import com.kyukeoton_b.kyukeotonB_be.global.code.BaseErrorCode;
import com.kyukeoton_b.kyukeotonB_be.global.exception.GeneralException;

public class UserException extends GeneralException {
    private BaseErrorCode baseErrorCode;
    public UserException(BaseErrorCode baseErrorCode) {
        super(baseErrorCode);
    }
}
