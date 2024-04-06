package com.kyukeoton_b.kyukeotonB_be.domain.clova.dto;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SummaryRequest {
    private Document document;
    private Option option;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Document {
        private String title;
        private String content;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Option {
        private String language;
        private String model;
        private int tone;
        private int summaryCount;
    }
}