package com.kyukeoton_b.kyukeotonB_be.domain.clova.service;

import com.kyukeoton_b.kyukeotonB_be.domain.clova.dto.SummaryRequest;
import com.kyukeoton_b.kyukeotonB_be.domain.clova.dto.SummaryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClovaService {
    private final RestTemplate restTemplate;

    @Value("${spring.api.naver.client-id}")
    private String CLIENT_ID;

    @Value("${spring.api.naver.client-key}")
    private String CLIENT_SECRET;
    private static String API_URL = "https://naveropenapi.apigw.ntruss.com/text-summary/v1/summarize";

    // Request 객체 생성
    public String summarizeText(String title, String content) {

        // Request 객체 생성
        SummaryRequest.Document document = SummaryRequest.Document.builder()
                .title(title)
                .content(content)
                .build();

        SummaryRequest.Option option = SummaryRequest.Option.builder()
                .language("ko")
                .model("news")
                .tone(2)
                .summaryCount(3)
                .build();

        SummaryRequest request = SummaryRequest.builder()
                .document(document)
                .option(option)
                .build();

        // 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-NCP-APIGW-API-KEY-ID", CLIENT_ID);
        headers.set("X-NCP-APIGW-API-KEY", CLIENT_SECRET);

        System.out.println("id" + CLIENT_ID);
        System.out.println("key" + CLIENT_SECRET);

        System.out.println(headers.toString());

        // 요청 객체 생성
        HttpEntity<SummaryRequest> requestEntity = new HttpEntity<>(request, headers);
        System.out.println(requestEntity.toString());

        // API 호출
        ResponseEntity<SummaryResponse> responseEntity = restTemplate.exchange(
                API_URL,
                HttpMethod.POST,
                requestEntity,
                SummaryResponse.class
        );

        // 응답 데이터 확인
        HttpStatus statusCode = responseEntity.getStatusCode();
        if (statusCode == HttpStatus.OK) {
            SummaryResponse responseBody = responseEntity.getBody();
            return responseBody.getSummary();
        } else {
            return "Error occurred. Status code: " + statusCode;
        }
    }
}
