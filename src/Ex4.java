public class Ex4 {
    static class Node{
        int key;
        Node left, right;
        public Node(int item){
            key = item;
            left = right = null;
        }
    }
    public int distanceBetween(Node root, int a, int b){
        if(root == null) return -1;
        if(a > b){
            a = a^b;
            b = b^a;
            a = b^a;
        }
        Node lca = findLCAinBST(root, a, b);
        if (lca == null) return -1;
        int d1 = distanceFrom(lca, a);
        int d2 = distanceFrom(lca, b);
        if(d1 == -1 || d2 == -1) return -1;
        return d1 + d2;
    }
    private Node findLCAinBST(Node root, int a, int b){
        Node cur = root;
        while (cur != null){
            if(b < cur.key) cur = cur.left;
            else if( a > cur.key) cur = cur.right;
            else  return cur;
        }
        return null;
    }
    private int distanceFrom(Node start, int target) {
        int dist = 0;
        Node cur = start;
        while (cur != null) {
            if (target == cur.key) return dist;
            if (target < cur.key) cur = cur.left;
            else cur = cur.right;
            dist++;
        }
        return -1;
    }
    public Node insert(Node root, int key) {
        if (root == null) return new Node(key);
        if (key < root.key) root.left = insert(root.left, key);
        else if (key > root.key) root.right = insert(root.right, key);
        // nếu cho phép trùng, cần quy ước rõ; ở đây giả sử không có trùng
        return root;
    }

    public static void main(String[] args) {
        /*
                5
               / \
              3   8
             / \   \
            2   4   10
        */
        Ex4 s = new Ex4();
        Node root = null;
        for (int x : new int[]{5,3,8,2,4,10}) root = s.insert(root, x);

        // Ví dụ: khoảng cách (số cạnh)
        System.out.println(s.distanceBetween(root, 2, 4));   // 2 -> 3 -> 4 : 2
        System.out.println(s.distanceBetween(root, 2, 10));  // 2 -> 3 -> 5 -> 8 -> 10 : 4
        System.out.println(s.distanceBetween(root, 3, 8));   // 3 -> 5 -> 8 : 2
        System.out.println(s.distanceBetween(root, 5, 5));   // cùng nút: 0
        System.out.println(s.distanceBetween(root, 1, 8));   // 1 không có trong cây: -1
    }
}


