package application;

import java.util.List;

public class DataView {

	
	public void printData1(List<String> list){
		
		ContextModel contextsrc = new ContextModel(new OperationSourceIP());
		contextsrc.executeStrategy(list, "Top 10 Clients");
	
	}
	
   public void printData2(List<String> list2){
		
	     ContextModel contextdst = new ContextModel(new OperationDestIP());
		 contextdst.executeStrategy(list2, "Top 10 Servers");
	
	}
   
   public void printData3(List<String> list3){
		
	   ContextModel contextproto = new ContextModel(new OperationProtocol());
	   contextproto.executeStrategy(list3, "Top 10 Protocol");
	
	}
   
   public void printData4(List<String> list4){
		
	   ContextModel contextdport = new ContextModel(new OperationProtocol());
	   contextdport.executeStrategy(list4, "Top 10 DPort");
	
   }
		 
		
}

