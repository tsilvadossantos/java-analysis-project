package com.tsantos.stream;

import java.io.IOException;
import java.text.ParseException;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.tsantos.mvc.DataView;
import com.tsantos.mvc.FeedMVCModel;
import com.tsantos.mvc.WebServerController;
import com.tsantos.mvc.WebServerModel;

public class PacketsToWebServer {

	public PacketsToWebServer(String t1, String t2) throws ParseException, IOException {

		// Generate data for stream
		SeedNetworkAnalysis seed = new SeedNetworkAnalysis();
		seed.setFileName("Output.txt");
		seed.setReader(seed.getFileName());

		StringToDateTime obdate = new StringToDateTime();
		obdate.setStartDate(t1);
		obdate.setEndDate(t2);

		// Return data between start and end date time
		List<StreamAPIModel> items = seed.filterLogList(obdate.getStartDate(), obdate.getEndDate());

		// Map total bytes received per server {destination:totalbytes}
		Map<String, Integer> packetsToDport = items.stream()
				.filter(x -> "80".equals(x.getDport()) || "443".equals(x.getDport())).collect(Collectors
						.groupingBy(StreamAPIModel::getDport, Collectors.summingInt(StreamAPIModel::getTotalpackets)));

		// Sumary statics count, sum, min, average, max
		IntSummaryStatistics TotalPacketsSummary = items.stream()
				.filter(x -> "80".equals(x.getDport()) || "443".equals(x.getDport()))
				.filter(x -> x.getTotalpackets() >= 100)
				.collect(Collectors.summarizingInt(StreamAPIModel::getTotalpackets));

		// Get timerange
		String timeRange = obdate.getStartDate() + " - " + obdate.getEndDate();

		WebServerModel model = FeedMVCModel.feedDportPacketCount(packetsToDport, TotalPacketsSummary, timeRange);
		DataView view = new DataView();
		WebServerController controller = new WebServerController(model, view);
		controller.updateViewDportData();

	}
}
