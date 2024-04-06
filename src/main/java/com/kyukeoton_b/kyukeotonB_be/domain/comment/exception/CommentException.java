package com.kyukeoton_b.kyukeotonB_be.domain.comment.exception;

import com.kyukeoton_b.kyukeotonB_be.global.code.BaseErrorCode;
import com.kyukeoton_b.kyukeotonB_be.global.exception.GeneralException;

public class CommentException extends GeneralException {
    private BaseErrorCode baseErrorCode;
    public CommentException(BaseErrorCode baseErrorCode) {
        super(baseErrorCode);
    }
}
