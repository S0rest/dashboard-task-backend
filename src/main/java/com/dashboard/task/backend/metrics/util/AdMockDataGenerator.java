package com.dashboard.task.backend.metrics.util;

import com.dashboard.task.backend.metrics.data.AdMockData;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AdMockDataGenerator {

    private static final List<AdMockData> metrics = new ArrayList<>();

    public static List<AdMockData> generateMetrics() {

        if (!metrics.isEmpty()) return metrics;

        for (int i = 1; i <= 5; i++) {
            String name = "Ad-Campaign-" + i;
            int impressions = generateWithRange(5000, 10000);
            int clicks = generateWithRange(200, 500);
            double cost = generateWithRange(75, 200);
            int conversions = generateWithRange(20, 50);
            double revenue = generateWithRange(550,1000);

            BigDecimal ctr = BigDecimal.valueOf(((double) clicks / impressions) * 100);
            BigDecimal cpc = new BigDecimal(cost / clicks);
            BigDecimal cpm = BigDecimal.valueOf((cost / impressions) * 1000);
            BigDecimal cpa = new BigDecimal(cost / conversions);
            BigDecimal roas = new BigDecimal(revenue / cost);

            AdMockData campaign = AdMockData.builder()
                    .id(i)
                    .adName(name)
                    .impressions(impressions)
                    .clicks(clicks)
                    .cost(cost)
                    .conversions(conversions)
                    .revenue(revenue)
                    .ctr(ctr.setScale(2, RoundingMode.HALF_EVEN))
                    .cpc(cpc.setScale(2, RoundingMode.HALF_EVEN))
                    .cpm(cpm.setScale(2, RoundingMode.HALF_EVEN))
                    .cpa(cpa.setScale(2, RoundingMode.HALF_EVEN))
                    .roas(roas.setScale(2, RoundingMode.HALF_EVEN))
                    .build();

            metrics.add(campaign);
        }

        return metrics;
    }

    private static int generateWithRange(int min, int max) {
        Random random = new Random();

        return random.nextInt((max - min) + 1) + min;
    }
}
