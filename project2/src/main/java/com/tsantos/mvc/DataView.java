package com.tsantos.mvc;

import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.Map.Entry;

import com.tsantos.command.CommandRequest;

public class DataView {
	
	
	public void printDstData(Map<String, Integer> bytesreceived, IntSummaryStatistics summ, String timerange) {

		
		// Update table destinationdata
		for (Entry<String, Integer> entry : bytesreceived.entrySet()) {
			// Call command design pattern to populate db
			CommandRequest dstdata = new CommandRequest();
			dstdata.RequestInsertDestinationData(entry.getKey(), entry.getValue(), timerange);
		}

		// update table destinationsummary
		CommandRequest dstsum = new CommandRequest();
		dstsum.RequestInsertDestinationSummary(summ.getCount(), summ.getSum(), summ.getMin(), summ.getAverage(),
				summ.getMax(), timerange);

	}

	public void printDportData(Map<String, Integer> packetsreceived, IntSummaryStatistics summ, String timerange) {
		// Update table destinationdata

		for (Entry<String, Integer> entry : packetsreceived.entrySet()) {
			// System.out.println("DataView:" + entry.getKey() + "/" +
			// entry.getValue());
			// Call command design pattern to populate db
			CommandRequest wsdata = new CommandRequest();
			wsdata.RequestInsertWebServerData(entry.getKey(), entry.getValue(), timerange);
		}

		// //update table destinationsummary
		CommandRequest wssum = new CommandRequest();
		wssum.RequestInsertWebServerSummary(summ.getCount(), summ.getSum(), summ.getMin(), summ.getAverage(),
				summ.getMax(), timerange);

	}

}
