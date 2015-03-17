/**
 * 输入数字n,按顺序打印出1 ~ n位十进制数。
 * 
 * @author Vivian
 * 
 */
public class Print1ToN_12 {

	// 递归求数字排序问题
	public void print1ToMaxNDigits(int n) {

		if (n <= 0) {
			return;
		}

		int[] number = new int[n];

		for (int i = 0; i <= n - 1; i++) {
			number[i] = 0;
		}
		printRecursive(number, 0, n);

	}

	public void printRecursive(int[] number, int cur, int n) {
		if (cur == n) {
			print(number);
		} else {
			for (int i = 0; i <= 9; i++) {
				number[cur] = i;
				printRecursive(number, cur + 1, n);
			}
		}

	}

	public void print(int[] number) {
		boolean start = false;

		for (int i = 0; i <= number.length - 1; i++) {
			if (!start && number[i] != 0) {
				start = true;
			}
			if (start) {
				System.out.print(number[i]);
			}
		}

		System.out.print("\n");
	}

	public static void main(String[] args) {
		Print1ToN_12 test = new Print1ToN_12();
		test.print1ToMaxNDigits(2);
	}

}
