import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		Long answer = 0L;

		while (pq.size() > 1) {
			int x = pq.poll();
			int y = pq.poll();
			int sum = x + y;
			answer += sum;
			pq.add(sum);
		}
		bw.write(answer + "\n");

		bw.flush();
		bw.close();
		br.close();
	}
}
