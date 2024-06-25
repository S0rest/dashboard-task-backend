package com.dashboard.task.backend.metrics.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ErrorDetails {
    @JsonProperty("status_code")
    private int statusCode;
    private String message;
    private String details;
}
