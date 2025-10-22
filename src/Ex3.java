public class Ex3 {
    static class Node{
        int key;
        Node left, right;

        public Node(int item){
            key = item;
            left = right = null;
        }
    }
    public boolean hasPairWithSum(Node root, int target){
        java.util.HashSet<Integer> seen = new java.util.HashSet<>();
        return dfs(root, target, seen);
    }

    private boolean dfs(Node root, int target, java.util.Set<Integer> seen){
        if (root == null) return false;
        if (seen.contains(target - root.key)) return true;
        seen.add(root.key);
        return dfs(root.left, target, seen) || dfs(root.right, target, seen);
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(8);
        root.left.left = new Node(1);
        root.right.right = new Node(9);

        Ex3 sol = new Ex3();
        int n = 10;
        System.out.println("Có cặp có tổng bằng " + n + ": " + sol.hasPairWithSum(root,n ));
    }
}
