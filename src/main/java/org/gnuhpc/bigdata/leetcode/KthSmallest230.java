package org.gnuhpc.bigdata.leetcode;

import org.gnuhpc.bigdata.leetcode.utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class KthSmallest230 {
    /*
    Method 1: 递归 公共变量计数 TODO 重要方法 ！！
     */
    int count = 0;
    int result = Integer.MIN_VALUE;

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return result;
    }

    /*
    进入一次就记录一次的数据，也就是在遍历中计数
     */
    public void traverse(TreeNode root, int k) {
        if(root == null) return;
        traverse(root.left, k);
        if(++count == k) result = root.val;
        traverse(root.right, k);
    }

    /*
    Method2: 非递归计数 InOrder Traversal  TODO 非常重要
     */

    public int kthSmallest2(TreeNode root, int k){
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
            //左子树
            if(p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                if (--k == 0) return p.val;
                p = p.right;
            }
        }

        return -1;
    }

}
