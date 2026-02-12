import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;


class Solution {
    public int solution(int[][] maps) {
        
        int n = maps.length;
        int m = maps[0].length;
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    Queue<int[]> queue = new LinkedList<>();
    boolean[][] visited = new boolean[n][m];
    visited[0][0] = true;
    queue.add(new int[]{0, 0, 1});
    int result = -1;
    while (!queue.isEmpty()) {
      int[] now = queue.poll();
      if (now[0] == n-1 && now[1] == m-1) {
        result = now[2];
        break;
      }
      for (int[] d : dir) {
        int x = now[0] + d[0];
        int y = now[1] + d[1];
        if (x >= 0 && x < n && y >= 0 && y < m && !visited[x][y]&&maps[x][y] == 1) {
          visited[x][y] = true;
          queue.add(new int[]{x, y, now[2] + 1});
        }
      }
    }
        return result;
    }
}