package com.concept.interview;

/**
 * Copy Constructors
 * 
 * @author Vivian
 * 
 */
public class CopyConstructors {
	static class PointOne {
		private Integer x;
		private Integer y;

		public PointOne(PointOne point) {
			this.x = point.x;
			this.y = point.y;
		}

		public PointOne(int x, int y) {
			this.x = x;
			this.y = y;
		}

		/**
		 * 
		 * Another way of creating a copy constructor is to have static factory
		 * methods. They take class type in argument and create a new instance
		 * using another constructor of class. Then these factory methods will
		 * copy all the state data to new class instance just created in
		 * previous step, and return this updated instance.
		 * 
		 */
		public PointOne copyPoint(PointOne point)
				throws CloneNotSupportedException {
			if (!(point instanceof Cloneable)) {
				throw new CloneNotSupportedException("Invalid cloning");
			}
			// Can do multiple other things here
			return new PointOne(point.x, point.y);
		}
	}

	static class PointTwo extends PointOne {
		private Integer z;

		public PointTwo(PointTwo point) {
			super(point); // Call Super class constructor here
			this.z = point.z;
		}

		public PointTwo(int x, int y, int z) {
			super(x, y);
			this.z = z;
		}
	}

	public static void main(String[] args) {
		PointOne one = new PointOne(1, 2);
		PointTwo two = new PointTwo(1, 2, 3);

		PointOne clone1 = new PointOne(one);
		PointOne clone2 = new PointOne(two);

		// The problem with inheritance is that exact behavior is identified
		// only in run time. So, in our case if some class passed the instance
		// of PointTwo in constructor of PointOne. In this case, you will get
		// the instance of PointOne in return where you passed instance of
		// PointTwo as argument.

		// Let check for class types
		System.out.println(clone1.getClass());
		System.out.println(clone2.getClass());
	}
}
