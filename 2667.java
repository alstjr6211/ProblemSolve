import java.util.*;
import java.io.*;

import static java.util.Arrays.deepToString;

public class Main {

    static int[][] arr;

    static int N;

    static ArrayList<Integer> list = new ArrayList<>();

    static void init(int N) {
        arr = new int[N][N];
    }
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());


        init(N);

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        bfs();

        Collections.sort(list);

        System.out.println(list.size());
        for (int i : list) {
            System.out.println(i);
        }


    }

    static void bfs() {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1) {
                    q.add(new int[]{i, j});
                    arr[i][j] = 2;
                    int cnt = 1;

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();

                        for (int k = 0; k < 4; k++) {
                            int nx = cur[0] + dx[k];
                            int ny = cur[1] + dy[k];

                            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                            if (arr[nx][ny] == 1) {
                                q.add(new int[]{nx, ny});
                                arr[nx][ny] = 2;
                                cnt++;
                            }
                        }
                    }

                    list.add(cnt);

                }
            }
        }
    }
}