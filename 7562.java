import java.util.*;
import java.io.*;
public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int I = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer (br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            int target_x = Integer.parseInt(st.nextToken());
            int target_y = Integer.parseInt(st.nextToken());

            System.out.println(bfs(x, y, target_x, target_y, I));
        }


    }

    static int bfs(int x, int y, int target_x, int target_y, int I) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y, 0});
        int[] dx = {1, -1, 2, -2, 1, -1, 2, -2};
        int[] dy = {2, 2, 1, 1, -2, -2, -1, -1};
        boolean[][] visited = new boolean[300][300];
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cur_x = cur[0];
            int cur_y = cur[1];
            int cur_cnt = cur[2];

            if (cur_x == target_x && cur_y == target_y) {
                return cur_cnt;
            }

            for (int i = 0; i < 8; i++) {
                int nx = cur_x + dx[i];
                int ny = cur_y + dy[i];

                if (nx < 0 || nx >= I || ny < 0 || ny >= I) {
                    continue;
                } else if (visited[nx][ny]) {
                    continue;
                }

                queue.add(new int[]{nx, ny, cur_cnt + 1});
                visited[nx][ny] = true;
            }


        }
        return -1;
    }
}

// 처음에 체스판의 크기를 300 * 300으로 고정해두다가 틀린 문제.
// 당연히 8 * 8체스판에서 5번 걸리는 문제를, 300 * 300으로 확장되면, 기존 체스판의 경우의 수보다 더 짧아지는 경우가 존재했다.
// 고로 체스판의 크기를 파라미터로 넘겨줌과 동시에 해결한 문제.