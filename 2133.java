import java.util.*;
import java.io.*;
public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());


        int[] dp = new int[31];

        dp[2] = 3;

        for (int i = 4; i <= 30; i += 2) {
            dp[i] = dp[i - 2] * 3 + 2;
            for (int j = 4; j <= i - 2; j += 2) {
                dp[i] += dp[i - j] * 2;
            }
        }

        System.out.println(dp[N]);


    }
}

//정말 고민을 많이한 문제

//풀이를 간략하게 적자면, 이 문제는 DP이다.

// N이 홀수인 경우는 주어진 타일로 메꿀 수 없으므로, 0

// N이 짝수인 경우는 이전 짝수에서 오른쪽에 2 * 3 타일 붙였을 때 3의 경우를 곱하는 것과 같다.

// 또한 각 N에 대해 고유한 경우 두 가지가 존재한다. 중간 타일을 잘 조합하다보면 나온다.

// 즉, dp[i - 2] * 3 + 2가 성립한다.

// 여기서 각 타힐의 고유한 경우 두 가지가 있다고 했으므로, 해당 고유의 경우를 오른쪽에 붙이고, 왼쪽에 대해 나머지 N의 타일 경우를 곱한 것과 같다.

// 예로, N = 10인 경우

// 왼쪽 8칸의 경우에 새로이 2 * 3타일을 더한 것이므로 dp[8] * 3을 하고 10의 고유 타일 경우 2를 더한다.

// 이후 오른쪽을 dp[4]였을 때의 4의 고유한 타힐의 경우로 채운다고 가정(2가지 경우) 나머지 왼쪽 6줄을 6에서 사용했던 방법으로 더한다.
// 점점 dp를 늘려가면 결국, 6 * 2 + 4 * 2 + 2 * 2 가 만들어지는 것이다.

// 즉,
// problem은 dp[N]의 경우의 수 구하기
// subproblem은 d[i]의 경우의 수 구하기 이고,

// dependency는 dp[i]는 이전 모든 dp table에 대해 의존성을 갖는다는 것.

// 점화식은 dp[i] = dp[i - 2] * 3 + dp[i - 4] * 2 + ... + dp[2] * 2 + 2라는 것이다.

// 굉장히 생각하기 까다로웠던 문제.