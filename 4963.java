import java.util.*;
import java.io.*;
public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            int[][] arr = new int[w][h];
            for (int i = 0; i < w; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < h; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            System.out.println(bfs(arr));

        }






    }
    static int bfs(int[][] arr) {
        int w = arr.length;
        int h = arr[0].length;

        Queue<int[]> queue = new ArrayDeque<>();

        int cnt = 0;

        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (arr[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    arr[i][j] = 0;
                    cnt++;

                    while(!queue.isEmpty()) {
                        int x = queue.peek()[0];
                        int y = queue.poll()[1];
                        for (int t = 0; t < 8; t++) {
                            int nx = x + dx[t];
                            int ny = y + dy[t];
                            if (nx >= 0 && nx < w && ny >= 0 && ny < h && arr[nx][ny] == 1) {
                                queue.add(new int[]{nx, ny});
                                arr[nx][ny] = 0;
                            }
                        }
                    }
                }
            }
        }



        return cnt;
    }
}