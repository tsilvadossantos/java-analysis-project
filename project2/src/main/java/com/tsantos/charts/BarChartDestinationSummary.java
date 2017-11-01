package com.tsantos.charts;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

import com.tsantos.template.Mysql;

public class BarChartDestinationSummary extends ApplicationFrame {

	private static long con_total = 0;
	private static long bytes_total = 0;
	private static long bytes_min = 0;
	private static long bytes_avg = 0;
	private static long bytes_max = 0;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;

	private static final long serialVersionUID = 1L;

	public BarChartDestinationSummary(String applicationTitle, String chartTitle, LocalDateTime startDateTime, LocalDateTime endDateTime) {
		super(applicationTitle);
		
		String timerange = startDateTime + " - " + endDateTime;
		
		JFreeChart barChart = ChartFactory.createBarChart(chartTitle, "Data Transmitted x Total Connections", "Giga Bytes",
				createDataset(timerange), PlotOrientation.VERTICAL, true, true, false);

		ChartPanel chartPanel = new ChartPanel(barChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
		setContentPane(chartPanel);
	}

	private CategoryDataset createDataset(String timerange) {
		
try {
			
			con = Mysql.getConnection();
			
			// Port 80/443 9:00:00
			String query1 = "select " + "con_total, " + "bytes_total, " + "bytes_min, " + "bytes_avg, " + "bytes_max "
					+ "from destinationsummary " + "where timerange = '"+timerange+"'";
			
		
			// create the java statement
			stmt = con.createStatement();

			// execute the query, and get a java resultset
			rs = stmt.executeQuery(query1);
			
			while (rs.next()) {
				con_total = rs.getLong("con_total");
				bytes_total = rs.getLong("bytes_total");
				bytes_min = rs.getLong("bytes_min");
				bytes_avg = rs.getLong("bytes_avg");
				bytes_max = rs.getLong("bytes_max");
			}

		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}

		final String con_total1 = "Total Connections";
		final String sum_bytes = "Sum";
		final String min_bytes = "Min";
		final String avg_bytes = "Avg";
		final String max_bytes = "Max";
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		//Bytes to gigabyte
		dataset.addValue(Math.sqrt(con_total), con_total1, "");
		dataset.addValue(Math.sqrt(bytes_total/1024/1024), sum_bytes, "");
		dataset.addValue(Math.sqrt(bytes_min/1024/1024), min_bytes, "");
		dataset.addValue(Math.sqrt(bytes_avg/1024/1024), avg_bytes, "");
		dataset.addValue(Math.sqrt(bytes_max/1024/1024), max_bytes, "");

		return dataset;
	}

//	public static void main(String[] args) {
//		BarChartDestinationSummary chart = new BarChartDestinationSummary("Data Transmitted Statistics", "Data transmitted to servers - Summary");
//		chart.pack();
//		RefineryUtilities.centerFrameOnScreen(chart);
//		chart.setVisible(true);
//	}
}