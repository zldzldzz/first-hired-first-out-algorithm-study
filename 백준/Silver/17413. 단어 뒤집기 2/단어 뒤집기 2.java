import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {

		String line = br.readLine();
		StringBuilder res = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		boolean isIn = false;
		for (int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			if (c == '<') {
				while (!stack.isEmpty()) {
					res.append(stack.pop());
				}
				isIn = true;
				res.append(c);
			} else if (c == '>') {
				isIn = false;
				res.append(c);
			} else if (c == ' ' && !isIn) {
				while (!stack.isEmpty()) {
					res.append(stack.pop());
				}
				res.append(c);
			} else if (isIn) {
				res.append(c);
			} else {
				stack.push(c);
			}
		}
		while (!stack.isEmpty()) {
			res.append(stack.pop());
		}
		bw.write(res.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
