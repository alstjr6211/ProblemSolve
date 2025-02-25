import java.util.*;
import java.io.*;
public class Main {

    static int[][] arr;
    static int[][] dp;

    public static void init(int N) {
        arr = new int[N][3];
        dp = new int[N][3];
    }
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        init(N);
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        System.out.println(rgb(N));

    }

    public static int rgb(int N) {

        for (int i = 0; i < 3; i++) {
            dp[0][i] = arr[0][i];
        }
        for (int i = 1; i < N; i++) {
            dp[i][0] = arr[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = arr[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = arr[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }
        int min = Math.min(dp[N-1][0], dp[N-1][1]);
        min = Math.min(dp[N-1][2], min);
        return min;
    }
}

// 이 문제는 subproblem을 정하기 어려웠던 문제였다.

// 처음에는, dp[i]를 결정할 때, dp[i - 1]과 dp[i - 2]의 값으로 6번을 각각 비교하여 값을 채워나가려고 했다.

// 그러나 problem이 무엇인지 고민해보던 차에,

// Problem : RGB거리의 최솟값을 구하기 이다.

// 그렇다면 여기서 어떻게 구하는 것인가? 였다.

// 다시 생각해 낸 Problem은, arr[i]의 세 가지 RGB값 중, R을 사용한 최솟값과, G를 사용한 최솟값, B를 사용한 최솟값 세 개를 비교하면
// 최종 최솟값이 나온다는 점이었다.

// 이에 각각의 색을 사용한 최솟값들은, arr[i - 1]의 값들 중 동일한 색을 사용하지 않은 두 가지 경우를 비교해서 얻어낼 수 있다.

// 이에 초기값은 arr[0][i] == dp[0][i]인 것이다.

// 이후 (N - 1)번 해당 알고리즘을 진행하면 된다.