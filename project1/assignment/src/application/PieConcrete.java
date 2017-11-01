package application;

import java.util.Map;

import application.PieChart;

public class PieConcrete implements ChartShape  {

	   @Override
	   public void draw(Map<String, Long> result, String title) {
	      PieChart demo = new PieChart("Network Flow Analyser", title, result);
          demo.pack();
          demo.setVisible(true);
         
	   }
	}
