import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  static int countChar(String s, char c) {

    int count = 0;

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == c) {
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());

    String text = st.nextToken();
    StringBuilder sb = new StringBuilder(text);
    String reversed = sb.reverse().toString();

    if (text.equals(reversed)) {
      int charCount = countChar(text, text.charAt(0));
      if (text.length() == 1 || charCount == text.length()) {
        bw.write("-1\n");
      }else {
				bw.write(String.valueOf(text.length()-1));
			}
    }else{
			bw.write(String.valueOf(text.length()));
		}

    bw.flush();
    bw.close();
    br.close();
  }
}
