package com.dashboard.task.backend.metrics.web;

import com.dashboard.task.backend.metrics.data.AdMockData;
import com.dashboard.task.backend.metrics.service.MetricsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/metrics")
@Tag(name = "Metrics")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class MetricsController {

    private final MetricsService metricsService;

    @Operation(description = "Get all ad campaigns with metrics")
    @GetMapping
    public ResponseEntity<List<AdMockData>> getAllMetrics(
            @RequestParam(required = false) String search
    ) {
        List<AdMockData> response = metricsService.getAllMetrics(search);
        return ResponseEntity.ok(response);
    }

    @Operation(description = "Get campaign with metric")
    @GetMapping("/{id}")
    public ResponseEntity<AdMockData> getMetric(@PathVariable int id) {
        AdMockData response = metricsService.getMetric(id);
        return ResponseEntity.ok(response);
    }
}