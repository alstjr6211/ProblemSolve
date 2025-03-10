import java.util.*;
import java.io.*;
public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();

        int[][] dp = new int[str1.length+1][str2.length+1];

        for (int i = 1; i <= str1.length; i++) {
            for (int j = 1; j <= str2.length; j++) {
                if (str1[i - 1] == str2[j - 1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = str1.length;
        int j = str2.length;
        while(i > 0 && j > 0) {
            int left = dp[i][j-1];
            int up = dp[i-1][j];
            int cur = dp[i][j];
            int leftup = dp[i-1][j-1];

            if (cur > left) {
                if (cur > up) {
                    sb.append(str1[i-1]);
                    i--;
                    j--;
                } else {
                    i--;
                }
            } else if (cur > up) {
                j--;
            } else {
                i--;
            }
        }
        System.out.println(dp[str1.length][str2.length]);
        System.out.println(sb.reverse().toString());
    }
}

//class5 백준 9252 LCS2

// 기존 LCS에서 LCS의 값을 구하는 문제이다.

// 방법은 다음과 같다.

// dp의 크기가 N * M이라면,
// dp[N - 1][M - 1]에서 시작한다.

// 왼쪽 칸과 위쪽 칸이 둘 다 현재의 값보다 작다면,
// 당연히 대각선 칸도 현재의 값보다 작고, 그 곳에서 LCS의 값이 하나 추가된 것이므로, 대각선 칸으로 이동하고, StringBuilder에 추가해준다.

// 만약 왼쪽 칸은 같고, 위쪽 칸은 작다면 현재의 LCS길이는 왼쪽 칸에서 온 것이므로 왼쪽 칸으로 이동해준다.

// 만약 왼쪽 칸은 작고, 위쪽 칸은 같다면 현재의 길이는 위쪽 칸에서 온 것이므로 위쪽 칸으로 이동해준다.

// 참고사항은, 오른쪽 대각선 칸이 그 외의 칸보다 작을리는 없으므로 위 sequence가 성립한다는 것이다.

// 이후 첫번째 칸으로 이동했다면, 더 이상 LCS역추적을 할 이유가 없으므로 종료조건이다.