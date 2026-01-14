import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static List<Integer[]> pair;
	static boolean[] visited;
	static String line;
	static TreeSet<String> results = new TreeSet<>();

	public static void dfs(int depth) {
		boolean hasRemoved = false;
		// 가장 마지막 순서의 짝을 보면 처리 시작
		if (depth == pair.size()) {
			// 제거 대상의 인덱스 저장 되는 배열
			boolean[] skip = new boolean[line.length()];
			for (int i = 0; i < pair.size(); i++) {
				if (visited[i]) {
					skip[pair.get(i)[0]] = true;
					skip[pair.get(i)[1]] = true;
					hasRemoved = true;
				}
			}

			if (hasRemoved) {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < line.length(); i++) {
					if (!skip[i]) {
						sb.append(line.charAt(i));
					}
				}
				results.add(sb.toString());
			}
			return;
		}

		// 제거 하는 경우
		visited[depth] = true;
		dfs(depth + 1);

		// 제거 안 하는 경우
		visited[depth] = false;
		dfs(depth + 1);
	}

	public static void main(String[] args) throws IOException {
		line = br.readLine();
		Stack<Integer> stack = new Stack<>();
		pair = new ArrayList<>();
		for (int i = 0; i < line.length(); i++) {
			Character c = line.charAt(i);
			if (c.equals('(')) {
				stack.push(i);
			} else if (c.equals(')')) {
				pair.add(new Integer[] {stack.pop(), i});
			}
		}

		visited = new boolean[pair.size()];

		dfs(0);

		for (String result : results) {
			bw.write(result);
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
