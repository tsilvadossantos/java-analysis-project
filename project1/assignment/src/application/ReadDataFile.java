package application;

import java.util.ArrayList;
import java.util.List;

public class ReadDataFile {
	
	public static NetworkModel ReadFile(int flag){
		
		Thread t1= new Thread();
		t1.start();
		
		//Read file  
		FileManager file1 = new FileManager("capture20110810.binetflow");
		  
	   
		//StartTime[0], Dur[1], Proto[2], SrcAddr[3], Sport[4], Dir[5], DstAddr[6], Dport[7], 
		//State[8], sTos[9], dTos[10], TotPkts[11], TotBytes[12], SrcBytes[13], Label[14]
		
		//Read headers
        file1.nextLine();
        
        List<String> source = new ArrayList<String>();
        List<String> dest = new ArrayList<String>();
        List<String> proto = new ArrayList<String>();
        List<String> dport = new ArrayList<String>();
        
                       
        //Loop into the file
        while(file1.hasNextLine()){            
        	String line[] = file1.nextLine().split(",");
        	proto.add(line[2]);
        	source.add(line[3]);
        	dest.add(line[6]); 
        	dport.add(line[7]);            	            
        } 
	    
        //Close the file
        file1.closeFile();
        
        NetworkModel data = new NetworkModel();
        data.setsource((ArrayList<String>) source);
        data.setdest((ArrayList<String>) dest);
	    data.setproto(proto);
	    data.setdport(dport);
	    
	    return data;
	      
	}

}
