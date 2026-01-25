import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		int[][] map = new int[N + 1][M + 1];
		boolean[][] visited = new boolean[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			for (int j = 1; j <= M; j++) {
				map[i][j] = line.charAt(j - 1) - '0';
			}
		}
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {1, 1, 1});
		visited[1][1] = true;
		int res = 0;
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			if (now[0] == N && now[1] == M) {
				res = now[2];
				break;
			}

			for (int i = 0; i < 4; i++) {
				int x = now[0] + dir[i][0];
				int y = now[1] + dir[i][1];
				if (x >= 1 && y >= 1 && x <= N && y <= M) {
					if (!visited[x][y]&& map[x][y] == 1) {
						visited[x][y] = true;
						queue.offer(new int[] {x, y, now[2] + 1});
					}
				}
			}
		}
		bw.write(res + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
