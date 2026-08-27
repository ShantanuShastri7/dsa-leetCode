class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int[] chars = new int[26];

        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }

        StringBuilder str = new StringBuilder();
        boolean proceed = false;

        for (int i = 0; i < target.length(); i++) {
            int t = target.charAt(i) - 'a';

            if (chars[t] > 0) {
                str.append((char) (t + 97));
                chars[t]--;
            } else {
                int next = nextGreater(chars, target.charAt(i));
                if (next != -1) {
                    str.append((char) (next + 97));
                    chars[next]--;
                    proceed = true;
                }
                break;
            }
        }

        if (proceed) {
            for (int i = 0; i < chars.length; i++) {
                while (chars[i] > 0) {
                    str.append((char) (i + 97));
                    chars[i]--;
                }
            }

            return str.toString();
        } else {
            while (!proceed) {
                if (str.length() == 0) {
                    return "";
                }
                char lastChar = str.charAt(str.length() - 1);
                chars[lastChar - 'a']++;
                str.deleteCharAt(str.length() - 1);

                int next = nextGreater(chars, target.charAt(str.length()));
                if (next != -1) {
                    str.append((char) (next + 97));
                    chars[next]--;
                    proceed = true;
                } else {
                    if (str.length() == 0)
                        return "";
                }
            }

            for (int i = 0; i < chars.length; i++) {
                while (chars[i] > 0) {
                    str.append((char) (i + 97));
                    chars[i]--;
                }
            }

            return str.toString();
        }

    }

    private int nextGreater(int[] chars, char c) {
        int res = 0;

        int index = c - 'a';
        index++;

        while (index < chars.length) {
            if (chars[index] > 0)
                return index;
            index++;
        }

        return -1;
    }
}