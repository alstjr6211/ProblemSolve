import java.util.*;
import java.io.*;
public class Main {
    static ArrayList<ArrayList<Integer>> vertex;

    static void init(int N) {
        vertex = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= N; i++) {
            vertex.add(new ArrayList<Integer>());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        int count_case = 1;
        while (!(N == 0 && M == 0)) {
            init(N);
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                vertex.get(start).add(end);
                vertex.get(end).add(start);
            }
            sb.append("Case ").append(count_case).append(": ");
            int k = dfs(N);
            if (k == 0) {
                sb.append("No trees.\n");
            } else if (k == 1) {
                sb.append("There is one tree.\n");
            } else {
                sb.append("A forest of ").append(k).append(" trees.\n");
            }

            count_case++;
            vertex.clear();

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
        }
        System.out.println(sb);
    }

    static int dfs(int N) {
        int cnt = 0;

        boolean[] visited = new boolean[N + 1];
        Stack<int[]> stack = new Stack<>();

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                stack.push(new int[]{i, -1});

            }

            boolean countFlag = true;

            if (visited[i]) {
                countFlag = false;
            }
            while (!stack.isEmpty()) {
                int[] cur = stack.pop();

                int cur_vertex = cur[0];
                int parent = cur[1];

                int parentCnt = 0;

                for (int next : vertex.get(cur_vertex)) {

                    if (next == parent && parentCnt == 0) {

                        parentCnt++;
                    } else if (next == parent && parentCnt == 1) {

                        countFlag = false;

                        break;
                    } else if (!visited[next]) {

                        visited[next] = true;

                        stack.push(new int[]{next, cur_vertex});
                    } else {

                        countFlag = false;
                        break;
                    }
                }
            }

            if (countFlag) {
                cnt++;
            }
        }

        return cnt;
    }
}

// 이 문제는 그렇게 어려운 개념이 아니라 개념을 알면 풀기 쉬운 문제.

// 문제에서 주어진 조건을 명확하게 풀어내면 된다.

// 노드가 3개인 그래프에서
// (1, 2), (2, 3), (3, 1)의 간선을 가지면 이는 트리가 아니다.

// 이 점을 명확히 알고 접근해야한다.

// 나는 문제를 풀때 DFS를 사용하면 된다고 생각했었지만, (1, 2), (2, 1)이 주어진 경우에 대해서는 어떻게 판단할지 꽤 고민을 하게했다.

// (1, 2)의 경우 하나만 주어진다면, 전혀 문제가 되지 않지만, (2, 1)과 같이 주어진다면 사이클이 발생하게 된다.

// 따라서 간선에 각각 추가해주고, parent를 검사해서 한 번 카운트 된 경우는 허용하고, 두 번 이상인 경우는 flag를 false로 만든다.

// 그리고 visited가 true인 경우는 while문을 돌지 않으니 true로 만든다.

// 이런 모든 과정을 거치고 나면 정답이 출력된다.

// 다만,  M이 0인 경우도 확인해야한다.
