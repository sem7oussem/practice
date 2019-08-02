package practice;

public class Temperature {
	private static Integer min = Integer.MAX_VALUE;
	private static Integer max = Integer.MIN_VALUE;
	private static int count = 0;
	private static float mean;

	public static void insert(Integer value) {
		count++;
	if (value < min ) {min = value;}
		if (value > max) {
			max = value;
		}
		if (count == 1) {
			mean = value;
		} else {
			mean = (mean * (count - 1) + value) / count;
		}
	}

	public static Integer getMax() {
		return max;
	}

	public static Integer getMin() {
		return min;
	}

	public static float getMean() {
		return mean;
	}
	public static void main(String[] args) {
		
		
		

	}

}
