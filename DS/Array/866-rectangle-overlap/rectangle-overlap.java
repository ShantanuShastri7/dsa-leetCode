class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // Check if either rectangle has an area of 0 (it's just a line or a point)
        if (rec1[0] == rec1[2] || rec1[1] == rec1[3] ||
            rec2[0] == rec2[2] || rec2[1] == rec2[3]) {
            return false;
        }

        // Return false if they do NOT overlap in any direction.
        // Otherwise, they must overlap.
        return !(rec1[2] <= rec2[0] ||  // rec1 is completely to the left of rec2
                 rec1[0] >= rec2[2] ||  // rec1 is completely to the right of rec2
                 rec1[3] <= rec2[1] ||  // rec1 is completely below rec2
                 rec1[1] >= rec2[3]);
    }
}