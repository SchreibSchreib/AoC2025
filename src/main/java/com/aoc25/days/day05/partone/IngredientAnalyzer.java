package com.aoc25.days.day05.partone;

import java.util.List;

public class IngredientAnalyzer {

    int _result;

    public IngredientAnalyzer(List<String> freshIngredientRanges, List<String> ingredients) {
        List<String> mergedFreshIngredientList = new IngredientRangeMerger(freshIngredientRanges)
                .getMergedIngredientRanges();
        _result = analyzeIngredients(mergedFreshIngredientList, ingredients);
    }

    private int analyzeIngredients(List<String> mergedFreshIngredientList, List<String> ingredients) {
        int usableIngredientCount = 0;

        for (String ingredient : ingredients) {
            if (isIngredientUsable(mergedFreshIngredientList, ingredient)) {
                usableIngredientCount++;
            }
        }
        return usableIngredientCount;
    }

    private boolean isIngredientUsable(List<String> mergedFreshIngredientList, String ingredient) {
        for (String freshIngredientRange : mergedFreshIngredientList) {
            if (isIngredientInRange(freshIngredientRange, ingredient)) {
                return true;
            }
        }
        return false;
    }

    private boolean isIngredientInRange(String freshIngredientRange, String ingredient) {
        String[] rangeParts = freshIngredientRange.split("-");
        long rangeStart = Long.parseLong(rangeParts[0]);
        long rangeEnd = Long.parseLong(rangeParts[1]);
        long ingredientValue = Long.parseLong(ingredient);

        return ingredientValue >= rangeStart && ingredientValue <= rangeEnd;
    }

    public int getResult() {
        return _result;
    }
}
