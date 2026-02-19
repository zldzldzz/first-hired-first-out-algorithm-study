import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Main {

  static class Edge {

    int end;
    int weight;

    public Edge(int end, int weight) {
      this.end = end;
      this.weight = weight;
    }
  }

  static final long INF = Long.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int V = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());
    int stratNode = Integer.parseInt(br.readLine());

    List<Edge>[] edges = new ArrayList[V + 1];
    for (int i = 0; i < edges.length; i++) {
      edges[i] = new ArrayList<>();
    }

    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      edges[s].add(new Edge(e, w));
    }

    long[] result = new long[V + 1];
    Arrays.fill(result, INF);
    result[stratNode] = 0;
    PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
    pq.add(new long[]{stratNode, 0});
    while (!pq.isEmpty()) {
      long[] cur = pq.poll();
      int now = Math.toIntExact(cur[0]);
      long weight = cur[1];
      if (result[now] < weight) {
        continue;
      }
      for (Edge e : edges[now]) {
        if (result[e.end] > result[now] + e.weight) {
          result[e.end] = result[now] + e.weight;
          pq.add(new long[]{e.end, result[e.end]});
        }
      }
    }
    for (int i = 1; i < V + 1; i++) {
      if(result[i] == INF) {
        bw.write("INF\n");
      }else{
        bw.write(result[i] + "\n");
      }
    }
    bw.flush();
    bw.close();
    br.close();

  }
}