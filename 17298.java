import java.util.*;
import java.io.*;
public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());

        Deque<int[]> dq = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());

            if(dq.isEmpty()) {
                dq.add(new int[]{cur, i});
            } else {
                while(!dq.isEmpty() && dq.peekLast()[0] < cur) {
                    int idx = dq.pollLast()[1];

                    arr[idx] = cur;
                }
                dq.add(new int[]{cur, i});
            }
        }

        while(!dq.isEmpty()) {
            int idx = dq.pollLast()[1];

            arr[idx] = -1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}