import java.util.*;
import java.io.*;
public class Main {

    static int L = 0;
    static int N = 0;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        System.out.println(sequence(L));


    }

    public static String sequence(int L) {

        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (int len = L; len <= 100; len++) {
            if(len % 2 == 0) {
                int standard = N / len;
                if ((standard * 2 + 1) * (len / 2) == N) {
                    int len_2 = len / 2;
                    for (int i = -len_2 + 1; i <= len_2; i++) {
                        sb.append(standard + i + " ");
                    }
                    if (standard - len_2 >= -1) {
                        flag = true;
                        break;
                    }

                }

            } else {
                int standard = N / len;
                if (standard * len == N) {
                    int len_2 = len / 2;
                    for (int i = -len_2; i <= len_2; i++) {
                        sb.append(standard + i + " ");
                    }
                    if (standard - len_2 >= 0) {
                        flag = true;
                        break;
                    }
                }
            }
        }

        String str = sb.toString();

        if(flag) {
            return str;
        } else {
            return "-1";
        }
    }
}