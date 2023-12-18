import java.util.ArrayDeque;
import java.util.Queue;

public class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int key) {
        this.key = key;
    }

    public static TreeNode constructBinaryTree(int start, int stop, int step) {
        if (start > stop) {
            System.out.println("Start could not larger than stop");
            return null;
        }
        TreeNode root = new TreeNode(start);
        Queue<TreeNode> queue = new ArrayDeque();
        queue.offer(root);
        int i = start + step;

        while(i <= stop) {
            TreeNode cur = (TreeNode)queue.poll();
            if (i <= stop) {
                cur.left = new TreeNode(i);
                i += step;
                queue.offer(cur.left);
            }

            if (i <= stop) {
                cur.right = new TreeNode(i);
                i += step;
                queue.offer(cur.right);
            }
        }

        return root;
    }

    public static TreeNode constructBinaryTree(int stop) {
        return constructBinaryTree(0, stop, 1);
    }

    public static TreeNode constructBinaryTree(int start, int stop) {
        return constructBinaryTree(start, stop, 1);
    }

    public static void printPreOrder(TreeNode root) {
        if (root != null) {
            System.out.printf("%d, ", root.key);
            printPreOrder(root.left);
            printPreOrder(root.right);
        }
    }

    public static void printInOrder(TreeNode root) {
        if (root != null) {
            printInOrder(root.left);
            System.out.printf("%d, ", root.key);
            printInOrder(root.right);
        }
    }

    public static void printPostOrder(TreeNode root) {
        if (root != null) {
            printPostOrder(root.left);
            printPostOrder(root.right);
            System.out.printf("%d, ", root.key);
        }
    }
}
