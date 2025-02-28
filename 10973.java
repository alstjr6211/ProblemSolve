import java.util.*;
import java.io.*;
public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int last_index = find_last_descend(arr);

        if (last_index == -1) {
            System.out.println(-1);
        } else {
            int[] copy = new int[N - last_index];


            for (int i = 0; i < N - last_index; i++) {
                copy[i] = arr[last_index + i];
            }

            int max = Integer.MIN_VALUE;


            for (int i : copy) {
                if (i < copy[0]) {
                    max = Math.max(max, i);
                }
            }


            Arrays.sort(copy);

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < last_index; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append(max).append(" ");
            int max_cnt = 0;
            for (int i = copy.length - 1; i >= 0; i--) {
                if (copy[i] == max) {
                    if (max_cnt == 0) {
                        max_cnt++;
                        continue;
                    } else {
                        sb.append(copy[i]).append(" ");
                    }
                } else {
                    sb.append(copy[i]).append(" ");
                }
            }
            System.out.println(sb);
        }

    }

    static int find_last_descend(int[] arr) {
        int index = -1;
        int arr_len = arr.length;

        for (int i = 0; i < arr_len - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                index = i;
            }
        }
        return index;
    }
}

// 백준 10973번, 이전 수열

// 사전 순 정렬이 어떻게 이루어지는지 조금만 고민해보면 쉬운 문제.

// 문제 풀이는 어렵지 않다.

// 가장 뒤에 있는 내림차순 [i, i + 1]의 인덱스를 찾아준다.

// 인덱스 i까지는 그대로 수열을 가져가고, i를 포함한 그 뒤의 수열에서는
// i보다 작은 수 중, 최댓값을 i번째 위치에 고정시키고, 나머지 수는 역 사전순 정렬해서 붙이면 된다.

// 어렵지 않지만, 전부 오름차순인 경우에만 -1 이기 때문에, 그 점을 유의해서 풀면 된다.