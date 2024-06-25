package com.dashboard.task.backend.metrics.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdMockData {
    private int id;
    @JsonProperty("ad_name")
    private String adName;
    private int impressions;
    private int clicks;
    private double cost;
    private int conversions; // installs
    private double revenue;
    private BigDecimal ctr;
    private BigDecimal cpc;
    private BigDecimal cpm;
    private BigDecimal cpa;
    private BigDecimal roas;
}
