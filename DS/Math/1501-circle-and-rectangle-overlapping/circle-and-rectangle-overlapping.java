class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int nearestX = Math.max(x1, Math.min(xCenter, x2));
        int nearestY = Math.max(y1, Math.min(yCenter, y2));
        
        // 2. Calculate the distance from the circle's center to this nearest point
        int distX = xCenter - nearestX;
        int distY = yCenter - nearestY;
        
        // 3. Check if the distance squared is <= radius squared
        // We use squared distance to avoid expensive and imprecise Math.sqrt() calls
        return (distX * distX) + (distY * distY) <= radius * radius;
    }
}