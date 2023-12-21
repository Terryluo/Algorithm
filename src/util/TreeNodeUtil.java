package util;

import java.util.LinkedList;
import java.util.List;

public class TreeNodeUtil {
    private static final String NULL_POINTER_EXPRESSION = "#";
    public static TreeNode reconstructTreeFromLevelOrder(List<String> array) {
        if (array.size() == 0) return null;
        TreeNode root = new TreeNode(Integer.valueOf(array.get(0)));
        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 1;
        while (index < array.size()) {
            for (int i = 0; i < queue.size(); i++) {
                TreeNode cur = queue.remove(0);
                if (cur != null) {
                    if (index < array.size()) {
                        String current = array.get(index);
                        cur.left = !NULL_POINTER_EXPRESSION.equals(current) ? new TreeNode(Integer.valueOf(current)) : null;
                        queue.add(cur.left);
                        index++;
                    } else {
                        cur.left = null;
                    }
                    if (index < array.size()) {
                        String current = array.get(index);
                        cur.right = !NULL_POINTER_EXPRESSION.equals(current) ? new TreeNode(Integer.valueOf(current)) : null;
                        queue.add(cur.right);
                        index++;
                    } else {
                        cur.right = null;
                    }
                } else {
                    if (index < array.size()) {
                        queue.add(null);
                        queue.add(null);
                        index += 2;
                    }
                }
            }
        }
        return root;
    }
}
