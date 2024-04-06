package com.kyukeoton_b.kyukeotonB_be.domain.s3.exception;

import com.kyukeoton_b.kyukeotonB_be.global.code.BaseErrorCode;
import com.kyukeoton_b.kyukeotonB_be.global.exception.GeneralException;

public class S3Exception extends GeneralException {
    private BaseErrorCode baseErrorCode;
    public S3Exception(BaseErrorCode baseErrorCode) {
        super(baseErrorCode);
    }
}
