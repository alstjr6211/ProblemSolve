import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int[][] arr;
    static void init() {
        arr = new int[N][N];
    }
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        init();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 1;

        for (int i = 0; i <= 100; i++) {
            int cnt = bfs(i);

            if (cnt > max) {
                max = cnt;

            }
        }

        System.out.println(max);

    }

    static int bfs(int t) {
        int[][] arrs = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arrs[i][j] = arr[i][j] <= t ? 1 : 0;
            }
        }


        int cnt = 0;

        Queue<int[]> q = new LinkedList<>();


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arrs[i][j] == 0) {
                    q.add(new int[]{i, j});
                    cnt++;

                }
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    int x = cur[0];
                    int y = cur[1];
                    if (x > 0 && arrs[x - 1][y] == 0) {
                        arrs[x - 1][y] = 1;
                        q.add(new int[]{x - 1, y});
                    }
                    if (x < N - 1 && arrs[x + 1][y] == 0) {
                        arrs[x + 1][y] = 1;
                        q.add(new int[]{x + 1, y});
                    }
                    if (y > 0 && arrs[x][y - 1] == 0) {
                        arrs[x][y - 1] = 1;
                        q.add(new int[]{x, y - 1});
                    }
                    if (y < N - 1 && arrs[x][y + 1] == 0) {
                        arrs[x][y + 1] = 1;
                        q.add(new int[]{x, y + 1});
                    }
                }
            }
        }

        return cnt;


    }
}