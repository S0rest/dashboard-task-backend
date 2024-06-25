package com.dashboard.task.backend.metrics.service.impl;

import com.dashboard.task.backend.exceptions.NotFoundException;
import com.dashboard.task.backend.metrics.data.AdMockData;
import com.dashboard.task.backend.metrics.service.MetricsService;
import com.dashboard.task.backend.metrics.util.AdMockDataGenerator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MetricsServiceImpl implements MetricsService {
    @Override
    public List<AdMockData> getAllMetrics() {
        return AdMockDataGenerator.generateMetrics();
    }

    @Override
    public AdMockData getMetric(int id) {
        List<AdMockData> metrics = AdMockDataGenerator.generateMetrics();

        return metrics.stream()
                .filter(mt -> mt.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NotFoundException(String.format("Ad campaign with id: %d is not found", id)));
    }
}
