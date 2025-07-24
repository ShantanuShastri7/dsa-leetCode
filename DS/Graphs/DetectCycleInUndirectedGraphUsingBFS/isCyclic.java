class Solution {
  public boolean isCycle(int n, int[][] edges) {
    boolean visited[] = new boolean[n];
    ArrayList<ArrayList<Integer>> adjacents = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      adjacents.add(new ArrayList<>());
    }

    for (int i = 0; i < n; i++) {
      adjacents.get(edges[i][0]).add(edges[i][1]);
      adjacents.get(edges[i][1]).add(edges[i][0]);
    }

    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        boolean result = bfsCycle(i, adjacents, visited);
        if (result) return true;
      }
    }

    return false;
  }

  private boolean bfsCycle(int src, ArrayList<ArrayList<Integer>> adjacents, boolean visited[]) {
    Queue<Pair<Integer, Integer>> q = new ArrayDeque<>();
    visited[src] = true;
    q.offer(new Pair<>(src, -1));

    while (!q.isEmpty()) {
      int parent = q.peek().getValue();
      int target = q.peek().getKey();
      q.poll();

      for (int adjacent : adjacents.get(target)) {
        if (!visited[adjacent]) {
          q.offer(new Pair<>(adjacent, target));
          visited[adjacent] = true;

        } else if (parent != adjacent) return true;
      }
    }

    return false;
  }
}
