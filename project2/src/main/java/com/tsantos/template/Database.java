package com.tsantos.template;

public abstract class Database {

	public abstract void openStream();
	
	abstract void closeStream();

	// template method
	public final void play() {

		// open connection to database
		openStream();

		// Close connection database
		closeStream();

	}
}
