package com.kyukeoton_b.kyukeotonB_be.global.code;


import com.kyukeoton_b.kyukeotonB_be.global.dto.ReasonDto;

public interface BaseCode {
    public ReasonDto getReason();

    public ReasonDto getReasonHttpStatus();
}
