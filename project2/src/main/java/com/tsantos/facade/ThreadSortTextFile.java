package com.tsantos.facade;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreadSortTextFile implements ThreadShape {

	int counter = 0;
	
	@Override
	public void run() {

		String line = null;

			BufferedReader reader = null;
			PrintWriter outputStream = null;
			List<String> rows = new ArrayList<String>();

			try {
				reader = new BufferedReader(new FileReader("Input.txt"));
				outputStream = new PrintWriter(new FileWriter("Output.txt"));

				String file;
				while ((file = reader.readLine()) != null) {
					rows.add(file);
				}
				
				//Sort the file
				Collections.sort(rows);
				String[] strArr = rows.toArray(new String[0]);
				
				//Write to the file
				for (String cur : strArr)
					outputStream.println(cur);
				
			} catch (IOException e) {
				e.printStackTrace();
			} finally {

				if (outputStream != null) {
					outputStream.close();
				}
			}

		
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (line == null)
			System.exit(0);

	}

}