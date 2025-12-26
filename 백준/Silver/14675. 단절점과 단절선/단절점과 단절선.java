import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {
    //정점 수
    int n = Integer.parseInt(br.readLine());
    int[] nEdg = new int[n];
    StringTokenizer st = null;
    for (int i = 0; i < n - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;
      nEdg[a]++;
      nEdg[b]++;
    }
    int q = Integer.parseInt(br.readLine());
    for (int i = 0; i < q; i++) {
      st = new StringTokenizer(br.readLine());
      int t = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken()) - 1;
      if (t!=1) {
        bw.write("yes\n");
      } else {
        if (nEdg[k] >= 2) {
          bw.write("yes\n");
        } else {
          bw.write("no\n");
        }
      }
    }
    bw.flush();
    bw.close();
    br.close();
  }
}
