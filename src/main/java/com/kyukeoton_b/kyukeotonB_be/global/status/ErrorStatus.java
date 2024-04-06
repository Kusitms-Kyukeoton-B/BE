package com.kyukeoton_b.kyukeotonB_be.global.status;

import com.kyukeoton_b.kyukeotonB_be.global.code.BaseErrorCode;
import com.kyukeoton_b.kyukeotonB_be.global.dto.ErrorReasonDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {
    //기본(전역) 에러
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR,"COMMON_500", "서버에서 요청을 처리 하는 동안 오류가 발생했습니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON_400", "입력 값이 잘못된 요청 입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON_401", "인증이 필요 합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON_403", "금지된 요청 입니다."),

    //User 관련 에러
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "USER_001", "사용자를 찾을 수 없습니다."),
    FAILED_TO_LOGIN_ID(HttpStatus.NOT_FOUND,"USER_002","아이디가 일치하지 않습니다."),
    FAILED_TO_LOGIN_PWD(HttpStatus.NOT_FOUND, "USER_003","비밀번호가 일치하지 않습니다."),
    INVALID_USER_JWT(HttpStatus.FORBIDDEN,"USER_004","권한이 없는 유저의 접근입니다."),
    S3_NOT_FOUND(HttpStatus.NOT_FOUND,"S3_001","이미지를 처리하는데 오류가 발생하였습니다"),

    POST_NOT_FOUND(HttpStatus.NOT_FOUND,"POST_001","게시물을 찾지 못했습니다."),
    POST_TALK_NOT_FOUND(HttpStatus.NOT_FOUND, "POST_001", "도파밍 토크 글을 찾을 수 없습니다."),
    COMMENT_NOT_FOUND(HttpStatus.NOT_FOUND,"COMMENT_001","코멘트를 찾지 못했습니다."),

    INVALID_BODY(HttpStatus.BAD_REQUEST, "BODY_ERROR", "Body가 올바르지 않습니다.");


    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDto getReason() {
        return ErrorReasonDto.builder()
                .isSuccess(false)
                .code(code)
                .message(message)
                .build();
    }

    @Override
    public ErrorReasonDto getReasonHttpStatus() {
        return ErrorReasonDto.builder()
                .isSuccess(false)
                .httpStatus(httpStatus)
                .code(code)
                .message(message)
                .build();
    }


}
