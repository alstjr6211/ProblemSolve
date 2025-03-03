import java.util.*;
import java.io.*;
public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String keyword = br.readLine();
        int keynumber = Integer.parseInt(br.readLine());

        String word = br.readLine();

        System.out.println(decode(keyword, keynumber, word));





    }
    static String decode(String keyword, int keynumber, String word) {
        int num = keynumber - 1;
        char[] arr = new char[26];
        int key_length = keyword.length();
        int cnt = key_length;
        Set<Character> alphabet = new HashSet<>();
        for (int i = 0; i < key_length; i++) {
            if (num >= 26) {
                num = 0;
            }
            arr[num] = keyword.charAt(i);
            num++;
            alphabet.add(keyword.charAt(i));
        }
        while (cnt < 26) {
            if (num >= 26) {
                num = 0;
            }
            for (char c = 'A'; c <= 'Z'; c++) {
                if (!alphabet.contains(c)) {
                    arr[num] = c;
                    alphabet.add(c);
                    num++;
                    cnt++;
                    break;
                }
            }
        }


        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < 26; i++) {
            map.put((arr[i]), (char)('A' + i));
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            sb.append(map.get(c));
        }
        return sb.toString();
    }
}