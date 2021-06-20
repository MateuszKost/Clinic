package clinic.entities;

import javax.ejb.Stateful;

@Stateful
public class testEJB {

	private double amount = 1000;
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		System.out.println("setAmount: "+this.hashCode());
		this.amount = amount;
	}
}
