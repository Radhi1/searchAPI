package com.radhika.naik.string.problem;

public class StringProblem {

	public static void main(String[] args) {
		StringProblem prob = new StringProblem();
		System.out.println(prob.replaceCharsUsingStringClass("Sample Data", 'a'));
		System.out.println(prob.replaceCharsUsingNoClass("Sample Data", 'a'));

	}
	
	/**
	 * Using standard methods
	 * @param input
	 * @param character
	 * @return
	 */
	public String replaceCharsUsingStringClass(String input, Character character) {
		input = input.replaceAll(character.toString(), "");
		return input;
	}
	
	/**
	 * Using custome method to search through string and replace the characters
	 * @param input
	 * @param character
	 * @return
	 */
	public String replaceCharsUsingNoClass(String input, Character character) {
		char charData[] = new char[input.length()];
		int iCount = 0;
		for(int ichar = 0; ichar < input.length(); ichar++) {
			if(input.charAt(ichar) != character) {
				charData[iCount] = input.charAt(ichar);
				iCount++;
			}
		}
		return new String(charData);
	}

}
