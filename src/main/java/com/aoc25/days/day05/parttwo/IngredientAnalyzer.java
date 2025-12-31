package com.aoc25.days.day05.parttwo;

import java.util.List;

public class IngredientAnalyzer {

    long _result;

    public IngredientAnalyzer(List<String> freshIngredientRanges) {
        List<String> mergedFreshIngredientList = new IngredientRangeMerger(freshIngredientRanges)
                .getMergedIngredientRanges();
        _result = analyzeIngredients(mergedFreshIngredientList);
    }

    private long analyzeIngredients(List<String> mergedFreshIngredientList) {
        long usableIngredientCount = 0;

        for (String range : mergedFreshIngredientList) {
            usableIngredientCount += calculateRangeSize(range);

        }
        return usableIngredientCount;
    }

    private long calculateRangeSize(String range) {
            String[] rangeParts = range.split("-");
            long rangeStart = Long.parseLong(rangeParts[0]);
            long rangeEnd = Long.parseLong(rangeParts[1]);

            return rangeEnd - rangeStart + 1;
    }

    public long getResult() {
        return _result;
    }
}
