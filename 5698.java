import java.util.*;
import java.io.*;
public class Main {
    public static void main (String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        loop:
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            char check = s.charAt(0);
            if (check == '*') {
                break loop;
            } else {
                check = Character.toLowerCase(check);
            }
            while(st.hasMoreTokens()) {
                String str = st.nextToken();
                if (Character.toLowerCase(str.charAt(0)) != check) {
                    sb.append("N\n");
                    continue loop;
                } else {
                }
            }
            sb.append("Y\n");
        }

        System.out.print(sb);

    }
}