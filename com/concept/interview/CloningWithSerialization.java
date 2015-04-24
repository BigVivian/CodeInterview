package com.concept.interview;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;

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
	@SuppressWarnings("unchecked")
	static T clone(T t) throws Exception {
		// Check if T is instance of Serializeble other throw
		// CloneNotSupportedException
		ByteArrayOutputStream bos = new ByteArrayOutputStream();

		// Serialize it
		serializeToOutputStream(t, bos);
		byte[] bytes = bos.toByteArray();
		ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(
				bytes));

		// Deserialize it and return the new instance
		return (T) ois.readObject();
	}

	public static void main(String[] args) {

	}

}
