import java.util.*;
import java.io.*;
public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int length = str.length();

        String[] arr = new String[length];

        for (int i = 0; i < length; i++) {
            arr[i] = str.substring(i);
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(arr[i]).append("\n");
        }

        System.out.println(sb);

    }
}