import java.util.*;
import java.io.*;
public class Main {
    static Set<String> set = new HashSet<>();

    static int[] arr;

    static void init(int N) {
        arr = new int[N];
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        init(N);

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        backtracking(N, M, 0, new ArrayList<>(), 0);
    }

    static void backtracking(int N, int M, int depth, ArrayList<Integer> list, int last) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int i : list) {
                sb.append(i).append(" ");
            }
            String str = sb.toString();
            if (!set.contains(str)) {
                set.add(str);
                System.out.println(str);
            }
        } else if (depth < M) {
            for (int i = last; i < N; i++) {
                list.add(arr[i]);
                backtracking(N, M, depth + 1, list, i);
                list.remove(list.size() - 1);
            }
        }
    }
}

// class4 백준 15666번 문제

// 문제 조건은 다른 N과 M에서 크게 달라지는게 없었다. 비 내림차순이고, 같은 수를 재사용할 수 있지만, 정답을 중복 출력하면 안된다.

// 따라서 15663번과 비슷하게 중복검사를 위해 Set을 사용했고,

// 비 내림차순 조건으로는 last라는 정수를 사용하여, 현재 위치에서 뒤의 수만 검사하도록 했다.

// 정답이 잘 되는 이유는, last자체가 backtracking 메서드를 호출할 때의 arr위치이고, arr은 sorted된 상태로 변환하고 backtracking을 진행하기 때문에,
// arr[i] >= arr[i - k] (이때 k는 i를 넘어가지 않는 임의의 양의 정수)을 항상 만족하기 때문이다.

// 고로 현재위치에서 중복 선택이 가능하게끔만 last를 사용해준다면, Set에서 중복검사를 하고 print함으로써 15663처럼 출력할 수 있다.

// 끝.