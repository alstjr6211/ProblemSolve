import java.util.*;
import java.io.*;
public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arr = new ArrayList<>();

        backtracking(N, M, 0, arr);
    }

    static void backtracking(int N, int M, int depth, ArrayList<Integer> arr) {
        if (depth == M) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        int last = 1;
        if (!arr.isEmpty()) {
            last = arr.get(arr.size() - 1);
        }

        for (int i = last; i <= N; i++) {
            arr.add(i);
            backtracking(N, M, depth + 1, arr);
            arr.remove(arr.size() - 1);
        }
    }

}

// 다른 N과 M 문제인 15650 코드와 달라진 점은, 문제 조건에 의해 i도 포함시켰다는 것이고,

// 또 달라진 점은 backtracking함수의 매개변수로 int last를 지우고, int M과 depth, ArrayList arr를 주었다는 것이다.

// 이로인해, M과 depth의 비교하느라 사용했던 불필요한 코드를 지우고 단순히 depth == M 조건만 사용한다. 원래는 전역변수 M이었지만, 내부에 매개변수로만 주는 것.

// 또한, ArrayList를 사용함으로써, 기존 last를 저장할 필요없이 코드가 진행된다.
// visited를 사용해서 방문한 것 전부를 체크했던 기존과 달리 출력 시에 시간적으로도 최적화되었다.

// 또, last를 직접 줬던 기존과 달리, arr의 마지막 부분만 체크하면 되었다.

// 따라서, 공간적으로는 매개변수가 많아짐으로 인해 조금 손해를 볼 진 몰라도, 시간적으로는 최적화 된 것이다.