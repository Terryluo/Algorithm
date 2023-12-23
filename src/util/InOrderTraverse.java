package util;

import java.sql.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class InOrderTraverse {
    public List<Integer> inOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.offerFirst(root);
                root = root.left;
            } else {
                TreeNode cur = stack.pollFirst();
                result.add(cur.key);
                root = cur.right; // we need to control root in the while loop
            }
        }
        return result;
    }
}
