import java.util.*;

public class Ex6 {

    static class Node {
        int key;
        Node left, right;
        Node(int k) { key = k; }
    }

    // 1) Thu thập các khóa theo thứ tự tăng dần
    private void inorder(Node root, List<Integer> arr) {
        if (root == null) return;
        inorder(root.left, arr);
        arr.add(root.key);
        inorder(root.right, arr);
    }

    // 2) Xây lại BST cân bằng từ mảng đã sắp xếp
    private Node buildBalanced(List<Integer> arr, int l, int r) {
        if (l > r) return null;
        int m = l + (r - l) / 2;
        Node root = new Node(arr.get(m));
        root.left  = buildBalanced(arr, l, m - 1);
        root.right = buildBalanced(arr, m + 1, r);
        return root;
    }

    // API chính: nhận gốc của BST không cân bằng, trả về BST cân bằng
    public Node balanceBST(Node root) {
        List<Integer> arr = new ArrayList<>();
        inorder(root, arr);
        return buildBalanced(arr, 0, arr.size() - 1);
    }

    // --- Tiện ích để demo ---
    public Node insert(Node root, int key) {
        if (root == null) return new Node(key);
        if (key < root.key) root.left = insert(root.left, key);
        else if (key > root.key) root.right = insert(root.right, key);
        return root; // bỏ qua khóa trùng
    }

    public void printLevelOrder(Node root) {
        if (root == null) { System.out.println("(empty)"); return; }
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                Node cur = q.poll();
                System.out.print(cur.key + " ");
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
            System.out.println();
        }
    }
}
