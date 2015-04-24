package com.code.interview;

/**
 * 数组c只包含非负数，且c单调递增<br>
 * 给定数组c，求出c中满足c[i] * c[j] >= c[i] + c[j]的值对(c[i],c[j])
 * 
 * @author Vivian
 * 
 */
public class Solution {

	public int solution(double[] c) {
		int count = 0;

		int i = 0;
		int j = c.length - 1;

		while (i < j) {
			if (c[i] * c[j] >= c[i] + c[j]) {
				count += j - i;
				j--;
			} else {
				i++;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		double[] c = { 0.5, 1.5, 2.0, 2.0, 3.0, 5.02 };
		int res = test.solution(c);
		System.out.println(res);
	}
}
