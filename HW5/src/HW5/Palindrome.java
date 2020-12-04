package HW5;

import java.util.ArrayDeque;
import java.util.*;
import java.util.Deque;
import java.util.Stack;

public class Palindrome
{
	private String inputString;
	
	private static Stack<Character> charStack;
	
	public Palindrome(String str)
	{
		inputString = str;
		fillStack(str);
	}
	
	private static Deque<Character> fillStack(String inputString) 
	{
		 Deque<Character> charStack = new ArrayDeque<>();
		 for (int i = 0; i < inputString.length(); i++) 
		 {
		 charStack.push(inputString.charAt(i));
		 }
		 return charStack;
		 }
	
	private static String buildReverse(String inputString) 
	{
		 StringBuilder result = new StringBuilder();
		 
		 while (!charStack.isEmpty()) 
		 {
			 result.append(charStack.pop());
		 }
		 	return result.toString();
	}
	
	public static boolean isPalindrome(String inputString)
	{
		 return inputString.equalsIgnoreCase(buildReverse(inputString));
	}
}
