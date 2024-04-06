package com.kyukeoton_b.kyukeotonB_be.domain.clova.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SummaryResponse {
    private String summary;
}
