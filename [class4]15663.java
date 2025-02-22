import java.util.*;
import java.io.*;
public class Main {

    static int[] arr;

    static boolean[] visited;

    static Set<String> set = new HashSet<>();

    static void init(int N) {
        visited = new boolean[N];
        arr = new int[N];
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

        backtracking(N, M, 0, new ArrayList<>());





    }
    static void backtracking(int N, int M, int depth, ArrayList<Integer> list) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(list.get(i)).append(" ");
            }
            if (!set.contains(sb.toString())) {
                set.add(sb.toString());
                System.out.println(sb);
            }
        } else if (depth > M) {
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(arr[i]);
                backtracking(N, M, depth + 1, list);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}

// class4 15663 백준 N과 M중 신경을 꽤나 썼어야했던 문제.
// 문제 조건 중, 숫자 중복은 가능하지만, 최종 출력 배열은 중복이 불가능하다는 조건을 만족해야했다.

// 이 문제를 풀기 직전, Set을 이용해서 11478번 문제를 풀었던터라, 문제를 보자마자 Set을 사용하면 된다고 생각하고, 일단 String Set을 만들었다.
// 이후 정답을 출력하기 전에 collections.sort를 사용해서 정렬하고 출력하였더니, 틀렸다.

// 그 이유는 문자열의 정렬시에 10, 9는 9->10 순서가 아니라 10->9순서로 정렬된다는 점이었다.

// 이에 Set에서 sort를 하지 않고 출력하였다. 가능하다고 판단한 이유는 어차피 arr자체를 sort하고 backtracking을 진행하기 때문에, 처음 관찰하는 배열은
// sorted인 상태로 list에 들어가기 때문이다.

// 그러나 문제점이 또 하나 발생했다.

// Set자체가 add할때, sorted가 기본값인 것 처럼 그대로 10->9로 출력이 되었다.
// Set을 HashSet으로 사용해서 1이 최우선에 있는 듯하다. 이건 추후에 좀 더 확인을 해봐야겠지만..

// 어쨌든, 위와 같은 문제점 때문에, 기존에 backtracking 내에서는 set에 추가하고, main에서 set을 출력하는 형태였지만,
// set에 포함되어있지 않은 경우, backtracking 메서드 내에서 바로 출력하도록 변경하였다.

// 그랬더니 문제없이 통과되었다.

// HashSet의 저장방법이 어떤지 확실하게 깨닫게 해 준 문제였다.