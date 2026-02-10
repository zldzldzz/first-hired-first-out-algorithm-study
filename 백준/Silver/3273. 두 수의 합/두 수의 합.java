import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    List<Integer> list = new ArrayList<>();
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      list.add(Integer.parseInt(st.nextToken()));
    }
    int target = Integer.parseInt(br.readLine());
    Collections.sort(list);
    int l = 0;
    int r = N - 1;
    int count = 0;

    while (l < r) {
      int left = list.get(l);
      int right = list.get(r);
      if (target < left + right) {
        r--;
      } else if (target > left + right) {
        l++;
      } else {
        count++;
        l++;
        r--;
      }
    }
    bw.write(count + "");
    bw.flush();
    bw.close();
    br.close();
  }
}