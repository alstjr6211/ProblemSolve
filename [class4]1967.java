import java.util.*;
import java.io.*;
public class Main {

    static ArrayList<ArrayList<int[]>> node;

    static void init(int N) {
        node = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            node.add(new ArrayList<>());
        }
    }
    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        init(N);

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());


            node.get(parent).add(new int[] {child, weight});
        }

        int[] max = find_diameter(1);
        System.out.println(max[0]);
    }

    static int[] find_diameter(int node_num) {
        int max = 0;
        int max_weight = 0;

        ArrayList<int[]> child_list = node.get(node_num);

        int first_max_weight = 0;
        int second_max_weight = 0;

        for (int[] child : child_list) {
            int child_num = child[0];
            int child_weight = child[1];

            int[] child_max = find_diameter(child_num);

            max = Math.max(max, child_max[0]);

            if (first_max_weight < child_max[1] + child_weight) {
                second_max_weight = first_max_weight;
                first_max_weight = child_max[1] + child_weight;
            } else if (second_max_weight < child_max[1] + child_weight) {
                second_max_weight = child_max[1] + child_weight;
            }

            max = Math.max(max, first_max_weight + second_max_weight);
        }

        max_weight = first_max_weight;

        //System.out.println("node_num: " + node_num + " max: " + max + " first_max_weight: " + first_max_weight + " second_max_weight: " + second_max_weight);

        return new int[] {max, max_weight};
    }
}

// DFS에 대해 더 깊이 공부할 수 있었던 문제.

// 트리의 지름 문제를 풀면서 필요한 관점은 두가지다.

// 언제 최댓값을 비교해야하나?, 무엇을 가지고 이전 최댓값과 비교해야하나? 이다.

// 첫번째 질문에 대한 답은, 당연히 자식 노드의 최댓값을 발견하고 부모노드를 루트로 한 최댓값을 탐색할때이다.

// dp의 subproblem을 구하는 과정에서 처럼 한 노드를 루트노드로 할 때의 최댓값을 탐색하는 것이다.

// 그렇다면 두 번째 질문, 무엇으로 비교해야하나? 이다.

// 이때의 비교대상은 당연히 [자식 노드에서의 최댓값]이다. 또한 자식 노드가 여러개 있을 수 있으므로 정확히는
// [자식 노드들의 최댓값 중 최대값]과 [자식 노드들의 최대가중치 + 부모 노드와 자식 노드의 가중치]들을 전부 비교해야한다.

// 즉 비교 수는 자식 노드 수 * 2번.

// 처음에는 queue로 풀려다가 필요한 정보는 자식 노드의 최댓값, 자식 노드의 최대 가중치, 나의 최대 가중치와, 나의 두 번째로 큰 가중치라는 것을 알았다.

// 이때 나의 두 가중치들은, 합이 내 최댓값이 될 수 있으며, 그게 아니더라도 나의 부모에게 필요한 최대가중치의 정보를 전달해야하므로 나눴다.

// 또한 return을 max, max_weight로 주기 때문에, 재귀함수를 사용하여 풀었다.


// 확실히 예제가 잘 주어졌던 문제이고, 풀면서 느낀 것은, 정답을 도출하기 위해서 내가 필요한 정보들은 무엇이냐.. 였다.