import java.util.*;
import java.io.*;
public class Main {

    static int[] arr;
    static boolean[] visited;

    static void init(int N) {
        arr = new int[N];
        visited = new boolean[N];
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        init(N);
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
            Arrays.sort(arr);

        backtracking(N, M, new ArrayList<Integer>());




    }

    static void backtracking(int N, int M, ArrayList<Integer> list) {
        if (list.size() == M) {
            for (int i : list) {
                System.out.print(i + " ");
            }

            System.out.println();
        } else {
            for (int i = 0; i < N; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    list.add(arr[i]);
                    backtracking(N, M, list);
                    list.remove(list.size() - 1);
                    visited[i] = false;
                }
            }
        }
    }
}

// 풀때 for-loop문에 사용한게 list인지 arr인지 확인하자!
// 여러 방법으로 시도하다가 visited를 전역변수로 두고 푼 문제.
// 매개변수로 visited를 주는 것도 가능하지만, 여기선 굳이 그러지 않았다.

// 문제 조건이 N<=8, M<=8이어서 이렇게 풀이해도 정답처리겠지만, 사실 depth < M일때만 else문을 돌아야한다.
// 그것도 조금 수정해서 풀면 좋을 것 같다.