import java.util.*;
import java.io.*;
public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.println(b / (a + 1));
        }


    }
}

// 오랜만에 Scanner를 사용한 문제.
// EOF를 다루기 위해서는 sc.hasNext로 End of File인지 아닌지 확인하는 것이 훨씬 편했다.
