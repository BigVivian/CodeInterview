package com.concept.interview;

import java.io.Serializable;

import org.apache.commons.lang.SerializationUtils;

/**
 * 
 * Apache commons 实现 Deep Clone
 * 
 * Apache commons has also utility function for deep cloning. If you feel
 * interested the follow their official docs. Below is sample usage of cloning
 * facility using Apache commons:
 * 
 * @author Vivian
 * 
 */
public class ApacheCommons {
	static class SomeObject implements Serializable {

	}

	public static void main(String[] args) {
		SomeObject someObject = new SomeObject();
		SomeObject cloned = (SomeObject) SerializationUtils.clone(someObject);
	}

}

/**
 * Deep Clone - 总结
 * 
 * 1) When you don’t know whether you can call the clone() method of a
 * particular class as you are not sure if it is implemented in that class, you
 * can check with checking if the class is instance of “Cloneable” interface as
 * below.
 * 
 * if(obj1 instanceof Cloneable){ obj2 = obj1.clone(); }
 * 
 * //Don't do this. Cloneable don't have any methods
 * 
 * obj2 = (Cloneable)obj1.clone();
 * 
 * 2) No constructor is called on the object being cloned. As a result, it is
 * your responsibility, to make sure all the members have been properly set.
 * Also, if you are keeping track of number of objects in system by counting the
 * invocation of constructors, you got a new additional place to increment the
 * counter.
 * 
 */
