import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		//맵 이전 입력 받기
		int jumps = Integer.parseInt(br.readLine());
		String[] mapSize = br.readLine().split(" ");
		int rowSize = Integer.parseInt(mapSize[1]);
		int colSize = Integer.parseInt(mapSize[0]);
		String[][] map = new String[rowSize][colSize];
		boolean[][][] visited = new boolean[rowSize][colSize][jumps+1];
		boolean flag = false;

		//맵 기입
		for (int i = 0; i < rowSize; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < colSize; j++) {
				map[i][j] = line[j];
			}
		}
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		int[] loookX = {1, 2, 2, 1, -1, -2, -2, -1};
		int[] loookY = {2, 1, -1, -2, -2, -1, 1, 2};
		Queue<int[]> q = new LinkedList<>();
		//x, y, 이동수, 남은 점프
		q.add(new int[] {0, 0, 0, jumps});
		visited[0][0][jumps] = true;

		while (!q.isEmpty()) {
			int[] now = q.poll();

			if(now[0]==rowSize-1 && now[1]==colSize-1) {
				flag = true;
				bw.write(String.valueOf(now[2]));
				break;
			}
			for(int i=0;i<dx.length;i++) {
				int x = now[0]+dx[i];
				int y = now[1]+dy[i];
				if(x>=0 && x<rowSize && y>=0 && y<colSize) {
					if(!visited[x][y][now[3]]&&map[x][y].equals("0")) {
						visited[x][y][now[3]] = true;
						q.add(new int[] {x, y, now[2]+1,now[3]});
					}
				}
			}
			for (int i = 0; i < loookX.length; i++) {
				int x = now[0]+loookX[i];
				int y = now[1]+loookY[i];
				if(x>=0 && x<rowSize && y>=0 && y<colSize&&now[3]>0) {
					if(!visited[x][y][now[3]-1]&&map[x][y].equals("0")) {
						visited[x][y][now[3]-1] = true;
						q.add(new int[] {x, y, now[2]+1,now[3]-1});
					}
				}
			}
		}

		if (!flag) {
			bw.write("-1\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}