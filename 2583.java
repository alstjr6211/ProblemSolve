import java.util.*;
import java.io.*;
public class Main {

    static int[][] arr;

    static void init(int N, int M) {
        arr = new int[N][M];
    }
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(st.nextToken());

        init(M, N);

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    arr[j][k] = 1;
                }
            }
        }

        System.out.println(bfs());

    }

    static String bfs() {
        StringBuilder sb = new StringBuilder();
        Queue<int[]> queue = new ArrayDeque<>();

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        int result = 0;

        int[] res = new int[11000];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    arr[i][j] = 1;
                    result++;
                    int cnt = 0;

                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        cnt++;

                        int x = cur[0];
                        int y = cur[1];

                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            if (nx < 0 || nx >= arr.length || ny < 0 || ny >= arr[0].length) {
                            } else if (arr[nx][ny] == 0) {
                                queue.add(new int[]{nx, ny});
                                arr[nx][ny] = 1;
                            }
                        }
                    }
                    res[i * 100 + j] = cnt;


                }
            }
        }
        StringBuilder resultSb = new StringBuilder();
        Arrays.sort(res);

        resultSb.append(result).append("\n");

        for (int i : res) {
            if (i != 0) {
                resultSb.append(i).append(" ");
            }
        }

        return resultSb.toString();
    }
}