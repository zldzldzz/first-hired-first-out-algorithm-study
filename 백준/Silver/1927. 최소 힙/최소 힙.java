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
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Long> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			Long value = Long.parseLong(br.readLine());
			if (value != 0) {
				pq.offer(value);
			} else if (pq.isEmpty()) {
				bw.write("0\n");
			} else {
				bw.write(pq.poll() + "\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
