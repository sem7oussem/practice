package practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class Pair<A, B> {
    private A first;
    private B second;

    public Pair(A first, B second) {
        super();
        this.first = first;
        this.second = second;
    }

    public int hashCode() {
        int hashFirst = first != null ? first.hashCode() : 0;
        int hashSecond = second != null ? second.hashCode() : 0;

        return (hashFirst + hashSecond) * hashSecond + hashFirst;
    }

    public boolean equals(Object other) {
        if (other instanceof Pair) {
            Pair otherPair = (Pair) other;
            return 
            (
			(this.first == otherPair.first
					|| (this.first != null && otherPair.first != null && this.first.equals(otherPair.first)))
					&&
            (  this.second == otherPair.second ||  ( this.second != null && otherPair.second != null &&  this.second.equals(otherPair.second))) 
            );
        }

        return false;
    }

    public String toString()
    { 
           return "(" + first + ", " + second + ")"; 
    }

    public A getFirst() {
        return first;
    }

    public void setFirst(A first) {
        this.first = first;
    }

    public B getSecond() {
        return second;
    }

    public void setSecond(B second) {
        this.second = second;
    }

	public boolean isUnique(String s) {
		int[] countSort = new int[256];
		if (s.length() > 256)
			return false;

		for (int i = 0; i < s.length(); i++) {
			if (countSort[s.charAt(i)] == 1)
				return false;
			countSort[s.charAt(i)]++;
		}
		return true;
	}

	public String replaceSpaces(char[] str , int length){
		int count = 0;
		for (int i = 0; i<length;i++){
			if(str[i] == ' '){
				count++;
			}
			}
		int newLength = length + count*2;
		int tracer = length-1;
		int i = newLength - 1;

		while(i>=0){
			if(str[tracer] == ' '){
				str[i]= '0';
				str[i-1]= '2';
				str[i-2]= '%';
				i=i-3;
			} else {
				str[i]=str[tracer];
				i--;
			}
			tracer--;
		}
		return str.toString();
		}

	public String CompressString(String s) {
		char lastChar = s.charAt(0);
		StringBuffer compressedS = new StringBuffer();
		int count = 1;
		for (int i = 1; i < s.length(); i++) {
			if (lastChar == s.charAt(i)) {
				count++;
			} else {
				compressedS.append(count + lastChar);// += count.toString() + lastChar;
				lastChar = s.charAt(i);
				count = 1;
			}

		}
		return compressedS.append(lastChar + count).toString();
	}

	class LinkedListNode {
		Integer data;
		LinkedListNode next;
	}

	public boolean isPalindrome(LinkedListNode head) {
		LinkedListNode fast = head;
		LinkedListNode slow = head;
		Stack<Integer> firstHalf = new Stack<Integer>();
		while (fast != null && fast.next != null) {
			firstHalf.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		if (fast != null) {
			slow = slow.next;
		}
		while (slow != null) {
			if (slow.data != firstHalf.pop()) {
				return false;
			} else {
				slow = slow.next;
			}

		}
		return true;
	}

	public class threeStackArray {

		int stackSize;
		int[] array = new int[3 * stackSize];
		int[] indexes = { -1, -1, -1 };

		public void push(int stackNumber, int value) throws Exception {
			if (indexes[stackNumber] + 1 > stackSize)
				throw new Exception("max size exceeded");
			indexes[stackNumber]++;
			array[stackNumber * stackSize + indexes[stackNumber]] = value;
		}

		public int pop(int stackNumber) throws Exception {
			if (indexes[stackNumber] == -1) {
				throw new Exception("stack is empty");
			}
			int result = array[stackNumber * stackSize + indexes[stackNumber]];
			indexes[stackNumber]--;
			return result;
		}

		public int peek(int stackNumber) throws Exception {
			if (indexes[stackNumber] == -1) {
				throw new Exception("stack is empty");
			}
			return array[stackNumber*stackSize+indexes[stackNumber]];

		}

	}

	public class StackWithMins{
		Stack<Integer> values;
		Stack<Integer> mins;

	public void push(Integer value){
		values.push(value);
		if ( mins.peek() >= value){
			mins.push(value);
		}
	}

	public Integer pop(){
		if (values.peek() == mins.peek()){
			mins.pop();
		}
		return values.pop();
	}
	public Integer peek(){
		return values.peek();
	}
	}

	public Integer queuePeek() {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.offer(1);
		queue.peek();
		return queue.pop();
	}

	// public int[] increment(int[] array) {
	// int carry = 1;
	// int index = array.length;// 3
	// while (carry == 1 && index > 0) {
	// int temp = array[index] + 1;
	// array[index] = temp % 10;
	// carry = (int) temp / 10;
	// index--;
	// }
	// if (carry == 1) {
	// int[] extendedArray = new int[array.length + 1];
	// extendedArray[0] = 1;
	// extendedArray = copyArray(1, array);// Copy array function
	// return extendedArray;
	// }
	// return array;
	// }

	public int[] increment(int[] array) {
		int carry =1;
		int index= array.length;//3
		while(carry==1 && index >0){
			int temp = array[index]+1;
			array[index]=temp %10;
			carry = (int) temp / 10;
			index --;
		}
		if(carry==1){
		int [] extendedArray = new int[array.length+1];
		extendedArray[0] = 1;
			extendedArray = Arrays.copyOf(array, array.length + 1);// Copy array function
		return extendedArray;
	}
	return array;
	}



}