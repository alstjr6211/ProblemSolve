import java.util.*;
import java.io.*;
public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (num < min) {
                min = num;
                max = num;

                if (i == 0) {
                    arr[i] = 0;
                } else {
                    arr[i] = arr[i - 1];
                }
            } else if (num >= max) {
                max = num;
                int k = Math.max(max - min, arr[i - 1]);
                arr[i] = k;
            } else {
                arr[i] = arr[i - 1];
            }

        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);


    }
}