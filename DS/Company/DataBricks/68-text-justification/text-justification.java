class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int n = words.length;
        int i = 0;

        while (i < n) {
            int width = words[i].length();
            int j = i + 1;

            // Find how many words fit in the current line
            while (j < n && width + 1 + words[j].length() <= maxWidth) {
                width += 1 + words[j].length();
                j++;
            }

            int totalGaps = j - i - 1;
            StringBuilder str = new StringBuilder();

            // If it's the last line OR only one word
            if (j == n || totalGaps == 0) {
                while (i < j) {
                    str.append(words[i]);
                    if (i < j - 1) str.append(" ");
                    i++;
                }
                // Fill remaining spaces to the right
                while (str.length() < maxWidth) {
                    str.append(" ");
                }
            } else {
                int totalSpaces = maxWidth;
                for (int k = i; k < j; k++) {
                    totalSpaces -= words[k].length();
                }

                int spaceBetween = totalSpaces / totalGaps;
                int extraSpaces = totalSpaces % totalGaps;

                int iterator = i;
                while (iterator < j) {
                    str.append(words[iterator]);
                    if (iterator < j - 1) {
                        for (int s = 0; s < spaceBetween; s++) str.append(" ");
                        if (extraSpaces > 0) {
                            str.append(" ");
                            extraSpaces--;
                        }
                    }
                    iterator++;
                }
                i = j;
            }

            result.add(str.toString());
        }

        return result;
    }
}