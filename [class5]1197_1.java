import java.util.*;
import java.io.*;
public class Main {

    static int[] parent;

    static void init(int V) {
        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }
    }
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        init(V);

        ArrayList<Edge> edges = new ArrayList<>();



        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges.add(new Edge(start, end, weight));
        }

        Collections.sort(edges);


        int MST_count = 0;
        for (int i = 0; i < V - 1; i++) {
            Edge curEdge = edges.get(0);
            edges.remove(0);

            while (find(curEdge.start) == find(curEdge.end)) {
                curEdge = edges.get(0);
                edges.remove(0);
            }

            union(curEdge.start, curEdge.end);

            MST_count += curEdge.weight;

        }

        System.out.println(MST_count);

    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;
        }
    }

}

class Edge implements Comparable<Edge> {
    int start;
    int end;
    int weight;

    public Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge edge) {
        if (edge.weight < weight) {
            return 1;
        } else if (edge.weight > weight) {
            return -1;
        }
        return 0;
    }
}

// class5 1197 최소 스패닝 트리(MST)

// 스패닝 트리란, 사이클 없이 모든 간선을 연결한 트리이다.

// 그렇기 때문에, 스패닝 트리에서의 vertex V에 대해 edge는 (V - 1)이라는 성질을 갖는다.

// 여기서 MST는 최소 가중치 트리이다.

// MST를 구하는 알고리즘은 kruskal, prim알고리즘이 있는데, 위 풀이는 kruskal알고리즘이다.

// kruskal 알고리즘의 동작 원리는

// 1. 선택 가능한 것 중 최소 가중치 Edge를 선택한다.
// 2. 선택한 Edge가 사이클을 만들지 않는다면 선택을 유지, 사이클을 만든다면 다음 가중치 Edge를 선택한다.
// 3. V - 1개의 Edge를 선택할 때까지 반복.

// kruskal 알고리즘에서, 사이클을 만드는지 아닌지에 대한 판별은 분리 집합(union - find)를 사용한다.

// union - find에서 parent가 같다면, Edge를 선택하게 되면, 사이클이 생기는 것이다.

// 예시로, 더 작은 index를 parent라고 할 때,
// (1, 2)와 (3, 4), (4, 1)을 선택한 경우, 새로이 (2, 3)을 선택하려고 하면 부모가 1로 같아서, 사이클이 생기는 것을 확인 할 수 있다.

// 또한 Edge class를 생성하여 사용자 정의 compareTo를 만들어서 weight에 대해 정렬될 수 있도록 하였다.