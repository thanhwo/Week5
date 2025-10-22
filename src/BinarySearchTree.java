
public class BinarySearchTree {

    // Inner Node class
    public class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    Node root;

    public BinarySearchTree() {
        root = null;
    }

    // Insert a new key into the BST
    public void insert(int key) {
        root = insertRec(root, key);
    }

    // Recursive insert function
    private Node insertRec(Node root, int key) {
        // Base case: if tree is empty, return new node
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Otherwise, recur down the tree
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        // Return unchanged node pointer
        return root;
    }

    //Hàm tìm kiếm nút
    public boolean search (int key) {
        return searchRec(root,key);
    }
    private boolean searchRec(Node root,int key){
        if(root == null ){
            return false;
        }
        if(root.key == key){
            return true;
        }
        if (root.key < key){
            return searchRec(root.right, key);
        }
        return searchRec(root.left,key);
    }

    // Hàm xóa nút
    public void delete(int key){
        root = deleteRec(root, key);
    }
    private Node deleteRec(Node root, int key){
        if(root == null){
            return root;
        }
        if(key < root.key){
            root.left = deleteRec(root.left, key);
        }
        else if(key > root.key){
            root.right = deleteRec(root.right, key);
        }
        else{
            // TH1&2: chỉ có 1 or 0 nhánh con
            if(root.left == null){
                return root.right;
            }
            else if (root.right == null){
                return root.left;
            }
            // TH3: có 2 nhánh con
            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }
    // Tìm gtri nhỏ nhất trong cây
    private int minValue(Node root){
        int minv = root.key;
        while (root.left != null){
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }
    // Hàm duyệt cây
    public void inorder() {
        inorderRec(root);
        System.out.println("\n");
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // 1️⃣ Chèn các phần tử vào cây
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        System.out.println("🌳 Cây sau khi chèn các nút:");
        bst.inorder(); // Kết quả: 20 30 40 50 60 70 80

        // 2️⃣ Tìm kiếm phần tử
        int keyToSearch = 40;
        System.out.println("🔍 Tìm kiếm " + keyToSearch + ": " +
                (bst.search(keyToSearch) ? "Tồn tại" : "Không tồn tại"));

        // 3️⃣ Xóa nút có 0 con (lá)
        bst.delete(20);
        System.out.println("🗑️ Cây sau khi xóa 20 (nút lá):");
        bst.inorder();

        // 4️⃣ Xóa nút có 1 con
        bst.delete(30);
        System.out.println("🗑️ Cây sau khi xóa 30 (có 1 con):");
        bst.inorder();

        // 5️⃣ Xóa nút có 2 con
        bst.delete(50);
        System.out.println("🗑️ Cây sau khi xóa 50 (có 2 con):");
        bst.inorder();
    }
}
