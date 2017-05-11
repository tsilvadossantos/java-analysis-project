package com.tsantos.command;

public class CommandInvoker {

	private CommandOrder order;

	public void takeOrder(CommandOrder order) {
		this.order = order;
	}

	public void placeOrders(String timestamp, String proto, String source, String dst, String dport) {
	
			order.execute(timestamp, proto, source, dst, dport);
		
	}

}
