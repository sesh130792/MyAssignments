package week3.day1.assignment3;

public class AxisBank extends BankInfo{
	
	@Override
	public String deposit() {
		// TODO Auto-generated method stub
			return "This is an account for deposit but from Axis Bank!";	
		}
	
	public static void main(String[] args) {
		AxisBank bank = new AxisBank();
		System.out.println(bank.deposit());
	}
}
