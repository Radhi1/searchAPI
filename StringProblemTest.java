package com.radhika.naik.string.problem;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringProblemTest {

	@Test
	public void testEqual() {
		StringProblem prob = new StringProblem();
		System.out.println(prob.replaceCharsUsingStringClass("Sample Data", 'a'));
		assertEquals("This should be equal","Smple Dt" , prob.replaceCharsUsingStringClass("Sample Data", 'a')); 
	}
	
	@Test
	public void testNotEqual() {
		StringProblem prob = new StringProblem();
		assertNotEquals("This should not be equal","Sample Data" , prob.replaceCharsUsingStringClass("Sample Data", 'a'));
	}
	
	@Test
	public void testEqual1() {
		StringProblem prob = new StringProblem();
		System.out.println(prob.replaceCharsUsingNoClass("Sample Data", 'a'));
		assertEquals("This should be equal","Smple Dt" , prob.replaceCharsUsingNoClass("Sample Data", 'a')); 
	}
	
	@Test
	public void testNotEqual1() {
		StringProblem prob = new StringProblem();
		assertNotEquals("This should not be equal","Sample Data" , prob.replaceCharsUsingNoClass("Sample Data", 'a'));
	}

}
