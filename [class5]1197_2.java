import java.util.*;
import java.io.*;
public class Main {
    static int V, E;
    static ArrayList<ArrayList<int[]>> vertex = new ArrayList<>();
    static void init() {
        for (int i = 0; i <= V; i++) {
            vertex.add(new ArrayList<>());
        }
    }
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        init();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            vertex.get(start).add(new int[]{end, weight});
            vertex.get(end).add(new int[]{start, weight});
        }

        int MST_count = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        boolean[] visited = new boolean[V + 1];

        pq.add(new int[]{1, 0});

        for (int i = 0; i < V; i++) {
            int[] cur = pq.poll();

            while (visited[cur[0]]) {
                cur = pq.poll();
            }
            visited[cur[0]] = true;
            MST_count += cur[1];

            for (int[] next : vertex.get(cur[0])) {
                if (!visited[next[0]]) {
                    pq.add(new int[]{next[0], next[1]});
                }
            }
        }

        System.out.println(MST_count);
    }
}

// class5 1197 최소 스패닝 트리(MST)

// 이 풀이는 MST를 prim알고리즘으로 푼 것이다.

// prim 알고리즘의 동작 원리는

// 1. vertex 중 아무 vertex로 시작(이 풀이에서는 1번 vertex로 시작함)
// 2. 갈 수 있는 vertex중 간선의 가중치가 최소인 Edge를 선택.
// 3. 선택한 Edge의 end vertex가 방문한 vertex면 사이클이 만들어지므로, 변경
// 4. 이후, vertex를 선택한 것이 V개가 되도록 edge를 선택한다.

// 이 문제에선, weight를 정렬할 필요없이 visited와 PriorityQueue로만 구현했다.

// PriorityQueue에서, 정렬 방식은, a와 b의 [1] 즉, weight를 기준으로 정렬했다.
