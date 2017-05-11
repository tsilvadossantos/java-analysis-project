package com.tsantos.command;

public class PopulateDB implements CommandOrder {
	
	 @SuppressWarnings("unused")
	private CommandRequest populate;
	 
	//command request constructor
	    public PopulateDB(CommandRequest pop){
	        this.populate = pop;
	     }
	    
	    @Override
		public void execute(String timestamp, String proto, String source, String dst, String dport) {
	    	//populate.RequestInsertDport(timestamp, proto, source, dst, dport);
			
		}
	
	

}
