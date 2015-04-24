package com.concept.interview;

/**
 * Deep Cloning
 * 
 * It is the desired behavior in most the cases. We want a clone which is
 * independent of original and making changes in clone should not affect
 * original.
 * 
 * Deep Cloning requires satisfaction of following rules - 深拷贝遵循的原则
 * 
 * 1.No need to separately copy primitives. <br>
 * 
 * 2.All the member classes in original class should support cloning and in
 * clone method of original class in context should call super.clone() on all
 * member classes.<br>
 * 
 * 3.If any member class does not support cloning then in clone method, one must
 * create a new instance of that member class and copy all its attributes one by
 * one to new member class object. This new member class object will be set in
 * cloned object.<br>
 * 
 * @author Vivian
 * 
 */
public class DeepClone {
	static class Employee implements Cloneable {
		private int empoyeeId;
		private String employeeName;
		private Department department;

		public Employee(int id, String name, Department dept) {
			this.empoyeeId = id;
			this.employeeName = name;
			this.department = dept;
		}

		// 注意和shallow clone中的区别
		@Override
		protected Object clone() throws CloneNotSupportedException {
			Employee cloned = (Employee) super.clone();
			cloned.setDepartment((Department) cloned.getDepartment().clone());
			return cloned;
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

	// member class必须实现clone()方法，如果不实现，则需要new一个对象，并把成员依次拷贝过来
	static class Department implements Cloneable {
		private int id;
		private String name;

		public Department(int id, String name) {
			this.id = id;
			this.name = name;
		}

		// Defined clone method in Department class.
		@Override
		protected Object clone() throws CloneNotSupportedException {
			return super.clone();
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
		Department hr = new Department(1, "Human Resource");
		Employee original = new Employee(1, "Admin", hr);
		Employee cloned = (Employee) original.clone();

		// Let change the department name in cloned object and we will verify in
		// original object
		cloned.getDepartment().setName("Finance");

		// 在Deep clone的情况下，修改cloned中Department的name
		// 不会改变original中Department的name
		System.out.println(original.getDepartment().getName());
	}

}
