package com.code.interview;

/**
 * 
 * 
 <code>
    public static Long valueOf(long l) {
       final int offset = 128;
       if (l >= -128 && l <= 127) { // will cache
           return LongCache.cache[(int)l + offset];
      }
      return new Long(l);
    }
 </code>
 * 
 * @author Vivian
 * 
 */
public class LongAndlong {

	public static void main(String[] args) {
		Long a = 5L;
		Long b = 5L;
		System.out.println(a == b);// true

		Long x = new Long(5L);
		Long y = new Long(5L);
		System.out.println(x == y);// false

		Long a1 = 129L;
		Long b1 = 129L;
		System.out.println(a1 == b1);// false

		Long x1 = 5L;
		long y1 = 5L;
		System.out.println(x1 == y1);// true

	}

}
