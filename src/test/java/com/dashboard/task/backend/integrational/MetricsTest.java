package com.dashboard.task.backend.integrational;

import com.dashboard.task.backend.WebIntegrationTest;
import com.dashboard.task.backend.util.MetricsMVCUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class MetricsTest extends WebIntegrationTest {
    @Test
    @DisplayName("User can get all metrics")
    public void getAllMetrics() throws Exception {

        MetricsMVCUtils.getMetrics(mvc)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(5)));
    }

    @Test
    @DisplayName("User can get metric by id")
    public void getMetricWithId() throws Exception {

        MetricsMVCUtils.getMetric(1, mvc)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.ad_name").value("Ad-Campaign-1"));
    }

    @Test
    @DisplayName("User can't get metric with invalid id")
    public void getMetricWithInvalidId() throws Exception {

        MetricsMVCUtils.getMetric(12, mvc)
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Ad campaign with id: 12 is not found"));
    }

    @Test
    @DisplayName("User can get metrics with search term")
    public void getMetricWithSearch() throws Exception {

        MetricsMVCUtils.getMetricsWithSearch("ad-campaign-2", mvc)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].ad_name").value("Ad-Campaign-2"));
    }
}
