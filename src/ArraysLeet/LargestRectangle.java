package ArraysLeet;

import java.util.Stack;

public class LargestRectangle {

	public static void main(String[] args) {

		int arr[] = {2,1,5,6,2,3 };
		System.out.println(largestRectangleArea(arr));
	}

	public static int largestRectangleArea(int[] heights) {

		if(heights == null || heights.length == 0) {
			return 0;
		}
		if(heights.length == 1) {
			return heights[0];
		}
		int i;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		int left[] = new int[heights.length];
		left[0] = 1;
		for (i = 1; i < heights.length; i++) {
			if (heights[stack.peek()] < heights[i]) {
				stack.push(i);
				left[i] = 1;
			} else {
				while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
					stack.pop();
				}
				left[i] = stack.isEmpty() ? i+1 : i - stack.peek();
				stack.push(i);
			}
		}
		printElement(left);
		Stack<Integer> stack1 = new Stack<Integer>();
		stack1.push(heights.length -1);
		int right[] = new int[heights.length];
		right[heights.length -1] = 1;
		for (i = heights.length - 2; i >= 0; i--) {
			if (heights[stack1.peek()] < heights[i]) {
				stack1.push(i);
				right[i] = 1;
			} else {
				while (!stack1.isEmpty() && heights[stack1.peek()] >= heights[i]) {
					stack1.pop();
				}
				right[i] = stack1.isEmpty() ? heights.length - i : stack1.peek() -i ;
				stack1.push(i);
			}
		}
		printElement(right);
		int max = Integer.MIN_VALUE;
		for(i = 0; i < heights.length; i++) {
			max = Math.max(max, heights[i]*(left[i]+ right[i]-1));
		}
		return max;
	}
	
	public static void printElement(int arr[]){
		System.out.println();
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "  ");
		}
		System.out.println();
	}

}
