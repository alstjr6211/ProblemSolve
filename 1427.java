import java.util.*;
import java.io.*;
public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String str = br.readLine();

        int length = str.length();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = str.charAt(i) - '0';
        }

        Arrays.sort(arr);
        for (int i = length - 1; i >= 0; i--) {
            System.out.print(arr[i]);
        }


    }
}