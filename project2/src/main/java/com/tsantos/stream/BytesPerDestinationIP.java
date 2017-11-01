package com.tsantos.stream;

import java.io.IOException;
import java.text.ParseException;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.tsantos.mvc.DataView;
import com.tsantos.mvc.DestinationController;
import com.tsantos.mvc.DestinationModel;
import com.tsantos.mvc.FeedMVCModel;

public class BytesPerDestinationIP {
	
	static String name;
	
	public BytesPerDestinationIP(String name){
		this.name = name;
	}

	public BytesPerDestinationIP(String t1, String t2) throws ParseException, IOException {

		// Read a file
		FileProvider file = new ProxyFileProvider("Output.txt");
		SeedNetworkAnalysis seed = new SeedNetworkAnalysis();
		seed.setFileName(file.fname());
		seed.setReader(seed.getFileName());

		StringToDateTime obdate = new StringToDateTime();
		obdate.setStartDate(t1);
		obdate.setEndDate(t2);

		List<StreamAPIModel> items = seed.filterLogList(obdate.getStartDate(), obdate.getEndDate());

		// Map total bytes received per server {destination:totalbytes}
		Map<String, Integer> bytesPerDestination = items.stream()
				.filter(x -> x.getTotalbytes() >= 10000000) //10000000 == 10MB
				.collect(Collectors
				.groupingBy(StreamAPIModel::getDestination, Collectors.summingInt(StreamAPIModel::getTotalbytes)));

		// Sumary statics count, sum, min, average, max
		IntSummaryStatistics TotalBytesSummary = items.stream()
				.filter(x -> x.getTotalbytes() >= 10000000)
				.collect(Collectors.summarizingInt(StreamAPIModel::getTotalbytes));

		// Get timerange
		String timeRange = obdate.getStartDate() + " - " + obdate.getEndDate();

		DestinationModel model = FeedMVCModel.feedDstByteCount(bytesPerDestination, TotalBytesSummary, timeRange);
		DataView view = new DataView();
		DestinationController controller = new DestinationController(model, view);
		controller.updateViewDstData();

	}
}
