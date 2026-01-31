import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		boolean[][] visited = new boolean[N][M];

		int[][] dir = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		ArrayDeque<int[]> stack = new ArrayDeque();
		stack.add(new int[] {0, 0, 1});
		visited[0][0] = true;
		int res = 0;
		while (!stack.isEmpty()) {
			int[] cur = stack.poll();
			if (cur[0] == N - 1 && cur[1] == M - 1) {
				res = cur[2];
				break;
			}
			for (int i = 0; i < dir.length; i++) {
				int x = cur[0] + dir[i][0];
				int y = cur[1] + dir[i][1];
				int v = cur[2];
				if (x >= 0 && x < N && y >= 0 && y < M) {
					if (map[x][y] == 1 && !visited[x][y]) {
						visited[x][y] = true;
						stack.add(new int[] {x, y, v + 1});
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
