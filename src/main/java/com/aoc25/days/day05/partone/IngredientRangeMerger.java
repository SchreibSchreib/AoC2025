package com.aoc25.days.day05.partone;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class IngredientRangeMerger {

    private final List<String> _mergedIngredientRanges;

    public IngredientRangeMerger(List<String> freshIngredientRanges) {
        _mergedIngredientRanges = mergeRanges(freshIngredientRanges);
    }

    private List<String> mergeRanges(List<String> freshIngredientRanges) {
        List<String> mergedRanges = new ArrayList<>(freshIngredientRanges);
        mergedRanges.sort(getComparator());
        mergedRanges = mergeIngredients(mergedRanges);

        return mergedRanges;
    }

    private List<String> mergeIngredients(List<String> freshIngredientRanges) {
        List<String> mergedRanges = new ArrayList<>();
        String currentRange = freshIngredientRanges.get(0);

        for (int index = 1; index < freshIngredientRanges.size(); index++) {
            String nextRange = freshIngredientRanges.get(index);
            if (canMergeRanges(currentRange, nextRange)) {
                currentRange = mergeTwoRanges(currentRange, nextRange);
            } else {
                mergedRanges.add(currentRange);
                currentRange = nextRange;
            }
        }
        mergedRanges.add(currentRange);
        return mergedRanges;
    }

    private String mergeTwoRanges(String currentRange, String nextRange) {
        String[] currentRangeParts = currentRange.split("-");
        String[] nextRangeParts = nextRange.split("-");

        long currentRangeStart = Long.parseLong(currentRangeParts[0]);
        long currentRangeEnd = Long.parseLong(currentRangeParts[1]);

        long nextRangeStart = Long.parseLong(nextRangeParts[0]);
        long nextRangeEnd = Long.parseLong(nextRangeParts[1]);

        long mergedStart = Math.min(currentRangeStart, nextRangeStart); // optional, aber sauber
        long mergedEnd = Math.max(currentRangeEnd, nextRangeEnd);

        return mergedStart + "-" + mergedEnd;
    }

    private boolean canMergeRanges(String currentRange, String nextRange) {
        String[] currentRangeParts = currentRange.split("-");
        String[] nextRangeParts = nextRange.split("-");

        long currentRangeEnd = Long.parseLong(currentRangeParts[1]);
        long nextRangeStart = Long.parseLong(nextRangeParts[0]);

        return currentRangeEnd >= nextRangeStart - 1;
    }

    private Comparator<String> getComparator() {
        return (rangeOne, rangeTwo) -> {
            String[] rangeOneParts = rangeOne.split("-");
            String[] rangeTwoParts = rangeTwo.split("-");

            long rangeOneStart = Long.parseLong(rangeOneParts[0]);
            long rangeOneEnd = Long.parseLong(rangeOneParts[1]);
            long rangeTwoStart = Long.parseLong(rangeTwoParts[0]);
            long rangeTwoEnd = Long.parseLong(rangeTwoParts[1]);

            int compareStart = Long.compare(rangeOneStart, rangeTwoStart);

            if (compareStart != 0) {
                return compareStart;
            }
            return Long.compare(rangeOneEnd, rangeTwoEnd);
        };
    }

    public List<String> getMergedIngredientRanges() {
        return _mergedIngredientRanges;
    }
}
