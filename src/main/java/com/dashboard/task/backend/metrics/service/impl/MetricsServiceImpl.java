package com.dashboard.task.backend.metrics.service.impl;

import com.dashboard.task.backend.exceptions.NotFoundException;
import com.dashboard.task.backend.metrics.data.AdMockData;
import com.dashboard.task.backend.metrics.service.MetricsService;
import com.dashboard.task.backend.metrics.util.AdMockDataGenerator;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MetricsServiceImpl implements MetricsService {
    @Override
    public List<AdMockData> getAllMetrics(String search) {
        List<AdMockData> metrics = AdMockDataGenerator.generateMetrics();

        if (search == null || search.isEmpty()) {
            return metrics;
        } else {
            return metrics.stream()
                    .filter(m -> StringUtils.containsIgnoreCase(m.getAdName(), search))
                    .toList();
        }
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
