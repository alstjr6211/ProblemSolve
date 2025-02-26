import java.util.*;
import java.io.*;
public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] min_arr = new int[2][3];
        int[][] max_arr = new int[2][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            if (i == 0) {
                min_arr[0][0] = Integer.parseInt(st.nextToken());
                min_arr[0][1] = Integer.parseInt(st.nextToken());
                min_arr[0][2] = Integer.parseInt(st.nextToken());

                max_arr[0][0] = min_arr[0][0];
                max_arr[0][1] = min_arr[0][1];
                max_arr[0][2] = min_arr[0][2];
            } else {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                min_arr[1][0] = Math.min(min_arr[0][0], min_arr[0][1]) + a;
                min_arr[1][1] = Math.min(min_arr[0][0], Math.min(min_arr[0][1], min_arr[0][2])) + b;
                min_arr[1][2] = Math.min(min_arr[0][1], min_arr[0][2]) + c;

                max_arr[1][0] = Math.max(max_arr[0][0], max_arr[0][1]) + a;
                max_arr[1][1] = Math.max(max_arr[0][0], Math.max(max_arr[0][1], max_arr[0][2])) + b;
                max_arr[1][2] = Math.max(max_arr[0][1], max_arr[0][2]) + c;

                min_arr[0][0] = min_arr[1][0];
                min_arr[0][1] = min_arr[1][1];
                min_arr[0][2] = min_arr[1][2];

                max_arr[0][0] = max_arr[1][0];
                max_arr[0][1] = max_arr[1][1];
                max_arr[0][2] = max_arr[1][2];
            }
        }

        int min = Math.min(min_arr[0][0], Math.min(min_arr[0][1], min_arr[0][2]));
        int max = Math.max(max_arr[0][0], Math.max(max_arr[0][1], max_arr[0][2]));



        System.out.println(max + " " + min);
    }
}

// 이전 2096_1번 풀이에서,

// 슬라이딩 윈도우 기법을 적용한 문제.

// 이전에 정의했던 Problem과 SubProblem, dependency와 같다.

// 그러나 이 방법에서는, max배열과 min배열의 크기를 2 * 3으로 고정하고,

// 인풋이 발생하는 즉시 배열의 값을 변경해준다.

// 이후 다음 for루프를 진행하기 전에 1번째 줄 배열을 0번째에서 복사한다.

// 출력 시에는는 0번째와 1번째 줄의 값이 같기 때문에, 0번째 줄에서 최소/최대 값을 도출한다.

// used Memory : 42092
// time : 344ms

// 메모리와 time모두 줄었다.

// 이전 약 53000kb를 사용한 것 보다, 전에 계산했던 배열의 크기만큼 줄었던 것을 볼 수 있다.

// 아무래도 42000kb의 대부분은 StringTokenizer나 버퍼의 영향이 아닐까 싶다.