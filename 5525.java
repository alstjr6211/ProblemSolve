import java.util.*;
import java.io.*;
public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()) * 2 + 1;

        int M = Integer.parseInt(br.readLine());

        String str = br.readLine();

        int cnt = 0;
        int res = 0;

        boolean start = true;

        for (int i = 0; i < M; i++) {
            char c = str.charAt(i);

            if (c == 'I') {
                // 이후 아래에서 O인 경우, i += 2를 할 것이므로, 무조건 I가 나오면 새로운 시작지점
                start = false;
                cnt = 1;
            } else {
                if (start) {
                    //start가 true라면, 이전 값이 I가 아닌데 O가 나온 것이므로, start를 true로 유지하고,
                    cnt = 0;
                    // cnt는 O입력이므로 0으로 초기화
                } else {
                    if (i + 1 >= M) break;
                    if(str.charAt(i + 1) == 'O') {
                        cnt = 0;
                        start = true;
                    } else {
                        //이전 값이 I이고, 현재값은 O이며, 다시 다음 값이 I인 경우
                        cnt += 2;
                        i++;
                        if (cnt >= N) {
                            res++;
                        }
                    }
                }
            }
        }

        System.out.println(res);


    }
}