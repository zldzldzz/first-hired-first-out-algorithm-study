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

  public static void main(String[] args) throws IOException {

    int t = Integer.parseInt(br.readLine());
    for (int c = 0; c < t; c++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      // 배열 크기
      int n = Integer.parseInt(st.nextToken());
      int mid = n / 2;
      // 회전 수
      int m = Integer.parseInt(st.nextToken()) / 45;
      int[][] map = new int[n][n];
      int[][] cpmap = new int[n][n];

      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < n; j++) {
          map[i][j] = Integer.parseInt(st.nextToken());
          cpmap[i][j] = map[i][j];
        }
      }

      if (m > 0) {
        for (int i = 0; i < m; i++) {
          for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
              // 정방향
              if (j == k) {
                cpmap[j][mid] = map[j][k];
              } else if (j + k == mid * 2) {
                cpmap[mid][k] = map[j][k];
              } else if (j == mid) {
                cpmap[k][k] = map[j][k];
              } else if (k == mid) {
                cpmap[j][mid * 2 - j] = map[j][k];
              }
            }

          }

          for (int k = 0; k < n; k++) {
            for (int l = 0; l < n; l++) {
              map[k][l] = cpmap[k][l];
            }
          }
        }
      } else {
        for (int i = 0; i < Math.abs(m); i++) {
          for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
              // 역방향
              if (j == k) {
                cpmap[mid][k] = map[j][k];
              } else if (j + k == mid * 2) {
                cpmap[j][mid] = map[j][k];
              } else if (k == mid) {
                cpmap[j][j] = map[j][k];
              } else if (j == mid) {
                cpmap[mid * 2 - k][k] = map[j][k];
              }
            }

          }

          for (int k = 0; k < n; k++) {
            for (int l = 0; l < n; l++) {
              map[k][l] = cpmap[k][l];
            }
          }
        }
      }

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          bw.write(cpmap[i][j] + " ");
        }
        bw.newLine();
      }

    }

    bw.flush();
    bw.close();
    br.close();
  }
}
