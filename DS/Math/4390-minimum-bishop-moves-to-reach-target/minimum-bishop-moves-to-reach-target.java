class Solution {
    public int minBishopMoves(int[] source, int[] target) {
        if(((source[0]+source[1])%2==0 && (target[0]+target[1])%2!=0) ||
        ((source[0]+source[1])%2!=0 && (target[0]+target[1])%2==0)) return -1;


        int startX=source[0];
        int startY=source[1];

        int targetX=target[0];
        int targetY=target[1];

        int xAbs = Math.abs(startX-targetX);
        int yAbs = Math.abs(startY-targetY);

        if(xAbs==yAbs) return 1;

        return 2;
    }
}