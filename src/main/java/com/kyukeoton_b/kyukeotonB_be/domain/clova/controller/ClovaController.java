package com.kyukeoton_b.kyukeotonB_be.domain.clova.controller;

import com.kyukeoton_b.kyukeotonB_be.domain.clova.dto.SummaryResponse;
import com.kyukeoton_b.kyukeotonB_be.domain.clova.service.ClovaService;
import com.kyukeoton_b.kyukeotonB_be.global.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ClovaController {
    private final ClovaService clovaService;

    @PostMapping("/clovatest")
    public ApiResponse<SummaryResponse> testClova(@RequestParam String content) {
        String str = clovaService.summarizeText("제목", content);
        SummaryResponse summaryRes =
                SummaryResponse.builder()
                        .summary(str)
                        .build();
        return ApiResponse.onSuccess(summaryRes);
    }

}