import java.util.*;
import java.io.*;
public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Node[] nodes = new Node[N+1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = new Node((char)(i + 'A' - 1));
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            char data = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if (left != '.') {
                nodes[data - 'A' + 1].setLeft(nodes[left - 'A' + 1]);
            }
            if (right != '.') {
                nodes[data - 'A' + 1].setRight(nodes[right - 'A' + 1]);
            }
        }


        preorder(nodes[1]);
        System.out.println();
        inorder(nodes[1]);
        System.out.println();
        postorder(nodes[1]);





    }

    public static void preorder(Node node) {
        System.out.printf("%c", node.data);

        if (node.left != null) {
            preorder(node.left);
        }
        if (node.right != null) {
            preorder(node.right);
        }
    }
    public static void inorder(Node node) {
        if (node.left != null) {
            inorder(node.left);
        }
        System.out.printf("%c", node.data);
        if (node.right != null) {
            inorder(node.right);
        }
    }
    public static void postorder(Node node) {
        if (node.left != null) {
            postorder(node.left);
        }
        if (node.right != null) {
            postorder(node.right);
        }
        System.out.printf("%c", node.data);

    }
}

class Node {
    char data;
    Node left;
    Node right;
    Node(char data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}

// Class4 #1991

// 먼저 문제 조건을 보면, Node의 값은 알파벳으로 이루어져 있으므로 최대 26가지이다.

// 또한 left와 right 두 개만 존재하므로, 다른 자식들을 생각할 필요가 없다.

// 즉, Node Class에는 Node의 data, left Node, right Node만 생각해주면 된다.

// 따라서 Node Class에서는 생성자로 값만 가지고 문제 조건에 의해 생성된 왼쪽 노드와 오른쪽 노드를 각각 set함수로 설정한다.

// 이후 preoder와 inorder, postorder을 각각 실행해야 한다.

// 노드들의 관계는 각각 Node 배열에 저장해두었다.

// Node A가 항상 루트 노드가 되므로, A의 노드 번호인 node[1]로 각각 순회를 진행하였다.

// 만약 루트도 입력으로 주어진다고 하면, 그땐 해당 번호로 바꾸면 된다.

// 이후에는 preorder, inorder, postorder를 각각 순회해야 한다.

// 따라서 정답 코드는 위와 같다.