package com.code.interview;

import java.util.Arrays;
import java.util.BitSet;

/**
 * BitSet的应用场景
 * 
 * 常见的应用是那些需要对海量数据进行一些统计工作的时候，比如日志分析、用户数统计等等
 * 
 * 如统计40亿个数据中没有出现的数据，将40亿个不同数据进行排序等。
 * 现在有1千万个随机数，随机数的范围在1到1亿之间。现在要求写出一种算法，将1到1亿之间没有在随机数中的数求出来
 * 
 * @author Vivian
 * 
 */
public class BitSetDemo {

	/**
	 * 求一个字符串包含的char
	 * 
	 */
	public static void containChars(String str) {
		BitSet bitSet = new BitSet();
		for (int i = 0; i < str.length(); i++)
			bitSet.set(str.charAt(i)); // set bit for char

		StringBuilder sb = new StringBuilder();
		sb.append("[");

		int size = bitSet.size();
		System.out.println(size);
		for (int i = 0; i < size; i++) {
			if (bitSet.get(i)) {
				sb.append((char) i);
			}
		}
		sb.append("]");
		System.out.println(sb.toString());
	}

	/**
	 * 求素数 有无限个。一个大于1的自然数，如果除了1和它本身外，不能被其他自然数整除(除0以外）的数称之为素数(质数） 否则称为合数
	 */
	public static void computePrime() {
		BitSet sieve = new BitSet(1024);
		int size = sieve.size();
		for (int i = 2; i < size; i++)
			sieve.set(i);
		int finalBit = (int) Math.sqrt(sieve.size());

		for (int i = 2; i < finalBit; i++)
			if (sieve.get(i))
				for (int j = 2 * i; j < size; j += i)
					sieve.clear(j);

		int counter = 0;
		for (int i = 1; i < size; i++) {
			if (sieve.get(i)) {
				System.out.printf("%5d", i);
				if (++counter % 15 == 0)
					System.out.println();
			}
		}
		System.out.println();
	}

	/**
	 * 进行数字排序
	 */
	public static void sortArray() {
		int[] array = new int[] { 423, 700, 9999, 2323, 356, 6400, 1, 2, 3, 2,
				2, 2, 2 };
		BitSet bitSet = new BitSet(2 << 13);
		// 虽然可以自动扩容，但尽量在构造时指定估算大小,默认为64
		System.out.println("BitSet size: " + bitSet.size());

		for (int i = 0; i < array.length; i++) {
			bitSet.set(array[i]);
		}
		// 剔除重复数字后的元素个数
		int bitLen = bitSet.cardinality();

		// 进行排序，即把bit为true的元素复制到另一个数组
		int[] orderedArray = new int[bitLen];
		int k = 0;
		for (int i = bitSet.nextSetBit(0); i >= 0; i = bitSet.nextSetBit(i + 1)) {
			orderedArray[k++] = i;
		}

		System.out.println("After ordering: ");
		for (int i = 0; i < bitLen; i++) {
			System.out.print(orderedArray[i] + "\t");
		}

		System.out.println("iterate over the true bits in a BitSet");
		// 或直接迭代BitSet中bit为true的元素iterate over the true bits in a BitSet
		for (int i = bitSet.nextSetBit(0); i >= 0; i = bitSet.nextSetBit(i + 1)) {
			System.out.print(i + "\t");
		}
		System.out.println("---------------------------");
	}

	/**
	 * 将BitSet对象转化为ByteArray
	 * 
	 * @param bitSet
	 * @return
	 */
	public static byte[] bitSet2ByteArray(BitSet bitSet) {
		byte[] bytes = new byte[bitSet.size() / 8];
		for (int i = 0; i < bitSet.size(); i++) {
			int index = i / 8;
			int offset = 7 - i % 8;
			bytes[index] |= (bitSet.get(i) ? 1 : 0) << offset;
		}
		return bytes;
	}

	/**
	 * 将ByteArray对象转化为BitSet
	 * 
	 * @param bytes
	 * @return
	 */
	public static BitSet byteArray2BitSet(byte[] bytes) {
		BitSet bitSet = new BitSet(bytes.length * 8);
		int index = 0;
		for (int i = 0; i < bytes.length; i++) {
			for (int j = 7; j >= 0; j--) {
				bitSet.set(index++, (bytes[i] & (1 << j)) >> j == 1 ? true
						: false);
			}
		}
		return bitSet;
	}

	/**
	 * 简单使用示例
	 */
	public static void simpleExample() {
		String names[] = { "Java", "Source", "and", "Support" };
		BitSet bits = new BitSet();
		for (int i = 0, n = names.length; i < n; i++) {
			if ((names[i].length() % 2) == 0) {
				bits.set(i);
			}
		}

		System.out.println(bits);
		System.out.println("Size : " + bits.size());
		System.out.println("Length: " + bits.length());
		for (int i = 0, n = names.length; i < n; i++) {
			if (!bits.get(i)) {
				System.out.println(names[i] + " is odd");
			}
		}
		BitSet bites = new BitSet();
		bites.set(0);
		bites.set(1);
		bites.set(2);
		bites.set(3);
		bites.andNot(bits);
		System.out.println(bites);
	}

	// 给定已知的一组的集合，判断对于当前的输入的集合，已知集合中哪些为输入集合的子集
	public static void subArray() {
		BitSet array = new BitSet();
		for (int i = 1; i <= 7; i++) {
			array.set(i);
		}

		BitSet[] arrays = new BitSet[3];

		arrays[0] = new BitSet();
		arrays[0].set(1);
		arrays[0].set(2);

		arrays[1] = new BitSet();
		arrays[1].set(2);
		arrays[1].set(100);

		arrays[2] = new BitSet();
		arrays[2].set(4);
		arrays[2].set(5);
		arrays[2].set(6);

		isSubArray(array, arrays);
	}

	public static void isSubArray(BitSet array, BitSet[] arrays) {

		for (int i = 0; i <= arrays.length - 1; i++) {
			int length = arrays[i].length();
			BitSet tmp = arrays[i];
			tmp.and(array);

			if (length == tmp.length()) {
				System.out.println(" * " + arrays[i] + "*");
			}

		}
	}

	public static void main(String args[]) {
		// BitSet使用示例
		BitSetDemo.containChars("How do you do? 你好呀");
		BitSetDemo.computePrime();
		BitSetDemo.sortArray();
		BitSetDemo.simpleExample();

		// BitSet与Byte数组互转示例
		BitSet bitSet = new BitSet();
		bitSet.set(3, true);
		bitSet.set(98, true);
		System.out.println(bitSet.size() + "," + bitSet.cardinality());
		// 将BitSet对象转成byte数组
		byte[] bytes = BitSetDemo.bitSet2ByteArray(bitSet);
		System.out.println(Arrays.toString(bytes));

		// 在将byte数组转回来
		bitSet = BitSetDemo.byteArray2BitSet(bytes);
		System.out.println(bitSet.size() + "," + bitSet.cardinality());
		System.out.println(bitSet.get(3));
		System.out.println(bitSet.get(98));
		for (int i = bitSet.nextSetBit(0); i >= 0; i = bitSet.nextSetBit(i + 1)) {
			System.out.print(i + "\t");
		}

		System.out.println("\n**************判断子集***************");
		BitSetDemo.subArray();
	}
}
