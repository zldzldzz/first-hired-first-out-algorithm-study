import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int c = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

		int[][] map = new int[r][c];
		boolean[][] visited = new boolean[r][c];

		for (int i = 0; i < r; i++) {
			String line = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		Deque<Integer[]> q = new ArrayDeque<>();
		q.add(new Integer[] {0, 0, 0});
		visited[0][0] = true;
		int result = 0;
		while (!q.isEmpty()) {
			Integer[] now = q.poll();

			if (now[0] == r - 1 && now[1] == c - 1) {
				result = now[2];
				break;
			}

			for (int i = 0; i < 4; i++) {
				int x = now[0] + dir[i][0];
				int y = now[1] + dir[i][1];
				int breakCount = now[2];
				if (x >= 0 && y >= 0 && x < r && y < c) {
					if (!visited[x][y]) {
						if (map[x][y] == 0) {
							visited[x][y] = true;
							q.addFirst(new Integer[] {x, y, breakCount});
						} else if (map[x][y] == 1) {
							visited[x][y] = true;
							q.addLast(new Integer[] {x, y, breakCount + 1});
						}
					}
				}
			}
		}
		bw.write(String.valueOf(result));

		br.close();
		bw.flush();
		bw.close();
	}
}