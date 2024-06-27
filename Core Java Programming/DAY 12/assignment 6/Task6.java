package com.example.stacksorter;
import java.util.Stack;
public class StackSequenceChecker {
	    public static boolean isSequenceInStack(Stack<Integer> stack, int[] sequence) {
	        int[] reversedSequence = new int[sequence.length];
	        for (int i = 0; i < sequence.length; i++) {
	            reversedSequence[i] = sequence[sequence.length - 1 - i];
	        }
Stack<Integer> stackCopy = (Stack<Integer>) stack.clone();

	         int seqIndex = 0;
 while (!stackCopy.isEmpty() && seqIndex < reversedSequence.length) {
	             int top = stackCopy.pop();

	            if (top == reversedSequence[seqIndex]) {
	               
	                seqIndex++;
	            }
	        }
 
	        return seqIndex == reversedSequence.length;
	    }

	    public static void main(String[] args) {
	        Stack<Integer> stack = new Stack<>();
	        stack.push(1);
	        stack.push(2);
	        stack.push(3);
	        stack.push(4);
	        stack.push(5);

	        int[] sequence1 = {3, 4, 5};
	        int[] sequence2 = {2, 3, 4};
	        int[] sequence3 = {5, 4, 3};

	        System.out.println(isSequenceInStack(stack, sequence1)); 
	        System.out.println(isSequenceInStack(stack, sequence2)); 
	        System.out.println(isSequenceInStack(stack, sequence3)); 
	    }
	}