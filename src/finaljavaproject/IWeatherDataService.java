package finaljavaproject;

public interface IWeatherDataService {
	public WeatherData getWeatherData(Location location) throws WeatherDataServiceException;
}
