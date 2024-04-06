package com.kyukeoton_b.kyukeotonB_be.domain.dopamine.exception;

import com.kyukeoton_b.kyukeotonB_be.global.code.BaseErrorCode;
import com.kyukeoton_b.kyukeotonB_be.global.exception.GeneralException;

public class PostTalkException extends GeneralException {
    private BaseErrorCode baseErrorCode;
    public PostTalkException(BaseErrorCode baseErrorCode) {
        super(baseErrorCode);
    }
}
