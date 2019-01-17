package org.gnuhpc.bigdata.leetcode;

import org.gnuhpc.bigdata.leetcode.utils.TreeNode;

import java.util.*;

public class LevelOrderBottom107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Deque<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if (root==null) return new ArrayList<>(res);

        q.offer(root);
        while (!q.isEmpty()){
            List<Integer> subRes = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode n = q.poll();
                subRes.add(n.val);
                if (n.left!=null) q.offer(n.left);
                if (n.right!=null) q.offer(n.right);
            }

            res.push(subRes);
        }

        return new ArrayList<>(res);

    }
}
