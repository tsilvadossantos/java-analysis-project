package com.tsantos.template;

import com.tsantos.facade.ThreadMaker;

public class TextFile extends Database {

	@Override
	public void openStream() {
		ThreadMaker tmaker = new ThreadMaker();
		tmaker.generateThreadSortText();
		
	}

	@Override
	void closeStream() {
		// Close the file
		//FileManager close = new FileManager(fileName);
		//close.closeFile();
	}

}
