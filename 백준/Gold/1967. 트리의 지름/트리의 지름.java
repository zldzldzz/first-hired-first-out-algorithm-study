import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  static int maxDistance = 0;
  static int farthestNode = 0;
  static boolean[] visited;
  static List<int[]>[] lists;

  static void dfs(int currentNode, int currentDistance) {
    visited[currentNode] = true;
    if (currentDistance > maxDistance) {
      maxDistance = currentDistance;
      farthestNode = currentNode;
    }
    for (int[] t : lists[currentNode]) {
      if (!visited[t[0]]) {
        dfs(t[0], currentDistance + t[1]);
      }
    }
  }


  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());

    visited = new boolean[N + 1];

    // 타깃, 가중치 저장
    lists = new List[N + 1];

    for (int i = 0; i < N + 1; i++) {
      lists[i] = new ArrayList<>();
    }

    for (int i = 1; i <= N - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      int value = Integer.parseInt(st.nextToken());
      lists[x].add(new int[]{y, value});
      lists[y].add(new int[]{x, value});
    }
    dfs(1, 0);

    int startNode = farthestNode;
    maxDistance = 0;
    visited = new boolean[N + 1];
    dfs(startNode, 0);

    bw.write(maxDistance + "\n");

    bw.flush();
    bw.close();
    br.close();
  }
}
