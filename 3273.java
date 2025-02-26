import java.util.*;
import java.io.*;
public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int start = 0;
        int end = n - 1;
        int cnt = 0;

        while (start < end) {
            int sum = arr[start] + arr[end];

            if (sum == x) {

                cnt++;
                if (arr[start] == arr[start + 1]) {
                    start++;
                } else {
                    end--;
                }
            } else if (sum < x) {
                start++;
            } else {
                end--;
            }
        }

        System.out.println(cnt);

    }
}

//투 포인터 문제. 계수정렬로도 풀 수 있는 문제.

//투 포인터에 대한 연습을 하기 쉬운 문제라고 생각한다.