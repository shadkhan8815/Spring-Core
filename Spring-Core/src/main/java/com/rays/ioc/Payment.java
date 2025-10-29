package com.rays.ioc;

public class Payment {
	
	private double balance ;
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public double makePayment(double amount) {
		
		balance -= amount ;
		return balance ;
	}
	
	public double deposit (double amount) {
		
		balance += amount ;
		return balance ;
	}
	
}
