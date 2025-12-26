import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer[]> stack = new Stack<>();
        String[] line = br.readLine().split("");
        Stack<Integer> value = new Stack<Integer>();

        int sum = 0;
        boolean closed = true;
        boolean nofind = false;
        for (int i = 0; i < line.length; i++) {
            if (line[i].equals("(")) {
                stack.push(new Integer[]{2, value.size()});
            } else if (line[i].equals("[")) {
                stack.push(new Integer[]{3, value.size()});
            } else if (line[i].equals("]")) {
                if (stack.empty() || stack.peek()[0] != 3) {
                    nofind = true;
                    break;
                } else {
                    Integer[] now = stack.pop();
                    //"[]"인 바로 닫는 경우
                    if (now[1] == value.size()) {
                        value.push(now[0]);
                    }
                    //"[x]"인 경우
                    else {
                        int tmp = 0;
                        while (!value.isEmpty() && now[1] != value.size()) {
                            tmp += value.pop();
                        }
                        value.push(tmp * now[0]);
                    }
                }
            } else if (line[i].equals(")")) {
                if (stack.empty() || stack.peek()[0] != 2) {
                    nofind = true;
                    break;
                } else {
                    Integer[] now = stack.pop();
                    //"()"인 바로 닫는 경우
                    if (now[1] == value.size()) {
                        value.push(now[0]);
                    }
                    //"(x)"인 경우
                    else {
                        int tmp = 0;
                        while (!value.isEmpty() && now[1] != value.size()) {
                            tmp += value.pop();
                        }
                        value.push(tmp * now[0]);
                    }
                }
            }
        }

        if (nofind || !stack.empty()) {  // stack에 뭔가 남아있으면 에러
            bw.write("0");
        } else {
            while (!value.empty()) {
                sum += value.pop();
            }
            bw.write(String.valueOf(sum));
        }
        bw.flush();
        bw.close();
        br.close();


    }

}