package com.concept.interview;

/**
 * 
 * Shallow Cloning - 浅拷贝
 * 
 * This is default implementation in java. In overridden clone method, if you
 * are not cloning all the object types (not primitives), then you are making a
 * shallow copy.
 * 
 * 1.基本类型采用复制; 2.其他类型复制引用，因此在cloned的object和原始的object中，指向同一个对象;
 * 
 * @author Vivian
 * 
 */
public class ShallowClone {
	static class Employee implements Cloneable {
		private int empoyeeId;
		private String employeeName;
		private Department department;

		public Employee(int id, String name, Department dept) {
			this.empoyeeId = id;
			this.employeeName = name;
			this.department = dept;
		}

		@Override
		protected Object clone() throws CloneNotSupportedException {
			return super.clone();
		}

		public int getEmpoyeeId() {
			return empoyeeId;
		}

		public void setEmpoyeeId(int empoyeeId) {
			this.empoyeeId = empoyeeId;
		}

		public String getEmployeeName() {
			return employeeName;
		}

		public void setEmployeeName(String employeeName) {
			this.employeeName = employeeName;
		}

		public Department getDepartment() {
			return department;
		}

		public void setDepartment(Department department) {
			this.department = department;
		}

	}

	static class Department {
		private int id;
		private String name;

		public Department(int id, String name) {
			this.id = id;
			this.name = name;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}

	public static void main(String[] args) throws CloneNotSupportedException {
		Department dept = new Department(1, "Human Resource");
		Employee original = new Employee(1, "Admin", dept);
		// Lets create a clone of original object
		Employee cloned = (Employee) original.clone();
		// Let verify using employee id, if cloning actually workded
		System.out.println(cloned.getEmpoyeeId());

		// Verify JDK's rules

		// Must be true and objects must have different memory addresses
		System.out.println(original != cloned);

		// As we are returning same class; so it should be true
		System.out.println(original.getClass() == cloned.getClass());

		// Default equals method checks for refernces so it should be false. If
		// we want to make it true,
		// we need to override equals method in Employee class.
		System.out.println(original.equals(cloned));

		/************* Shallow Clone-浅拷贝 ***************/

		// 由于Department没有重写Clone方法，默认采用shallow clone，只是传递Department的引用
		// 引发在second中修改Depart中的name，会影响到first中的值
		Department hr = new Department(1, "Human Resource");
		Employee first = new Employee(1, "Admin", hr);
		Employee second = (Employee) first.clone();

		// Let change the department name in cloned object and we will verify in
		// original object
		second.getDepartment().setName("Finance");

		System.out.println(first.getDepartment().getName());
	}

}
