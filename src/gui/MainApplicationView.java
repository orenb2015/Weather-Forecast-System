package gui;

import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.joda.time.DateTimeZone;

import weather.WeatherData;

public class MainApplicationView {

	private JFrame frame;
	private JLabel lblCoordinatesLongtitude;
	private JTextField cityIDValueLabel;
	private JTextField cityNameValueLabel;
	private JTextField cloudsValueLabel;
	private JTextField coordLatValueLabel;
	private JTextField coordLonValueLabel;
	private JTextField countryCodeValueLabel;
	private JTextField humidityValueLabel;
	private JTextField pressureValueLabel;
	private JTextField rain3hValueLabel;
	private JTextField snow3hValueLabel;
	private JTextField sunriseValueLabel;
	private JTextField sunsetValueLabel;
	private JTextField tempValueLabel;
	private JTextField tempMaxValueLabel;
	private JTextField tempMinValueLabel;
	private JTextField weatherDescValueLabel;
	private JTextField windDegValueLabel;
	private JTextField windSpeedValueLabel;
	private JTextField timeOfCalculationValueLabel;
	JComboBox currentCityComboBox;
	JLabel iconLabel;

	public final String GET_WEATHER_COMMAND = "getWeather";

	public MainApplicationView(ActionListener listener, ArrayList<String> cities) {
		frame = new JFrame();
		frame.setBounds(100, 100, 555, 543);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblCity = new JLabel("City:");
		lblCity.setBounds(10, 11, 46, 14);
		frame.getContentPane().add(lblCity);

		currentCityComboBox = new JComboBox();
		/*
		 * for (int i = 0; i < cities.size(); i++) { String city =
		 * cities.get(i); comboBox.addItem(city); }
		 */
		for (String city : cities) {
			currentCityComboBox.addItem(city);
		}
		currentCityComboBox.setBounds(66, 8, 307, 20);
		frame.getContentPane().add(currentCityComboBox);

		JButton btnGetWeather = new JButton("Get Weather");
		btnGetWeather.setBounds(383, 7, 146, 23);
		btnGetWeather.addActionListener(listener);
		btnGetWeather.setActionCommand(GET_WEATHER_COMMAND);
		frame.getContentPane().add(btnGetWeather);

		JLabel lblCityId = new JLabel("City ID:");
		lblCityId.setBounds(10, 36, 154, 14);
		frame.getContentPane().add(lblCityId);

		JLabel lblCityName = new JLabel("City Name:");
		lblCityName.setBounds(10, 61, 154, 14);
		frame.getContentPane().add(lblCityName);

		JLabel lblClouds = new JLabel("Clouds:");
		lblClouds.setBounds(10, 86, 154, 14);
		frame.getContentPane().add(lblClouds);

		JLabel lblCoordinatesLatitude = new JLabel("Coordinates Latitude:");
		lblCoordinatesLatitude.setBounds(10, 111, 154, 14);
		frame.getContentPane().add(lblCoordinatesLatitude);

		lblCoordinatesLongtitude = new JLabel("Coordinates Longtitude:");
		lblCoordinatesLongtitude.setBounds(10, 136, 154, 14);
		frame.getContentPane().add(lblCoordinatesLongtitude);

		JLabel lblCountryCode = new JLabel("Country Code:");
		lblCountryCode.setBounds(10, 161, 154, 14);
		frame.getContentPane().add(lblCountryCode);

		JLabel lblHumidity = new JLabel("Humidity:");
		lblHumidity.setBounds(10, 186, 154, 14);
		frame.getContentPane().add(lblHumidity);

		JLabel lblPressure = new JLabel("Pressure:");
		lblPressure.setBounds(10, 211, 154, 14);
		frame.getContentPane().add(lblPressure);

		JLabel lblRainh = new JLabel("Rain 3h:");
		lblRainh.setBounds(10, 236, 154, 14);
		frame.getContentPane().add(lblRainh);

		JLabel lblSnowh = new JLabel("Snow 3h:");
		lblSnowh.setBounds(10, 261, 154, 14);
		frame.getContentPane().add(lblSnowh);

		JLabel lblSunriseTime = new JLabel("Sunrise Time:");
		lblSunriseTime.setBounds(10, 286, 154, 14);
		frame.getContentPane().add(lblSunriseTime);

		JLabel lblSunsetTime = new JLabel("Sunset Time:");
		lblSunsetTime.setBounds(10, 312, 154, 14);
		frame.getContentPane().add(lblSunsetTime);

		JLabel lblTempeture = new JLabel("Tempeture:");
		lblTempeture.setBounds(10, 337, 154, 14);
		frame.getContentPane().add(lblTempeture);

		JLabel lblTempetureMax = new JLabel("Tempeture Max:");
		lblTempetureMax.setBounds(10, 362, 154, 14);
		frame.getContentPane().add(lblTempetureMax);

		JLabel lblTempetureMin = new JLabel("Tempeture Min:");
		lblTempetureMin.setBounds(10, 387, 154, 14);
		frame.getContentPane().add(lblTempetureMin);

		JLabel lblTimeOfCalculation = new JLabel("Time Of Calculation:");
		lblTimeOfCalculation.setBounds(242, 480, 121, 14);
		frame.getContentPane().add(lblTimeOfCalculation);

		JLabel lblWeatherDescription = new JLabel("Weather Description:");
		lblWeatherDescription.setBounds(10, 412, 154, 14);
		frame.getContentPane().add(lblWeatherDescription);

		JLabel lblWindDegrees = new JLabel("Wind Degrees:");
		lblWindDegrees.setBounds(10, 437, 154, 14);
		frame.getContentPane().add(lblWindDegrees);

		JLabel lblWindSpeed = new JLabel("Wind Speed:");
		lblWindSpeed.setBounds(10, 462, 154, 14);
		frame.getContentPane().add(lblWindSpeed);

		cityIDValueLabel = new JTextField();
		cityIDValueLabel.setEditable(false);
		cityIDValueLabel.setBounds(174, 33, 199, 20);
		frame.getContentPane().add(cityIDValueLabel);
		cityIDValueLabel.setColumns(10);

		cityNameValueLabel = new JTextField();
		cityNameValueLabel.setEditable(false);
		cityNameValueLabel.setBounds(174, 58, 199, 20);
		frame.getContentPane().add(cityNameValueLabel);
		cityNameValueLabel.setColumns(10);

		cloudsValueLabel = new JTextField();
		cloudsValueLabel.setEditable(false);
		cloudsValueLabel.setBounds(174, 83, 199, 20);
		frame.getContentPane().add(cloudsValueLabel);
		cloudsValueLabel.setColumns(10);

		coordLatValueLabel = new JTextField();
		coordLatValueLabel.setEditable(false);
		coordLatValueLabel.setBounds(174, 108, 199, 20);
		frame.getContentPane().add(coordLatValueLabel);
		coordLatValueLabel.setColumns(10);

		coordLonValueLabel = new JTextField();
		coordLonValueLabel.setEditable(false);
		coordLonValueLabel.setBounds(174, 133, 199, 20);
		frame.getContentPane().add(coordLonValueLabel);
		coordLonValueLabel.setColumns(10);

		countryCodeValueLabel = new JTextField();
		countryCodeValueLabel.setEditable(false);
		countryCodeValueLabel.setBounds(174, 158, 199, 20);
		frame.getContentPane().add(countryCodeValueLabel);
		countryCodeValueLabel.setColumns(10);

		humidityValueLabel = new JTextField();
		humidityValueLabel.setEditable(false);
		humidityValueLabel.setBounds(174, 183, 199, 20);
		frame.getContentPane().add(humidityValueLabel);
		humidityValueLabel.setColumns(10);

		pressureValueLabel = new JTextField();
		pressureValueLabel.setEditable(false);
		pressureValueLabel.setBounds(174, 208, 199, 20);
		frame.getContentPane().add(pressureValueLabel);
		pressureValueLabel.setColumns(10);

		rain3hValueLabel = new JTextField();
		rain3hValueLabel.setEditable(false);
		rain3hValueLabel.setBounds(174, 233, 199, 20);
		frame.getContentPane().add(rain3hValueLabel);
		rain3hValueLabel.setColumns(10);

		snow3hValueLabel = new JTextField();
		snow3hValueLabel.setEditable(false);
		snow3hValueLabel.setBounds(174, 258, 199, 20);
		frame.getContentPane().add(snow3hValueLabel);
		snow3hValueLabel.setColumns(10);

		sunriseValueLabel = new JTextField();
		sunriseValueLabel.setEditable(false);
		sunriseValueLabel.setBounds(174, 283, 199, 20);
		frame.getContentPane().add(sunriseValueLabel);
		sunriseValueLabel.setColumns(10);

		sunsetValueLabel = new JTextField();
		sunsetValueLabel.setEditable(false);
		sunsetValueLabel.setBounds(174, 309, 199, 20);
		frame.getContentPane().add(sunsetValueLabel);
		sunsetValueLabel.setColumns(10);

		tempValueLabel = new JTextField();
		tempValueLabel.setEditable(false);
		tempValueLabel.setBounds(174, 334, 199, 20);
		frame.getContentPane().add(tempValueLabel);
		tempValueLabel.setColumns(10);

		tempMaxValueLabel = new JTextField();
		tempMaxValueLabel.setEditable(false);
		tempMaxValueLabel.setBounds(174, 359, 199, 20);
		frame.getContentPane().add(tempMaxValueLabel);
		tempMaxValueLabel.setColumns(10);

		tempMinValueLabel = new JTextField();
		tempMinValueLabel.setEditable(false);
		tempMinValueLabel.setBounds(174, 384, 199, 20);
		frame.getContentPane().add(tempMinValueLabel);
		tempMinValueLabel.setColumns(10);

		weatherDescValueLabel = new JTextField();
		weatherDescValueLabel.setEditable(false);
		weatherDescValueLabel.setBounds(174, 409, 199, 20);
		frame.getContentPane().add(weatherDescValueLabel);
		weatherDescValueLabel.setColumns(10);

		windDegValueLabel = new JTextField();
		windDegValueLabel.setEditable(false);
		windDegValueLabel.setBounds(174, 434, 199, 20);
		frame.getContentPane().add(windDegValueLabel);
		windDegValueLabel.setColumns(10);

		windSpeedValueLabel = new JTextField();
		windSpeedValueLabel.setEditable(false);
		windSpeedValueLabel.setBounds(174, 459, 199, 20);
		frame.getContentPane().add(windSpeedValueLabel);
		windSpeedValueLabel.setColumns(10);

		timeOfCalculationValueLabel = new JTextField();
		timeOfCalculationValueLabel.setEditable(false);
		timeOfCalculationValueLabel.setBounds(373, 477, 156, 20);
		frame.getContentPane().add(timeOfCalculationValueLabel);
		timeOfCalculationValueLabel.setColumns(10);

		JLabel lblIcon = new JLabel("Icon");
		lblIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcon.setBounds(383, 36, 146, 14);
		frame.getContentPane().add(lblIcon);

		iconLabel = new JLabel("");
		iconLabel.setHorizontalAlignment(SwingConstants.CENTER);
		iconLabel.setBounds(383, 61, 146, 64);
		frame.getContentPane().add(iconLabel);
	}

