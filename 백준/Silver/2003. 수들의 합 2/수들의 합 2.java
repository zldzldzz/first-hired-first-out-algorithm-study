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
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      list.add(Integer.parseInt(st.nextToken()));
    }

    int s = 0;
    int e = 0;
    int sum = 0;
    int count = 0;
    while (true) {
      if (sum >= M) {
        if(sum==M){
          count++;
        }
        sum -= list.get(s++);
      } else if (e==N) {
        break;
      }else  {
        sum += list.get(e++);
      }

    }

    bw.write(count+"");

    bw.flush();
    bw.close();
    br.close();
  }
}