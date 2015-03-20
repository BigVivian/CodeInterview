package com.code.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * 20.顺时针打印二维矩阵[同leetCode的54题]<br>
 * 
 * 1.需要注意分情况讨论，包括打印矩阵的一圈可分为四种情况[一步、两步、三步或者四步] <br>
 * 2.需要注意结束的条件start * 2 < row && start * 2 < col
 * 
 * @author Vivian
 * 
 */
public class PrintMatrixClockWisely_20 {

	List<Integer> res = null;

	public List<Integer> spiralOrder(int[][] matrix) {
		res = new ArrayList<Integer>();

		if (matrix.length <= 0) {
			return res;
		}

		int row = matrix.length;
		int col = matrix[0].length;

		int start = 0;

		while (start * 2 < row && start * 2 < col) {
			traverseInCircle(matrix, row, col, start);
			start++;
		}

		return res;
	}

	public void traverseInCircle(int[][] matrix, int row, int col, int start) {

		int endX = col - 1 - start;
		int endY = row - 1 - start;

		// 从左到右打印一行
		for (int tmp = start; tmp <= endX; tmp++) {
			res.add(matrix[start][tmp]);
		}

		// 从上打下打印一行
		if (endY > start) {
			for (int tmp = start + 1; tmp <= endY; tmp++) {
				res.add(matrix[tmp][endX]);
			}
		}

		// 从右到左打印一行
		if (endY > start && endX > start) {
			for (int tmp = endX - 1; tmp >= start; tmp--) {
				res.add(matrix[endY][tmp]);
			}
		}

		// 从下到上打印一行
		if (endY - start > 1 && endX > start) {
			for (int tmp = endY - 1; tmp >= start + 1; tmp--) {
				res.add(matrix[tmp][start]);
			}
		}

	}

	public static void main(String[] args) {
		PrintMatrixClockWisely_20 test = new PrintMatrixClockWisely_20();
		int matrix[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		List<Integer> res = test.spiralOrder(matrix);

		for (Integer i : res) {
			System.out.print(i + " ");
		}
	}

}
