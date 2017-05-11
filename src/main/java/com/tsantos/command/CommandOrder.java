package com.tsantos.command;

public interface CommandOrder {
	   
	//void execute();
	void execute(String timestamp, String proto, String source, String dst, String dport);
	}
