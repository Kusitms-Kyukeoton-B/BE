package com.kyukeoton_b.kyukeotonB_be.global.jwt;

import lombok.Getter;

@Getter
public class JwtSecret {

    public static String RANDOM_SECRET_KEY = "kyuketonkyuketonkyuketonkyuketonkyuketonkyuketonkyuketonkyuketonkyuketonkyuketonkyuketon";

    public static long ACCESS_TOKEN_VALID_TIME = 1000L * 60 * 60 * 24 * 7; //7일 //1000L * 60 * 15;//1000L * 60 * 1; //1분 //1000L * 60 * 60; 1시간
    public static long REFRESH_TOKEN_VALID_TIME = 1000L * 60 * 60 * 24 * 60;//1000L * 60 * 60; //1시간 //1000L * 60 * 60 * 24 * 60; // 두달

    //Cookie는 초 단위 //[주의] refreshToken 기한과 쿠키 기한이 동일하게 설정되면 안됨!!! 재발급받을때 없어지면 곤란
    public static long COOKIE_EXPIRATION_TIME = 7776000; //세달 //60 * 60; //1시간 //5184000; //두달
}
