package application;

import java.util.List;
import java.util.Map;

public class ContextModel {
	   private StrategyCapture strategy;

	   public ContextModel(StrategyCapture strategy){
	      this.strategy = strategy;
	   }

	   public Map<String, Long> executeStrategy(List<String> list, String title){
	      return strategy.doOperation(list, title);
	   }
	}
