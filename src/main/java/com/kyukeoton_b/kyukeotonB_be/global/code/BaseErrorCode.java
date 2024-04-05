package com.kyukeoton_b.kyukeotonB_be.global.code;


import com.kyukeoton_b.kyukeotonB_be.global.dto.ErrorReasonDto;

public interface BaseErrorCode {
    public ErrorReasonDto getReason();

    public ErrorReasonDto getReasonHttpStatus();
}