	public void displayMainWindow() {
		frame.setVisible(true);
	}

	public String getCurrentCityAndCountryCode() {
		return (String) currentCityComboBox.getSelectedItem();
	}

	public void DisplayWeatherData(WeatherData data) {
		cityIDValueLabel.setText(String.valueOf(data.getCityID()));
		cityNameValueLabel.setText(data.getCityName());
		cloudsValueLabel.setText(String.valueOf(data.getClouds()));
		coordLatValueLabel.setText(String.valueOf(data.getCoordLat()));
		coordLonValueLabel.setText(String.valueOf(data.getCoordLon()));
		countryCodeValueLabel.setText(data.getCountryCode());
		humidityValueLabel.setText(String.valueOf(data.getHumidity()));
		pressureValueLabel.setText(String.valueOf(data.getPressure()));
		rain3hValueLabel.setText(String.valueOf(data.getRain3h()));
		snow3hValueLabel.setText(String.valueOf(data.getSnow3h()));
		sunriseValueLabel.setText(data.getSunrise()
				.toDateTime(DateTimeZone.forID("Israel")).toString());
		sunsetValueLabel.setText(data.getSunset()
				.toDateTime(DateTimeZone.forID("Israel")).toString());
		tempValueLabel.setText(String.valueOf(data.getTemp()));
		tempMaxValueLabel.setText(String.valueOf(data.getTempMax()));
		tempMinValueLabel.setText(String.valueOf(data.getTempMin()));
		timeOfCalculationValueLabel.setText(data.getTimeOfCalculation()
				.toDateTime(DateTimeZone.forID("Israel")).toString());
		weatherDescValueLabel.setText(data.getWeatherDescription());
		windDegValueLabel.setText(String.valueOf(data.getWindDeg()));
		windSpeedValueLabel.setText(String.valueOf(data.getWindSpeed()));

		iconLabel.setIcon(createImageIcon("http://openweathermap.org/img/w/"
				+ data.getWeatherIcon() + ".png"));
	}

	ImageIcon createImageIcon(String path) {
		java.net.URL imgURL;
		try {
			imgURL = new URL(path);
			ImageIcon icon = new ImageIcon(imgURL, "");
			return icon;

		} catch (MalformedURLException e) {
			displayError(e.getMessage());
		}
		return null;
	}

	public void displayError(String errorText) {
		JOptionPane.showMessageDialog(frame, errorText, "Error",
				JOptionPane.ERROR_MESSAGE);
	}
}
