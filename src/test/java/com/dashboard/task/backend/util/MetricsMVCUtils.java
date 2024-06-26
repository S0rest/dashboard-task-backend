package com.dashboard.task.backend.util;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

public class MetricsMVCUtils {

    private static final String BASE_URL = "/api/v1/metrics";

    public static ResultActions getMetrics(MockMvc mvc) throws Exception {
        return mvc.perform(get(BASE_URL));
    }

    public static ResultActions getMetricsWithSearch(String search, MockMvc mvc) throws Exception {
        return mvc.perform(get(BASE_URL + "?search=" + search));
    }

    public static ResultActions getMetric(int id, MockMvc mvc) throws Exception {
        return mvc.perform(get(BASE_URL + '/' + id));
    }
}
