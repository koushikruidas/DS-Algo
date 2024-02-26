package Tree;

public class Inorder {
    public static void inorderTravel(TreeNode root){
        if (root == null) return;
        inorderTravel(root.left);
        System.out.println(root.val);
        inorderTravel(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2,new TreeNode(3),null);
        inorderTravel(root);
    }
}
