package application;

public class ChartFactory {
	
	
   //use getType method to get object of type ChartType 
   public ChartShape getType(String cType){
      if(cType == null){
         return null;
      }		
      if(cType.equalsIgnoreCase("Pie Chart")){
         return new PieConcrete();
         
      }
      
      return null;
   }
	}