package week1.day2;

public class SquareRoot {

	public int computeSquareRoot(int num) {
		if (num < 2) {
			return num; //3
		}
		int squareRoot = 0;
		for (int i=1;i<=num;i++) {
			if(i*i <=num) squareRoot++;
			else break;
		}
		return squareRoot;
//		int start = 1;
//		int end = num; //11
//		while (start <= end) { //1<11
//			int mid = (start + end) / 2; //7
//			if (mid * mid == num) {
//				return mid;
//			} else if (mid * mid > num) {
//				end = mid - 1; //8
//			} else {
//				start = mid + 1; //7
//			}
//		}
//		return end;
	}

	public static void main(String[] args) {
		int input = 81;
		SquareRoot obj1 = new SquareRoot();
		System.out.println(obj1.computeSquareRoot(input));
	}
}
