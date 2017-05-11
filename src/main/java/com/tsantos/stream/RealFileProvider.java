package com.tsantos.stream;

public class RealFileProvider implements FileProvider {

	   private String fileName;

	   public RealFileProvider(String fileName){
	      this.fileName = fileName;
	      loadFromParameter(fileName);
	   }

	   @Override
	   public String fname() {
	      System.out.println("Displaying " + fileName);
		return fileName;
	   }

	   private void loadFromParameter(String fileName){
		   System.out.println("Real file " + fileName);	     
	   }
	}
