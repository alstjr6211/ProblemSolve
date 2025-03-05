import com.sun.security.jgss.GSSUtil;

import java.util.*;
import java.io.*;
public class Main {
    public static void main (String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());

        Stack<Character> stack = new Stack<>();

        String str = br.readLine();

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            char k = str.charAt(i);

            stack.push(k);

            while (true) {

                if (stack.size() <= 4) break;
                if (stack.peek() == '0' || stack.peek() == 'p') {
                    char a = stack.pop();
                    if (stack.peek() == '0' || stack.peek() == 'e') {
                        char b = stack.pop();
                        if (stack.peek() == '0' || stack.peek() == 'e') {
                            char c = stack.pop();
                            if (stack.peek() == '0' || stack.peek() == 'k') {
                                char d = stack.pop();
                                if (stack.peek() == 's') {
                                    stack.pop();
                                    stack.push('0');
                                    cnt++;
                                } else {
                                    stack.push(d);
                                    stack.push(c);
                                    stack.push(b);
                                    stack.push(a);
                                    break;
                                }
                            } else {
                                stack.push(c);
                                stack.push(b);
                                stack.push(a);
                                break;
                            }
                        } else {
                            stack.push(b);
                            stack.push(a);
                            break;
                        }
                    } else {
                        stack.push(a);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}