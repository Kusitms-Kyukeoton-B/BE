package com.kyukeoton_b.kyukeotonB_be.global.jwt;

import com.kyukeoton_b.kyukeotonB_be.domain.user.dto.TokenDto;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.Date;

@Slf4j
@Service
public class JwtService implements InitializingBean {
    private final UserDetailsService userDetailService;
    private final RedisService redisService;

    private static final String UUID = "uuid";
    private final Long accessTokenValidityInMilliseconds;
    private final Long refreshTokenValidityInMilliseconds;

    private String secretKey = JwtSecret.RANDOM_SECRET_KEY;
    private static Key key;
    public JwtService (UserDetailsService userDetailService, RedisService redisService) {
        this.userDetailService = userDetailService;
        this.redisService = redisService;
        this.secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes(StandardCharsets.UTF_8));
        this.accessTokenValidityInMilliseconds = JwtSecret.ACCESS_TOKEN_VALID_TIME;
        this.refreshTokenValidityInMilliseconds =  JwtSecret.REFRESH_TOKEN_VALID_TIME;
    }

    @Override
    public void afterPropertiesSet() throws Exception { //시크릿 키 설정
         key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
    }

    // TODO: 토큰 생성
    /**
     * access token과 refresh token 생성
     */
    public TokenDto createToken(String userUid){
        log.info("[createToken]: 토큰 생성 시작");
        Date now = new Date();

        String accessToken = Jwts.builder()
                .setExpiration(new Date(now.getTime() + accessTokenValidityInMilliseconds))
                .setSubject("access-token")
                .claim(UUID, userUid)
                .setIssuedAt(now)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        String refreshToken = Jwts.builder()
                .setExpiration(new Date(now.getTime() + refreshTokenValidityInMilliseconds))
                .setSubject("refresh-token")
                .claim(UUID, userUid)
                .setIssuedAt(now)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        log.info("[createToken]: 토큰 생성 완료");

        return new TokenDto(accessToken, refreshToken);
    }

    // TODO: Header에서 X-ACCESS-TOKEN 으로 JWT 추출
    public String getJwt(){
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.
                currentRequestAttributes()).getRequest();
        return request.getHeader("X-AUTH-TOKEN");
    }

    /**
     * 토큰으로부터 정보 추출
     */
    public Claims getClaims(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) { //Access Token
            return e.getClaims();
        }
    }
    /**
     * 토큰으로부터 정보 추출 - JWT 토큰에서 인증 정보 조회
     */
    public Authentication getAuthentication(String token)  {
        String uuid = getClaims(token).get(UUID).toString();
        UserDetails userDetails = userDetailService.loadUserByUsername(uuid);
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }
    /**
     * 토큰으로부터 정보 추출 - 만료 시간 조회
     */
    public long getTokenExpirationTime(String token) {
        return getClaims(token).getExpiration().getTime();
    }

    // TODO: 토큰의 유효성 및 만료 여부 확인

    /**
     * 토큰 검증 - refresh token
     */
    public boolean validateRefreshToken(String refreshToken) {
        try {
            if(redisService.getValues(refreshToken) != null && redisService.getValues(refreshToken).equals("delete")) {
                //회원 탈퇴시
                return false;
            }
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(refreshToken);
            return true;
        } catch (SignatureException e) {
            log.error("Invalid JWT signature.");
        } catch (MalformedJwtException e) {
            log.error("Invalid JWT token.");
        } catch (ExpiredJwtException e) {
            log.error("Expired JWT token.");
        } catch (UnsupportedJwtException e) {
            log.error("Unsupported JWT token.");
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty.");
        } catch (NullPointerException e){
            log.error("JWT Token is empty.");
        }
        return false;
    }

    /**
     * Filter에서 사용함.
     */
    public boolean validateAccessToken(String accessToken) {
        try {
            if (redisService.getValues(accessToken) != null && redisService.getValues(accessToken).equals("logout")) {
                // 로그아웃 했을 경우
                return false;
            }
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(accessToken);
            return true;
        } catch(ExpiredJwtException e) {
            return true; //filter에서 AccessToken 검증을 위해 쓰인다.->기간이 만료되었을 때도 true를 반환한다.
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 재발급 검증 API에서 사용
     */
    public boolean validateAccessTokenOnlyExpired(String accessToken) {
        try {
            return getClaims(accessToken)
                    .getExpiration()
                    .before(new Date());
        } catch (ExpiredJwtException e) {
            return true; //유효기간이만 만료된 유효한 토큰일 경우 true를 반환한다.
        } catch (Exception e) {
            return false;
        }
    }

}
