package com.dashboard.task.backend.metrics.service;

import com.dashboard.task.backend.metrics.data.AdMockData;

import java.util.List;

public interface MetricsService {
    List<AdMockData> getAllMetrics();

    AdMockData getMetric(int id);
}
