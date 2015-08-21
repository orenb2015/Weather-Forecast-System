package finaljavaproject;

import java.time.LocalTime;

public class WeatherData {

	private String cityID;
	private String cityName;
	private int clouds;
	private double coordLat;
	private double coordLon;
	private String countryCode;
	private int humidity;
	private int pressure;
	private int rain3h;
	private int snow3h;
	private LocalTime sunrise;
	private LocalTime sunset;
	private double temp;
	private double tempMax;
	private double tempMin;
	private LocalTime timeOfCalculation;
	private String weatherDescription;
	private String weatherIcon;
	private int windDeg;
	private int windSpeed;
	public String getCityID() {
		return cityID;
	}
	public String getCityName() {
		return cityName;
	}

	public int getClouds() {
		return clouds;
	}

	public double getCoordLat() {
		return coordLat;
	}

	public double getCoordLon() {
		return coordLon;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public int getHumidity() {
		return humidity;
	}

	public int getPressure() {
		return pressure;
	}

	public int getRain3h() {
		return rain3h;
	}

	public int getSnow3h() {
		return snow3h;
	}

	public LocalTime getSunrise() {
		return sunrise;
	}

	public LocalTime getSunset() {
		return sunset;
	}

	public double getTemp() {
		return temp;
	}

	public double getTempMax() {
		return tempMax;
	}

	public double getTempMin() {
		return tempMin;
	}

	public LocalTime getTimeOfCalculation() {
		return timeOfCalculation;
	}

	public String getWeatherDescription() {
		return weatherDescription;
	}

	public String getWeatherIcon() {
		return weatherIcon;
	}

	public int getWindDeg() {
		return windDeg;
	}

	public int getWindSpeed() {
		return windSpeed;
	}

	public void setCityID(String cityID) {
		this.cityID = cityID;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public void setClouds(int clouds) {
		this.clouds = clouds;
	}

	public void setCoordLat(double coordLat) {
		this.coordLat = coordLat;
	}

	public void setCoordLon(double coordLon) {
		this.coordLon = coordLon;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	public void setPressure(int pressure) {
		this.pressure = pressure;
	}

	public void setRain3h(int rain3h) {
		this.rain3h = rain3h;
	}

	public void setSnow3h(int snow3h) {
		this.snow3h = snow3h;
	}

	public void setSunrise(LocalTime sunrise) {
		this.sunrise = sunrise;
	}

	public void setSunset(LocalTime sunset) {
		this.sunset = sunset;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

	public void setTempMax(double tempMax) {
		this.tempMax = tempMax;
	}

	public void setTempMin(double tempMin) {
		this.tempMin = tempMin;
	}

	public void setTimeOfCalculation(LocalTime timeOfCalculation) {
		this.timeOfCalculation = timeOfCalculation;
	}

	public void setWeatherDescription(String weatherDescription) {
		this.weatherDescription = weatherDescription;
	}

	public void setWeatherIcon(String weatherIcon) {
		this.weatherIcon = weatherIcon;
	}

	public void setWindDeg(int windDeg) {
		this.windDeg = windDeg;
	}

	public void setWindSpeed(int windSpeed) {
		this.windSpeed = windSpeed;
	}
}
