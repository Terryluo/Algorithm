import com.sun.source.tree.Tree;
import util.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

public class DeleteInBinarySearchTree {
    public TreeNode deleteTree(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (root.key > key) {
            root.left = deleteTree(root.left, key);
            return root;
        } else if (root.key < key) {
            root.right = deleteTree(root.right, key);
            return root;
        }
        // Now we have root.key == key, the root only has left/right child
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        }
        // root has both left/right child, we want to use the smallest node that larger than the root to replace the root
        // vice versa, we can use the largest node that is smaller than the root as our target, but we choose the first one.
        if (root.right.left == null) {
            // we cannot check this with root.left == null together because we are not sure root.right is not null
            root.right.left = root.left;
            return root.right;
        }
        TreeNode smallest = smallest(root.right);
        smallest.left = root.left;
        smallest.right = root.right;
        return smallest;
    }

    private TreeNode smallest(TreeNode cur) {
        // we are going to find the smallest node that larger than the root
        TreeNode prev = cur;
        cur = cur.left;
        while (cur.left != null) {
            prev = cur;
            cur = cur.left;
        }
        prev.left = cur.right; // we want to bring the cur out , so we have to left cur.right become prev.left. p.s. cur.left is null at this point
        return cur;
    }

    public static void main(String[] args) {
        /*TreeNode root = TreeNode.reconstructTreeFromLevelOrder(
                new ArrayList<>(Arrays.asList("6","3","12","2","4","8","16","1","null","null","5","7","9","14","18"))
        );*/
        /*TreeNode root = TreeNode.reconstructTreeFromLevelOrder(
                new ArrayList<>(Arrays.asList("2","1","3"))
        );*/
        TreeNode root = TreeNode.reconstructTreeFromLevelOrder(
                new ArrayList<>(Arrays.asList("7","#","16","#", "#","11","18","#", "#","#" ,"#" ,"#","12","#","20"))
        );
        TreeNode.printInOrder(root);
        System.out.println();
        DeleteInBinarySearchTree dibst = new DeleteInBinarySearchTree();
        root = dibst.deleteTree(root, 16);
        TreeNode.printInOrder(root);
    }
}
