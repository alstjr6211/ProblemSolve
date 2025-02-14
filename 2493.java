import java.util.*;
import java.io.*;
public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<int[]> stack = new Stack<>();
        Stack<int[]> second = new Stack<>();

        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(st.nextToken());

            stack.push(new int[]{height, i + 1});
        }

        second.push(stack.pop());

        int[] arr = new int[N];

        while(!stack.isEmpty()) {
            int num = stack.peek()[0];
            int secondNum = second.peek()[0];

            if (num < secondNum) {
                second.push(stack.pop());
            } else {
                while (!second.isEmpty() && num >= second.peek()[0]) {
                    int idx = second.pop()[1];
                    arr[idx - 1] = stack.peek()[1];
                }
                second.push(stack.pop());
            }
        }

        while (!second.isEmpty()) {
            int idx = second.pop()[1];
            arr[idx - 1] = 0;
        }

        StringBuilder sb = new StringBuilder();

        for (int i : arr) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);


    }
}