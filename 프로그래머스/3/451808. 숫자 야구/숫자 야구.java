import java.util.function.Function;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.function.Function;

class Solution {
    
    static private void allCase(List<Integer> list) {
    for (int a = 1; a <= 9; a++) {
      for (int b = 1; b <= 9; b++) {
        if (a == b) {
          continue;
        }
        for (int c = 1; c <= 9; c++) {
          if (a == c || b == c) {
            continue;
          }
          for (int d = 1; d <= 9; d++) {
            if (a == d || b == d || c == d) {
              continue;
            }
            list.add(1000 * a + 100 * b + 10 * c + d);
          }
        }
      }
    }
  }
    
    static public int[] countResult(String input) {
    StringTokenizer st = new StringTokenizer(input);
    int[] result = new int[2];

    result[0] = st.nextToken().charAt(0) - '0';
    result[1] = st.nextToken().charAt(0) - '0';
    return result;
  }

  static public List<Integer> selectList(String num, List<Integer> list, int s, int b) {
    List<Integer> cpList = new ArrayList<>();
    Set<Character> set = new HashSet<>();
    set.add(num.charAt(0));
    set.add(num.charAt(1));
    set.add(num.charAt(2));
    set.add(num.charAt(3));

    for (Integer i : list) {
      String now = i.toString();
      int countS = 0;
      int countB = 0;
      for (int a = 0; a < 4; a++) {
        if (num.charAt(a) == now.charAt(a)) {
          countS++;
        } else if (num.contains(String.valueOf(now.charAt(a)))) {
          countB++;
        }
      }
      if (countS == s && countB == b) {
        cpList.add(i);
      }
    }

    return cpList;
  }
    
    public int solution(int n, Function<Integer, String> submit) {
         List<Integer> list = new ArrayList<>();
    allCase(list);

    while (list.size() != 1) {
      int nowCase = list.get(0);
      int[] result = countResult(submit.apply(nowCase));
      list = selectList(String.valueOf(nowCase), list, result[0], result[1]);
    }

    return list.get(0);
    }
}