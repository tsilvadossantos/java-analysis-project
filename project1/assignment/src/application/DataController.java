package application;

import java.util.ArrayList;
import java.util.List;

public class DataController {
	
   private NetworkModel model;
   private DataView view;

   public DataController(NetworkModel model, DataView view){
      this.model = model;
      this.view = view;
   }

   public void setsource(List<String> ip){
      model.setsource((ArrayList<String>) ip);		
   }

   public List<String> getsource(){
      return model.getsource();		
   }

   public void setdest(List<String> ip){
      model.setdest((ArrayList<String>) ip);		
   }

   public List<String> getdest(){
      return model.getdest();		
   }
   
   public void setproto(List<String> proto){
	  model.setproto(proto);		
   }

   public List<String> getproto(){
      return model.getproto();		
   }
   
   public void setdport(List<String> dport){
	  model.setdport(dport);		
   }

   public List<String> getdport(){
	  return model.getdport();		
   }
   
  
   public void updateViewSrcIP(){				
      view.printData1(model.getsource());
   }
   
   public void updateViewDstIP(){				
	  view.printData2(model.getdest());
   }
   
   public void updateViewProto(){				
		  view.printData3(model.getproto());
   }
   
   public void updateViewDPort(){				
		  view.printData4(model.getdport());
   }

}
