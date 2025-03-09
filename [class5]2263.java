import java.util.*;
import java.io.*;
public class Main {
    static int[] inorder, postorder;
    static Map<Integer, Integer> map = new HashMap<>();

    static StringBuilder sb = new StringBuilder();

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        inorder = new int[N];
        postorder = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            map.put(inorder[i], i); //data, index
        }

        preorder(0, N - 1, 0, N - 1);

        System.out.println(sb);


    }
    static void preorder(int instart, int inend, int poststart, int postend) {
        if (instart > inend || poststart > postend) {
        } else {
            int root = postorder[postend];
            sb.append(root).append(" ");
            int idx = map.get(root);
            int leftsize = idx - instart;

            preorder(instart, idx - 1, poststart, poststart + leftsize - 1);
            preorder(idx + 1, inend, poststart + leftsize, postend - 1);
        }
    }
}

// class5 백준 2263번 문제, 트리의 순회

// postorder와 inorder 순회의 결과를 가지고 preorder 순회를 구하는 것이다.

// 방법은 어렵지 않다.

// postorder에서의 마지막 노드가 해당 서브트리에서의 root노드라고 할 수 있다.

// root노드의 값으로 inorder에서 해당 값이 있는 index를 구한다.

// 해당 idx기준으로, 왼쪽은 왼쪽 서브트리, 오른쪽은 오른쪽 서브트리이다.

// 따라서 inoder기준으로 left는 instart ~ idx -1 이고, right는 idx + 1 ~ inend이다.
// postorder기준으로는, post start값과 instart값이 다르기 때문에, poststart + inorder에서 구한 leftsize가 left의 postend값이다.
// 같은 맥락으로, right에서는 poststart + leftsize ~ postend - 1이 rigth의 범위이다.

// N이 최대 100000이기 때문에, 값을 효율적으로 가져오기 위하여, 초기에 inorder, postorder의 결과를 전역변수 배열로 저장해두고,
// map을 활용해서 idx를 구하는 것을 O(1)만에 할 수 있도록 하였다.

// 해당 과정은, 직접 트리를 만들지 않더라도, root 출력, left 순회, rigth 순회의 순서로 바로 preorder가 출력되도록 하였다.
