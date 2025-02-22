import java.util.*;
import java.io.*;
public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<String> set = new HashSet<>();

        String str = br.readLine();

        int len = str.length();

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                set.add(str.substring(i, j+1));
            }
        }

        System.out.println(set.size());


    }
}