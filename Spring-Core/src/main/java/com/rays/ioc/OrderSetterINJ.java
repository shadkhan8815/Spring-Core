package com.rays.ioc;

public class OrderSetterINJ {
	
	private Payment payment ;
	private Inventory inventory ;
	
	
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
	public void bookATicket(int bookItems) {
		
		int price = 200 ;
		
		int totalStock = inventory.getStock();
		
		double totalBalance = payment.getBalance();
		
		double totalPaidAmount = bookItems * price ;
		
		double remainingBalance = payment.makePayment(totalPaidAmount);
		
		double remainingStock = inventory.sold(bookItems);
		
		System.out.println("Tickets Booking Details");
		System.out.println("Total Balance: " + totalBalance);
		System.out.println("Total Amount Paid: " + totalPaidAmount);
		System.out.println("Remaining Balance: " + remainingBalance);
		System.out.println("Total Ticket Stock: " + totalStock);
		System.out.println("Total Booked Tickects: " + bookItems);
		System.out.println("Remaining Ticket Stock: " + remainingStock);
	}
}
