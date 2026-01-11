import java.util.Arrays;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
		boolean[][] map = new boolean[id_list.length][id_list.length];
		int[] banCount = new int[id_list.length];
		for (String s : report) {
			String[] split = s.split(" ");
			int sendIndex = Arrays.asList(id_list).indexOf(split[0]);
			int receiveIndex = Arrays.asList(id_list).indexOf(split[1]);
			if(!map[sendIndex][receiveIndex]) {
				map[sendIndex][receiveIndex] = true;
				banCount[receiveIndex]++;	
			}
		}
		for (int i = 0; i < id_list.length; i++) {
			if (banCount[i] >= k) {
				for (int j = 0; j < id_list.length; j++) {
					if (map[j][i]) {
						answer[j]++;
					}
				}
			}
		}
        return answer;
    }
}