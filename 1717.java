import java.util.*;
import java.io.*;
public class Main {

    static int[] arr;

    static void init(int N) {
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }
    }
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        init(N);

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int operation = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (operation == 0) {
                union(a, b);
            } else {
                if (find(a) == find(b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }


        }


    }

    static int find(int a) {
        if (arr[a] == a) {
            return a;
        } else {
            arr[a] = find(arr[a]);
            return arr[a];
        }

    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            arr[b] = a;
        }
    }
}

//처음에 hashset을 사용해서 풀었는데 시간초과가 났다. 최대 10만개의 set이 생성되고, 복사하고 지우는 과정에서 메모리초과가 발생한 것이다

//그래서 union-find를 사용해서 풀었다. 이는 알고리즘을 공부할 때 배웠던 내용이라 쉽게 풀 수 있었다.

//union-find를 사용하면 union의 시간복잡도가 O(1)이기 때문에 시간초과가 나지 않는다. 또한 find도 제한된 시간복잡도를 넘지 않는다.
//또한 공간복잡도 자체도 배열 하나만 쓰면 되기 때문에 훨씬 간편하다.
//여러모로 기존의 공부 내용이 중요하다는 걸 깨닫게 해준 문제.