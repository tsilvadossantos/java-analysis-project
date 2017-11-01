package application;

import java.util.ArrayList;
import java.util.List;

public class NetworkModel {
   
   private ArrayList<String> source = new ArrayList<String>();
   private ArrayList<String> dest = new ArrayList<String>();
   private List<String> proto;
   private List<String> dport;
   
   public ArrayList<String> getsource() {
      return source;
   }
   
   public void setsource(ArrayList<String> ip) {
      this.source = ip;
   }
   
   public List<String> getdest() {
      return dest;
   }
   
   public void setdest(List<String> ip) {
      this.dest = (ArrayList<String>) ip;
   }
   
   public List<String> getproto() {
	      return proto;
   }
	   
   public void setproto(List<String> proto) {
      this.proto = proto;
   }
   
   public List<String> getdport() {
	      return dport;
   }
	   
   public void setdport(List<String> dport) {
	  this.dport = dport;
   }
}
