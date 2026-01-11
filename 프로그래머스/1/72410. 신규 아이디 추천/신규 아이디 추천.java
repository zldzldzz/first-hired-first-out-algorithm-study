import java.util.Arrays;


class Solution {
    public String solution(String new_id) {
        String answer = "";
		String downId = new_id.toLowerCase();
		Character[] remove = {'-', '_', '.'};

		String removeId = "";

		for (int i = 0; i < downId.length(); i++) {
			char ch = downId.charAt(i);
			if (Arrays.asList(remove).contains(ch)) {
				removeId = removeId + ch;
			} else if (ch >= 'a' && ch <= 'z') {
				removeId = removeId + ch;
			} else if (ch >= '0' && ch <= '9') {
				removeId = removeId + ch;
			}
		}

		String reDotId = "";
		boolean flag = false;
		for (int i = 0; i < removeId.length(); i++) {
			if (removeId.charAt(i) == '.') {
				if (!flag) {
					flag = true;
					reDotId = reDotId + removeId.charAt(i);
				}
			} else {
				reDotId = reDotId + removeId.charAt(i);
				flag = false;
			}
		}

		if (!reDotId.isEmpty() && reDotId.charAt(0) == '.') {
			reDotId = reDotId.substring(1);
		}

		if (!reDotId.isEmpty() && reDotId.charAt(reDotId.length() - 1) == '.') {
			reDotId = reDotId.substring(0, reDotId.length() - 1);
		}

		if (reDotId.isEmpty()) {
			reDotId = "a";
		}
		if (reDotId.length() >= 16) {
			reDotId = reDotId.substring(0, 15);
		}

		if (!reDotId.isEmpty() && reDotId.charAt(0) == '.') {
			reDotId = reDotId.substring(1);
		}

		if (!reDotId.isEmpty() && reDotId.charAt(reDotId.length() - 1) == '.') {
			reDotId = reDotId.substring(0, reDotId.length() - 1);
		}

		while (reDotId.length() <= 2) {
			reDotId = reDotId + reDotId.charAt(reDotId.length() - 1);
		}
		answer = reDotId;
        return answer;
    }
}