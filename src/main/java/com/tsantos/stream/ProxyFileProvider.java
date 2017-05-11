package com.tsantos.stream;

public class ProxyFileProvider implements FileProvider{

private RealFileProvider realfile;
private String fileName;

public ProxyFileProvider(String fileName){
   this.fileName = fileName;
}

@Override
public String fname() {
   if(realfile == null){
	   realfile = new RealFileProvider(fileName);
	   System.out.println("Proxy file " + fileName);
   }
   
   return fileName;
}
}