package application;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OperationProtocol implements StrategyCapture{
	   @Override
	   public Map<String, Long> doOperation(List<String> list, String title) {
	      
		   Map<String, Long> result = list.stream().
				   collect(Collectors.groupingBy(Function.identity(), 
						   Collectors.counting()));
		   
		   Map<String, Long> finalMap = new LinkedHashMap<>();
		   
		   //Sort a map and add to finalMap
	       result.entrySet().stream()
	                .sorted(Map.Entry.<String, Long>comparingByValue()
	                        .reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));
	        
	        //Most 10 used protocol
	        Map<String, Long> mapTemp = new LinkedHashMap<>();
	        int item  = 0;
	        search: { for (Entry<String, Long> entry : finalMap.entrySet()) {
	        	if(item < 10)
	        	   mapTemp.put(entry.getKey(), entry.getValue());
	        	else
	        		 break search;
	        	item++;
	           } 
	        }
	        
	        //Create chart (Factory Pattern)
		    ChartFactory myChart = new ChartFactory();
		    ChartShape chart1 = myChart.getType("Pie Chart");
		    chart1.draw(mapTemp, title);	     
		  	     
			 return null;
	     
	   }
}
