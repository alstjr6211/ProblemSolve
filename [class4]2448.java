import java.util.*;
import java.io.*;
public class Main {

    static boolean[][] arr;

    static void init(int N) {
        arr = new boolean[N][2 * N - 1];
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());

        int K = N / 3;
        K = (int) (Math.log(K) / Math.log(2));


        init(N);

        staring(K, 0, N);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                if (arr[i][j]) {
                    sb.append("*");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);


    }

    static void staring(int K, int x, int y) {

        if (K == 0) {
            y--;
            arr[x][y] = true;
            arr[x + 1][y - 1] = arr[x + 1][y + 1] = true;

            for (int i = 0; i < 5; i++) {
                arr[x + 2][y - 2 + i] = true;
            }
        } else {
            staring(K - 1, x, y);
            staring(K - 1, x + 3 * (int) Math.pow(2, K - 1), y - 3 * (int) Math.pow(2, K - 1));
            staring(K - 1, x + 3 * (int) Math.pow(2, K - 1), y + 3 * (int) Math.pow(2, K - 1));
        }
    }
}

// solved.ac class4 2448번 문제

// 재귀를 조금 다룰 줄 안다면 그리 어렵지는 않은 문제.

// 그러나 JAVA로 풀때는 StringBuilder를 이용해서 풀어야한다.

// BufferWrite를 사용해서 푼 건 아니라 그건 모르겠다.

// StringBuilder로 풀지 않고 바로 출력하게 되면 시간 초과가 발생한다.

// 그 이유는 JAVA의 출력 형식을 잘 알아야한다.

// 한 번 더 StringBuilder의 위력을 실감한 문제이다.

// 추가 설명을 조금 하자면,

// staring에서 k는 단계, x와 y는 배열의 좌표이다.

// 각각 0, N(N은 배열의 중간 위치)에서 시작하는데,

// 재귀를 불러오는 부분은,

// staring(k - 1, x, y)는 x, y 위치에서 단계를 하나 낮춘 위치이고,
// staring(k - 1, x + 3 * 2^(k - 1), y - 3 * 2^(k - 1))와 다음 문장은, 본래 주어졌던 N의 규칙인 3 * 2^N크기만큼 각각 이동해야 하기 때문이다.

// 위치를 잘 살펴본다면 이해가 잘 될 것이다.

// 각각 현재 위치, 아래 좌, 아래 우 순서이다.