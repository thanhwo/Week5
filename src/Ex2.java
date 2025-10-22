public class Ex2 {

    // Node định nghĩa trong BST
    static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    private int count = 0;
    private int result = -1;

    public int kthLargest(Node root, int k) {
        count = 0;
        result = -1;
        reverseInorder(root, k);
        return result;
    }

    private void reverseInorder(Node root, int k) {
        if (root == null || count >= k) return;

        // duyệt nhánh phải trước (lớn hơn)
        reverseInorder(root.right, k);

        count++;
        if (count == k) {
            result = root.key;
            return;
        }

        reverseInorder(root.left, k);
    }

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

        Ex2 sol = new Ex2();
        int k = 2;
        System.out.println("Phần tử lớn thứ " + k + " là: " + sol.kthLargest(root, k));
    }
}
