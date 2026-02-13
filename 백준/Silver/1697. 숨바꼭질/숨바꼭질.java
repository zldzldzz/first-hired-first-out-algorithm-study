import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        boolean[] visited = new boolean[100001];
        Queue<Integer[]> q= new LinkedList<>();

        visited[n]=true;

        q.add(new Integer[]{n,0});
        int min=0;
        while (!q.isEmpty()){
            Integer[] now = q.poll();
           int x = now[0];
           if(x==m){
               min=now[1];
               break;
           }
           if(x-1>=0&&x-1<=100000&&!visited[x-1]){
               visited[x-1]=true;
               q.add(new Integer[]{x-1,now[1]+1});

           }if (x+1<=100000&&x+1>=0&&!visited[x+1]){
               visited[x+1]=true;
               q.add(new Integer[]{x+1,now[1]+1});

           }if(2*x<=100000&&!visited[2*x]){
               visited[2*x]=true;
               q.add(new Integer[]{2*x,now[1]+1});
           }
        }

        bw.write(String.valueOf(min));

        bw.flush();
        bw.close();
        br.close();

    }
}