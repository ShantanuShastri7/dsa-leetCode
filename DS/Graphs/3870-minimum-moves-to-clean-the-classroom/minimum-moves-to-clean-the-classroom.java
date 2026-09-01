import java.util.LinkedList;
import java.util.Queue;
import java.util.HashSet;

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int n = classroom.length;
        int m = classroom[0].length();
        
        int startX = -1;
        int startY = -1;
        
        // Step 1: Assign a unique ID (0, 1, 2...) to each piece of litter
        int[][] litterIds = new int[n][m];

        int idCounter = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = classroom[i].charAt(j);
                if (c == 'S') {
                    startX = i;
                    startY = j;
                } else if (c == 'L') {
                    litterIds[i][j] = idCounter;
                    idCounter++;
                }
            }
        }
        
        int totalLitters = idCounter;
        
        if (totalLitters == 0) return 0;
        
        // The winning bitmask: e.g., if 3 litters, target is binary 111 (which is 7)
        int targetMask = (1 << totalLitters) - 1;

        int[][][] energyMax = new int[n][m][targetMask];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++){
                Arrays.fill(energyMax[i][j], Integer.MIN_VALUE);
            }
        }
        
        // Queue stores arrays of: { x, y, currentEnergy, bitmask, movesTaken }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, energy, 0, 0});
        
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        // Step 2: Standard BFS Loop
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cx = curr[0];
            int cy = curr[1];
            int cEnergy = curr[2];
            int cMask = curr[3];
            int moves = curr[4];
            
            // If we are out of energy and NOT standing on a Reset point, we can't move.
            // if (cEnergy == 0 && classroom[cx].charAt(cy) != 'R') {
            //     continue;
            // }
            
            // Explore all 4 adjacent cells
            for (int[] dir : directions) {
                int nx = cx + dir[0];
                int ny = cy + dir[1];
                
                // Check grid bounds and obstacles
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && classroom[nx].charAt(ny) != 'X') {
                    
                    int nEnergy = cEnergy - 1;
                    if (nEnergy < 0) continue; // We don't have the energy to make this step
                    
                    int nMask = cMask;
                    char nextCell = classroom[nx].charAt(ny);
                    
                    // Handle special cells we step on
                    if (nextCell == 'R') {
                        nEnergy = energy; // Reset to max capacity!
                    } else if (nextCell == 'L') {
                        // Flip the bit for this specific piece of litter
                        nMask = nMask | (1 << litterIds[nx][ny]);
                    }
                    
                    // Did we just pick up the last piece of litter?
                    if (nMask == targetMask) {
                        return moves + 1;
                    }
                    
                    if (energyMax[nx][ny][nMask]<nEnergy) {
                        energyMax[nx][ny][nMask]=nEnergy;
                        queue.add(new int[]{nx, ny, nEnergy, nMask, moves + 1});
                    }
                }
            }
        }
        
        // If the queue empties and we haven't returned, it's impossible.
        return -1;
    }
}