import java.util.*;
import java.io.*;
public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] min_arr = new int[N][3];
        int[][] max_arr = new int[N][3];

        int[][] arr = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        min_arr[0][0] = arr[0][0]; min_arr[0][1] = arr[0][1]; min_arr[0][2] = arr[0][2];
        max_arr[0][0] = arr[0][0]; max_arr[0][1] = arr[0][1]; max_arr[0][2] = arr[0][2];

        for (int i = 1; i < N; i++) {

            for (int j = 0; j < 3; j++) {
                //min
                if (j == 0) {
                    min_arr[i][j] = Math.min(min_arr[i - 1][j], min_arr[i - 1][j + 1]) + arr[i][j];
                } else if (j == 1) {
                    min_arr[i][j] = Math.min(Math.min(min_arr[i - 1][j - 1], min_arr[i - 1][j + 1]), min_arr[i - 1][j]) + arr[i][j];
                } else {
                    min_arr[i][j] = Math.min(min_arr[i - 1][j - 1], min_arr[i - 1][j]) + arr[i][j];
                }

                //max
                if (j == 0) {
                    max_arr[i][j] = Math.max(max_arr[i - 1][j], max_arr[ i- 1][j + 1]) + arr[i][j];
                } else if (j == 1) {
                    max_arr[i][j] = Math.max(Math.max(max_arr[i - 1][j - 1], max_arr[i - 1][j + 1]), max_arr[i - 1][j]) + arr[i][j];
                } else {
                    max_arr[i][j] = Math.max(max_arr[i - 1][j - 1], max_arr[i - 1][j]) + arr[i][j];
                }
            }
        }

        int min = Math.min(min_arr[N - 1][0], Math.min(min_arr[N - 1][1], min_arr[N - 1][2]));
        int max = Math.max(max_arr[N - 1][0], Math.max(max_arr[N - 1][1], max_arr[N - 1][2]));

//        System.out.println(Arrays.deepToString(min_arr));
//        System.out.println(Arrays.deepToString(max_arr));

        System.out.println(max + " " + min);
    }
}

// DP를 사용해서 푼 문제. 현재 위치를 포함한 최솟값과 최댓값을 DP table에 저장하고,

// 이후 마지막에 최대와 최소를 한 번 더 계산하면 되는 문제.

// Problem : N-1번 줄에서 최소/최댓값 구하기

// SubProblem : i번째 줄에서 최소/최댓값 구하기

// dependency : i번째 줄에서의 최소/최댓값은, i번째 위치로 이동할 수 있는 (i - 1)번째의 값들 중 최소/최대를 비교해야한다.

// dp table : 위와 같이 구할 수 있다.

// used Memory : 백준 기준, 53408KB의 메모리를 사용했으며, 계산해보면 3{arr의 개수} * 4byte{int 배열이므로} * 3{한 줄 당 3개의 int} * 1,000,000{N의 최댓값은 1백만}이므로, 12,000,000byte가 나와야한다.

// 기준보다 약 4.5배 더 나온 것  같은데, 그 이유는 잘 모르겠다. 