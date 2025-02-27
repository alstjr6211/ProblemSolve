import java.util.*;
import java.io.*;
public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> positive_deque = new ArrayDeque<>();
        Deque<Integer> negative_deque = new ArrayDeque<>();

        int zero_count = 0;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        boolean isfront_positive = true;
        boolean isfront_negative = true;

        for (int i = 0; i < N; i++) {
            if (arr[i] < 0) {
                if (isfront_negative) {
                    negative_deque.addFirst(arr[i]);
                    isfront_negative = false;
                } else {
                    negative_deque.addLast(arr[i]);
                    isfront_negative = true;
                }
            } else if (arr[i] == 0) {
                zero_count++;
            } else {
                break;
            }
        }
        for (int i = N - 1; i >= 0; i--) {
            if (arr[i] > 0) {
                if (isfront_positive) {
                    positive_deque.addFirst(arr[i]);
                    isfront_positive = false;
                } else {
                    positive_deque.addLast(arr[i]);
                    isfront_positive = true;
                }
            } else {
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        int negative_size = negative_deque.size();
        int positive_size = positive_deque.size();
        while (!negative_deque.isEmpty()) {
            if (negative_size % 2 == 0) {
                sb.append(negative_deque.pollFirst()).append(" ");
            } else {
                sb.append(negative_deque.pollLast()).append(" ");
            }
        }
        for (int i = 0; i < zero_count; i++) {
            sb.append("0 ");
        }
        while (!positive_deque.isEmpty()) {
            if (positive_size % 2 == 0) {
                sb.append(positive_deque.pollLast()).append(" ");
            } else {
                sb.append(positive_deque.pollFirst()).append(" ");
            }
        }
        System.out.println(sb);
    }
}
// 수학? 사실 생각이 크게 많이 필요하진 않은 문젠데.. 구현을 어떻게 해야하나가 중요한 문제였다.

// 처음에는 배열로 풀었다.
// 각각 positive, negative에 대해 새로운 배열, 짝수 홀수를 파생시켜서 더했다.

// 물론, 아마 0이 없을 때의 경우를 체크를 못했겠지만, 시간초과도 났을 것이다.

// 배열에 sort를 총 6번 정도 했을 것이다.

// 이후 덱에다가 넣는 방법으로 바꿨다.

// 문제를 푸는 아이디어 대로, 덱의 First와 Last에 순서대로 집어넣고, 출력했다.
// 0이 없을 경우를 대비해 음수의 절댓값 최솟값은 오른쪽에, 양수의 절댓값 최솟값은 왼쪽에 위치하도록 했다.