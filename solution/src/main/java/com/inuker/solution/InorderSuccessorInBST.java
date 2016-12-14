package com.inuker.solution;

import java.util.Stack;

/**
 * Created by dingjikerbo on 16/11/20.
 */

/**
 * 有两种方法，用栈做普通的中序遍历，这种没有充分利用BST的特点
 * 第二种方法比较巧妙，首先遍历到p，然后继续遍历找到p的右子树的最小值
 */
public class InorderSuccessorInBST {

    // 耗时10ms
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = null, prev = null;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                if (prev == p) {
                    return node;
                }
                prev = node;
                node = node.right;
            }
        }
        return null;
    }

    // 耗时4ms
    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        TreeNode res = null;
        while (root != null) {
            if (root.val > p.val) {
                res = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return res;
    }
}
