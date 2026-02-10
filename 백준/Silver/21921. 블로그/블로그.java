import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int x = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());

    List<Integer> list = new ArrayList<>();

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < x; i++) {
      list.add(Integer.parseInt(st.nextToken()));
    }

    long sum = 0;
    for (int i = 0; i < n - 1; i++) {
      sum += list.get(i);
    }
    long nowValue = 0;
    int count = 0;

    for (int i = n-1; i < x; i++) {
      sum += list.get(i);
      if (nowValue < sum) {
        nowValue = sum;
        count = 1;
      } else if (nowValue == sum) {
        count++;
      }
      sum -= list.get(i - (n-1));
    }

    if (nowValue == 0) {
      bw.write("SAD");
    } else {
      bw.write(nowValue + "\n" + count);
    }
    bw.flush();
    bw.close();
    br.close();
  }
}