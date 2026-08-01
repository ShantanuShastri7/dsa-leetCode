import java.util.*;

class Solution {
    public int maximumWidth(int[] planks) {
        if (planks == null || planks.length == 0) return 0;
        
        // Count frequencies of each plank length
        Map<Integer, Integer> count = new HashMap<>();
        for (int plank : planks) {
            count.put(plank, count.getOrDefault(plank, 0) + 1);
        }
        
        // This map will store the total possible width for any viable fence height
        Map<Integer, Integer> widths = new HashMap<>();
        
        // 1. Single planks contribute directly to a fence of their own height
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            widths.put(entry.getKey(), entry.getValue());
        }
        
        // Extract distinct plank lengths to prevent duplicate work
        List<Integer> distinct = new ArrayList<>(count.keySet());
        int n = distinct.size();
        
        // 2. Add pairs of the SAME length
        for (int i = 0; i < n; i++) {
            int length = distinct.get(i);
            int c = count.get(length);
            if (c >= 2) {
                int pairedHeight = length * 2;
                widths.put(pairedHeight, widths.getOrDefault(pairedHeight, 0) + (c / 2));
            }
        }
        
        // 3. Add pairs of DIFFERENT lengths
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int length1 = distinct.get(i);
                int length2 = distinct.get(j);
                
                int pairedHeight = length1 + length2;
                // We are limited by whichever plank we have fewer of
                int possiblePairs = Math.min(count.get(length1), count.get(length2));
                
                widths.put(pairedHeight, widths.getOrDefault(pairedHeight, 0) + possiblePairs);
            }
        }
        
        // 4. Find the global maximum width
        int maxFenceWidth = 0;
        for (int w : widths.values()) {
            if (w > maxFenceWidth) {
                maxFenceWidth = w;
            }
        }
        
        return maxFenceWidth;
    }
}