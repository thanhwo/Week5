public class Ex1 {

    // ✅ static để có thể tạo Node mà không cần đối tượng Ex1
    static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    Node root;
    private int count;
    private int sum;

    public Ex1() {
        root = null;
    }

    public int sumSmaller(Node root, int k) {
        // ✅ reset biến đếm và tổng mỗi lần gọi
        count = 0;
        sum = 0;
        inorder(root, k);
        return sum;
    }

    private void inorder(Node root, int k) {
        if (root == null || count >= k) return;

        inorder(root.left, k);

        if (count < k) {
            sum += root.key;
            count++;
        }

        inorder(root.right, k);
    }

    // ✅ Đặt hàm main trong class Ex1
    public static void main(String[] args) {
        /*
                5
               / \
              3   8
             / \   \
            2   4   10
        */

        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.right = new Node(10);

        Ex1 sol = new Ex1();
        int k = 4;
        System.out.println("Tổng các phần tử nhỏ hơn hoặc bằng phần tử nhỏ thứ "
                + k + " là: " + sol.sumSmaller(root, k));
    }
}
