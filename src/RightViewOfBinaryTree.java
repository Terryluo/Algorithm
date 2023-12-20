/*
Given a Binary Tree, return the right view of it. Right view of a Binary Tree is list of nodes visible when tree is visited from Right side,
the order of the nodes in the list should be from top to bottom level of the original tree.

        Examples:
        1
        /    \
        2      3
        / \    /  \
        4   5   6  7
        /            \
        9             8

        /  \

        10  11

        the right view =  [1, 3, 7, 8, 11]
   */

import util.TreeNode;

import java.util.*;

public class RightViewOfBinaryTree {
    public List<Integer> rightView(TreeNode root) {
        // find out the last element of each level, the time complexity is O(n)
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.remove();
                if (i == size - 1) {
                    result.add(cur.key);
                }
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.reconstructTreeFromLevelOrder(new ArrayList<String>(
                Arrays.asList("1","2", "3", "4", "5", "6", "7", "9", "null", "null", "null", "null", "null", "null","8", "10", "11")
                ));
        RightViewOfBinaryTree rvobt = new RightViewOfBinaryTree();
        List<Integer> result = rvobt.rightView(root);
        for (Integer i : result) {
            System.out.printf("%d, ", i);
        }
    }
}
