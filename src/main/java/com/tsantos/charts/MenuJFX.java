package com.tsantos.charts;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

import org.jfree.ui.RefineryUtilities;

import com.tsantos.stream.BytesPerDestinationIP;
import com.tsantos.stream.PacketsToWebServer;
import com.tsantos.stream.StringToDateTime;
import com.tsantos.template.Database;
import com.tsantos.template.TextFile;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class MenuJFX extends Application {

	static Stage stage;
	static DatePicker startDatePicker;
	static DatePicker checkOutDatePicker;
	static LocalDate date1;
	static LocalDate date2;
	static MenuModel menuObj = new MenuModel();
	static StringToDateTime obdate = new StringToDateTime();
	static Database obj = new TextFile();

	public static void callMainMenu(String[] args) {

		Locale.setDefault(Locale.US);
		launch(args);
		obj.openStream();
	}

	@SuppressWarnings("static-access")
	@Override
	public void start(Stage stage) {
		this.stage = stage;
		stage.setTitle("NetworkFlow ");
		initUI();
		stage.show();
		

		// Print the new date in the TextArea
		startDatePicker.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				date1 = startDatePicker.getValue();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				String d1 = date1.format(formatter);
				menuObj.setStartdate(d1);
			}
		});

		// Print the new date in the TextArea
		checkOutDatePicker.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				date2 = startDatePicker.getValue();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				String d2 = date2.format(formatter);
				menuObj.setEndate(d2);

			}
		});
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initUI() {
		
		VBox vbox = new VBox(20);
		vbox.setStyle("-fx-padding: 10;");
		Scene scene = new Scene(vbox, 420, 350);
		stage.setScene(scene);
		startDatePicker = new DatePicker();
		checkOutDatePicker = new DatePicker();
		// startDatePicker.setValue(LocalDate.now());
		startDatePicker.setValue(LocalDate.now());
		final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {
			@Override
			public DateCell call(final DatePicker datePicker) {
				return new DateCell() {
					@Override
					public void updateItem(LocalDate item, boolean empty) {
						super.updateItem(item, empty);

						long p = ChronoUnit.DAYS.between(startDatePicker.getValue(), item);
						setTooltip(new Tooltip("You're searching for " + p + " days"));
					}
				};
			}
		};
		checkOutDatePicker.setDayCellFactory(dayCellFactory);
		checkOutDatePicker.setValue(startDatePicker.getValue().plusDays(1));

		// Choice box
		// Choice box1
		ChoiceBox choiceBox = new ChoiceBox();
		for (int i = 0; i < 24; i++)
			if (i < 10)
				choiceBox.getItems().add("0" + i + ":00:00");
			else
				choiceBox.getItems().add(i + ":00:00");

		choiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
				String time1 = (String) choiceBox.getItems().get((Integer) number2);
				menuObj.setInitialtime(time1);
			}
		});

		ChoiceBox choiceBox2 = new ChoiceBox();
		for (int i = 0; i < 24; i++)
			if (i < 10)
				choiceBox2.getItems().add("0" + i + ":00:00");
			else
				choiceBox2.getItems().add(i + ":00:00");

		choiceBox2.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
				String time2 = (String) choiceBox2.getItems().get((Integer) number2);
				menuObj.setFinaltime(time2);

			}
		});

		HBox root = new HBox();

		// radio buttons
		ToggleGroup group = new ToggleGroup();
		RadioButton button1 = new RadioButton("Transmitted Data - Summary");
		button1.setToggleGroup(group);
		button1.setSelected(false);

		RadioButton button2 = new RadioButton("Data to Servers");
		button2.setToggleGroup(group);

		RadioButton button3 = new RadioButton("Server per IP Range");
		button3.setToggleGroup(group);

		RadioButton button4 = new RadioButton("Packets to web server - Summary");
		button4.setToggleGroup(group);

		RadioButton button5 = new RadioButton("Packets sent to port 80/443");
		button5.setToggleGroup(group);

		root.getChildren().add(button1);
		root.getChildren().add(button2);
		root.getChildren().add(button3);
		root.getChildren().add(button4);
		root.getChildren().add(button5);

		group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
				if (menuObj.getInitialtime() == null || menuObj.getFinaltime() == null || menuObj.getStartdate() == null || menuObj.getEndate() == null) {
					
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Dialog");
					alert.setHeaderText(null);
					alert.setContentText("Date or time is NULL!");
					alert.showAndWait();
					
				} else {
					if (group.getSelectedToggle() != null) {
						String choice = group.getSelectedToggle().toString();

						// Check if date is null
						menuObj.setChoice(choice);
						String t1 = menuObj.getStartdate() + " " + menuObj.getInitialtime();
						String t2 = menuObj.getEndate() + " " + menuObj.getFinaltime();
						obdate.setStartDate(t1);
						obdate.setEndDate(t2);

						try {
							// obj.openStream();
							if (menuObj.getChoice().contains("Transmitted Data - Summary")) {

								new BytesPerDestinationIP(t1, t2);

								BarChartDestinationSummary chart = new BarChartDestinationSummary(
										"Data Transmitted Statistics", "Transmitted Data - Summary",
										obdate.getStartDate(), obdate.getEndDate());
								chart.pack();
								RefineryUtilities.centerFrameOnScreen(chart);
								chart.setVisible(true);

							} else if (menuObj.getChoice().contains("Data to Servers")) {

								new BytesPerDestinationIP(t1, t2);

								PieChartDestinationData demo = new PieChartDestinationData("Network Traffic Monitor");
								PieChartDestinationData.createDemoPanel(obdate.getStartDate(), obdate.getEndDate());
								demo.pack();
								RefineryUtilities.centerFrameOnScreen(demo);
								demo.setVisible(true);

							}

							else if (menuObj.getChoice().contains("Server per IP Range")) {
								new BytesPerDestinationIP(t1, t2);

								PieChartDestinationDataIpRange demo = new PieChartDestinationDataIpRange(
										"Network Traffic Monitor");
								PieChartDestinationDataIpRange.createDemoPanel(obdate.getStartDate(),
										obdate.getEndDate());
								demo.pack();
								RefineryUtilities.centerFrameOnScreen(demo);
								demo.setVisible(true);
							}

							else if (menuObj.getChoice().contains("Packets to web server - Summary")) {
								new PacketsToWebServer(t1, t2);

								BarChartWebServerSummary chart = new BarChartWebServerSummary(
										"Data Transmitted Statistics", "Packets to web server - Summary",
										obdate.getStartDate(), obdate.getEndDate());
								chart.pack();
								RefineryUtilities.centerFrameOnScreen(chart);
								chart.setVisible(true);

							} else if (menuObj.getChoice().contains("Packets sent to port 80/443")) {
								new PacketsToWebServer(t1, t2);

								PieChartWebServerFinal demo = new PieChartWebServerFinal("Network Traffic Monitor");
								PieChartWebServerFinal.createDemoPanel(obdate.getStartDate(), obdate.getEndDate());
								demo.pack();
								RefineryUtilities.centerFrameOnScreen(demo);
								demo.setVisible(true);

							}
						}

						catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		});

		GridPane gridPane = new GridPane();
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		Label checkInlabel = new Label("Start Date and Hour Range:");
		gridPane.add(checkInlabel, 1, 0);
		GridPane.setHalignment(checkInlabel, HPos.LEFT);
		gridPane.add(startDatePicker, 1, 1);
		Label checkOutlabel = new Label("End Date and Hour Range:");
		gridPane.add(checkOutlabel, 1, 2);
		GridPane.setHalignment(checkOutlabel, HPos.LEFT);
		gridPane.add(checkOutDatePicker, 1, 3);
		gridPane.add(choiceBox, 4, 1);
		gridPane.add(choiceBox2, 4, 3);
		gridPane.add(button1, 1, 6);
		gridPane.add(button2, 1, 7);
		gridPane.add(button3, 1, 8);
		gridPane.add(button4, 1, 9);
		gridPane.add(button5, 1, 10);

		vbox.getChildren().add(gridPane);
	}

}