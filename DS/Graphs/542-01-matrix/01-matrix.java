class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int result[][] = new int[mat.length][mat[0].length];
        boolean visited[][] = new boolean[mat.length][mat[0].length];
        Queue<Pair<Pair<Integer, Integer>, Integer>> q = new ArrayDeque<>();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new Pair<>(new Pair<>(i, j), 0));
                    visited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int i = q.peek().getKey().getKey();
            int j = q.peek().getKey().getValue();
            int dis = q.peek().getValue();
            q.poll();

            result[i][j] = dis;

            if (i < mat.length - 1 && !visited[i + 1][j]) {
                q.offer(new Pair<>(new Pair<>(i + 1, j), dis + 1));
                visited[i + 1][j]=true;
            }
            if (i > 0 && !visited[i - 1][j]) {
                q.offer(new Pair<>(new Pair<>(i - 1, j), dis + 1));
                visited[i - 1][j]=true;
            }
            if (j < mat[0].length - 1 && !visited[i][j + 1]) {
                q.offer(new Pair<>(new Pair<>(i, j + 1), dis + 1));
                visited[i][j + 1]=true;
            }
            if (j > 0 && !visited[i][j - 1]) {
                q.offer(new Pair<>(new Pair<>(i, j - 1), dis + 1));
                visited[i][j - 1]=true;
            }
        }

        return result;
    }

    // public int[][] updateMatrix(int[][] mat) {
    //     int result[][] = new int[mat.length][mat[0].length];
    //     boolean visited[][] = new boolean[mat.length][mat[0].length];

    //     for(int i=0; i<mat.length; i++){
    //         for(int j=0; j<mat[0].length; j++){
    //             if(mat[i][j]==0) continue;
    //             else {
    //                 int distance = bfs(mat, i, j);
    //                 result[i][j]=distance;
    //             }
    //         }
    //     }

    //     return result;        
    // }

    //MLE
    private int bfs(int[][] mat, int i, int j) {
        Queue<Pair<Pair<Integer, Integer>, Integer>> q = new ArrayDeque<>();
        q.offer(new Pair<>(new Pair<>(i, j), 0));

        while (!q.isEmpty()) {
            int newi = q.peek().getKey().getKey();
            int newj = q.peek().getKey().getValue();
            int newDis = q.poll().getValue();

            if (newi + 1 < mat.length && mat[newi + 1][newj] == 0) {
                return newDis + 1;
            } else if (newi + 1 < mat.length) {
                q.offer(new Pair<>(new Pair<>(newi + 1, newj), newDis + 1));
            }
            if (newi - 1 >= 0 && mat[newi - 1][newj] == 0) {
                return newDis + 1;
            } else if (newi - 1 >= 0) {
                q.offer(new Pair<>(new Pair<>(newi - 1, newj), newDis + 1));
            }
            if (newj + 1 < mat[0].length && mat[newi][newj + 1] == 0) {
                return newDis + 1;
            } else if (newj + 1 < mat[0].length) {
                q.offer(new Pair<>(new Pair<>(newi, newj + 1), newDis + 1));
            }
            if (newj - 1 >= 0 && mat[newi][newj - 1] == 0) {
                return newDis + 1;
            } else if (newj - 1 >= 0) {
                q.offer(new Pair<>(new Pair<>(newi, newj - 1), newDis + 1));
            }
        }

        return 0;
    }
}