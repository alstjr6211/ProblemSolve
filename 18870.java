import java.util.*;
import java.io.*;
public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();

        int[][] arr = new int[N][2];

        int[] not_sorted = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            not_sorted[i] = Integer.parseInt(st.nextToken());
        }
        int[] sorted = not_sorted.clone();

        Arrays.sort(sorted);

        int sameNum = 0;
        for (int i = 0; i < N; i++) {
            if (i > 0 && sorted[i] == sorted[i - 1]) {
                sameNum++;
            }
            arr[i][0] = sorted[i];
            arr[i][1] = sameNum;
        }
        for (int i = 0; i < N; i++) {
            map.put(arr[i][0], i - arr[i][1]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i : not_sorted) {
            sb.append(map.get(i) + " ");
        }
        System.out.println(sb);
    }
}