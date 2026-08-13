class Solution {
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        SegmentTree tree = new SegmentTree(s);

        int[] res = new int[queryIndices.length];

        for (int i = 0; i < queryIndices.length; i++) {
            tree.update(0, 0, s.length() - 1, queryIndices[i], queryCharacters.charAt(i));
            res[i] = tree.tree[0].maxLen;
        }

        return res;
    }

    class SegmentTree {

        Node[] tree;
        char[] chars;

        public SegmentTree(String s) {
            tree = new Node[s.length() * 4];
            chars = s.toCharArray();

            for (int i = 0; i < tree.length; i++) {
                tree[i] = new Node();
            }

            build(0, 0, s.length() - 1);
        }

        private void update(int node, int start, int end, int idx, char c) {
            if (start == end) {
                chars[idx] = c;
                setupSingleCharNode(node, c);
                return;
            }
            int mid = start + (end - start) / 2;
            if (idx <= mid) {
                update(2 * node + 1, start, mid, idx, c);
            } else {
                update(2 * node + 2, mid + 1, end, idx, c);
            }

            // Recalculate this segment after the child is updated
            merge(node, 2 * node + 1, 2 * node + 2);
        }

        private void build(int node, int start, int end) {
            if (start == end) {
                setupSingleCharNode(node, chars[start]);
                return;
            }

            int mid = start + (end - start) / 2;
            build(2 * node + 1, start, mid);
            build(2 * node + 2, mid + 1, end);

            merge(node, 2 * node + 1, 2 * node + 2);
        }

        private void setupSingleCharNode(int node, char c) {
            tree[node].maxLen = 1;
            tree[node].prefLen = 1;
            tree[node].suffLen = 1;
            tree[node].size = 1;
            tree[node].prefChar = c;
            tree[node].suffChar = c;
        }

        private void merge(int root, int left, int right) {
            Node L = tree[left];
            Node R = tree[right];

            tree[root].size = L.size + R.size;
            tree[root].prefChar = L.prefChar;
            tree[root].suffChar = R.suffChar;

            // 1. Calculate Prefix
            tree[root].prefLen = L.prefLen;
            // If the left child is entirely ONE character, and it matches the right child's start
            if (L.prefLen == L.size && L.prefChar == R.prefChar) {
                tree[root].prefLen += R.prefLen;
            }

            // 2. Calculate Suffix
            tree[root].suffLen = R.suffLen;
            // If the right child is entirely ONE character, and it matches the left child's end
            if (R.suffLen == R.size && R.suffChar == L.suffChar) {
                tree[root].suffLen += L.suffLen;
            }

            // 3. Calculate Maximum
            tree[root].maxLen = Math.max(L.maxLen, R.maxLen);
            // Did we create a new massive segment across the boundary?
            if (L.suffChar == R.prefChar) {
                tree[root].maxLen = Math.max(tree[root].maxLen, L.suffLen + R.prefLen);
            }
        }
    }

    class Node {
        int maxLen, prefLen, suffLen, size;
        char prefChar, suffChar;
    }
}