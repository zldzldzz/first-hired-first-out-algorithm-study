import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		int[][][] dirt = new int[N][M][4];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < 4; k++) {
					dirt[i][j][k] = Integer.MAX_VALUE;
				}
			}
		}
		int[] start = {-1, -1};
		int[] end = {-1, -1};
		int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

		for (int i = 0; i < M; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				map[j][i] = line.charAt(j);
				if (map[j][i] == 'C') {
					if (start[0] == -1) {
						start[0] = j;
						start[1] = i;
					} else {
						end[0] = j;
						end[1] = i;
					}
				}
			}
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
			return a[3] - b[3];
		});

		for (int i = 0; i < 4; i++) {
			int x = start[0] + dir[i][0];
			int y = start[1] + dir[i][1];
			if (x >= 0 && y >= 0 && x < N && y < M) {
				if (map[x][y] != '*') {
					pq.add(new int[] {x, y, i, 0});
					dirt[x][y][i] = 0;
				}
			}
		}
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();

			if (dirt[cur[0]][cur[1]][cur[2]] < cur[3]) {
				continue;
			}

			if (cur[0] == end[0] && cur[1] == end[1]) {
				bw.write(cur[3] + "\n");
				break;
			}

			for (int i = 0; i < 4; i++) {
				int x = cur[0] + dir[i][0];
				int y = cur[1] + dir[i][1];
				if (x >= 0 && y >= 0 && x < N && y < M) {
					if (map[x][y] != '*') {
						if (i == cur[2]) {
							if (dirt[x][y][i] > cur[3]) {
								pq.add(new int[] {x, y, i, cur[3]});
								dirt[x][y][i] = cur[3];
							}
						} else {
							if (dirt[x][y][i] > cur[3] + 1) {
								dirt[x][y][i] = cur[3] + 1;
								pq.add(new int[] {x, y, i, cur[3] + 1});
							}
						}
					}
				}
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}