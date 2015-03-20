package com.code.interview;

/**
 * 输入一个整数数组，判断是不是某个二叉搜索树的后序遍历的结果<br>
 * 
 * 1.递归调用<br>
 * 2.二叉搜索树的特点为左子树的值均小于根节点,右子树的值均大于根节点<br>
 * 3.后序遍历中，最后一个数字是根节点的值<br>
 * 
 * 
 * @author Vivian
 * 
 */
public class PostOrderOfBST_24 {

	public boolean isPostOrderOfBST(int[] sequence) {
		int len = sequence.length;

		return isPostOrder(sequence, 0, len - 1);
	}

	// 递归调用，判断是不是一个二叉搜索树的后序遍历
	public boolean isPostOrder(int[] sequence, int start, int end) {

		if (start > end) {
			return false;
		}

		int root = sequence[end];

		// 找到左子树的起始
		int i = 0;
		for (i = start; i <= end - 1; i++) {
			if (sequence[i] > root) {
				break;
			}
		}

		int leftEnd = i - 1;

		// 判断右子树是不是都大于根节点
		int rightStart = i;
		for (int tmp = rightStart; tmp <= end - 1; tmp++) {
			if (sequence[tmp] < root) {
				return false;
			}
		}

		// 判断左子树是不是二叉搜索树
		boolean left = true;
		if (start < leftEnd) {
			left = isPostOrder(sequence, start, leftEnd);
		}

		// 判断右子树是不是二叉搜索树
		boolean right = true;
		if (rightStart < end - 1) {
			right = isPostOrder(sequence, rightStart, end - 1);
		}

		return left && right;
	}

	public static void main(String[] args) {
		PostOrderOfBST_24 test = new PostOrderOfBST_24();
		int[] sequence = { 5, 4, 3, 2, 1 };
		boolean res = test.isPostOrderOfBST(sequence);
		System.out.println(res);
	}

}
