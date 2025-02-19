import java.util.*;
import java.io.*;
public class Main {
    static int[] arr;
    static boolean[] visited;

    static int N;

    static int M;
    static StringBuilder sb = new StringBuilder();

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }
        visited = new boolean[N];

        backtracking(N, 1, -1);

        System.out.println(sb);

    }
    static void backtracking(int N, int cnt, int last) {
        if (cnt == M) {
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i <= last; i++) {
                if (visited[i]) {
                    sb2.append(arr[i]).append(" ");
                }
            }
            for (int i = last + 1; i < N; i++) {
                sb2.append(arr[i]);
                sb.append(sb2).append("\n");
                sb2.delete(sb2.length() - 1, sb2.length());

            }

        } else {
            cnt++;
            for (int i = last + 1; i < N; i++) {
                visited[i] = true;
                backtracking(N, cnt, i);
                visited[i] = false;
            }
        }
    }
}

// 백준 15650, solved.ac class4 N과 M

// 처음엔 브루트포스로 풀 수 있을 줄 알았다.
// 그런데 M이 정해져있는게 아니라 입력으로 주어지다보니, 해당 문제는 백트래킹으로 풀어야함을 알게되었다.

// 백트래킹이 무엇인가?

// BackTracking이란, 답을 찾아가는 트리에서, 더 이상 답이 될 수 없다고 판단하면 하위 노드로의 탐색을 중단하고 되돌아가는 것을 말한다.

// 나는 그간 DFS혹은 BFS문제를 재귀가 아니라 queue에 넣는 반복문으로 풀었기 때문에, 처음 접해보는 느낌이었다.

// 백트래킹은, 위와 같이 4 2가 주어졌을 때 cnt가 M과 같아지는 순간, 하위 노드로의 탐색은 의미가 없으므로, 탐색을 중단한다.

// 따라서 코드를 위와 같이 구성했고, visited에 따른 탐색을 진행한다.

// visted가 true라면, 해당 배열은 답에 있는 노드이므로 정답 수열에 추가하고, 그 뒤의 부분만 탐색한다.
// false라면, last보다 큰 상태에서만 visited를 진행한다. 오름차순이 문제 조건이기 때문이다.

// 또한 last라는 파라미터를 준 이유는, last를 visited에서 한 번 더 탐색할 필요 없이 O(1)만에 진행하는 것을 원했기 때문이다.

// 따라서 해당 문제의 코드는 위와 같다.