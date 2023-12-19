import java.util.ArrayDeque;
import java.util.Queue;

public class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int key) {
        this.key = key;
    }

    public static TreeNode binaryTree(int start, int stop, int step) throws Exception {
        if (start > stop) {
            throw new Exception("Start could not larger than stop");
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

    public static TreeNode binaryTree(int stop) throws Exception {
        return binaryTree(0, stop, 1);
    }

    public static TreeNode binaryTree(int start, int stop) throws Exception {
        return binaryTree(start, stop, 1);
    }

    public static TreeNode fromIntegerArray(int[] array) {
        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new ArrayDeque();
        queue.offer(root);
        int i = 1;
        while (i < array.length) {
            TreeNode cur = (TreeNode)queue.poll();
            if (i < array.length) {
                cur.left = new TreeNode(i);
                i++;
                queue.offer(cur.left);
            }
            if (i < array.length) {
                cur.right = new TreeNode(i);
                i++;
                queue.offer(cur.right);
            }
        }
        return root;
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
