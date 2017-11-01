package com.tsantos.app;

import java.io.IOException;
import java.text.ParseException;

import com.tsantos.charts.MenuJFX;
import com.tsantos.command.CommandRequest;

public class App {

	public static void main(String[] args) throws ParseException, IOException {

		// Open original and output sorted to another file
		MenuJFX.callMainMenu(args);	

		  // Shutdown hibernate
		 CommandRequest.close();

	}
}
