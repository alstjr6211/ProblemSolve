import java.util.*;
import java.io.*;
public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =  new StringTokenizer(br.readLine());


        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;

        for (int i = 0; i < X; i++) {
            sum += arr[i];
        }

        int max = sum;
        int max_count = 1;

        for (int i = X; i < N; i++) {
            sum += arr[i];
            sum -= arr[i - X];

            if (sum > max) {
                max = sum;
                max_count = 1;
            } else if (sum == max) {
                max_count++;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(max_count);
        }
    }
}

// 백준 21921번

// 슬라이딩 윈도우 기법을 활용해 푼 문제