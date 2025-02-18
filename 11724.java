import java.util.*;
import java.io.*;
public class Main {

    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    static boolean[] visited;

    static int N = 0;
    static int M = 0;

    static void init() {
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
    }


    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        init();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            list.get(v1).add(v2);
            list.get(v2).add(v1);
        }


        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        int cnt = 0;

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                queue.add(i);
                visited[i] = true;
                cnt++;
                while (!queue.isEmpty()) {
                    for (int j : list.get(queue.poll())) {
                        if (!visited[j]) {
                            queue.add(j);
                            visited[j] = true;
                        }
                    }
                }
            }
        }
        return cnt;
    }
}


//#11724
//
//Conected Component의 개수를 구하는 문제
//
//CC란, 그래프에서 연결되어있는 부분을 구하는 것이므로, 전체 노드에 대해 각각 BFS 혹은 DFS를 해주면 된다. 위 코드는 BFS를 사용했다.
