package com.concept.interview;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.Serializable;

/**
 * Cloning with serialization - 序列化
 * 
 * This is another easy way of deep cloning. In this method, you just serialize
 * the object to be cloned and de-serialize it. Obviously, the object which need
 * to be cloned should implement Serializable interface.
 * 
 * 
 * 序列化的特点
 * 
 * First of all, serialization is hugely expensive. It could easily be a hundred
 * times more expensive than the clone() method. Secondly, not all objects are
 * serializable. Thirdly, making a class serializable is tricky and not all
 * classes can be relied on to get it right.
 * 
 * @author Vivian
 * 
 */
public class CloningWithSerialization {

	static class Professor implements Serializable {
		String name;
		int age;

		Professor(String name, int age) {
			this.name = name;
			this.age = age;
		}
	}

	static class Student implements Serializable {
		int age;
		String name;// 常量对象。
		Professor professor;// 学生1和学生2的引用值都是一样的。

		Student(String name, int age, Professor p) {
			this.name = name;
			this.age = age;
			this.professor = p;
		}

		public Object deepClone() throws IOException, OptionalDataException,
				ClassNotFoundException {

			// 将对象写到流里
			ByteArrayOutputStream bo = new ByteArrayOutputStream();
			ObjectOutputStream oo = new ObjectOutputStream(bo);
			oo.writeObject(this);

			// 从流里读出来
			ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
			ObjectInputStream oi = new ObjectInputStream(bi);
			return (oi.readObject());
		}
	}

	public static void main(String[] args) throws OptionalDataException,
			ClassNotFoundException, IOException {
		Professor professor = new Professor("王五", 50);
		Student student1 = new Student("张三", 18, professor);

		Student student2 = (Student) student1.deepClone();
		student2.professor.name = "李四";
		student2.professor.age = 30;

		System.out.println("name=" + student1.professor.name + "," + "age="
				+ student1.professor.age); // 学生1的教授不改变。
	}
}
