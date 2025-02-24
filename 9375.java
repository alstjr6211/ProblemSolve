import java.util.*;
import java.io.*;
public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
           int N = Integer.parseInt(br.readLine());
           Map<String, Integer> map = new HashMap<>();
           Set<String> set = new HashSet<>();


           for (int j = 0; j < N; j++) {
               StringTokenizer st = new StringTokenizer(br.readLine());
               String name = st.nextToken();
               String close = st.nextToken();

               if (map.containsKey(close)) {
                   map.put(close, map.get(close) + 1);
               } else {
                   map.put(close, 1);
               }
               set.add(close);

           }


            int count = 1;

           for (String str : set) {
                count *= (map.get(str) + 1);
           }

            System.out.println(count - 1);


        }


    }
}