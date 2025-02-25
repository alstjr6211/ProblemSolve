import java.util.*;
import java.io.*;
public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        String str = st.nextToken();

        answer(n, str);

    }

    static void answer(int n, String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();

        StringBuilder sb_camel = new StringBuilder();
        StringBuilder sb_snake = new StringBuilder();
        StringBuilder sb_pascal = new StringBuilder();


        if (n == 1) {
            sb.append(str);
            for (int i = 0; i < length; i++) {
                int A = str.charAt(i);
                if (A - 'a' < 0) {
                    sb_snake.append("_").append((char)(A + 32));
                    sb_pascal.append((char)(A));
                } else {
                    sb_snake.append((char)(A));
                    if (i == 0) {
                        sb_pascal.append((char)(A - 32));
                    } else {
                        sb_pascal.append((char) (A));
                    }
                }
            }
            sb.append("\n").append(sb_snake).append("\n").append(sb_pascal);
        } else if (n == 2) {
            for (int i = 0; i < length; i++) {
                int A = str.charAt(i);
                if (i == 0 || str.charAt(i) == '_') {

                    if (i == 0) {
                        sb_camel.append((char)(A));
                        sb_pascal.append((char)(A - 32));
                    } else {
                        i++;
                        A = str.charAt(i);
                        sb_camel.append((char)(A - 32));
                        sb_pascal.append((char)(A - 32));
                    }
                } else {
                    sb_pascal.append((char)(A));
                    sb_camel.append((char)(A));
                }
            }
            sb.append(sb_camel).append("\n").append(str).append("\n").append(sb_pascal);
        } else {
            for (int i = 0; i < length; i++) {
                int A = str.charAt(i);
                if (A - 'a' < 0) {
                    //대문자
                    if (i == 0) {
                        sb_snake.append((char)(A + 32));
                        sb_camel.append((char)(A + 32));
                    } else {
                        sb_snake.append("_").append((char)(A + 32));
                        sb_camel.append((char)(A));
                    }
                } else {
                    sb_snake.append((char)(A));
                    sb_camel.append((char)(A));
                }
            }
            sb.append(sb_camel).append("\n").append(sb_snake).append("\n").append(str);
        }

        System.out.println(sb);
    }
}