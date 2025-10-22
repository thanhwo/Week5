public class Ex5 {
    static class Node{
        int key;
        Node left, right;
        public Node(int item){
            key = item;
            left = right = null;
        }
    }
    public Node LCA(Node root, int a, int b ){
        if (root == null) return null;
        if (a > b) {
            a = a^b;
            b = b^a;
            a = b^a;
        }

        Node cur = root;
        while(cur != null){
            if (b < cur.key) cur = cur.left;
            else if (a > cur.key) cur = cur.right;
            else{
                return cur;
            }
        }
        return null;
    }
    public Node insert(Node root, int key) {
        if (root == null) return new Node(key);
        if (key < root.key) root.left = insert(root.left, key);
        else if (key > root.key) root.right = insert(root.right, key);
        return root; // giả sử không có khóa trùng
    }
    public static void main(String[] args) {
        /*
                5
               / \
              3   8
             / \   \
            2   4   10
        */
        Ex5 s = new Ex5();
        Node root = null;
        for (int x : new int[]{5,3,8,2,4,10}) root = s.insert(root, x);

        Node l1 = s.LCA(root, 2, 4);   // kỳ vọng: 3
        Node l2 = s.LCA(root, 2, 10);  // kỳ vọng: 5
        Node l3 = s.LCA(root, 3, 8);   // kỳ vọng: 5
        Node l4 = s.LCA(root, 5, 5);   // kỳ vọng: 5 (một nút chính là LCA của chính nó)

        System.out.println(l1 != null ? l1.key : "null"); // 3
        System.out.println(l2 != null ? l2.key : "null"); // 5
        System.out.println(l3 != null ? l3.key : "null"); // 5
        System.out.println(l4 != null ? l4.key : "null"); // 5

    }
}


