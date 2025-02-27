import java.util.*;
import java.io.*;
public class Main {

    static int N, M;

    static int[][] map;

    static void init() {
        map = new int[N][M];

    }
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        init();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        bfs();

    }
    static void bfs() {

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        //first

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                //second
                loop:
                for (int q = 0; q < N; q++) {
                    for (int w = 0; w < M; w++) {

                        int[][] local = new int[N][M];
                        int localMax = 0;

                        Queue<int[]> queue = new LinkedList<>();
                        boolean[][] visited = new boolean[N][M];

                        if (map[i][j] == 1) {break loop;}

                        queue.add(new int[]{i, j});
                        visited[i][j] = true;

                        if (map[q][w] == 1) {continue;}
                        if (i != q && j != w) {
                            queue.add(new int[]{q, w});
                            visited[q][w] = true;
                        }

                        while (!queue.isEmpty()) {
                            int[] cur = queue.poll();
                            int x = cur[0];
                            int y = cur[1];


                            for (int k = 0; k < 4; k++) {
                                int nx = x + dx[k];
                                int ny = y + dy[k];

                                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                                } else if (visited[nx][ny]) {
                                } else {
                                    local[nx][ny] = local[x][y] + 1;
                                    queue.add(new int[]{nx, ny});
                                    visited[nx][ny] = true;
                                }

                            }
                        }

                        for (int a = 0; a < N; a++) {
                            for (int b = 0; b < M; b++) {
                                if (map[a][b] == 1) {
                                    localMax = Math.max(localMax, local[a][b]);
                                }
                            }
                        }

                        min = Math.min(min, localMax);
                    }
                }
            }
        }

        System.out.println(min);
    }
}

// 단순히 bfs를 두 점을 중심으로 한 것을 브루트포스로 푸는 문제

// 처음에는 bfs결과로 두 번째 bfs를 진행할까 하였지만, 문제 조건 중 마을에는 독주머니를 놓을 수 없다는 것 때문에
// 실패하였다.

// 그러다 문제 조건을 자세히 보니 N, M <= 20(N, M은 정수) 조건 때문에 브루트포스로 풀어도 된다는 확신이 생겼다.

// 위는 java의 loop break를 달아서 보다 쉽게 마을인 경우 다음 루프를 진행하게 했고, localMax와 min값을 비교해 해당 경우의 수 최댓값과
// 최종 최솟값을 비교하였다.