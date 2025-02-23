import java.util.*;
import java.io.*;
public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());
        Queue <Integer> positive_queue = new LinkedList<>();

        Queue <Integer> negative_queue = new LinkedList<>();

        Queue <Integer> zero_queue = new LinkedList<>();

        int[] pos_arr = new int[N];
        int[] nega_arr = new int[N];

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 0) {
                pos_arr[i] = num;
            } else {
                nega_arr[i] = num;
            }
        }

        Arrays.sort(pos_arr);
        Arrays.sort(nega_arr);

        int k = 0;
        for (int i = N - 1; i > -1; i--) {
            if (pos_arr[i] > 0) {
                positive_queue.add(pos_arr[i]);
            } else if (nega_arr[i] == 0) {
                zero_queue.add(nega_arr[i]);
            } else {
                k = i;
                break;
            }
        }
        for (int i = 0; i <= k; i++) {
            if (nega_arr[i] < 0) {
                negative_queue.add(nega_arr[i]);
            }
        }

        int cnt = 0;
        while (positive_queue.size() > 1) {
            int a = positive_queue.poll();
            int b = positive_queue.poll();
            cnt += Math.max(a * b, a + b);
        }
        if (positive_queue.size() == 1) {
            cnt += positive_queue.poll();
        }

        while (negative_queue.size() > 1) {
            int a = negative_queue.poll();
            int b = negative_queue.poll();
            cnt += a * b;
        }
        if (negative_queue.size() == 1) {
            if (zero_queue.size() > 0) {
                zero_queue.poll();
            } else {
                cnt += negative_queue.poll();
            }
        }
        System.out.println(cnt);
    }
}

// 백준 1744번 문제

// 먼저 문제 조건 중 하나는 수들은 한 번만 묶을 수 있다.

// 즉 (1, 2, 3) 배열에서 ((1, 2), 3) 혹은 (1, (2, 3)) 혹은 ((1, 3), 2) 이렇게 세 가지 경우로만 묶을 수 있다.

// 이때 전부 양수인 경우에는, 큰 수 부터 묶어야 값이 커진다.
// 다만, 묶는 수 중에 1이 포함되어있는 경우에는 (위의 예시로는 (1, 2) 혹은 (1, 3)) 더하는 것이 값이 더 크다.

// 음수인 경우에는 -1인지 아닌지에 상관없이 그냥 곱하는 것이 더 크다.

// 따라서 양수는 두 수씩 곱해주거나 더하고, 음수인 경우에는 남은 음수가 하나가 될 때까지 곱한다.

// 하나가 남았을 때, 0이 존재하면 0을 더하면 되고, 아닌 경우에는 음수 그대로 더해야 한다.

// 최대 N의 개수 50개와 각 수의 범위는 -1000 ~ 1000 이므로 int범위 내에서 해결된다.

// 끝.