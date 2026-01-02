import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    int R = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());
    boolean[][] map = new boolean[R][C];
    boolean[][] nextMap = new boolean[R][C];

    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    List<int[]> list = new LinkedList<>();

    //입력 받기 땅이면 참
    for (int i = 0; i < R; i++) {
			String line = br.readLine();
      for (int j = 0; j < C; j++) {
        if (line.charAt(j) == 'X') {
          map[i][j] = true;
        }
      }
    }

    int minR = R, maxR = 0, minC = C, maxC = 0;
    boolean hasIsland = false;

    // 바다 면 개수 체크
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (map[i][j]) {
          int countSea = 0;
          for (int k = 0; k < 4; k++) {
            //높이
            int nj = j + dir[k][0];
            //넓이
            int ni = i + dir[k][1];

            if (ni < 0 || ni >= R || nj < 0 || nj >= C) {
              countSea++;
              continue;
            }
            if (!map[ni][nj]) {
              countSea++;
            }
          }

          if (countSea < 3) {
            //남는 섬
            nextMap[i][j] = true;
            minR = Math.min(minR, i);
            maxR = Math.max(maxR, i);
            minC = Math.min(minC, j);
            maxC = Math.max(maxC, j);
          }

        }
      }
    }
			for (int i = minR; i <= maxR; i++) {
				for (int j = minC; j <= maxC; j++) {
					if (nextMap[i][j]) {
						bw.write("X");
					} else {
						bw.write(".");
					}
				}
				bw.write("\n");
			}

    bw.flush();
    bw.close();
    br.close();
  }
}
