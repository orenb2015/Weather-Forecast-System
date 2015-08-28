package weather;

import java.time.LocalTime;

import org.joda.time.DateTime;

public class WeatherData {

	private int cityID;
	private String cityName;
	private int clouds;
	private double coordLat;
	private double coordLon;
	private String countryCode;
	private int humidity;
	private int pressure;
	private double rain3h;
	private double snow3h;
	private DateTime sunrise;
	private DateTime sunset;
	private double temp;
	private double tempMax;
	private double tempMin;
	private DateTime timeOfCalculation;
	private String weatherDescription;
	private String weatherIcon;
	private double windDeg;
	private double windSpeed;
	public int getCityID() {
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

	public double getRain3h() {
		return rain3h;
	}

	public double getSnow3h() {
		return snow3h;
	}

	public DateTime getSunrise() {
		return sunrise;
	}

	public DateTime getSunset() {
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

	public DateTime getTimeOfCalculation() {
		return timeOfCalculation;
	}

	public String getWeatherDescription() {
		return weatherDescription;
	}

	public String getWeatherIcon() {
		return weatherIcon;
	}

	public double getWindDeg() {
		return windDeg;
	}

	public double getWindSpeed() {
		return windSpeed;
	}

	public void setCityID(int cityID) {
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

	public void setRain3h(double rain3h) {
		this.rain3h = rain3h;
	}

	public void setSnow3h(double snow3h) {
		this.snow3h = snow3h;
	}

	public void setSunrise(DateTime sunrise) {
		this.sunrise = sunrise;
	}

	public void setSunset(DateTime sunset) {
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

	public void setTimeOfCalculation(DateTime timeOfCalculation) {
		this.timeOfCalculation = timeOfCalculation;
	}

	public void setWeatherDescription(String weatherDescription) {
		this.weatherDescription = weatherDescription;
	}

	public void setWeatherIcon(String weatherIcon) {
		this.weatherIcon = weatherIcon;
	}

	public void setWindDeg(double windDeg) {
		this.windDeg = windDeg;
	}

	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}
}
