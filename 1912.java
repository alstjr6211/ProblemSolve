import java.util.*;
import java.io.*;
public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] sum = new int[N + 1];
        int[] num = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean[] isNegative = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            int a = sum[i - 1] + num[i];

            if (a < 0) {
                sum[i] = 0;
                isNegative[i] = true;
            } else {
                sum[i] = a;
            }
        }

        int max = -1000;
        boolean isAllNegative = true;
        for (int i = 1; i <= N; i++) {
            if (!isNegative[i]) {
                isAllNegative = false;
                break;
            }
            max = Math.max(max, num[i]);

        }
        if (!isAllNegative) {
            for (int i = 1; i <= N; i++) {
                if (isNegative[i]) {
                    max = Math.max(max, sum[i - 1]);
                } else {
                    max = Math.max(max, sum[i]);
                }
            }
        }
        System.out.println(max);
    }
}


// dp를 활용해야 하는 문제.

// 처음에는 dp table을 2차원으로 만들어서 좌 우의 최댓값과 비교하여 dp[][]크기가 1 * 1일때부터 채워 나가는 것을 사용했다.
// 결과는 메모리초과. (사실 메모리 아니더라도 시간초과 였을 것이다.)

// 두 번째 방법은, 부분합을 사용하는 것이었다.
// 누적합에서 한 단계 더 나아가서 Sum[i] - Sum[j]의 결과값으로 j ~ i까지의 부분합을 구할 수 있기 때문에 O(1)시간만에 각 부분합의 최대를 알 수 있다.
// 그러나 이 또한, 부분합 검색을 최대 N^2해야한다. 따라서 시간초과.

// 세 번째로 생각한 방법은, 만약, 이전 값들부터 값을 더해나갈때, i번째까지의 부분합이 음수라면, 이 이후의 i + k(k >= 1) 번째의 부분합에는 굳이 i이전범위를 포함시킬 필요가 없다는 것이다.

// 그 이유는 i에서 음수가 나왔다는 것은, i번째의 값에 의해서 왼쪽 모든 것을 합친 값보다 더 작아졌다는 것이기 때문이다.

// 따라서 negative를 flag로 두어, negative인 경우는 0으로 취급하고, 다시 dp를 채워나갔다.
// 그러다보니, 전부 음수인 테이블에서는 문제가 발생했으므로,
// for (int i = 1; i <= N; i++) {
//   if (!isNegative[i]) {
//     isAllNegative = false;
//     break;
//   }
//   max = Math.max(max, num[i]);
// }
// 이 코드를 추가하여 해당 부분을 검사했다.

// DP의 기초인 누적합과 부분합에 대한 연습에 도움된 문제라고 생각한다.