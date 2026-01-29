import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		List<String> list = new LinkedList<>();
		for (int i = 0; i < t; i++) {
			String line = br.readLine();
			Stack<Character> stack = new Stack<>();
			boolean flag = false;
			for (int j = 0; j < line.length(); j++) {
				if (line.charAt(j) == '(') {
					stack.push('(');
				} else if (line.charAt(j) == ')') {
					if (stack.isEmpty()) {
						flag = true;
						break;
					}
					stack.pop();
				}
			}
			if (!flag && stack.isEmpty()) {
				list.add("YES");
			} else {
				list.add("NO");
			}
		}
		for (String s : list) {
			bw.write(s);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
