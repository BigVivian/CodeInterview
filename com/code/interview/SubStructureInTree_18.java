package com.code.interview;

/**
 * 给定两棵二叉树A和B，判断B是否为A的子树
 * 
 * @author Vivian
 * 
 */
public class SubStructureInTree_18 {

	public boolean isSubTree(TreeNode treeA, TreeNode treeB) {
		boolean res = false;

		if (treeA != null && treeB != null) {
			if (treeA.val == treeB.val) {
				// 判断以这个结点为根，A是否为B的子树
				res = treeAContainsB(treeA, treeB);
			}
			if (!res) {
				res = isSubTree(treeA.left, treeB);
			}

			if (!res) {
				res = isSubTree(treeA.right, treeB);
			}

		}

		return res;
	}

	public boolean treeAContainsB(TreeNode treeA, TreeNode treeB) {
		if (treeB == null)
			return true;
		if (treeA == null)
			return false;
		if (treeA.val != treeB.val) {
			return false;
		}

		return treeAContainsB(treeA.left, treeB.left)
				&& treeAContainsB(treeA.right, treeB.right);
	}

	public static void main(String[] args) {

	}

}
